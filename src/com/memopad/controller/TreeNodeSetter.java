package com.memopad.controller;

import java.awt.event.ActionListener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class TreeNodeSetter implements TreeSelectionListener {
	ObjectManager objectManager;
	GUI gui;
	
	public TreeNodeSetter (ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) gui.getTree().getLastSelectedPathComponent();
		gui.treeGUI.setSelectedNode(selectedNode);
		if(selectedNode.getParent() != null) {
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
			gui.treeGUI.setParentNode(parentNode);
		}
		
		
	}

}
