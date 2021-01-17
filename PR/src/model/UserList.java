package model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserList extends JFrame {

	// 콤보박스에 나타낼 데이터를 배열에 저장합니다.

	String users[] = { 
			"손님1",
            "손님2",
            "손님3",
            "손님4",
            "손님5",
            "손님6",
            "손님7",
            "손님8",
            "손님9",
            "손님10",
            "손님11",
            "손님12",
            "손님13",
            "손님14",
            "손님15",
            "손님16" };

	JComboBox<String> combo;
	JButton btnServer = new JButton("채팅하기");

	UserList() {
		setLayout(new BorderLayout());

		combo = new JComboBox<String>(users);

		add(combo, BorderLayout.NORTH);
		add(btnServer, BorderLayout.SOUTH);

		setSize(200, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 콤보박스에 addActionListener 이벤트 처리를 합니다.
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChatServer.id = combo.getSelectedItem().toString();
				ChatClient.id = combo.getSelectedItem().toString();
			}
		});
		
		btnServer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChatServer cs = new ChatServer();
				ChatClient cc = new ChatClient();
				
			}
		});
	}

	public static void main(String[] args) {
		new UserList();
	}
}
