package com.memopad.controller;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import com.memopad.model.FileManager;
import com.memopad.model.FolderManager;
import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn, memoSaveBtn;
	private JList folderList, memoList;
	private JTextField folderTitleField;
	
	GUI gui;
	FileManager fileManager;
	FolderManager folderManager;
	
	public ButtonController(ObjectManager objectManager) {
		gui = new GUI(objectManager);
		folderManager = objectManager.folderManager;
		fileManager = objectManager.fileManager;
		
		folderAddBtn = objectManager.uiData.getFolderAddBtn();
		folderDeleteBtn = objectManager.uiData.getFolderDeleteBtn();
		memoAddBtn = objectManager.uiData.getMemoAddBtn();
		memoDeleteBtn = objectManager.uiData.getMemoDeleteBtn();
		memoClearBtn = objectManager.uiData.getMemoClearBtn();
		memoSaveBtn = objectManager.uiData.getMemoSaveBtn();
		
		folderAddBtn.addActionListener(new AddFolderUIController(objectManager, gui));
		folderDeleteBtn.addActionListener(new DeleteFolderController());
		memoAddBtn.addActionListener(new AddMemoUIController(gui));
		memoDeleteBtn.addActionListener(new DeleteMemoController());
		memoClearBtn.addActionListener(new ClearMemoController());
		memoSaveBtn.addActionListener(new AddMemoController(objectManager, gui));
		
		folderList = objectManager.uiData.getFolderList();
		folderList.addMouseListener(new FolderLoadingController(objectManager, gui));
		
		folderTitleField = objectManager.uiData.getFolderTitleField();
		
//		gui.mainFrame.addT;
		
	}
}
