import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login{
	
	static JFrame f = new JFrame("로그인");
	static JTextField text = new JTextField();
	static JPasswordField value = new JPasswordField();
	static JTextField pc = new JTextField();


	public Login() {
	
	JLabel l1 = new JLabel("아이디:");
	l1.setBounds(20,20,80,30);
	text.setBounds(100,20,100,30);
	JLabel l2 = new JLabel("비밀번호:");
	l2.setBounds(20,75,80,30);
	value.setBounds(100,75,100,30);
	
	JLabel l3 = new JLabel("PC:");
	l3.setBounds(20,125,120,30);
	pc.setBounds(100,130,100,30);
	
	JButton b = new JButton("로그인");
	b.setBounds(100,170,80,30);
	
	f.add(l1); f.add(text);
	f.add(l2); f.add(value); 
	f.add(l3); f.add(pc);
	f.add(b);
	f.setSize(300,250);
	f.setLayout(null);
	f.setLocationRelativeTo(null);
	f.setVisible(true);
	
	
	b.addActionListener(new ActionListener() {
		
		@Override 
		public void actionPerformed(ActionEvent e) {
			String id = text.getText().toString();
			String pw = value.getText().toString();
			MemberDAO md = new MemberDAO();
			boolean check = md.isExist(id, pw);
			
			if(text.getText().isEmpty() || value.getText().isEmpty() || pc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"정보를 모두 입력하세요.");
			}//end if
			
			if(!checkSeat(pc.getText().toString())) {
				JOptionPane.showMessageDialog(null,"좌석은 0 ~ 20 숫자입니다.");
				pc.setText("");
			}//end if
			else if(0>Integer.parseInt(pc.getText().toString()) || 20<Integer.parseInt(pc.getText().toString())) {
				JOptionPane.showMessageDialog(null,"좌석은 0 ~ 20 입니다.");
				pc.setText("");
			}//end else if
			

			
			if(check && !pc.getText().isEmpty()) {
				if(md.loginCheck(id)) {
					JOptionPane.showMessageDialog(null,"이미 로그인 되어있습니다.");
					text.setText("");
					value.setText("");
					pc.setText("");
				}//end if
				else {
					setSeat(id, pw, Integer.parseInt(pc.getText()));
				}//end else
			}//end if
			else if(!check){
				JOptionPane.showMessageDialog(null,"Incorrect Account");
			}//end else
			
		}//end actionPerformed
	});
	}//end cons
	//자리 배정
	public static void setSeat(String id, String password, int seat) {
		MemberDAO md = new MemberDAO();
		if(md.pcCheck(seat)) {
			JOptionPane.showMessageDialog(null,"해당 좌석은 비어 있지 않습니다.");
			text.setText("");
			value.setText("");
			pc.setText("");
		}//end if
		else {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String strDate = String.valueOf(sdf.format(date));
			
			long intDate = date.getTime();
			long seconds = TimeUnit.MILLISECONDS.toSeconds(intDate);
		
			md.insert(seat, id, password, seconds);
			JOptionPane.showMessageDialog(null,"좌석 배정됨.");
			text.setText("");
			value.setText("");
			pc.setText("");
			//좌석배정
			//TRUNCATE TABLE tableName; -- 테이블의 구조는 유지하면서 모든 데이터들만 삭제
			f.dispose();//좌석 배정시 창 닫기

			setTime(seat, id, strDate);
		}//end else
	}//end setSeat
	
	public static void setTime(int seat, String id, String strDate) {


			String strTime = strDate;

			
			switch(seat) {
				case 1:
					MainPanel.tfName1.setText(id);
					MainPanel.tfTime1.setText(strTime);
					break;
				case 2:
					MainPanel.tfName2.setText(id);
					MainPanel.tfTime2.setText(strTime);
					break;
				case 3:
					MainPanel.tfName3.setText(id);
					MainPanel.tfTime3.setText(strTime);
					break;
				case 4:
					MainPanel.tfName4.setText(id);
					MainPanel.tfTime4.setText(strTime);
					break;
				case 5:
					MainPanel.tfName5.setText(id);
					MainPanel.tfTime5.setText(strTime);
					break;
				case 6:
					MainPanel.tfName6.setText(id);
					MainPanel.tfTime6.setText(strTime);
					break;
				case 7:
					MainPanel.tfName7.setText(id);
					MainPanel.tfTime7.setText(strTime);
					break;
				case 8:
					MainPanel.tfName8.setText(id);
					MainPanel.tfTime8.setText(strTime);
					break;
				case 9:
					MainPanel.tfName9.setText(id);
					MainPanel.tfTime9.setText(strTime);
					break;
				case 10:
					MainPanel.tfName10.setText(id);
					MainPanel.tfTime10.setText(strTime);
					break;
				case 11:
					MainPanel.tfName11.setText(id);
					MainPanel.tfTime11.setText(strTime);
					break;
				case 12:
					MainPanel.tfName12.setText(id);
					MainPanel.tfTime12.setText(strTime);
					break;
				case 13:
					MainPanel.tfName13.setText(id);
					MainPanel.tfTime13.setText(strTime);
					break;
				case 14:
					MainPanel.tfName14.setText(id);
					MainPanel.tfTime14.setText(strTime);
					break;
				case 15:
					MainPanel.tfName15.setText(id);
					MainPanel.tfTime15.setText(strTime);
					break;
				case 16:
					MainPanel.tfName16.setText(id);
					MainPanel.tfTime16.setText(strTime);
					break;
				case 17:
					MainPanel.tfName17.setText(id);
					MainPanel.tfTime17.setText(strTime);
					break;
				case 18:
					MainPanel.tfName18.setText(id);
					MainPanel.tfTime18.setText(strTime);
					break;
				case 19:
					MainPanel.tfName19.setText(id);
					MainPanel.tfTime19.setText(strTime);
					break;
				case 20:
					MainPanel.tfName20.setText(id);
					MainPanel.tfTime20.setText(strTime);
					break;
			}//end switch
	}//end setTime


	public static boolean checkSeat(String seat) {
		boolean result = true;
		String num = "0123456789";
		for(int i = 0; i < seat.length(); i++) {
			String numChar = String.valueOf(seat.charAt(i));
			if(!num.contains(numChar)) {
				result = false;
			}//end if
		}//end for
		return result;
	}//end checkSeat

	public static void main(String[] args) {
		new Login();
	}//end main
}//end Login
