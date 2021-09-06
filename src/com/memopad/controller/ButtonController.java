package com.memopad.controller;

import javax.swing.JButton;
import javax.swing.JList;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn;
	private JList folderList, memoList;
	
	ObjectManager objectManager = new ObjectManager();
	GUI gui = new GUI(objectManager);
	
	public ButtonController() {
		folderAddBtn = objectManager.uiData.getFolderAddBtn();
		folderDeleteBtn = objectManager.uiData.getFolderDeleteBtn();
		memoAddBtn = objectManager.uiData.getMemoAddBtn();
		memoDeleteBtn = objectManager.uiData.getMemoDeleteBtn();
		memoClearBtn = objectManager.uiData.getMemoClearBtn();
		
		folderAddBtn.addActionListener(new AddFolderController(gui));
		folderDeleteBtn.addActionListener(new DeleteFolderController());
		memoAddBtn.addActionListener(new AddMemoController(gui));
		memoDeleteBtn.addActionListener(new DeleteMemoController());
		memoClearBtn.addActionListener(new ClearMemoController());
		
		folderList = objectManager.uiData.getFolderList();
		folderList.addMouseListener(new MemoLoadingController(objectManager));
	}
}
