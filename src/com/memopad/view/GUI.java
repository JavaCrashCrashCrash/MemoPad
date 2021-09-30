package com.memopad.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.memopad.controller.AddFolderController;
import com.memopad.model.Folder;
import com.memopad.model.FolderManager;
import com.memopad.model.Memo;
import com.memopad.model.ObjectManager;
import com.memopad.model.UiData;

public class GUI {
	public JFrame mainFrame = new JFrame();
	public JFrame folderAddFrame = new JFrame();
	public JFrame memoAddFrame = new JFrame();
	JFrame memoFrame = new JFrame();
	public JPanel mainPanel = new JPanel();
	JPanel memoPanel = new JPanel();
	JPanel memoAddPanel = new JPanel();
	JTree tree;
	public TreeGUI treeGUI;
	JList folderList, memoList;
	AddFolderController addFolderController = null;

	public JList getFolderList() {
		return folderList;
	}

	public void setFolderList(JList folderList) {
		this.folderList = folderList;
	}

	public JTextArea memoArea;
	public JTextField folderTitleField;
	JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn, memoSaveBtn;

	UiData uiData;
	ObjectManager objectManager;
	FolderManager folderManager;
	ArrayList<Folder> folders;

	public GUI(ObjectManager objectManager) {
		this.objectManager = objectManager;
		this.uiData = objectManager.uiData;
		this.folderManager = objectManager.folderManager;
		this.folders = folderManager.getFolderList();
		test();
	}

	private void test() {
		// Create the components.
		treeGUI = new TreeGUI(folderManager);
		mainPanel = new JPanel(new BorderLayout());

		// Lay everything out.
		treeGUI.setPreferredSize(new Dimension(500, 300));
		mainPanel.add(treeGUI, BorderLayout.CENTER);

		JPanel panel = new JPanel(new GridLayout(1, 2));
		panel.add(folderAddBtn = uiData.getFolderAddBtn());
		panel.add(folderDeleteBtn = uiData.getFolderDeleteBtn());
		panel.add(memoAddBtn = uiData.getMemoAddBtn());
		panel.add(memoDeleteBtn = uiData.getMemoDeleteBtn());
		mainPanel.add(panel, BorderLayout.SOUTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.

		mainPanel.setOpaque(true); // content panes must be opaque
		mainFrame.setContentPane(mainPanel);

		// Display the window.
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setTitle("Memo Pad");
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
	}

	public void folderAddUI() {
		
		folderAddFrame.setBounds(600, 400, 300, 150);
		folderAddFrame.setVisible(true);
		folderAddFrame.setResizable(false);
		folderAddFrame.setTitle("Add Category");
		folderAddFrame.setLayout(null);
		JLabel folderAddLabel = new JLabel("Set category title.\n");
		folderAddLabel.setBounds(20, -20, 300, 100);
		folderAddLabel.setFont(new Font("gulim", Font.PLAIN, 15));
		folderAddFrame.add(folderAddLabel);
		
		folderTitleField = uiData.getFolderTitleField();
		folderTitleField.setBounds(20, 50, 200, 30);
		if (addFolderController == null) {			
			folderTitleField.addKeyListener(addFolderController = new AddFolderController(objectManager, this));
		}
		folderAddFrame.add(folderTitleField);
	}

	public void memoUI(Folder folder) {
		memoFrame.setBounds(600, 200, 415, 700);
		memoFrame.setVisible(true);
		memoFrame.setResizable(false);
		memoFrame.setTitle(folder.getTitle());
		memoFrame.setLayout(null);
		memoFrame.add(memoPanel);
		memoPanel.setLayout(null);
		memoPanel.setBounds(0, 0, 400, 700);

		memoList = uiData.getMemoList(folder);
		memoList.setBounds(0, 50, 400, 650);
		memoList.setFixedCellHeight(30);
		memoList.setCellRenderer(new DefaultListCellRenderer() {
			public int getHorizontalAlignment() {
				return CENTER;
			}
		});
		memoPanel.add(memoList);
		JScrollPane jsp2 = new JScrollPane(); // 筌∽옙 占쎈뮞占쎄쾿嚥∽옙
		jsp2.setBounds(0, 50, 400, 650); // 占쎈뮞占쎄쾿嚥∽옙 占쎄텢占쎌뵠筌앾옙 占쎄퐬占쎌젟
		memoPanel.add(jsp2); // �굜�꼹�쀯㎘占� 占쎈솇占쎄퐶占쎈퓠 占쎈뮞占쎄쾿嚥∽옙 �빊遺쏙옙

		memoPanel.add(memoAddBtn = uiData.getMemoAddBtn());
		memoAddBtn.setBounds(0, 0, 200, 50);
		memoPanel.add(memoDeleteBtn = uiData.getMemoDeleteBtn());
		memoDeleteBtn.setBounds(200, 0, 200, 50);
	}

	public void memoAddUI() {
		memoAddFrame.setBounds(500, 300, 765, 500);
		memoAddFrame.setVisible(true);
		memoAddFrame.setResizable(false);
		memoAddFrame.setTitle("Add Memo");
		memoAddFrame.add(memoAddPanel);
		memoAddPanel.setBounds(0, 0, 800, 500);
		memoAddPanel.setLayout(null);

		memoArea = uiData.getMemoArea();
		memoAddPanel.add(memoArea);
		JScrollPane scroll = new JScrollPane(memoArea);
		scroll.setBounds(20, 20, 600, 420);
		memoAddPanel.add(scroll);

		memoAddPanel.add(memoSaveBtn = uiData.getMemoSaveBtn());
		memoSaveBtn.setBounds(640, 22, 90, 50);
		memoAddPanel.add(memoClearBtn = uiData.getMemoClearBtn());
		memoClearBtn.setBounds(640, 92, 90, 50);
	}

	public void memoAddUI(Memo memo) {
		memoAddFrame.setBounds(500, 300, 765, 500);
		memoAddFrame.setVisible(true);
		memoAddFrame.setResizable(false);
		memoAddFrame.setTitle(memo.getTitle());
		memoAddFrame.add(memoAddPanel);
		memoAddPanel.setBounds(0, 0, 800, 500);
		memoAddPanel.setLayout(null);

		memoArea = uiData.getMemoArea();
		memoArea.setText(memo.getContent());
		memoAddPanel.add(memoArea);
		JScrollPane scroll = new JScrollPane(memoArea);
		scroll.setBounds(20, 20, 600, 420);
		memoAddPanel.add(scroll);

		memoAddPanel.add(memoSaveBtn = uiData.getMemoSaveBtn());
		memoSaveBtn.setBounds(640, 22, 90, 50);
		memoAddPanel.add(memoClearBtn = uiData.getMemoClearBtn());
		memoClearBtn.setBounds(640, 92, 90, 50);
	}

	public void setFolderTitleField(String text) {
		folderTitleField.setText(text);
	}
	
	public JTree getTree() {
		return treeGUI.tree;
	}
	
	public void setMemoArea(String text) {
		memoArea.setText(text);
	}
}