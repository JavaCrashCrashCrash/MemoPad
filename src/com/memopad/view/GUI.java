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
	// 필드 (field)

	public GUI(UiData uiData) {
		this.uiData = uiData;
		ta = uiData.getTa();
		startGUI();
		// UiData (model) 에서 생성자로 정보 받아오기
	}

	public void startGUI() {
		jframe.setBounds(450, 300, 700, 450);
		// 프레임 사이즈
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// X 눌러서 종료
		jframe.setVisible(true);
		// 창 보여주기
		jframe.setTitle("Memo Pad");
		// 타이틀
		jframe.add(jpanel);
		// 프레임에 판넬 추가
		jpanel.setLayout(null);
		// 판넬에 레이아웃 적용
		
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setBounds(20, 20, 550, 370);
		jpanel.add(scrollPane);
		// textarea에 scrollpane 적용
		jpanel.add(btn1 = uiData.getBtn1());
		btn1.setBounds(585, 20, 80, 50);
		// 비우기 버튼 (clear)
		jpanel.add(btn2 = uiData.getBtn2());
		btn2.setBounds(585, 90, 80, 50);
		// 저장 버튼 (save)
		jpanel.add(btn3 = uiData.getBtn3());
		btn3.setBounds(585, 160, 80, 50);
		// 불러오기 버튼 (load)
	}
}
