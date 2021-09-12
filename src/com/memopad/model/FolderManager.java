package com.memopad.model;

import java.util.ArrayList;

public class FolderManager {
	ArrayList<Folder> folderArrayList;
	FileManager fileManager;
	
	public FolderManager() {
		folderArrayList = new ArrayList<>();
		fileManager = new FileManager();
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
	
	public void addFolder(String title) {
		Folder folder = new Folder(title, "");
		addFolder(folder);
		
	}

	public void addFolder(Folder folder) {
		folderArrayList.add(folder);
		fileManager.writeFolder(folder.getTitle());
	}
	
	public void addFolder(String title, String path) {
		Folder folder = new Folder(title, path);
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
