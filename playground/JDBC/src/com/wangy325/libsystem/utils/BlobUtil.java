package com.wangy325.libsystem.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wangy325.libsystem.bean.BorrowRecord;
import com.wangy325.libsystem.bean.Lib;

import oracle.sql.BLOB;

/**
 * @author wangy325
 *
 * @date Jan 12, 2018-- 5:18:13 PM
 *
 * @description insert Object to column, with BLOB
 *
 */

public class BlobUtil {

	public static void borrowBody(String username, String bname, Integer bnum) throws SQLException {
		List<BorrowRecord> brList = genBorrowBookList(username, bname, bnum);
		// 2. commit operator to database
		// 将 List 存入 BLOB 字段
		saveBorrowInfo(username, bname, bnum, brList);
	}

	public static void saveBorrowInfo(String username, String bname, Integer bnum, List<BorrowRecord> brList)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = C3p0Util.getConn();
			conn.setAutoCommit(false);
			// initialize BLOB
			if (brList.size() == 0) {
				ps = conn.prepareStatement("UPDATE STU  SET BOOKINFO = NULL WHERE SNAME= '" + username + "'");
				ps.executeUpdate();
				conn.commit();
			} else {
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				ObjectOutputStream outObj = new ObjectOutputStream(byteOut);
				outObj.writeObject(brList);
				final byte[] objbytes = byteOut.toByteArray();
				ps = conn.prepareStatement("UPDATE STU  SET BOOKINFO =EMPTY_BLOB() WHERE SNAME= '" + username + "'");
				ps.executeUpdate();
				// update BLOB
				rs = ps.executeQuery("SELECT BOOKINFO FROM STU WHERE SNAME= '" + username + "' FOR UPDATE");
				if (rs.next()) {
					BLOB blob = (BLOB) rs.getBlob("BOOKINFO");
					@SuppressWarnings("deprecation")
					OutputStream outStream = blob.getBinaryOutputStream();
					outStream.write(objbytes, 0, objbytes.length);
					outStream.flush();
					outStream.close();
				}
				byteOut.close();
				outObj.close();
				conn.commit();
			}
			// update library data
			List<Lib> book = QueryUtil.queryAll("SELECT * FROM LIBRARY WHERE BNAME = '" + bname + "'", Lib.class);
			int originNum = book.get(0).getbnumber();
			int remainNum = (originNum - bnum);
			UpdateUtil.update("UPDATE LIBRARY SET BNUMBER = ? WHERE BNAME = ?", remainNum, bname);
			// conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.setAutoCommit(true);
			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("operation filed, roll back...");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new SQLException("The database operaton occured  vital mistake!");
		} finally {
			C3p0Util.close(rs, ps, conn);
		}
	}

	public static List<BorrowRecord> genBorrowBookList(String username, String bname, Integer bnum) {
		// 1. add borrowed information to List<BorrowRecord> first is BLOB is not empty
		List<BorrowRecord> brList = getBLOB(username);
		BorrowRecord br = new BorrowRecord();
		if (brList == null) {
			brList = new ArrayList<>();
			br.setBorrowedBookName(bname);
			br.setBorrowedBookNum(bnum);
			brList.add(br);
			return brList;
		} else { // brList != null
			int index = -1;
			for (int i = 0; i < brList.size(); i++) {
				if (brList.get(i).getBorrowedBookName().equals(bname)) {
					br.setBorrowedBookNum(bnum + brList.get(i).getBorrowedBookNum());
					br.setBorrowedBookName(bname);
					index = i;
					break;
				} else
					continue;
			}
			if (index == -1) {
				brList.add(new BorrowRecord(bname, bnum));
			} else {
				brList.set(index, br);
			}
			return brList;
		}
	}

	// 取出 BOLB 中的信息
	public static List<BorrowRecord> getBLOB(String sname) {
		BLOB inblob = checkBLOB(sname);
		if (inblob == null) {
			return null;
		} else {
			try {
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);
				byte[] buff = new byte[inblob.getBufferSize()];
				while (-1 != (input.read(buff, 0, buff.length)))
					;
				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				@SuppressWarnings("unchecked")
				List<BorrowRecord> brList = (List<BorrowRecord>) in.readObject();
				return brList;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * before borrow books , check user's borrowed record first.
	 * 
	 * @param username
	 * @return true if blob has been initialized , which means user has borrow
	 *         record.
	 */
	public static BLOB checkBLOB(String username) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		BLOB inblob = null;
		try {
			// con.setAutoCommit(false);
			conn = C3p0Util.getConn();
			st = conn.createStatement();
			rs = st.executeQuery("select BOOKINFO from STU where SNAME='" + username + "'");
			if (rs.next()) {
				// if user haven't borrowed book yet, the BLOB has not been initialized
				// so the inblob could be null
				inblob = (BLOB) rs.getBlob("BOOKINFO");
			}
			if (inblob == null) {
				// System.out.println("you have not borrowed book yet");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			C3p0Util.close(rs, st, conn);
		}
		return inblob;
	}

	@Test
	public void test() {
		try {
			borrowBody("kikyo", "TIJ", 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// List<BorrowRecord> brList = new ArrayList<>();
		// brList.add(new BorrowRecord("TIC", 1));
		//
		// saveBorrowInfo("kikyo", "TIC", 1, brList);
		List<BorrowRecord> w3 = getBLOB("kikyo");
		for (int i = 0; i < w3.size(); i++) {
			System.out.println(
					"kikyo " + " borrowed " + w3.get(i).getBorrowedBookNum() + " " + w3.get(i).getBorrowedBookName());
		}
	}
}
