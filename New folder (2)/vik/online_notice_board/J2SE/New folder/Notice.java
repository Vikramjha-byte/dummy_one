import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.sql.*;
import java.util.Date; 
public class Notice implements ActionListener{
	JFrame dashboard;
	JButton search;
	JLabel roll,dateofbirth,noe,header;
	JTextField noexam,reg,dob;
    JDateChooser chooser;
	String sd,id,title,l,m,pop,branchh,regis,ey,ne,s1,s2,s3,s4,s5,s6,percent;
	int f;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
		Notice() throws Exception{	
			dashboard=new JFrame("STUDENT dashboard");
			noe=new JLabel("ENTER NOTICE TITLE :");
			noe.setBounds(100,150,400,30);
			noe.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//noe.setVisible(false);
			dashboard.add(noe);
			noexam=new JTextField();
			noexam.setBounds(450,150,280,30);
			noexam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			//noexam.setVisible(false);
			dashboard.add(noexam);
			roll=new JLabel("ENTER NOTICE ID :");
			roll.setBounds(100,190,400,30);
			roll.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//roll.setVisible(false);
			dashboard.add(roll);
			
			reg=new JTextField();
			reg.setBounds(450,190,280,30);
			reg.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			//reg.setVisible(false);
			dashboard.add(reg);
			dateofbirth=new JLabel("ENTER DATE OF NOTICE :");
			dateofbirth.setBounds(100,230,400,30);
			dateofbirth.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//dateofbirth.setVisible(false);
			dashboard.add(dateofbirth);
			chooser = new JDateChooser();
			chooser.setBounds(450,230,280,30);
			//chooser.setVisible(false);
			dashboard.add(chooser);
			header=new JLabel("VIP ONLINE NOTICES");
			header.setForeground(Color.red);
			header.setBounds(100,100,700,30);
			//header.setVisible(false);
			header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
			dashboard.add(header);
			search=new JButton("SEARCH NOTICE");
			 search.setBounds(470,280,230,50);
			 search.setForeground(new Color(247,202,24));
			 search.setBackground(new Color(0,0,60));
			 //search.setVisible(false);
			 search.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 search.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 search.addActionListener(this);
	dashboard.add(search);
	dashboard.setSize(1000,400);
			   dashboard.setUndecorated(true);
			   dashboard.setLayout(null);
			   dashboard.setLocationRelativeTo(null);
			   dashboard.setVisible(true);
			   try{
											Class.forName("com.mysql.cj.jdbc.Driver");
											System.out.println("Connecting to database...");
											conn = DriverManager.getConnection(DB_URL,USER,PASS);
											}
										catch(SQLException e){
											System.out.println(e.getMessage());
											}
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==search){
				dashboard.dispose();
				String titlee=noexam.getText();
				String id=reg.getText();
				Date BirthDate=(Date) chooser.getDate();
				SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			    String sd = oDateFormat.format(BirthDate);
				try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql=" SELECT * FROM notice  WHERE id='"+id+"'AND title='"+titlee+"'AND date='"+sd+"'";
			  ResultSet rs=stmt.executeQuery(sql);
			  while(rs.next()){
				  f=rs.getInt("id");
			  l=rs.getString("title");
			  m=rs.getString("description");
			  // pop=rs.getDate("date");
			   branchh=rs.getString("branch");
			 //  regis=rs.getString("regno");
			   ey=rs.getString("year"); 
			   ne=rs.getString("type"); 
			   s1=rs.getString("almuni"); 
			  }
			  /*if(ne.equals(exam)&&regis.equals(registration)){
			  System.out.println(f+l+m+pop+branchh+ey+ne+s1);}*/
			  
			}catch(SQLException ex){ex.printStackTrace();}
			JFrame res= new JFrame("NOTICE");
			JLabel title=new JLabel("VIRTUAL INFORMATION PORTAL");
			JLabel Fname=new JLabel(sd);
			JLabel branc=new JLabel("NOTICE");
			JLabel branch=new JLabel(l);
			JLabel rno=new JLabel("<html>"+m+"</html>");
			JLabel regno=new JLabel(ne);
			JLabel subject1=new JLabel(s1);
			
			
			title.setBounds(300,10,1000,30);
			title.setForeground(new Color(0,0,60));
			title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
			
			Fname.setBounds(250,192,120,30);
			Fname.setForeground(Color.black);
			Fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
			branc.setBounds(550,130,180,30);
			branc.setForeground(Color.red);
			branc.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
				branch.setBounds(500,185,400,30);
				branch.setForeground(Color.black);
				branch.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				 rno.setBounds(200,190,900,300);
				 rno.setForeground(Color.black);
				rno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				regno.setBounds(150,530,250,30);
				regno.setForeground(Color.black);
				regno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				
				subject1.setBounds(135,563,200,30);
				subject1.setForeground(Color.black);
				subject1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				

			res.add(title);
			res.add(Fname);
			res.add(branc);
			res.add(branch);
			res.add(rno);
			res.add(regno);
			res.add(subject1);
			

			
			
			  res.setSize(1366,768);
			  res.setLayout(null);
			  res.setVisible(true);
			  
		}
		}
		public static void main(String[] args) throws Exception{
		new Notice();
}	}	