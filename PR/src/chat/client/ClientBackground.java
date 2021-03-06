package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	private String nickName;
	
	public void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public void connect() {
		try {
			socket = new Socket("127.0.0.1",7777);
			System.out.println("서버 연결됨");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName);	//접속하자마자 닉네임 전송, 서버가 인식후 맵에 넣음
			System.out.println("클라이언트: 메시지 전송완료");	//서버에서 뜸
			
			while(in!=null) {
				msg=in.readUTF();
				gui.appendMsg(msg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}

	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
		
	}
	
}
