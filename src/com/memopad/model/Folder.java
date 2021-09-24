package com.memopad.model;

import java.util.ArrayList;

public class Folder {
	private String title;
	private String path;
	private ArrayList<Memo> memos;
	
	public Folder (String title, String path) {
		this.title = title;
		this.path = path;
		memos = new ArrayList<>();
	}
	
	
	public ArrayList<Memo> getMemoArrayList(Folder folder) {
		return folder.memos;
	}
	

	
	public String getTitle() { return title; }
	
	

	public void setTitle(String title) { this.title = title; }

	

	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public ArrayList<Memo> getMemos() {
		return memos;
	}



	public void setMemos(ArrayList<Memo> memos) {
		this.memos = memos;
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
