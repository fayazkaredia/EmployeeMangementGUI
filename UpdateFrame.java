import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class UpdateFrame extends JFrame
{
Container c;
JLabel lblEid, lblName,lblSalary;
JTextField txtEid, txtName,txtSalary;
JButton btnSave, btnBack;

UpdateFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());

lblEid=new JLabel("Enter Employee ID");
txtEid=new JTextField(20);
lblName=new JLabel("Enter Employee Name");
txtName=new JTextField(20);
lblSalary=new JLabel("Enter Employee Salary");
txtSalary=new JTextField(20);
btnSave=new JButton("Save");
btnBack=new JButton("Back");



txtEid.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                   // txtEid.setText(" ");
                }
            }
});

txtName.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();
                if(Character.isLetter(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only char are allowed!");
                    //txtName.setText(" ");
                }
            }
});

txtSalary.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){

                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                }
                else{
                    JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
                    //txtSalary.setText(" ");
                }
            }
});







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
String name=txtName.getText();
String salary=txtSalary.getText();
int s1=Integer.parseInt(salary);


if(name.length()==0 )
{
JOptionPane.showMessageDialog(null, "Enter all fields");
}

else
{

if(s1<8000)
{	
JOptionPane.showMessageDialog(null, "Salary Should be greater than 8000 !");
                   // txtSalary.setText(" ");
}
else if((name.length())<2){
JOptionPane.showMessageDialog(null, "name should be greater than 2");
                   // txtName.setText(" ");
}

else
{
	
					
					
db.updateStudent(eid,name,salary);
}


}


}});

c.add(lblEid);
c.add(txtEid);
c.add(lblName);
c.add(txtName);
c.add(lblSalary);
c.add(txtSalary);
c.add(btnSave);
c.add(btnBack);

setTitle("Add. S.");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
