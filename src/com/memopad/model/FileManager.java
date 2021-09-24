package com.memopad.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public FileManager() {

	}

	public void writeFolder(String title) {
		String path = "C:\\Users\\jang6\\Desktop\\MemoData\\" + title; // 폴더 경로
		File folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!folder.exists()) {
			try {
				folder.mkdir(); // 폴더 생성합니다.
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
			sb.append(memo.getTitle());
			sb.append(memo.getContent());
			String memoPath = "C:\\Users\\jang6\\Desktop\\MemoData\\" + folderTitle;
			FileWriter fw;
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
