package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class AddFolderUIController implements ActionListener {
	ObjectManager objectManager;
	GUI gui;
	JTextField folderTitleField;
	
	public AddFolderUIController(ObjectManager objectManager, GUI gui) {
		this.objectManager  = objectManager;
		this.gui = gui;
		this.folderTitleField = objectManager.uiData.getFolderTitleField();
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gui.folderAddUI();
	}
	
}
