package com.memopad.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
		Map<String, ArrayList<String>> dirs = fileManager.readFolders();

		Set<String> key = dirs.keySet();

		Iterator<String> it = key.iterator();

		ArrayList<String> folders = new ArrayList<String>();

		while (it.hasNext()) {
			String folder = it.next();
			folders.add(folder);
			ArrayList<String> memo = dirs.get(folder);
			for (String m : memo) {
				System.out.println(m);
			}
//			folderManager.initFolders(folder, );
		}
		folderManager.insertFolders(folders);
	}
}
