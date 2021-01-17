
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Total {
      static JTextField tf=new JTextField(10);
      MemberDAO dao=new MemberDAO();
      
      
      public  Total() {
         dao.sales();
      
         JFrame f =new JFrame();
         f.setTitle("Sales");
         f.setLayout(new FlowLayout());
         f.setLocationRelativeTo(null);

         JLabel la=new JLabel("√— ∏≈√‚");
         
      //   tf.setEditable(false);


         f.add(la);
         f.add(tf);
         
         f.setSize(190, 150);
         f.setVisible(true);
         
      }

}