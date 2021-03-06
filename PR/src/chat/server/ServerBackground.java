package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;

	//사용자들의 정보 저장맵
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

	public void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() throws IOException {
			Collections.synchronizedMap(clientsMap); // 네트워크쪽 정리
			serverSocket = new ServerSocket(7777);

			while (true) {
				// 서버 할일 : 방문자를 게속 받아서, 쓰레드 리시버를 계속 생성
				System.out.println("대기중...");
				socket = serverSocket.accept(); // 먼저 서버가 할일 계속 반복해 사용자 받기
				System.out.println(socket.getInetAddress() + "에서 접속");
				// 새로운 사용자 쓰레드 클래스 생성후 소켓정보 넣기
				Receiver receiver = new Receiver(socket);	//변수명 같아도 각기 다른 쓰레드로 생성
				receiver.start();

			}
	} // end setting

	public static void main(String[] args) throws IOException {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();

	}
	
	//맵의 내용(클라이언트) 저장,삭제 
	public void addClient(String nick, DataOutputStream out) {
		clientsMap.put(nick, out);

	}
	public void removeClient(String nick){
		clientsMap.remove(nick);
	}
	//메세지 내용 전달
	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator();
		String key="";
		while(it.hasNext()) {
			key=it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String nick;

		//리시버가 한 일 : 네트워크 소켓을 받아서 계속 듣고,요청
		public Receiver(Socket socket) throws IOException {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				//리시버가 처음에는 클라이언트 아이디 받고 싶다
				nick = in.readUTF();
				addClient(nick,out);
		}


		@Override
		public void run() {
			try {
				//계속 듣기
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.appendMsg(msg);
				}
			} catch (IOException e) {
				//사용접속 종료시 에러 발생 -> 나가기
				removeClient(nick);
			}
		}
	}
}
