package chat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener{
	private JTextArea jta = new JTextArea(40,25);
	private JTextField jtf = new JTextField(25);
	private ClientBackground client = new ClientBackground();
	private static String nickName;

	public ClientGui() {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800,100,400,600);
		setTitle("클라이언트 부분");
		
		client.setGui(this);
		client.setNickName(nickName);
		client.connect();
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임 설정:");
		nickName = sc.nextLine();
		sc.close();
		
		new ClientGui(); 
	}
	
	@Override
	//말치면 보내지는 부분
	public void actionPerformed(ActionEvent e) {
		String msg = nickName +":"+ jtf.getText()+"\n";
		client.sendMessage(msg);
		jtf.setText("");	//채팅 입력창 시작 공백 
		
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		
	}
}
