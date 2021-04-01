import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;


ViewFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
ta=new TextArea(5,30);
btnBack=new JButton("Back");

DbHandler db=new DbHandler();
ta.setText(db.getStudent());

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
MainFrame a=new MainFrame();
dispose();
}});



c.add(ta);
c.add(btnBack);

setTitle("View.S.");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
