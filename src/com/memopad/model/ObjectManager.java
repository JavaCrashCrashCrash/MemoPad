package com.memopad.model;

import java.util.ArrayList;

public class ObjectManager {
	public static FolderManager folderManager;
	public static FileManager fileManager;
	public static UiData uiData;

	public ObjectManager() {
		folderManager = new FolderManager();
		fileManager = new FileManager();
		uiData = new UiData();
		init();
	}
	
	public void init() {
		ArrayList<String> folderTitles = fileManager.readFolders();
		folderManager.insertFolders(folderTitles);
	}
}
