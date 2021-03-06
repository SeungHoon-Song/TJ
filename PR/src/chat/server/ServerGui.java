package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener{
	
	private JTextArea jta = new JTextArea(40,25);	//여러 줄 문자열 입력 창
	private JTextField jtf = new JTextField(25);	//한 줄 문자열 입력받는 창	
	//연동
	private ServerBackground server = new ServerBackground();
	

	public ServerGui() throws IOException {
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200,100,400,600);	//창 나올 위치 좌표 (x,y위치들,x,y 크기)
		setTitle("서버 부분");
		
		server.setGui(this);
		server.setting();
		
	}
	
	public static void main(String[] args) throws IOException {
		new ServerGui(); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "서버:"+jtf.getText()+"\n";
		System.out.println(msg);
		server.sendMessage(msg);
		jtf.setText("");	//채팅 입력창 시작 공백 
		
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		
	}
	
}
