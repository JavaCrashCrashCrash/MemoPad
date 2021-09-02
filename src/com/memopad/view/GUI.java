package com.memopad.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.memopad.model.Folder;
import com.memopad.model.FolderManager;
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
	JTextArea memoArea;
	JTextField folderTitleField;
	JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn, memoClearBtn;

	UiData uiData;
	FolderManager folderManager;
	ArrayList<Folder> folders;
	// �ʵ� (field)

	public GUI(ObjectManager objectManager) {
		this.uiData = objectManager.uiData;
		this.folderManager = objectManager.folderManager;
		this.folders = folderManager.getFolders();
//		mainUI();
		memoAddUI();
		// UiData (model) ���� �����ڷ� ���� �޾ƿ���
	}
	
	public void mainUI() {
		mainFrame.setBounds(600, 200, 400, 700); // (â ��ġ x, â ��ġ y, ����, ����)
		mainFrame.setVisible(true); // â ���̰�
		mainFrame.setResizable(false); // â ũ�� ���� �� �� ����
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ��� X�� ����
		mainFrame.setTitle("Memo Pad"); // Ÿ��Ʋ
		mainFrame.add(mainPanel); // ��ư �ǳ� �߰�
		mainPanel.setLayout(null); // ��ư �ǳ� ���̾ƿ� ����
		mainPanel.setBounds(0, 0, 400, 700); // ��ư �ǳ� ������ ����
		
		folderList = uiData.getFolderList();
		folderList.setBounds(0, 51, 400, 650);
		mainPanel.add(folderList);	
		JScrollPane jsp = new JScrollPane(); // â ��ũ��
		jsp.setBounds(0, 50, 400, 650); // ��ũ�� ������ ����
		mainPanel.add(jsp); // ������ �ǳڿ� ��ũ�� �߰�
		
		mainPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 0, 193, 50);
		mainPanel.add(folderDeleteBtn = uiData.getFolderDeleteBtn());
		folderDeleteBtn.setBounds(193, 0, 193, 50);
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
		folderAddFrame.add(folderTitleField);
	}
	
	public void memoUI(String folderTitle) {
		memoFrame.setBounds(600, 200, 400, 700);
		memoFrame.setVisible(true);
		memoFrame.setResizable(false);
		memoFrame.setTitle(folderTitle);
		memoFrame.setLayout(null);
		memoFrame.add(memoPanel);
		memoPanel.setLayout(null);
		memoPanel.setBounds(0, 0, 400, 700);
		
		memoList = uiData.getMemoList();
		memoList.setBounds(0, 51, 400, 650);
		memoPanel.add(memoList);
		JScrollPane jsp2 = new JScrollPane(); // â ��ũ��
		jsp2.setBounds(0, 50, 400, 650); // ��ũ�� ������ ����
		memoPanel.add(jsp2); // ������ �ǳڿ� ��ũ�� �߰�
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
		
		memoAddPanel.add(memoAddBtn = uiData.getMemoAddBtn());
		memoAddBtn.setBounds(640, 22, 90, 50);
		memoAddPanel.add(memoClearBtn = uiData.getMemoClearBtn());
		memoClearBtn.setBounds(640, 92, 90, 50);
	}
}
