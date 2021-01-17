import java.awt.Color;import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageProducer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainPanel extends JFrame implements Runnable{
	//�̹��� �ֱ�
	private Image background=new ImageIcon(MainPanel.class.getResource(".\\img/new background.jpg")).getImage();//����̹���
	private ImageIcon btImage1=new ImageIcon(MainPanel.class.getResource(".\\img/join.png"));
	private ImageIcon btImage2=new ImageIcon(MainPanel.class.getResource(".\\img/login.png"));
	private ImageIcon btImage3=new ImageIcon(MainPanel.class.getResource(".\\img/chat.png"));
	private ImageIcon btImage4=new ImageIcon(MainPanel.class.getResource(".\\img/payment.png"));
	private ImageIcon btImage5=new ImageIcon(MainPanel.class.getResource(".\\img/sales.png"));
	
	//��ư�����
	static JButton b1=new JButton("button1");
	static JButton b2=new JButton("button2");
	static JButton b3=new JButton("button3");
	static JButton b4=new JButton("button4");
	static JButton b5=new JButton("button5");
	//�ؽ�Ʈ�ʵ�
	static TextField tfName1,tfTime1,tfName2,tfTime2,
	tfName3,tfTime3,tfName4,tfTime4,
	tfName5,tfTime5,tfName6,tfTime6,tfName7,tfTime7,
	tfName8,tfTime8,tfName9,tfTime9,
	tfName10,tfTime10,tfName11,tfTime11,tfName12,tfTime12,
	tfName13,tfTime13,tfName14,tfTime14,tfName15,tfTime15,
	tfName16,tfTime16,tfName17,tfTime17,tfName18,tfTime18
	,tfName19,tfTime19,tfName20,tfTime20;

	public void seat() {
		tfName1=new TextField("");
		tfTime1=new TextField("");
		tfName2=new TextField("");
		tfTime2=new TextField("");
		tfName3=new TextField("");
		tfTime3=new TextField("");
		tfName4=new TextField("");
		tfTime4=new TextField("");
		tfName5=new TextField("");
		tfTime5=new TextField("");
		tfName6=new TextField("");
		tfTime6=new TextField("");
		tfName7=new TextField("");
		tfTime7=new TextField("");
		tfName8=new TextField("");
		tfTime8=new TextField("");
		tfName9=new TextField("");
		tfTime9=new TextField("");
		tfName10=new TextField("");
		tfTime10=new TextField("");
		tfName11=new TextField("");
		tfTime11=new TextField("");
		tfName12=new TextField("");
		tfTime12=new TextField("");
		tfName13=new TextField("");
		tfTime13=new TextField("");
		tfName14=new TextField("");
		tfTime14=new TextField("");
		tfName15=new TextField("");
		tfTime15=new TextField("");
		tfName16=new TextField("");
		tfTime16=new TextField("");
		tfName17=new TextField("");
		tfTime17=new TextField("");
		tfName18=new TextField("");
		tfTime18=new TextField("");
		tfName19=new TextField("");
		tfTime19=new TextField("");
		tfName20=new TextField("");
		tfTime20=new TextField("");
		
		tfName1.setBounds(170, 164, 50, 20);
		add(tfName1);
		tfTime1.setBounds(190, 200, 50, 20);
        add(tfTime1);
        
        tfName2.setBounds(343, 164, 50, 20);
		add(tfName2);
		tfTime2.setBounds(365, 200, 50, 20);
        add(tfTime2);
     
        tfName3.setBounds(510, 170, 50, 20);
        add(tfName3);
        tfTime3.setBounds(532, 207, 50, 20);
        add(tfTime3);
        
        tfName4.setBounds(688, 166, 50, 20);
        add(tfName4);
        tfTime4.setBounds(710, 202, 50, 20);
        add(tfTime4);
        
        tfName5.setBounds(863, 168, 50, 20);
        add(tfName5);
        tfTime5.setBounds(885, 204, 50, 20);
        add(tfTime5);
        
        tfName6.setBounds(170, 328, 50, 20);
        add(tfName6);
        tfTime6.setBounds(190, 366, 50, 20);
        add(tfTime6);
        
        tfName7.setBounds(343, 328, 50, 20);
        add(tfName7);
        tfTime7.setBounds(365, 366, 50, 20);
        add(tfTime7);
        
        tfName8.setBounds(510, 328, 50, 20);
        add(tfName8);
        tfTime8.setBounds(532, 366, 50, 20);
        add(tfTime8);
        
        tfName9.setBounds(688, 328, 50, 20);
        add(tfName9);
        tfTime9.setBounds(710, 366, 50, 20);
        add(tfTime9);
        
        tfName10.setBounds(863, 328, 50, 20);
        add(tfName10);
        tfTime10.setBounds(885, 366, 50, 20);
        add(tfTime10);
        
        tfName11.setBounds(170, 496, 50, 20);
        add(tfName11);
        tfTime11.setBounds(190, 532, 50, 20);
        add(tfTime11);
        
        tfName12.setBounds(343, 492, 50, 20);
        add(tfName12);
        tfTime12.setBounds(365, 526, 50, 20);
        add(tfTime12);
        
        tfName13.setBounds(510, 492, 50, 20);
        add(tfName13);
        tfTime13.setBounds(532, 526, 50, 20);
        add(tfTime13);
        
        tfName14.setBounds(688, 486, 50, 20);
        add(tfName14);
        tfTime14.setBounds(710, 522, 50, 20);
        add(tfTime14);
        
        tfName15.setBounds(863, 490, 50, 20);
        add(tfName15);
        tfTime15.setBounds(885, 526, 50, 20);
        add(tfTime15);
        
        tfName16.setBounds(170, 656, 50, 20);
        add(tfName16);
        tfTime16.setBounds(190, 692, 50, 20);
        add(tfTime16);
        
        tfName17.setBounds(343, 655, 50, 20);
        add(tfName17);
        tfTime17.setBounds(365, 691, 50, 20);
        add(tfTime17);
        
        tfName18.setBounds(510, 653, 50, 20);
        add(tfName18);
        tfTime18.setBounds(532, 689 ,50, 20);
        add(tfTime18);
        
        tfName19.setBounds(688, 652, 50, 20);
        add(tfName19);
        tfTime19.setBounds(710, 688, 50, 20);
        add(tfTime19);
        
        tfName20.setBounds(863, 652, 50, 20);
        add(tfName20);
        tfTime20.setBounds(885, 688, 50, 20);
        add(tfTime20);
	}

	

	
	public void btn() {
		//��ưũ��
		b1.setSize(400, 140);
		b2.setSize(400, 140);
		b3.setSize(400, 140);
		b4.setSize(400, 140);
		b5.setSize(400, 140);
		
		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b4.setLayout(null);
		b5.setLayout(null);
		
		//��ġ����,�г�ũ��
		b1.setBounds(1100, 60, 400, 140);
		b2.setBounds(1100, 200, 400, 140);
		b3.setBounds(1100, 340, 400, 140);
		b4.setBounds(1100, 480, 400, 140);
		b5.setBounds(1100, 620, 400, 140);
		//�гο��ֱ�
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
		//��ư�� �̹���������
		b1.setIcon(btImage1);
		b2.setIcon(btImage2);
		b3.setIcon(btImage3);
		b4.setIcon(btImage4);
		b5.setIcon(btImage5);
		
		setVisible(true);
		

		
		b1.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.DARK_GRAY, 40), 
	            BorderFactory.createEmptyBorder(
	                b1.getBorder().getBorderInsets(b1).top, 
	                b1.getBorder().getBorderInsets(b1).left, 
	                b1.getBorder().getBorderInsets(b1).bottom, 
	                b1.getBorder().getBorderInsets(b1).right)));
		b2.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.DARK_GRAY, 40), 
	            BorderFactory.createEmptyBorder(
	                b2.getBorder().getBorderInsets(b2).top, 
	                b2.getBorder().getBorderInsets(b2).left, 
	                b2.getBorder().getBorderInsets(b2).bottom, 
	                b2.getBorder().getBorderInsets(b2).right)));
		b3.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.DARK_GRAY, 40), 
	            BorderFactory.createEmptyBorder(
	                b3.getBorder().getBorderInsets(b3).top, 
	                b3.getBorder().getBorderInsets(b3).left, 
	                b3.getBorder().getBorderInsets(b3).bottom, 
	                b3.getBorder().getBorderInsets(b3).right)));
		b4.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.DARK_GRAY, 40), 
	            BorderFactory.createEmptyBorder(
	                b4.getBorder().getBorderInsets(b4).top, 
	                b4.getBorder().getBorderInsets(b4).left, 
	                b4.getBorder().getBorderInsets(b4).bottom, 
	                b4.getBorder().getBorderInsets(b4).right)));
		b5.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(Color.DARK_GRAY, 40), 
	            BorderFactory.createEmptyBorder(
	                b5.getBorder().getBorderInsets(b5).top, 
	                b5.getBorder().getBorderInsets(b5).left, 
	                b5.getBorder().getBorderInsets(b5).bottom, 
	                b5.getBorder().getBorderInsets(b5).right)));
		
		
		//��ư ��� �߰�
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp su = new SignUp();
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
			}
		});
		b3.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            ChatList cl = new ChatList();
	         }
	      });
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PayMent pm = new PayMent();

			}
		});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Total tt = new Total();
			}
		});
		
	
	}
	
	public MainPanel() {
		homeframe();
		btn();
	
	}
	public void homeframe() {
		
		seat();

		setTitle("1");
		setSize(1600,900);

		setResizable(false);//â�� ũ�� �������
		
		
	

		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame������ǰ�
	
	}
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);//background���׷���
        
		
	}
	
	
	public static void main(String[] args) {

		new MainPanel();
		
	}




	@Override
	public void run() {
		btn();
		
	}

	

	
}
