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
	
	public void setGui(ClientGui gui) {
		this.gui = gui;
	}

	public void connect() {
		try {
			socket = new Socket("127.0.0.1",7777);
			System.out.println("서버 연결됨");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF("Hi, I'm Client");
			System.out.println("클라이언트의 메시지 전송완료");	//서버에서 뜸
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}
	
}
