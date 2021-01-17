import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PayMent {

   JFrame fr=new JFrame("정산");
   JLabel lb , Ib2;
   JButton bt1;
   JTextField tf1;
   
   
   public PayMent() {
      
      fr.setLayout(null);
      fr.setLocationRelativeTo(null);
      fr.setBounds(500, 200, 400, 300);
      fr.setSize(240,200);


      lb=new JLabel("정산");
      Font f1=new Font("돋움",Font.BOLD,20);
      lb.setFont(f1);
      lb.setBounds(90,20,70,20);
      fr.add(lb);
      
      
      Ib2=new JLabel("PC");
      Ib2.setBounds(20,60,90,30);
      fr.add(Ib2);
      
      tf1=new JTextField();
      tf1.setBounds(70,60,100,30);
      fr.add(tf1);
      
      
      bt1=new JButton("정산");
      bt1.setBounds(80, 110, 80, 25);
      Font f2=new Font("굴림",Font.BOLD,10);
      bt1.setFont(f2);
      bt1.setBackground(Color.WHITE);
      fr.add(bt1);

      fr.setVisible(true);

      bt1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MemberDAO md = new MemberDAO();
			String strTf1 = tf1.getText().toString();
			long time = 0;
			long money = 0;
			//validation
			if(tf1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"좌석 번호를 입력하세요.");
			}//end if
			
			if(!checkSeat(strTf1)) {
				JOptionPane.showMessageDialog(null,"좌석은 0 ~ 20 숫자입니다.");
				tf1.setText("");
			}//end if
			else if(0>Integer.parseInt(strTf1) || 20<Integer.parseInt(strTf1)) {
				JOptionPane.showMessageDialog(null,"좌석은 0 ~ 20 입니다.");
				tf1.setText("");
			}//end else if
			

			if(md.checkPc(strTf1)) {
				time = md.getTime(strTf1);
				Date date = new Date();
				long intDate = date.getTime();
				long seconds = TimeUnit.MILLISECONDS.toSeconds(intDate);
				
				money = (seconds - time) * 10;
				
				md.insertMoney(Integer.parseInt(strTf1),money);
				md.deleteLogin(Integer.parseInt(strTf1));
				
				JOptionPane.showMessageDialog(null,money+"원 정산 되었습니다.");
					switch(Integer.parseInt(strTf1)) {
						case 1:
							MainPanel.tfName1.setText("");
							MainPanel.tfTime1.setText("");
							break;
						case 2:
							MainPanel.tfName2.setText("");
							MainPanel.tfTime2.setText("");
							break;
						case 3:
							MainPanel.tfName3.setText("");
							MainPanel.tfTime3.setText("");
							break;
						case 4:
							MainPanel.tfName4.setText("");
							MainPanel.tfTime4.setText("");
							break;
						case 5:
							MainPanel.tfName5.setText("");
							MainPanel.tfTime5.setText("");
							break;
						case 6:
							MainPanel.tfName6.setText("");
							MainPanel.tfTime6.setText("");
							break;
						case 7:
							MainPanel.tfName7.setText("");
							MainPanel.tfTime7.setText("");
							break;
						case 8:
							MainPanel.tfName8.setText("");
							MainPanel.tfTime8.setText("");
							break;
						case 9:
							MainPanel.tfName9.setText("");
							MainPanel.tfTime9.setText("");
							break;
						case 10:
							MainPanel.tfName10.setText("");
							MainPanel.tfTime10.setText("");
							break;
						case 11:
							MainPanel.tfName11.setText("");
							MainPanel.tfTime11.setText("");
							break;
						case 12:
							MainPanel.tfName12.setText("");
							MainPanel.tfTime12.setText("");
							break;
						case 13:
							MainPanel.tfName13.setText("");
							MainPanel.tfTime13.setText("");
							break;
						case 14:
							MainPanel.tfName14.setText("");
							MainPanel.tfTime14.setText("");
							break;
						case 15:
							MainPanel.tfName15.setText("");
							MainPanel.tfTime15.setText("");
							break;
						case 16:
							MainPanel.tfName16.setText("");
							MainPanel.tfTime16.setText("");
							break;
						case 17:
							MainPanel.tfName17.setText("");
							MainPanel.tfTime17.setText("");
							break;
						case 18:
							MainPanel.tfName18.setText("");
							MainPanel.tfTime18.setText("");
							break;
						case 19:
							MainPanel.tfName19.setText("");
							MainPanel.tfTime19.setText("");
							break;
						case 20:
							MainPanel.tfName20.setText("");
							MainPanel.tfTime20.setText("");
							break;
				}//end switch
				tf1.setText("");

			}//end if
			else {
				JOptionPane.showMessageDialog(null,"해당 좌석은 로그인되어있지 않습니다.");
				tf1.setText("");
			}//end else
			
		}//end actionPerformed
	});
   }//end cons
   
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
      new PayMent();
      
   }//main end
}//class end



