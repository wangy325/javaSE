package com.wangy325.libsystem.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.wangy325.libsystem.bean.BorrowRecord;
import com.wangy325.libsystem.bean.Lib;
import com.wangy325.libsystem.imp.Dao;
import com.wangy325.libsystem.imp.DaoImp;
import com.wangy325.libsystem.service.LibServices;

/**
 * 
 * @author wangy325
 *
 * @date Jan 12, 2018-- 2:51:56 PM
 *
 * @description this menu used to execute borrow book operation.
 *
 */
public class ThirdClassMenu {
	private static Dao dao = new DaoImp();

	// borrow books index
	public static <T> void borrowIndex(String username, int bid) {
		// if bid exist show the remnant of books in library
		String sql = "select * from library where bid =" + bid;
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) Lib.class;
		int NUM = 0;
		String BNAME = null;
		try {
			List<T> eleList = dao.queryData(sql, clazz);
			// get the rest number of book in the LIB
			NUM = ((Lib) eleList.get(0)).getbnumber();
			BNAME = ((Lib) eleList.get(0)).getBname();
			if (NUM > 0) {
				System.out.println("the book " + BNAME + " still have " + NUM + " remain(s) on the shief.");
				System.out.println("please input the number of books you want to borrow:");
				int borrowNum = 0;
				while (true) {
					borrowNum = InputUtil.getInt();
					if (borrowNum > NUM || borrowNum <= 0) {
						System.out.println("input invalid, try again.");
					} else {
						break;
					}
				}
				// System.out.println("congratulations, almost success!");
				try {
					LibServices.borrowBooks(username, BNAME, borrowNum);
					Date currentDate = new Date(System.currentTimeMillis());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String log = sdf.format(currentDate)+ " :   " + username + " borrowed " + borrowNum + " "
							+ BNAME + "(s)" + " from library. \n";
					writeLog(log);
					System.out.println("Operation success...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("the book " + BNAME + " had all borrowed out.");
				// back 2 upper menu, input the bid again.
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// return book index
	public static void returnBook(String username, String boName, int reNum, int boNum) {
		// 1. Get BLOB info and Update List data
		List<BorrowRecord> newList = BlobUtil.getBLOB(username);
		int index = 0;
		for (int i = 0; i < newList.size(); i++) {
			if (newList.get(i).getBorrowedBookName().equals(boName))
				index = i;
			else
				continue;
		}
		if ((boNum - reNum) != 0)
			newList.set(index, new BorrowRecord(boName, (boNum - reNum)));
		else
			newList.remove(index);
		// 3. Construct SQL statement
		try {
			LibServices.returnBook(username, boName, reNum, newList);
			Date currentDate = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String log = sdf.format(currentDate)+ " :   " + username + " returned " + reNum + " " + boName + "(s)"
					+ " to library. \n";
			writeLog( log);
			System.out.println("Operation success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3. write the borrow/ return information to a log file
	public static void writeLog(String log) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(new File("src/com/wangy325/libsystem/log"), true)));
			bw.write(log);
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/////////////////////////// UNDONE FUNCTION //////////////////////////////
	/*public static void borrowProcess(String username, String bname, Integer bnum) {
		System.out.println("book " + bname + " add to your list, continue or commit?");
		System.out.println("1. continue borrow books");
		System.out.println("2.commit");
		int choice = 0;
		List<BorrowRecord> brList = null;
		while (true) {
			choice = InputUtil.getInt();
			switch (choice) {
			case 1:
				// continue borrow book
	
				// * 1. 把得到的书名 和 借书数量先存入 List<BorrowBook>中,
				// * 2. 跳转到借书菜单, 要求输入 bid
	
				break;
			case 2:
				// commit
				break;
			}
		}
	}*/
	//////////////////////////////////////////////////////////////////////////////////

	@Test
	public void test() {
		borrowIndex("kaka", 1002);
	}

}
