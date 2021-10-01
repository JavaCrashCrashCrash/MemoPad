package com.memopad.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


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
		Map<String, ArrayList<String>> dirs = new HashMap<>();
		
		ArrayList<String> folderTitles = new ArrayList<>();
		for (File info : new File(LOCAL_PATH).listFiles()) {
			if (info.isDirectory()) {
				String folderTitle = info.getName();
				ArrayList<String> memos = new ArrayList<>();
				for (File memo : new File(LOCAL_PATH + folderTitle).listFiles()) {
					String memoTitle = memo.getName();
					memos.add(memoTitle);
				}
				dirs.put(folderTitle, memos);
//				folderTitles.add(folderTitle);
			
			}
		}
		
		return folderTitles;
	} 
	
	public static void main(String[] args) {
		Map<String, ArrayList<String>> dirs = new HashMap<>();
		ArrayList<String> memos = new ArrayList<>();
		memos.add("1.txt");
		memos.add("2.txt");
		
		dirs.put("Folder3", memos);

		ArrayList<String> memos2 = new ArrayList<>();
		memos2.add("a.txt");
		memos2.add("b.txt");
		dirs.put("Folder2", memos);
		
		Set<String> key = dirs.keySet();
		Iterator<String> it = key.iterator();
		while(it.hasNext()) {
			String folder = it.next();
			System.out.println(folder);
			ArrayList<String> memo = dirs.get(folder);
			for (String m : memo) {
				System.out.println(m);
			}
		}
		
		
	}
}
