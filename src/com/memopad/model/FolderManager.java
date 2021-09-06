package com.memopad.model;

import java.util.ArrayList;
import java.util.Arrays;

public class FolderManager {
	ArrayList<Folder> folderArrayList;
	
	public FolderManager() {
		folderArrayList = new ArrayList<>();
	}
	
	public void testFolderList() {
		Folder a = new Folder("a", "desk");
		Folder b = new Folder("b", "top");
		addFolder(a);
		addFolder(b);
	}
	
	public ArrayList<Folder> getFolderList() {
		return folderArrayList;
	}

	public void addFolder(Folder folder) {
		folderArrayList.add(folder);
	}

	public void deleteFolder(Folder folder) {
		folderArrayList.remove(folder);
	}
	
	public void printFolderAll() {
		for (Folder folder : folderArrayList) {
			folder.printMe();
			folder.printMemoAll();
		}
	}
}
