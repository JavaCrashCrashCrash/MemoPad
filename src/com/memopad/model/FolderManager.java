package com.memopad.model;

import java.util.ArrayList;

public class FolderManager {
	ArrayList<Folder> folderArrayList;
	FileManager fileManager;
	String selectedFolderTitle;
	String selectedMemoTitle;

	public String getSelectedFolder() {
		return selectedFolderTitle;
	}

	public void setSelectedFolder(String selectedFolderTitle) {
		this.selectedFolderTitle = selectedFolderTitle;
	}
	
	public String getSelectedMemo() {
		return selectedMemoTitle;
	}
	
	public void setSelectedMemo(String selectedMemoTitle) {
		this.selectedMemoTitle = selectedMemoTitle;
	}

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

	public Folder getFolder(String title) {
		Folder folder;

		try {
			for (int i = 0; i < folderArrayList.size(); i++) {
				if (folderArrayList.get(i).getTitle() == title) {
					folder = folderArrayList.get(i);
					return folder;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return folder = new Folder("null", "null");
		}
		
		return folder = new Folder("null", "null");
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
	
	public Folder getFolderByTitle(String folderTitle) {
		Folder folder;
		for (int i = 0; i < folderArrayList.size(); i++) {
			folder = folderArrayList.get(i);
			if (folder.getTitle() == folderTitle) {
				return folder;
			}
		}
		return null;
	}

	public void printFolderAll() {
		for (Folder folder : folderArrayList) {
			folder.printMe();
			folder.printMemoAll();
		}
	}
}
