package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class DeleteMemoController implements ActionListener {
	ObjectManager objectManager;
	GUI gui;

	public DeleteMemoController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) gui.treeGUI.getSelectedNode();
		if (selectedNode != null) {
			objectManager.folderManager.setSelectedFolder(gui.treeGUI.getSelectedNode().getParent().toString());
			objectManager.folderManager.setSelectedMemo(gui.treeGUI.getSelectedNode().getUserObject().toString());
		}

		// TODO Auto-generated method stub
		String path = "C:\\Users\\jang6\\Desktop\\MemoData\\" + objectManager.folderManager.getSelectedFolder() + "\\"
				+ objectManager.folderManager.getSelectedMemo() + ".txt";
		System.out.println(path);
		File memo = new File(path);
		memo.delete();
	}

}
