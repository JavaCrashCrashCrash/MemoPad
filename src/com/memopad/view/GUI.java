package com.memopad.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.memopad.model.UiData;

public class GUI {
	JFrame jframe = new JFrame();
	JPanel jpanel = new JPanel();
	JTextArea ta;
	JButton btn1, btn2, btn3;
	UiData uiData;
	// �ʵ� (field)

	public GUI(UiData uiData) {
		this.uiData = uiData;
		ta = uiData.getTa();
		startGUI();
		// UiData (model) ���� �����ڷ� ���� �޾ƿ���
	}

	public void startGUI() {
		jframe.setBounds(450, 300, 700, 450);
		// ������ ������
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// X ������ ����
		jframe.setVisible(true);
		// â �����ֱ�
		jframe.setTitle("Memo Pad");
		// Ÿ��Ʋ
		jframe.add(jpanel);
		// �����ӿ� �ǳ� �߰�
		jpanel.setLayout(null);
		// �ǳڿ� ���̾ƿ� ����
		
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setBounds(20, 20, 550, 370);
		jpanel.add(scrollPane);
		// textarea�� scrollpane ����
		jpanel.add(btn1 = uiData.getBtn1());
		btn1.setBounds(585, 20, 80, 50);
		// ���� ��ư (clear)
		jpanel.add(btn2 = uiData.getBtn2());
		btn2.setBounds(585, 90, 80, 50);
		// ���� ��ư (save)
		jpanel.add(btn3 = uiData.getBtn3());
		btn3.setBounds(585, 160, 80, 50);
		// �ҷ����� ��ư (load)
	}
}
