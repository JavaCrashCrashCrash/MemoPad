package com.memopad.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
		treeMainUI();
//		mainUI();
//		memoUI("first folder");
		// UiData (model) ���� �����ڷ� ���� �޾ƿ���
	}

	public void treeMainUI() {
//		mainPanel.setLayout(new FlowLayout()); // ��ư �ǳ� ���̾ƿ� ����
		mainPanel.setSize(415, 500); // ��ư �ǳ� ������ ����

		JTree tree;
		JLabel selectedLabel;
		// create the root node

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

		tree.setBounds(0, 0, 415, 400);
		JScrollPane treeScroll;
		mainPanel.add(treeScroll = new JScrollPane(tree));
		treeScroll.setBounds(0, 0, 415, 400);
	

		selectedLabel = new JLabel();
		mainPanel.add(selectedLabel);
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				selectedLabel.setText(selectedNode.getUserObject().toString());
			}
		});

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("Memo Pad");
		mainFrame.setBounds(650, 300, 415, 500);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setLayout(null);
		mainFrame.add(mainPanel);
		
		mainPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 500, 207, 100);		
		
	}

	public void mainUI() {
		mainFrame.setBounds(600, 300, 415, 700); // (â ��ġ x, â ��ġ y, ����, ����)
		mainFrame.setVisible(true); // â ���̰�
		mainFrame.setResizable(false); // â ũ�� ���� �� �� ����
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ��� X�� ����
		mainFrame.setTitle("Memo Pad"); // Ÿ��Ʋ
		mainFrame.add(mainPanel); // ��ư �ǳ� �߰�
		mainPanel.setLayout(null); // ��ư �ǳ� ���̾ƿ� ����
		mainPanel.setBounds(0, 0, 400, 700); // ��ư �ǳ� ������ ����

		folderList = uiData.getFolderList();
		folderList.setFixedCellHeight(30);
		folderList.setCellRenderer(new DefaultListCellRenderer() {
			public int getHorizontalAlignment() {
				return CENTER;
			}
		});
		folderList.setBounds(0, 50, 400, 650);
		folderList.addMouseListener(null);
		mainPanel.add(folderList);
		JScrollPane jsp = new JScrollPane(); // â ��ũ��
		jsp.setBounds(0, 50, 400, 650); // ��ũ�� ������ ����
		mainPanel.add(jsp); // ������ �ǳڿ� ��ũ�� �߰�

		mainPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 0, 200, 50);
		mainPanel.add(folderDeleteBtn = uiData.getFolderDeleteBtn());
		folderDeleteBtn.setBounds(200, 0, 200, 50);
	}

	public void folderAddUI() {
		folderAddFrame.setBounds(600, 400, 300, 150);
		folderAddFrame.setVisible(true);
		folderAddFrame.setResizable(false);
		folderAddFrame.setTitle("Add Category");
		folderAddFrame.setLayout(null);
		JLabel folderAddLabel = new JLabel("ī�װ��� �Է����ּ���\n");
		folderAddLabel.setBounds(20, -20, 300, 100);
		folderAddLabel.setFont(new Font("����", Font.PLAIN, 15));
		folderAddFrame.add(folderAddLabel);
		folderTitleField = uiData.getFolderTitleField();
		folderTitleField.setBounds(20, 50, 200, 30);
		folderTitleField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int a = 10; // red ����
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// TODO textField���� Ÿ��Ʋ�� �޾Ƽ� ���� �߰�
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
		JScrollPane jsp2 = new JScrollPane(); // â ��ũ��
		jsp2.setBounds(0, 50, 400, 650); // ��ũ�� ������ ����
		memoPanel.add(jsp2); // ������ �ǳڿ� ��ũ�� �߰�

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