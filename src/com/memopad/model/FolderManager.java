package com.memopad.model;

import java.util.ArrayList;

public class FolderManager {
	ArrayList<Folder> FolderList;

	public void AddFolder(Folder folder) {
		FolderList.add(folder);
	}

	public void DeleteFolder(Folder folder) {
		FolderList.remove(folder);
	}
}
