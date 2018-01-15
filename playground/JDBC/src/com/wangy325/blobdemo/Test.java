package com.wangy325.blobdemo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.BLOB;
/**
 * 
 * @author wangy325
 *
 * @date Jan 13, 2018-- 5:34:51 PM
 *
 * @description 代码来源于网络, 用于测试将 Java 对象以BLOB形式存入数据库并取出.
 *
 */
public class Test {

	public static void main(String[] args) {
		// 创建测试用对象
		City beijing = new City();
		beijing.setName("北京");
		beijing.setCode("010");

		City shanghai = new City();
		shanghai.setName("上海");
		shanghai.setCode("020");

		City tianjin = new City();
		tianjin.setName("天津");
		tianjin.setCode("021");

		List<City> cityList = new ArrayList<City>();
		cityList.add(beijing);
		cityList.add(shanghai);
		cityList.add(tianjin);

		TestObject obj = new TestObject();
		obj.setName("yangsq");
		obj.setPassword("111");
		obj.setDate(new Date());
		obj.setCityList(cityList);

		try {
			// 将对象存入blob字段
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream outObj = new ObjectOutputStream(byteOut);
			outObj.writeObject(obj);
			final byte[] objbytes = byteOut.toByteArray();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.152:1521:orcl", "scott",
					"tiger");
			con.setAutoCommit(false);
			Statement st = con.createStatement();

			st.executeUpdate("insert into TESTBLOB (ID, NAME, CONTENT) values (1, 'test1', empty_blob())");
			ResultSet rs = st.executeQuery("select CONTENT from TESTBLOB where ID=1 for update");

			if (rs.next()) {
				BLOB blob = (BLOB) rs.getBlob("CONTENT");
				@SuppressWarnings("deprecation")
				OutputStream outStream = blob.getBinaryOutputStream();
				outStream.write(objbytes, 0, objbytes.length);
				outStream.flush();
				outStream.close();
			}

			byteOut.close();
			outObj.close();
			con.commit();

			// 取出blob字段中的对象，并恢复
			rs = st.executeQuery("select CONTENT from TESTBLOB where ID=1");
			BLOB inblob = null;
			if (rs.next()) {
				inblob = (BLOB) rs.getBlob("CONTENT");
			}
			InputStream is = inblob.getBinaryStream();
			BufferedInputStream input = new BufferedInputStream(is);

			byte[] buff = new byte[inblob.getBufferSize()];
			while (-1 != (input.read(buff, 0, buff.length)))
				;

			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
			TestObject w3 = (TestObject) in.readObject();
			System.out.println(w3.getName());
			System.out.println(w3.getPassword());
			System.out.println(w3.getDate());

			List<City> list = w3.getCityList();
			for (City city : list) {
				System.out.println(city.getName() + "    " + city.getCode());
			}

			st.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}
