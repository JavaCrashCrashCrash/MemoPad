package com.memopad.model;

import java.util.ArrayList;

public class FolderManager {
	ArrayList<Folder> folderArrayList;
	FileManager fileManager = new FileManager();
	
	public FolderManager() {
		folderArrayList = new ArrayList<>();
		FileManager fileManager = new FileManager();
	}
	
	public void testFolderList() {
		Folder a = new Folder("a", "desk");
		Folder b = new Folder("b", "top");
		addFolder(a);
		addFolder(b);
	}
	
	
	public Folder getFolder(int index) {
		return folderArrayList.get(index);
	}
	
	
	public ArrayList<Folder> getFolderList() {
		return folderArrayList;
	}

	public void addFolder(Folder folder) {
		folderArrayList.add(folder);
		fileManager.writeFolder(folder.getTitle());
		
	}
	
	public void addFolder(String title, String path) {
		Folder folder = new Folder(title, "C:\\Users\\jang6\\Desktop\\MemoData\\" + title);
		folderArrayList.add(folder);
		fileManager.writeFolder(title);
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
