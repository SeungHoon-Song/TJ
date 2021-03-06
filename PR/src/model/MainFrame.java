package model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javafx.application.Application;
import javafx.scene.Scene;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.stage.Stage;

public class MainFrame extends JFrame {

	public MainFrame() {
		setTitle("Chatting Test");
		setBounds(10, 50, 400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		JButton btnServer = new JButton("Connect");
		TextField tftext = new TextField("테스트");
		// 버튼클릭 액션에 반응하기 위해 리스너 객체 생성 및 추가

		btnServer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserList ct = new UserList();
				

			}

		});
		
		

		panel.add(btnServer);

		tftext.setBounds(170, 164, 50, 20);
		add(tftext);
		add(panel, BorderLayout.CENTER);
		setVisible(true);

	}

	   public static void main(String[] args) {
	    	new MainFrame();
	    	
	        Application.launch(ChatList.class, args);
	}


}
