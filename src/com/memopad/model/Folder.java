package com.memopad.model;

import java.util.ArrayList;

public class Folder {
	String title;
	String path;
	ArrayList<Memo> memos;
	
	public Folder (String title, String path) {
		this.title = title;
		this.path = path;
		memos = new ArrayList<>();
	}
	
	public void addMemo(Memo memo) {
		memos.add(memo);
	}
	
	public void deleteMemo(Memo memo) {
		memos.remove(memo);
	}
	
	public void printMe() {
		System.out.println("==========Folder=============");
		System.out.println("title : " + title);
		System.out.println("path : " + path);
		System.out.println("=======================");
	}
	
	public void printMemoAll() {
		for (Memo memo : memos) {
			memo.printMemo();
		}
	}
}
