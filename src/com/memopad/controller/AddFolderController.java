package com.memopad.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;
import com.memopad.model.FileManager;

public class AddFolderController implements KeyListener {
	ObjectManager objectManager;
	GUI gui;	
	FileManager fileManager;
	
	public AddFolderController(ObjectManager objectManager, GUI gui, FileManager fileManager) {
		this.objectManager = objectManager;
		this.gui = gui;
		this.fileManager = fileManager;
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
			 String title = objectManager.uiData.getFolderTitleField().getText();
			 fileManager.writeFolder(title);
		   }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
