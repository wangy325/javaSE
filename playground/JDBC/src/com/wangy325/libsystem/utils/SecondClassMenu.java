package com.wangy325.libsystem.utils;

import java.util.List;

import org.junit.Test;

import com.wangy325.libsystem.bean.BorrowRecord;
import com.wangy325.libsystem.service.LibServices;

/**
 * 
 * @author wangy325
 *
 * @date Jan 11, 2018-- 8:20:43 PM
 *
 * @description 2nd user interface of library management system
 * 
 * @TODO
 * 		1. query all book's info, including book's name and book's number;
 *       2. borrow books
 *       3. return books
 *       4. query student info (books borrowed form library)
 *       5. back to upper menu
 * @additional once a new option was executed, you can check all book/ student
 *             info immediately.
 *
 */
public class SecondClassMenu {

	public static void getStart(String username) {
		while (true) {
			System.out.println("welcom to our library," + username + "!");
			System.out.println("\t 1. query all books' info of our library");
			System.out.println("\t 2. borrow books");
			System.out.println("\t 3. return books");
			System.out.println("\t 4. query your borrowed record");
			System.out.println("\t 5. log out and back to upper menu");
			int choice = InputUtil.getInt();
			switch (choice) {
			case 1: // query all books info
				LibServices.queryAll();
				break;
			case 2: // borrow book
				/**
				 * 1. input book id (or book name)
				 * 2. check weather book exist or not (query)
				 * 		 1. book has no index in library
				 * 		 2. book has no remnant
				 * 3. show book info, and acquire the number user want to borrow
				 * 		 1. number must less equal to the remnant number
				 * 4. get the variable BID and BNUMBER (update)
				 * 		 1. update database Library and database STU
				 * 		 2. write record to record.log(append)
				 */
				System.out.println("please input bid of a precise book:");
				int bid = 0;
				// check bid exist or not
				while (true) {
					bid = InputUtil.getInt();
					if (!(CheckUtil.check(bid)))
						System.out.println("bid invalid, try again");
					else
						break;
				}
				ThirdClassMenu.borrowIndex(username, bid);
				break;
			case 3: // return books
				System.out.println("please input the bookname you want to return:");
				String boName = InputUtil.getStr();
				List<BorrowRecord> boList = BlobUtil.getBLOB(username);
				int boNum = 0;
				int count = 0;
				if (boList == null)
					System.out.println("you haven't borrowed book(s) form library yet.");
				else {
					for (BorrowRecord br : boList) {
						if (boName.equals(br.getBorrowedBookName())) {
							boNum = br.getBorrowedBookNum();
							count++;
							System.out.println("you have borrowed " + boNum + " " + boName + "(s) from library");
						}
					}
				}
				if (count == 0) {
					System.out.println("you haven't borrowed " + boName
							+ " from library, you'd better check your borrow record first.");
					break;
				}
				System.out.println("please input the quantity of book you want to return:");
				int reNum = 0;
				while (true) {
					reNum = InputUtil.getInt();
					if(reNum <= 0 || reNum > boNum) {
						System.out.println("invalid inpput , try again");
					}else {
						break;
					}
				}
				// already get book name and borrowed number for user
				// ready to execute the SQL statement
				ThirdClassMenu.returnBook(username, boName, reNum,boNum);
				break;
			case 4: // query current user's borrow information
				List<BorrowRecord> brList = BlobUtil.getBLOB(username);
				if (brList == null)
					System.out.println("you haven't borrowed book(s) form library yet.");
				else {
					System.out.println(username + "'s borrow record: ");
					for (BorrowRecord br : brList) {
						System.out.println(br);
					}
				}
				break;
			case 5:
				return;
			}
		}
	}

	@Test
	public void test() {
		getStart("hello");
	}
}
