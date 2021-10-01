package com.memopad.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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

	public String read() throws IOException {
		FileReader fr = new FileReader(LOCAL_PATH);
		BufferedReader br = new BufferedReader(fr);

		String str = null;
		StringBuilder sb = new StringBuilder();

		while ((str = br.readLine()) != null) {
			sb.append(str + "\n");
		}
		return sb.toString();
	}

	public ArrayList<String> readFolders() {
		ArrayList<String> folderTitles = new ArrayList<>();
		for (File info : new File(LOCAL_PATH).listFiles()) {
			if (info.isDirectory()) {
				String folderTitle = info.getName();
				folderTitles.add(folderTitle);
			}
		}
		return folderTitles;
	}
	
}
