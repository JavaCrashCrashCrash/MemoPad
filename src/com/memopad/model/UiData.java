package com.memopad.model;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UiData {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn, memoSaveBtn;
	private JTextField folderTitleField;
	private JTextArea memoArea;
	private JList folderList, memoList;
	
	public UiData() {
		folderAddBtn = new JButton("Add Category");
		folderDeleteBtn = new JButton("Delete Category");
		memoAddBtn = new JButton("Add Memo");
		memoDeleteBtn = new JButton("Delete Memo");
		memoSaveBtn = new JButton("Save");
		memoClearBtn = new JButton("Clear");
		folderTitleField = new JTextField();
		memoArea = new JTextArea();
		folderList = new JList();
		memoList = new JList();
		// test code
		ObjectManager.folderManager.testFolderList();
		Folder a = ObjectManager.folderManager.getFolder(0);
		a.testMemoList();
	}
	
	public JButton getMemoSaveBtn() {
		return memoSaveBtn;
	}

	public JList getFolderList() {
		ArrayList<Folder> folders = ObjectManager.folderManager.getFolderList();
		String[] titles = new String[folders.size()];
		for (int i = 0; i < folders.size(); i++) {
			titles[i] = folders.get(i).getTitle();
		}
		folderList.setListData(titles);
		return folderList;
	}
	
	public JList getMemoList(Folder folder) {
		ArrayList<Memo> memos = folder.getMemos();
		String[] memoTitles = new String[memos.size()];
		for (int i = 0; i < memos.size(); i++) {
			memoTitles[i] = memos.get(i).getTitle();
 		}
		memoList.setListData(memoTitles);
		return memoList;
	}
	
	public JTextArea getMemoArea() {
		return memoArea;
	}
	
	public void setMemoArea(String text) {
		memoArea.setText(text);
	}
	
	public JTextField getFolderTitleField() {
		return folderTitleField;
	}
	
	public void setFolderTitleField(String title) {
		folderTitleField.setText(title);
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
	
	public JButton getMemoClearBtn() {
		return memoClearBtn;
	}
}
