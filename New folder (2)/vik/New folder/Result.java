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
public class Result implements ActionListener{
	JFrame dashboard;
	JButton search;
	JLabel roll,dateofbirth,noe,header;
	JTextField noexam,reg,dob;
    JDateChooser chooser;
	String sd,registration,exam,f,l,m,pop,branchh,regis,ey,ne,s1,s2,s3,s4,s5,s6,percent;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
		Result() throws Exception{	
			dashboard=new JFrame("STUDENT dashboard");
			noe=new JLabel("ENTER NAME OF EXAM :");
			noe.setBounds(100,150,400,30);
			noe.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//noe.setVisible(false);
			dashboard.add(noe);
			noexam=new JTextField();
			noexam.setBounds(450,150,280,30);
			noexam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			//noexam.setVisible(false);
			dashboard.add(noexam);
			roll=new JLabel("ENTER REGISTRATION NO. :");
			roll.setBounds(100,190,400,30);
			roll.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//roll.setVisible(false);
			dashboard.add(roll);
			
			reg=new JTextField();
			reg.setBounds(450,190,280,30);
			reg.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			//reg.setVisible(false);
			dashboard.add(reg);
			dateofbirth=new JLabel("ENTER DATE OF BIRTH :");
			dateofbirth.setBounds(100,230,400,30);
			dateofbirth.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			//dateofbirth.setVisible(false);
			dashboard.add(dateofbirth);
			chooser = new JDateChooser();
			chooser.setBounds(450,230,280,30);
			//chooser.setVisible(false);
			dashboard.add(chooser);
			header=new JLabel("VIP SEMESTER EXAM RESULT");
			header.setForeground(Color.red);
			header.setBounds(100,100,700,30);
			//header.setVisible(false);
			header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
			dashboard.add(header);
			search=new JButton("SEARCH RESULT");
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
				String exam=noexam.getText();
				String registration=reg.getText();
				Date BirthDate=(Date) chooser.getDate();
				SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			    String sd = oDateFormat.format(BirthDate);
				try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql=" SELECT * FROM member JOIN result WHERE regno='"+registration+"'AND nameofexam='"+exam+"'AND dob='"+sd+"'";
			  ResultSet rs=stmt.executeQuery(sql);
			  while(rs.next()){
				  f=rs.getString("firstname");
			  l=rs.getString("lastname");
			  m=rs.getString("middlename");
			   pop=rs.getString("fathername");
			   branchh=rs.getString("branch");
			   regis=rs.getString("regno");
			   ey=rs.getString("examyear"); 
			   ne=rs.getString("nameofexam"); 
			   s1=rs.getString("sub1"); 
			   s2=rs.getString("sub2"); 
			   s3=rs.getString("sub3");
			   s4=rs.getString("sub4");
			   s5=rs.getString("sub5");
			   s6=rs.getString("sub6");
			   percent=rs.getString("percentage");
			  }
			  if(ne.equals(exam)&&regis.equals(registration)){
			  System.out.println(f+l+m+pop+branchh+regis+ey+ne+s1+s2+s3+s4+s5+s6+percent);}
			  
			}catch(SQLException ex){ex.printStackTrace();}
			JFrame res= new JFrame("RESULT");
			JLabel title=new JLabel(ne);
			JLabel namee=new JLabel("NAME:");
			JLabel stname=new JLabel(f+" "+m+" "+l);
			JLabel fnamee=new JLabel("FATHER'S NAME:");
			JLabel Fname=new JLabel(pop);
			JLabel branc=new JLabel("BRANCH:");
			JLabel branch=new JLabel(branchh);
			JLabel rno=new JLabel("REGISTRATION NO.:");
			JLabel regno=new JLabel(regis);
			JLabel subj1=new JLabel("SUBJECT 1:");
			JLabel subj2=new JLabel("SUBJECT 2");
			JLabel subj3=new JLabel("SUBJECT 3:");
			JLabel subj4=new JLabel("SUBJECT 4:");
			JLabel subj5=new JLabel("SUBJECT 5:");
			JLabel subj6=new JLabel("SUBJECT 6:");
			JLabel subject1=new JLabel(s1);
			JLabel subject2=new JLabel(s2);
			JLabel subject3=new JLabel(s3);
			JLabel subject4=new JLabel(s4);
			JLabel subject5=new JLabel(s5);
			JLabel subject6=new JLabel(s6);
			JLabel percentage=new JLabel("PERCENTAGE :");
			JLabel percentagee=new JLabel(percent);
			
			
			title.setBounds(400,10,600,30);
			title.setForeground(new Color(0,0,60));
			title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
			namee.setBounds(300,100,120,30);
			namee.setForeground( Color.red);
			namee.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			stname.setBounds(380,100,200,30);
			stname.setForeground(Color.black);
			stname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
			fnamee.setBounds(200,140,180,30);
			fnamee.setForeground(Color.red);
			fnamee.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			Fname.setBounds(380,140,200,30);
			Fname.setForeground(Color.black);
			Fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
			branc.setBounds(900,100,120,30);
			branc.setForeground(Color.red);
			branc.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				branch.setBounds(1000,100,200,30);
				branch.setForeground(Color.black);
				branch.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				 rno.setBounds(800,140,200,30);
				 rno.setForeground(Color.red);
				rno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				regno.setBounds(1000,140,250,30);
				regno.setForeground(Color.black);
				regno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				subj1.setBounds(400,270,180,30);
				subj1.setForeground(Color.red);
				subj1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subj2.setBounds(400,310,180,30);
				subj2.setForeground(Color.red);
				subj2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subj3.setBounds(400,350,180,30);
				subj3.setForeground(Color.red);
				subj3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subj4.setBounds(400,390,180,30);
				subj4.setForeground(Color.red);
				subj4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subj5.setBounds(400,430,180,30);
				subj5.setForeground(Color.red);
				subj5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subj6.setBounds(400,470,180,30);
				subj6.setForeground(Color.red);
				subj6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				subject1.setBounds(650,270,120,30);
				subject1.setForeground(Color.black);
				subject1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				subject2.setBounds(650,310,120,30);
				subject2.setForeground(Color.black);
				subject2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

				subject3.setBounds(650,350,120,30);
				subject3.setForeground(Color.black);
				subject3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				subject4.setBounds(650,390,120,30);
				subject4.setForeground(Color.black);
				subject4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				subject5.setBounds(650,430,120,30);
				subject5.setForeground(Color.black);
				subject5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				 subject6.setBounds(650,470,120,30);
				 subject6.setForeground(Color.black);
				subject6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				 percentage.setBounds(550,520,180,30);
				 percentage.setForeground(Color.red);
				percentage.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				percentagee.setBounds(750,520,120,30);
				percentagee.setForeground(Color.black);
				percentagee.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));

			res.add(title);
			res.add(namee);
			res.add(stname);
			res.add(fnamee);
			res.add(Fname);
			res.add(branc);
			res.add(branc);
			res.add(branch);
			res.add(rno);
			res.add(regno);
			res.add(subj1);
			res.add(subj2);
			res.add(subj3);
			res.add(subj4);
			res.add(subj5);
			res.add(subj6);
			res.add(subject1);
			res.add(subject2);
			res.add(subject3);
			res.add(subject4);
			res.add(subject5);	
			res.add(subject6);
			res.add(percentage);
			res.add(percentagee);

			
			
			  res.setSize(1366,7680);
			  res.setLayout(null);
			  res.setVisible(true);
			  
		}
		}
		public static void main(String[] args) throws Exception{
		new Result();
}	}	