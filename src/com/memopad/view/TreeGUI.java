package com.memopad.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.memopad.model.Folder;
import com.memopad.model.FolderManager;
import com.memopad.model.Memo;
import com.memopad.model.ObjectManager;


public class TreeGUI extends JPanel {
	protected DefaultMutableTreeNode rootNode;
	protected DefaultTreeModel treeModel;
	protected JTree tree;
	private FolderManager folderManager;
	DefaultMutableTreeNode selectedNode, parentNode;

	public DefaultMutableTreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(DefaultMutableTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	public DefaultMutableTreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(DefaultMutableTreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeGUI(FolderManager folderManager) {
		super(new GridLayout(1, 0));
		this.folderManager = folderManager;

		rootNode = new DefaultMutableTreeNode("Jinseo Memo");
		treeModel = new DefaultTreeModel(rootNode);
		load();
		tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
	}
	
	public void reload() {
		clear();
		load();
		treeModel.reload();
	}

	public void clear() {
		rootNode.removeAllChildren();
		treeModel.reload();
	}

	public void load() {
		folderManager = ObjectManager.folderManager;
		ArrayList<Folder> folders = folderManager.getFolderList();

		DefaultMutableTreeNode folderNodes[] = new DefaultMutableTreeNode[folders.size()];

		for (int i = 0; i < folders.size(); i++) {
			folderNodes[i] = new DefaultMutableTreeNode(folders.get(i).getTitle());
			treeModel.insertNodeInto(folderNodes[i], rootNode, rootNode.getChildCount());
			ArrayList<Memo> memos = folders.get(i).getMemos();
			DefaultMutableTreeNode memoNodes[] = new DefaultMutableTreeNode[memos.size()];
			if (memos.size() == 0) {
				DefaultMutableTreeNode empty = new DefaultMutableTreeNode("No memo exists.");
				treeModel.insertNodeInto(empty, folderNodes[i], folderNodes[i].getChildCount());
			}
			for (int j = 0; j < memos.size(); j++) {
				memoNodes[j] = new DefaultMutableTreeNode(memos.get(j).getTitle());
				treeModel.insertNodeInto(memoNodes[j], folderNodes[i], folderNodes[i].getChildCount());
			}

			
//			DefaultMutableTreeNode empty = new DefaultMutableTreeNode("No memo exists.");
//			treeModel.insertNodeInto(empty, folderNodes[i], folderNodes[i].getChildCount());
		}
	}
	
	

//	public void addCategory(String title) {
//		DefaultMutableTreeNode category = new DefaultMutableTreeNode(title);
//		treeModel.insertNodeInto(category, rootNode, rootNode.getChildCount());
//		treeModel.reload();
//	}
	
	
}
