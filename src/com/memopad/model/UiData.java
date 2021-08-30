package com.memopad.model;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UiData {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn;
	private JTextArea ta;
	
	public UiData() {
		ta = new JTextArea();
		folderAddBtn = new JButton("카테고리 추가");
		folderDeleteBtn = new JButton("카테고리 삭제");
		memoAddBtn = new JButton("메모 추가");
		memoDeleteBtn = new JButton("메모 삭제");
	}
	
	public JTextArea getTa() {
		return ta;
	}
	
	public void setTa(JTextArea ta) {
		this.ta = ta;
	}
	
	public JButton getFolderAddBtn() {
		return folderAddBtn;
	}
	
	public JButton getFolderDeleteBtn() {
		return folderDeleteBtn;
	}	
	
	public JButton getMemoAddBtn() {
		return memoAddBtn;
	}
	
	public JButton getMemoDeleteBtn() {
		return memoDeleteBtn;
	}
}
