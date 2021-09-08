package com.memopad.model;

public class Memo {
	public String title;
	public String content;

	public Memo(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void printMemo() {
		System.out.println("===========Memo===========");
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		System.out.println("=======================");
	}

}
