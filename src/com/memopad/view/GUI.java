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
	// 필드 (field)

	public GUI(UiData uiData) {
		this.uiData = uiData;
		ta = uiData.getTa();
//		startGUI();
		mainUI();
		// UiData (model) 에서 생성자로 정보 받아오기
	}

//	public void startGUI() {
//		jframe.setBounds(450, 300, 700, 450);
//		// 프레임 사이즈
//		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		// X 눌러서 종료
//		jframe.setVisible(true);
//		// 창 보여주기
//		jframe.setTitle("Memo Pad");
//		// 타이틀
//		jframe.add(jpanel);
//		// 프레임에 판넬 추가
//		jpanel.setLayout(null);
//		// 판넬에 레이아웃 적용
//		
//		JScrollPane scrollPane = new JScrollPane(ta);
//		scrollPane.setBounds(20, 20, 550, 370);
//		jpanel.add(scrollPane);
//		// textarea에 scrollpane 적용
//		jpanel.add(btn1 = uiData.getBtn1());
//		btn1.setBounds(585, 20, 80, 50);
//		// 비우기 버튼 (clear)
//		jpanel.add(btn2 = uiData.getBtn2());
//		btn2.setBounds(585, 90, 80, 50);
//		// 저장 버튼 (save)
//		jpanel.add(btn3 = uiData.getBtn3());
//		btn3.setBounds(585, 160, 80, 50);
//		// 불러오기 버튼 (load)
//	}
	
	public void mainUI() {
		jframe.setBounds(600, 200, 400, 700); // (창 위치 x, 창 위치 y, 가로, 세로)
		jframe.setVisible(true); // 창 보이게
		jframe.setResizable(false); // 창 크기 조절 할 수 없게
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 우측 상단 X로 종료
		jframe.setTitle("Memo Pad"); // 타이틀
		jframe.add(btnPanel); // 버튼 판넬 추가
		btnPanel.setLayout(null); // 버튼 판넬 레이아웃 설정
		btnPanel.setBounds(0, 0, 400, 50); // 버튼 판넬 사이즈 설정
		jframe.add(contentPanel); // 콘텐츠 판넬 추가
		contentPanel.setLayout(new FlowLayout()); // 콘텐츠 판넬 레이아웃 설정
		contentPanel.setBounds(0, 50, 400, 650); // 콘텐츠 판넬 사이즈 설정
		
		JScrollPane jsp = new JScrollPane(); // 창 스크롤
		jsp.setBounds(0, 50, 400, 650); // 스크롤 사이즈 설정
		contentPanel.add(jsp); // 콘텐츠 판넬에 스크롤 추가
		
		btnPanel.add(folderAddBtn = uiData.getFolderAddBtn());
		folderAddBtn.setBounds(0, 0, 193, 50);
		btnPanel.add(folderDeleteBtn = uiData.getFolderDeleteBtn());
		folderDeleteBtn.setBounds(193, 0, 193, 50);
		
	}
}
