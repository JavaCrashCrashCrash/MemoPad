package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class DeleteMemoController implements ActionListener, TreeSelectionListener {
	ObjectManager objectManager;
	GUI gui;

	public DeleteMemoController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\jang6\\Desktop\\MemoData\\" + objectManager.folderManager.getSelectedFolder() ;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) gui.getTree().getLastSelectedPathComponent();
		if (selectedNode != null) {
			objectManager.folderManager.setSelectedFolder(selectedNode.getUserObject().toString());
//			System.out.println(folderTitle);
		}

	}
}
