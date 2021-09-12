package com.memopad.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.memopad.model.FolderManager;
import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class AddFolderController extends KeyAdapter {
	ObjectManager objectManager;
	GUI gui;	
	FolderManager folderManager;
	
	public AddFolderController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
		this.folderManager = objectManager.folderManager;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		      // Enter was pressed. Your code goes here.
			 String title = gui.folderTitleField.getText();
			 folderManager.addFolder(title, "C:\\Users\\jang6\\Desktop\\MemoData\\" + title);
			 gui.setFolderTitleField("");
			 gui.folderAddFrame.dispose();
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
