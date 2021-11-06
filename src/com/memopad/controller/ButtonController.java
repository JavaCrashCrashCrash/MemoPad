package com.memopad.controller;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.tree.*;

import com.memopad.model.FileManager;
import com.memopad.model.FolderManager;
import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn, memoSaveBtn;
	private JList folderList, memoList;
	private JTextField folderTitleField;

	public GUI gui;
	FileManager fileManager;
	FolderManager folderManager;

	public ButtonController(ObjectManager objectManager) {
		gui = new GUI(objectManager);
		folderManager = objectManager.folderManager;
		fileManager = objectManager.fileManager;
//		AddMemoController addMemoController = new AddMemoController(objectManager, gui);
//		DeleteFolderController deleteFolderController = new DeleteFolderController(objectManager, gui);
//		DeleteMemoController deleteMemoController = new DeleteMemoController(objectManager, gui);
		TreeNodeSetter treeNodeSetter = new TreeNodeSetter(objectManager, gui);
		gui.getTree().getSelectionModel().addTreeSelectionListener(treeNodeSetter);

		folderAddBtn = objectManager.uiData.getFolderAddBtn();
		folderDeleteBtn = objectManager.uiData.getFolderDeleteBtn();
		memoAddBtn = objectManager.uiData.getMemoAddBtn();
		memoDeleteBtn = objectManager.uiData.getMemoDeleteBtn();
		memoClearBtn = objectManager.uiData.getMemoClearBtn();
		memoSaveBtn = objectManager.uiData.getMemoSaveBtn();

		folderAddBtn.addActionListener(new AddFolderUIController(objectManager, gui));
		folderDeleteBtn.addActionListener(new DeleteFolderController(objectManager, gui));
//		gui.getTree().getSelectionModel().addTreeSelectionListener(deleteFolderController);
		memoAddBtn.addActionListener(new AddMemoUIController(gui));
		memoDeleteBtn.addActionListener(new DeleteMemoController(objectManager, gui));
//		gui.getTree().getSelectionModel().addTreeSelectionListener(deleteMemoController);
		memoClearBtn.addActionListener(new ClearMemoController(objectManager, gui));
		memoSaveBtn.addActionListener(new AddMemoController(objectManager, gui));
//		gui.getTree().getSelectionModel().addTreeSelectionListener(addMemoController);


		folderList = objectManager.uiData.getFolderList();
		folderList.addMouseListener(new FolderLoadingController(objectManager, gui));

		folderTitleField = objectManager.uiData.getFolderTitleField();
		
//		memoList = 
		gui.getTree().addMouseListener(new MemoLoadingController(objectManager, gui));

//		gui.mainFrame.addT;

	}
	
	
}
