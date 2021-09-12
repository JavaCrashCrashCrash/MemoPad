package com.memopad.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.memopad.model.Folder;
import com.memopad.model.FolderManager;

public class TreeGUI extends JPanel {
	protected DefaultMutableTreeNode rootNode;
	protected DefaultTreeModel treeModel[];
	protected JTree tree;
	private FolderManager folderManager;

	public TreeGUI(FolderManager folderManager) {
		super(new GridLayout(1, 0));
		this.folderManager = folderManager;

		rootNode = new DefaultMutableTreeNode("Jinseo Memo");
		ArrayList<Folder> folders = folderManager.getFolderList();
		DefaultMutableTreeNode folderNodes[] = new DefaultMutableTreeNode[folders.size()];
		for (int i = 0; i < folders.size(); i++) {
			folderNodes[i] = new DefaultMutableTreeNode(folders.get(i).getTitle());
			folderNodes[i].add(new DefaultMutableTreeNode("No memo exists."));
			rootNode.add(folderNodes[i]);
		}

		tree = new JTree(rootNode);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
	}
	
	public void add() {
		
		// create the child nodes
		

	}
}
