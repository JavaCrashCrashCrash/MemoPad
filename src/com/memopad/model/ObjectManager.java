package com.memopad.model;

import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Folder> folderList;
	public static FolderManager folderManager = new FolderManager();
	public static FileManager fileManager = new FileManager(folderManager);
	public UiData uiData = new UiData();
}
