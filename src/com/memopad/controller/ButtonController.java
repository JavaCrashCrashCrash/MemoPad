package com.memopad.controller;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import com.memopad.model.FileManager;
import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn;
	private JList folderList, memoList;
	private JTextField folderTitleField;
	
	ObjectManager objectManager = new ObjectManager();
	GUI gui = new GUI(objectManager);
	FileManager fileManager = new FileManager(objectManager.folderManager);
	
	
	public ButtonController() {
		folderAddBtn = objectManager.uiData.getFolderAddBtn();
		folderDeleteBtn = objectManager.uiData.getFolderDeleteBtn();
		memoAddBtn = objectManager.uiData.getMemoAddBtn();
		memoDeleteBtn = objectManager.uiData.getMemoDeleteBtn();
		memoClearBtn = objectManager.uiData.getMemoClearBtn();
		
		folderAddBtn.addActionListener(new AddFolderUIController(objectManager, gui));
		folderDeleteBtn.addActionListener(new DeleteFolderController());
		memoAddBtn.addActionListener(new AddMemoController(gui));
		memoDeleteBtn.addActionListener(new DeleteMemoController());
		memoClearBtn.addActionListener(new ClearMemoController());
		
		folderList = objectManager.uiData.getFolderList();
		folderList.addMouseListener(new FolderLoadingController(objectManager, gui));
		
		folderTitleField = objectManager.uiData.getFolderTitleField();
		folderTitleField.addKeyListener(new AddFolderController(objectManager, gui, fileManager));
	}
}
