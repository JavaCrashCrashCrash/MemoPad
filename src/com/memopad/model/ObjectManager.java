package com.memopad.model;

public class ObjectManager {
	public static FolderManager folderManager = new FolderManager();
	public static FileManager fileManager = new FileManager(folderManager);
	public UiData uiData = new UiData();
}
