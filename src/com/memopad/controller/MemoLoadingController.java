package com.memopad.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import com.memopad.model.Folder;
import com.memopad.model.Memo;
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
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) gui.treeGUI.getSelectedNode();

			if (selectedNode != null && selectedNode.getChildCount() == 0) {
				String parentNodeTitle = gui.treeGUI.getSelectedNode().getParent().toString();
				String currentNodeTitle = gui.treeGUI.getSelectedNode().getUserObject().toString();
				Folder folder = ObjectManager.folderManager.getFolder(parentNodeTitle);
				Memo memo = folder.getMemo(currentNodeTitle);
				gui.memoAddUI(memo);
			}

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
