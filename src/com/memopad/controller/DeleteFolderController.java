package com.memopad.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.memopad.model.ObjectManager;
import com.memopad.view.GUI;

public class DeleteFolderController implements ActionListener, TreeSelectionListener {
	ObjectManager objectManager;
	GUI gui;

	public DeleteFolderController(ObjectManager objectManager, GUI gui) {
		this.objectManager = objectManager;
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\jang6\\Desktop\\MemoData\\" + objectManager.folderManager.getSelectedFolder();
		File folder = new File(path);
		try {
			while (folder.exists()) {
				File[] folderList = folder.listFiles(); // 파일리스트 얻어오기

				for (int j = 0; j < folderList.length; j++) {
					folderList[j].delete(); // 파일 삭제
				}

				if (folderList.length == 0 && folder.isDirectory()) {
					folder.delete(); // 대상폴더 삭제
					gui.treeGUI.reload();
				}
			}
		} catch (Exception e1) {
			e1.getStackTrace();
		}
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
