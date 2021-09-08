package com.memopad.model;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
	public FileManager(FolderManager folderManager) {
		ArrayList<Folder> folderArrayList = folderManager.folderArrayList;
	}

	public void writeFolder(String title) {
		String path = "/Users/Kimmoonsu/Desktop/MemoData" + title; // 폴더 경로
		File folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!folder.exists()) {
			try {
				folder.mkdir(); // 폴더 생성합니다.

			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public void writeMemo() {
		
	}

}
