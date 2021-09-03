package com.memopad.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;

import com.memopad.model.Folder;
import com.memopad.model.ObjectManager;
import com.memopad.model.UiData;

public class MemoLoadingController implements MouseListener {
	JList folderList = null;
	
	public MemoLoadingController(UiData uiData) {
		this.folderList = uiData.getFolderList();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			 int index = folderList.locationToIndex(e.getPoint());
			 ArrayList<Folder> folders = ObjectManager.folderManager.getFolders();
			 Folder folder = folders.get(index);
			 
			 System.out.println("index : " + index);
			 System.out.println("title : " + folder.getTitle());
			 System.out.println("path : " + folder.getPath());
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
