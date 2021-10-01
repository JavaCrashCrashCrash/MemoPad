package com.memopad.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public static final String LOCAL_PATH = "C:\\Users\\jang6\\Desktop\\MemoData\\";
	
	public FileManager() {

	}

	public void writeFolder(String title) {
		String path = LOCAL_PATH + title; 
		File folder = new File(path);

		if (!folder.exists()) {
			try {
				folder.mkdir(); 
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {

		}
	}

	public void deleteFolder(String path) {

		File folder = new File(path);

		if (folder.exists()) {
			try {
				folder.delete();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}

	public void writeMemo(String folderTitle, Memo memo) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(memo.getTitle() + "\n");
			sb.append(memo.getContent());
			String memoPath = LOCAL_PATH + folderTitle + "\\" + memo.getTitle() + ".txt";
			FileWriter fw;
			System.out.println(memoPath);
			fw = new FileWriter(memoPath);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read() {
		
	}

}
