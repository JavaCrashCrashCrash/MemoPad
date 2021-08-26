package com.memopad.model;

import java.util.ArrayList;

public class FolderManager {
	ArrayList<Folder> folders;
	
	public FolderManager() {
		folders = new ArrayList<>();
	}

	public void addFolder(Folder folder) {
		folders.add(folder);
	}

	public void deleteFolder(Folder folder) {
		folders.remove(folder);
	}
	
	public void printFolderAll() {
		for (Folder folder : folders) {
			folder.printMe();
			folder.printMemoAll();
		}
	}
}
