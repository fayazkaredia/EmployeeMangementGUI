import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;

MainFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
AddFrame a=new AddFrame();
dispose();
} });

btnView.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
ViewFrame a=new ViewFrame();
dispose();
}});

btnUpdate.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a=new UpdateFrame();
dispose();
} });


btnDelete.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a=new DeleteFrame();
dispose();
} });


setTitle("Employee Management System");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

public static void main(String args[])
{
MainFrame m = new MainFrame();
}
}


class DbHandler
{
public void addStudent(int rno,String name,String salary)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GBF81G:1521:xe","system","abc123");
String sql="insert into employee values(?,?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
pst.setString(3,salary);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+"records inserted");
con.close();

}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"already added");
}
}

public String getStudent()
{
StringBuffer sb=new StringBuffer();
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GBF81G:1521:xe","system","abc123");
String sql="select * from employee";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next()){
sb.append("rno= " + rs.getInt(1)+ " name=" + rs.getString(2) + " salary=" + rs.getString(3) + " \n");
}
con.close();
}
catch(SQLException e){
System.out.println("issues" );
}
return sb.toString();
}
public void deleteStudent(int rno)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GBF81G:1521:xe","system","abc123");
String sql="delete from employee where eid='" + rno + "'";
String sql1="select * from employee where eid='" + rno + "'";



Statement stmt=con.createStatement();

ResultSet rs1=stmt.executeQuery(sql1);

if(!rs1.next())
{
JOptionPane.showMessageDialog(new JDialog(),"Doest exist");	

}

else
{
	ResultSet rs=stmt.executeQuery(sql);
JOptionPane.showMessageDialog(new JDialog(),"records delete");

}

con.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"issue"+e);
}
}

public void updateStudent(int eid,String name,String salary)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-2GBF81G:1521:xe","system","abc123");
String sql="update employee set ename='"+name+"',esalary='"+salary+"' where eid='"+eid+"'";
String sql1="select * from employee where eid='" + eid + "'";
Statement stmt=con.createStatement();
ResultSet rs1=stmt.executeQuery(sql1);

if(!rs1.next())
{
JOptionPane.showMessageDialog(new JDialog(),"Doest exist");	

}

else
{

ResultSet rs=stmt.executeQuery(sql);
JOptionPane.showMessageDialog(new JDialog(),"records updated");
}
con.close();

}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"issue"+e);
}
}


}
