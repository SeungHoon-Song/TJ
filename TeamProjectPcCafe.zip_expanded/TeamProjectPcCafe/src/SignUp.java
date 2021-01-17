
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class SignUp extends JFrame {
	JTextField tf1, tf2, tf3, tf4, tf5;
	JLabel l1, l2, l3, l4, l5;
	JButton bt1, bt2;
	JFrame fr = new JFrame("회원가입"); 



	public SignUp(){
		
		fr.setLayout(null);
		fr.setLocationRelativeTo(null);
		fr.setBounds(500, 200, 400, 300);
		fr.setSize(340,400);
		
		l1 = new JLabel("Id");
		l1.setBounds(50, 50, 100, 30);
		fr.add(l1);

		tf1 = new JTextField();
		tf1.setBounds(150, 50 , 100, 30);
		fr.add(tf1);
		

		l2 = new JLabel("pw");
		l2.setBounds(50, 100, 30, 30);
		fr.add(l2);

		tf2 = new JTextField();
		tf2.setBounds(150, 100 , 100, 30);
		fr.add(tf2);

		l3 = new JLabel("Name");
		l3.setBounds(50, 150, 100, 30);
		fr.add(l3);

		tf3 = new JTextField();
		tf3.setBounds(150, 150 , 100, 30);
		fr.add(tf3);

		l4 = new JLabel("Age");
		l4.setBounds(50, 200, 100, 30);
		fr.add(l4);

		tf4 = new JTextField();
		tf4.setBounds(150, 200 , 100, 30);
		fr.add(tf4);

		l5 = new JLabel("Phone");
		l5.setBounds(50, 250, 100, 30);
		fr.add(l5);

		tf5 = new JTextField();
		tf5.setBounds(150, 250 , 100, 30);
		fr.add(tf5);

		bt1 = new JButton("회원가입");
		bt1.setBounds(100, 300, 200, 35);
		Font f1=new Font("굴림",Font.BOLD,10);
		bt1.setFont(f1);
		bt1.setBackground(Color.WHITE);
		fr.add(bt1);

		fr.setVisible(true);
		
		//È¸¿ø°¡ÀÔ ¹öÆ° 
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id=tf1.getText().toString();
				String password=tf2.getText().toString();
				String name=tf3.getText().toString();
				String age=tf4.getText().toString();
				String phone=tf5.getText().toString();
			
				
				MemberDAO dao=new MemberDAO();//Á¤º¸¸¦ ³ÖÀ» »ý¼ºÀÚ 
				
				dao.phone(phone);
				dao.age(age);
				
				//³ªÀÌ¿¡ ¹®ÀÚ¿­ ¾µ¶§ 
				//¼ýÀÚ¿¡ ¹®ÀÚ ¾µ‹š 
				
				if(dao.searchID(id)) {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
					tf1.setText("");
				}else if(tf1.getText().length()>10) {
					JOptionPane.showMessageDialog(null, "아이디는 10자 이내로 입력해주세요");
					tf1.setText("");
				}else if(tf2.getText().length()>10) {
					JOptionPane.showMessageDialog(null, "비밀번호는 10자리 이내로 입력해주세요");
					tf2.setText("");
				}else if(dao.age(age)) {
					JOptionPane.showMessageDialog(null, "숫자로 입력해주세요");
					tf4.setText("");
				}else if(dao.checkPhone(phone)) {
					JOptionPane.showMessageDialog(null, "전화번호 형식은 [xxx-xxxx-xxxx]입니다 '-'생략 ");
					tf5.setText("");
				}else if(dao.phone(phone)=="") {
					JOptionPane.showMessageDialog(null, "전화번호 11자리 입력해주세요");
					tf5.setText("");
				}else if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty()||tf5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "정보를 전부 입력해주세요 ");
				}else {
					 JOptionPane.showMessageDialog(null, "회원가입이 완료 되었습니다 ");				 
					 dao.input(id, password, name, age, phone);
					 tf1.setText("");
					 tf2.setText("");
					 tf3.setText("");
					 tf4.setText("");
					 tf5.setText("");
				 }
				
		
			}
		});

		
	}//joinGui end
	
	public static void main(String[] args){
		new SignUp();
	}




}
