package com.memopad.model;

import java.io.File;
import java.util.ArrayList;

public class FileManager {
	public FileManager(FolderManager folderManager) {
		ArrayList<Folder> folderArrayList = folderManager.folderArrayList;
	}

	public void writeFolder(String title) {
		String path = "/Users/Kimmoonsu/Desktop/MemoData" + title; // ���� ���
		File folder = new File(path);

		// �ش� ���丮�� ������� ���丮�� �����մϴ�.
		if (!folder.exists()) {
			try {
				folder.mkdir(); // ���� �����մϴ�.

			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public void writeMemo() {
		
	}

}
