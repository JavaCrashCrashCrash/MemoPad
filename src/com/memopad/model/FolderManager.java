package com.memopad.model;

import java.util.ArrayList;
import java.util.Arrays;

public class FolderManager {
	ArrayList<Folder> folders;
	
	public FolderManager() {
		folders = new ArrayList<>();
	}
	
	public void testFolderList() {
		Folder a = new Folder("a", "desk");
		addFolder(a);
	}
	
	public ArrayList<Folder> getFolders() {
		return folders;
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
