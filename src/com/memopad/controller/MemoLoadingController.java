package com.memopad.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.memopad.model.Folder;
import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class MemoLoadingController extends ObjectManager implements MouseListener {
	ObjectManager objectManager;
	GUI gui;
	
	public MemoLoadingController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
//			 int index = gui.getMemoList().locationToIndex(e.getPoint());
//			 ArrayList<Folder> folders = ObjectManager.folderManager.getFolderList();
//			 Folder folder = folders.get(index);
			 
//			 gui.memoUI(folder);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}