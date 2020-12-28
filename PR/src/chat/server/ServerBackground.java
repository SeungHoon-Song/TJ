package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ServerGui gui;
	
	
	public void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress()+"에서 접속");
			
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			String msg = in.readUTF();
			System.out.println("클라이언트로부터의 메시지 : "+msg);
			gui.appendMsg(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	//end setting
	
	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
		
	}
	
}
