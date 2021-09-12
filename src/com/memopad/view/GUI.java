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

import com.memopad.model.Folder;
import com.memopad.model.FolderManager;
import com.memopad.model.Memo;
import com.memopad.model.ObjectManager;
import com.memopad.model.UiData;

public class GUI {
	JFrame mainFrame = new JFrame();
	JFrame folderAddFrame = new JFrame();
	JFrame memoAddFrame = new JFrame();
	JFrame memoFrame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel memoPanel = new JPanel();
	JPanel memoAddPanel = new JPanel();
	TreeGUI treeGUI;
	JList folderList, memoList;

	public JList getFolderList() {
		return folderList;
	}

	public void setFolderList(JList folderList) {
		this.folderList = folderList;
	}

	JTextArea memoArea;
	JTextField folderTitleField;
	JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn, memoSaveBtn;

	UiData uiData;
	ObjectManager objectManager;
	FolderManager folderManager;
	ArrayList<Folder> folders;
	// �ʵ� (field)

	public GUI(ObjectManager objectManager) {
		this.objectManager = objectManager;
		this.uiData = objectManager.uiData;
		this.folderManager = objectManager.folderManager;
		this.folders = folderManager.getFolderList();
		test();
//		treeMainUI();
//		mainUI();
//		memoUI("first folder");
		// UiData (model) ���� �����ڷ� ���� �޾ƿ���
	}

	public void treeMainUI() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Memo Pad");
		mainFrame.setBounds(650, 300, 415, 500);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLayout(null);

		JTree tree;
		JLabel selectedLabel;
		// create the root node

		mainPanel.setLayout(new FlowLayout());
		mainPanel.setBounds(0, 0, 415, 500);
		mainFrame.add(mainPanel);

		mainPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 400, 207, 100);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		// create the child nodes
		ArrayList<Folder> folders = folderManager.getFolderList();
		DefaultMutableTreeNode folderNodes[] = new DefaultMutableTreeNode[folders.size()];
		for (int i = 0; i < folders.size(); i++) {
			folderNodes[i] = new DefaultMutableTreeNode(folders.get(i).getTitle());
			folderNodes[i].add(new DefaultMutableTreeNode("No memo exists."));
			root.add(folderNodes[i]);
		}

		// create the tree by passing in the root node
		tree = new JTree(root);
//    ImageIcon imageIcon = new ImageIcon(TreeExample.class.getResource("/leaf.jpg"));
		DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
//    renderer.setLeafIcon(imageIcon);

		tree.setCellRenderer(renderer);
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		mainPanel.add(new JScrollPane(tree));
		tree.setBounds(0, 0, 415, 400);

		selectedLabel = new JLabel();
		mainPanel.add(selectedLabel);
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				selectedLabel.setText(selectedNode.getUserObject().toString());
			}
		});

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
	}

	public void folderAddUI() {
		folderAddFrame.setBounds(600, 400, 300, 150);
		folderAddFrame.setVisible(true);
		folderAddFrame.setResizable(false);
		folderAddFrame.setTitle("Add Category");
		folderAddFrame.setLayout(null);
		JLabel folderAddLabel = new JLabel("카테고리를 입력해주세요\n");
		folderAddLabel.setBounds(20, -20, 300, 100);
		folderAddLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		folderAddFrame.add(folderAddLabel);
		folderTitleField = uiData.getFolderTitleField();
		folderTitleField.setBounds(20, 50, 200, 30);
		folderTitleField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int a = 10; // red 성분
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// TODO textField에서 타이틀을 받아서 폴더 추가
					folderAddFrame.dispose();
				}
			}
		});

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
		JScrollPane jsp2 = new JScrollPane(); // 창 스크롤
		jsp2.setBounds(0, 50, 400, 650); // 스크롤 사이즈 설정
		memoPanel.add(jsp2); // 콘텐츠 판넬에 스크롤 추가

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
}