package com.memopad.model;

import java.util.ArrayList;

public class Folder {
	String title;
	String path;
	ArrayList<Memo> MemoList;
	
	Folder (String title, String path) {
		this.title = title;
		this.path = path;
	}
	
	public void AddMemo(Memo memo) {
		MemoList.add(memo);
	}
	
	public void DeleteMemo(Memo memo) {
		MemoList.remove(memo);
	}
}
