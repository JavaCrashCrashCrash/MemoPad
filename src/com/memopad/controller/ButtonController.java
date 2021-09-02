package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.memopad.model.FolderManager;
import com.memopad.model.ObjectManager;
import com.memopad.model.UiData;
import com.memopad.view.GUI;

public class ButtonController {
	private JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn;
	
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
	}
}
