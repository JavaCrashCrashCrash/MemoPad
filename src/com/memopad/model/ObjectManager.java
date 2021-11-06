package com.memopad.model;

import java.io.IOException;
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
		try {			
			init();
		} catch(IOException io) {
			io.printStackTrace();
		}
	}

	public void init() throws IOException {
		Map<String, ArrayList<String>> dirs = fileManager.readFolders();

		Set<String> key = dirs.keySet();

		Iterator<String> it = key.iterator();

		ArrayList<String> folders = new ArrayList<String>();

		while (it.hasNext()) {
			String folder = it.next();
			folders.add(folder);
			ArrayList<String> memoTitles = dirs.get(folder);
			ArrayList<Memo> memos = new ArrayList<>();
			for (String m : memoTitles) {
				String memoContent = fileManager.readMemo(folder, m);
				Memo memo = new Memo(m, memoContent);
				memos.add(memo);
			}
			folderManager.initFolders(folder, memos);
		}
//		folderManager.insertFolders(folders);
	}
}
