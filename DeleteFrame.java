import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class DeleteFrame extends JFrame
{
Container c;
JLabel lblEid;
JTextField txtEid;
JButton btnSave, btnBack;

DeleteFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());

lblEid=new JLabel("Enter EId");
txtEid=new JTextField(20);
btnSave=new JButton("Save");
btnBack=new JButton("Back");






btnBack.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent ae)
{
MainFrame a=new MainFrame();
dispose();
}});

btnSave.addActionListener(new ActionListener() 
{
public void actionPerformed(ActionEvent ae)
{
DbHandler db=new DbHandler();
int eid=Integer.parseInt(txtEid.getText());
//String name=txtName.getText();
db.deleteStudent(eid);
}});

c.add(lblEid);
c.add(txtEid);
c.add(btnSave);
c.add(btnBack);

setTitle("Delete. S.");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
