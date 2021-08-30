package com.memopad.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.memopad.model.UiData;

public class GUI {
	JFrame jframe = new JFrame();
	JPanel btnPanel = new JPanel();
	JPanel contentPanel = new JPanel();
	JTextArea ta;
	JButton folderAddBtn, folderDeleteBtn, memoAddBtn, memoDeleteBtn;
	UiData uiData;
	// �ʵ� (field)

	public GUI(UiData uiData) {
		this.uiData = uiData;
		ta = uiData.getTa();
//		startGUI();
		mainUI();
		// UiData (model) ���� �����ڷ� ���� �޾ƿ���
	}

//	public void startGUI() {
//		jframe.setBounds(450, 300, 700, 450);
//		// ������ ������
//		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// X ������ ����
//		jframe.setVisible(true);
//		// â �����ֱ�
//		jframe.setTitle("Memo Pad");
//		// Ÿ��Ʋ
//		jframe.add(jpanel);
//		// �����ӿ� �ǳ� �߰�
//		jpanel.setLayout(null);
//		// �ǳڿ� ���̾ƿ� ����
//		
//		JScrollPane scrollPane = new JScrollPane(ta);
//		scrollPane.setBounds(20, 20, 550, 370);
//		jpanel.add(scrollPane);
//		// textarea�� scrollpane ����
//		jpanel.add(btn1 = uiData.getBtn1());
//		btn1.setBounds(585, 20, 80, 50);
//		// ���� ��ư (clear)
//		jpanel.add(btn2 = uiData.getBtn2());
//		btn2.setBounds(585, 90, 80, 50);
//		// ���� ��ư (save)
//		jpanel.add(btn3 = uiData.getBtn3());
//		btn3.setBounds(585, 160, 80, 50);
//		// �ҷ����� ��ư (load)
//	}
	
	public void mainUI() {
		jframe.setBounds(600, 200, 400, 700); // (â ��ġ x, â ��ġ y, ����, ����)
		jframe.setVisible(true); // â ���̰�
		jframe.setResizable(false); // â ũ�� ���� �� �� ����
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ��� X�� ����
		jframe.setTitle("Memo Pad"); // Ÿ��Ʋ
		jframe.add(btnPanel); // ��ư �ǳ� �߰�
		btnPanel.setLayout(null); // ��ư �ǳ� ���̾ƿ� ����
		btnPanel.setBounds(0, 0, 400, 50); // ��ư �ǳ� ������ ����
		jframe.add(contentPanel); // ������ �ǳ� �߰�
		contentPanel.setLayout(new FlowLayout()); // ������ �ǳ� ���̾ƿ� ����
		contentPanel.setBounds(0, 50, 400, 650); // ������ �ǳ� ������ ����
		
		JScrollPane jsp = new JScrollPane(); // â ��ũ��
		jsp.setBounds(0, 50, 400, 650); // ��ũ�� ������ ����
		contentPanel.add(jsp); // ������ �ǳڿ� ��ũ�� �߰�
		
		btnPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 0, 193, 50);
		btnPanel.add(folderDeleteBtn = uiData.getFolderDeleteBtn());
		folderDeleteBtn.setBounds(193, 0, 193, 50);
		
	}
}
