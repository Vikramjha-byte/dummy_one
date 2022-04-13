import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Addash implements ActionListener{
	JFrame dashboard;
	JPanel title,content,admin;
	JButton stud,not,res,pro,log,rem,up,add,remn,upn,upr,addn,addr,rad,min,close;
	JTable student,notice,results;
	JLabel head,imgan;
	DefaultTableModel model ;
	JScrollPane scrollpane;
static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;


	Addash(){
		    dashboard=new JFrame("admin dashboard");
			title=new JPanel();
			title.setBounds(0,0,1366,70);
			title.setForeground(new Color(247,202,24));
			title.setBackground(new Color(0,0,0,60));
			title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			title.setLayout(null);
	dashboard.add(title);
			content=new JPanel();
			content.setBounds(0,71,250,738);
			content.setBackground(new Color(247,202,24));
			content.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
			content.setLayout(null);
	dashboard.add(content);
			head= new JLabel("VIRTUAL INFORMATION PORTAL");
			head.setBounds(2,2,600,70);
			head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,35));
			head.setForeground(new Color(0,0,0));
	title.add(head);
			min=new JButton("-");
			min.setBounds(1260,20,50,30);
			min.setForeground(new Color(247,202,24));
			min.setBackground(new Color(0,0,60));
			min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
			min.addActionListener(this);
	title.add(min);	
			close=new JButton("X");
			close.setBounds(1310,20,50,30);
			close.setForeground(new Color(247,202,24));
			close.setBackground(new Color(0,0,60));
			close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
			close.addActionListener(this);
	title.add(close);
		    ImageIcon me=new ImageIcon("admin.png");
			Image temp=me.getImage();
			Image temp_img=temp.getScaledInstance(250,200,Image.SCALE_SMOOTH);
			me=new ImageIcon(temp_img);
			JLabel img=new JLabel("",me,JLabel.CENTER);
			img.setBounds(15,25,250,200);
	content.add(img);	
			ImageIcon ban=new ImageIcon("adm.jpg");
			Image temple=ban.getImage();
			Image temple_img=temple.getScaledInstance(1100,300,Image.SCALE_SMOOTH);
			ban=new ImageIcon(temple_img);
			imgan=new JLabel("",ban,JLabel.CENTER);
			imgan.setBounds(260,80,1100,300);
	dashboard.add(imgan);		
		     stud=new JButton("STUDENT DATA TABLE");
			 stud.setBounds(10,230,230,50);
			 stud.setForeground(new Color(247,202,24));
			 stud.setBackground(new Color(0,0,60));
			 stud.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 stud.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 stud.addActionListener(this);
	content.add(stud);
	         not=new JButton("NOTICE DATA TABLE");
			 not.setBounds(10,300,230,50);
			 not.setForeground(new Color(247,202,24));
			 not.setBackground(new Color(0,0,60));
			 not.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 not.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 not.addActionListener(this);
	content.add(not);
			 res=new JButton("RESULT DATA TABLE");
			 res.setBounds(10,370,230,50);
			 res.setForeground(new Color(247,202,24));
			 res.setBackground(new Color(0,0,60));
			 res.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 res.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 res.addActionListener(this);
	content.add(res);
			 pro=new JButton("ADD ADMIN");
			 pro.setBounds(10,440,230,50);
			 pro.setForeground(new Color(247,202,24));
			 pro.setBackground(new Color(0,0,60));
			 pro.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 pro.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 pro.addActionListener(this);
	content.add(pro);
		     rad=new JButton("REMOVE ADMIN");
			 rad.setBounds(10,510,230,50);
			 rad.setForeground(new Color(247,202,24));
			 rad.setBackground(new Color(0,0,60));
			 rad.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 rad.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 rad.addActionListener(this);
	content.add(rad);
	log=new JButton("LOGOUT");
			 log.setBounds(10,570,230,50);
			 log.setForeground(new Color(247,202,24));
			 log.setBackground(new Color(0,0,60));
			 log.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 log.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 log.addActionListener(this);
	content.add(log);
	rem=new JButton("REMOVE STUDENT");
	rem.setBounds(270,550,230,50);
			rem.setForeground(new Color(247,202,24));
			 rem.setBackground(new Color(0,0,60));
			 rem.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 rem.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 rem.addActionListener(this);
	dashboard.add(rem);
	up=new JButton("UPDATE STUDENT ");
	 up.setBounds(550,550,230,50);
			up.setForeground(new Color(247,202,24));
			 up.setBackground(new Color(0,0,60));
			 up.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 up.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 up.addActionListener(this);
	dashboard.add(up);
	add=new JButton("ADD STUDENT ");
	 add.setBounds(830,550,230,50);
			add.setForeground(new Color(247,202,24));
			 add.setBackground(new Color(0,0,60));
			 add.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			add.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 add.addActionListener(this);
	dashboard.add(add);
	remn=new JButton("REMOVE NOTICE");
	remn.setBounds(1110,550,230,50);
			remn.setForeground(new Color(247,202,24));
			 remn.setBackground(new Color(0,0,60));
			 remn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 remn.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 remn.addActionListener(this);
	dashboard.add(remn);
	upn=new JButton("UPDATE NOTICE ");
	 upn.setBounds(550,650,230,50);
			upn.setForeground(new Color(247,202,24));
			 upn.setBackground(new Color(0,0,60));
			 upn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 upn.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 upn.addActionListener(this);
	dashboard.add(upn);
	addn=new JButton("ADD NOTICE ");
	 addn.setBounds(830,650,230,50);
			addn.setForeground(new Color(247,202,24));
			 addn.setBackground(new Color(0,0,60));
			 addn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			addn.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 addn.addActionListener(this);
	dashboard.add(addn);
	addr=new JButton("ADD RESULT ");
	 addr.setBounds(1100,650,230,50);
			addr.setForeground(new Color(247,202,24));
			 addr.setBackground(new Color(0,0,60));
			 addr.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			addr.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 addr.addActionListener(this);
	dashboard.add(addr);
	upr=new JButton("UPDATE RESULT ");
	 upr.setBounds(270,650,230,50);
			upr.setForeground(new Color(247,202,24));
			 upr.setBackground(new Color(0,0,60));
			 upr.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
			 upr.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));
			 upr.addActionListener(this);
	dashboard.add(upr);
					/*model = new DefaultTableModel();
                    student=new JTable(model);
                    model.addColumn("Id");
                    model.addColumn("First Name");
                    model.addColumn("Last Name");
                    model.addColumn("middle Name");
                    model.addColumn("father Name");
                    model.addColumn("mother Name");
                    model.addColumn("email id");
                    model.addColumn("Registration number");
					dashboard.getContentPane().add(new JScrollPane(student));*/
					 admin=new JPanel();
	admin.setBounds(260,80,1100,400);
	admin.setLayout(null);
	JLabel name=new JLabel("ENTER NAME:");
	name.setBounds(10,20,120,30);
	admin.add(name);
		
		       dashboard.setSize(1366,768);
			   dashboard.setUndecorated(true);
			   dashboard.setLayout(null);
			   dashboard.setLocationRelativeTo(null);
			   dashboard.setVisible(true);
		
	}

	

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==min){dashboard.setState(JFrame.ICONIFIED);}
		if(e.getSource()==close){System.exit(0);}
		try{if(e.getSource()==stud){
			JOptionPane.showMessageDialog(dashboard,"CLICK OK TO LOAD!");
			imgan.setVisible(false);
				Object[][] data = {
/*{"Mary", "Campione", 
"Snowboarding", new Integer(5), new Boolean(false)},
{"Alison", "Huml", 
"Rowing", new Integer(3), new Boolean(true)},
{"Kathy", "Walrath",
"Chasing toddlers", new Integer(2), new Boolean(false)},
{"Mark", "Andrews",
"Speed reading", new Integer(20), new Boolean(true)},
{"Angela", "Lih",
"Teaching high school", new Integer(4), new Boolean(false)}*/
};
			String[] columnNames = {"First Name", 
"Middle Name",
"Last name",
"Father name",
		"Mother name","gender","branch","dob","Mobile number","Year","EmailId","registration number","foccupation", "fmbno", "faddress", "moccupation", "mmbno", "maddress", "area", "nationality", "state"};
			        DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
					scrollpane=new JScrollPane();
					scrollpane.setBounds(260,80,1100,400);
					dashboard.add(scrollpane);
					student=new JTable();
					student.setModel(model);
					scrollpane.setViewportView(student);
					student.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
student.setFillsViewportHeight(true);

scrollpane.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollpane.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String firstt="";
String middlee="";
String lastt= "";
String fatherr= "";
String motherr= "";
String genderr = "";
String branchhh = "";
String dobb= "";
String mobilenoo="";
String Yearr="";
String Emailidd="";
String usernamee="";
String passswordd="";
String registrationn="";
String foccupationn="";
String fmbnoo="";
String faddresss="";
String moccupationn="";
String mmbnoo="";
String maddresss="";
String areaaa="";
String nationalityy="";
String statee="";
try
{ 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
String sql = "select * from member where almuni='student'";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{
 firstt=rs.getString("firstname");
 middlee=rs.getString("middlename");
 lastt= rs.getString("lastname");
 fatherr=rs.getString("fathername");
 motherr=rs.getString("mothername");
 genderr =rs.getString("gender");
 branchhh =rs.getString("branch");
 dobb=rs.getString("dob");
 mobilenoo=rs.getString("mobileno");
 Yearr=rs.getString("year");
 Emailidd=rs.getString("emailid");
 usernamee=rs.getString("username");
 passswordd=rs.getString("password");
 registrationn=rs.getString("regno");
 foccupationn=rs.getString("foccupation");
 fmbnoo=rs.getString("fmbno");
 faddresss=rs.getString("faddress");
 moccupationn=rs.getString("moccupation");
 mmbnoo=rs.getString("mmbno");
 maddresss=rs.getString("maddress");
 areaaa=rs.getString("area");
 nationalityy=rs.getString("nationality");
 statee=rs.getString("state");
model.addRow(new Object[]{firstt, 
middlee,
lastt,
fatherr,
motherr,genderr,branchhh,dobb,mobilenoo,Yearr,Emailidd,registrationn,foccupationn,fmbnoo,faddresss,moccupationn,mmbnoo,maddresss,areaaa,nationalityy,statee});
i++;
} 
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}catch(Exception ev){}
			}}catch(Exception ev){}
			try{if(e.getSource()==not){
				JOptionPane.showMessageDialog(dashboard,"CLICK OK TO LOAD!");
				imgan.setVisible(false);
				Object[][] data = {
/*{"Mary", "Campione", 
"Snowboarding", new Integer(5), new Boolean(false)},
{"Alison", "Huml", 
"Rowing", new Integer(3), new Boolean(true)},
{"Kathy", "Walrath",
"Chasing toddlers", new Integer(2), new Boolean(false)},
{"Mark", "Andrews",
"Speed reading", new Integer(20), new Boolean(true)},
{"Angela", "Lih",
"Teaching high school", new Integer(4), new Boolean(false)}*/
};
			String[] columnNames = {"id", "title", "description", "branch", "year", "almuni", "date", "type"};
			      DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
		            scrollpane=new JScrollPane();
					scrollpane.setBounds(260,80,1100,400);
					dashboard.add(scrollpane);
					student=new JTable();
					student.setModel(model);
					scrollpane.setViewportView(student);
					 student.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
student.setFillsViewportHeight(true);

scrollpane.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollpane.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

String branchh="";
String yearr="";
String title= "";
String description= "";
String branch= "";
String almuni = "";
String date = "";
String type= "";
String year="";
try
{ 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
String sql = "select * from notice ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{
int id = rs.getInt("id");
title = rs.getString("title");
description= rs.getString("description");
branchh = rs.getString("branch"); 
yearr=rs.getString("year");
almuni= rs.getString("almuni");
date=rs.getString("date");
type=rs.getString("type");
model.addRow(new Object[]{id,title,description,branchh,yearr,almuni,date,type});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}}catch(Exception ev){}
			}}catch(Exception ev){}
			try{if(e.getSource()==res){
				JOptionPane.showMessageDialog(dashboard,"CLICK OK TO LOAD!");
				imgan.setVisible(false);
				Object[][] data = {
/*{"Mary", "Campione", 
"Snowboarding", new Integer(5), new Boolean(false)},
{"Alison", "Huml", 
"Rowing", new Integer(3), new Boolean(true)},
{"Kathy", "Walrath",
"Chasing toddlers", new Integer(2), new Boolean(false)},
{"Mark", "Andrews",
"Speed reading", new Integer(20), new Boolean(true)},
{"Angela", "Lih",
"Teaching high school", new Integer(4), new Boolean(false)}*/
};
			String[] columnNames = {"id", "rollno", "examyear", "nameofexam", "sub1", "sub2", "sub3","sub4" ,"sub5","sub6","percentage"};
		            DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
		            scrollpane=new JScrollPane();
					scrollpane.setBounds(260,80,1100,400);
					dashboard.add(scrollpane);
					student=new JTable();
					student.setModel(model);
					scrollpane.setViewportView(student);
					 student.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
student.setFillsViewportHeight(true);

scrollpane.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrollpane.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

String rollno="";
String examyear= "";
String nameofexam= "";
String sub1= "";
String sub2 = "";
String sub3 = "";
String sub4= "";
String sub5="";
String sub6="";
String percentage="";
try
{ 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
String sql = "select * from result ";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
while(rs.next())
{
int id = rs.getInt("id");
rollno = rs.getString("rollno");
examyear= rs.getString("examyear");
nameofexam = rs.getString("nameofexam"); 
sub1=rs.getString("sub1");
sub2= rs.getString("sub2");
sub3=rs.getString("sub3");
sub4=rs.getString("sub4");
sub5=rs.getString("sub5");
sub6=rs.getString("sub6");
percentage=rs.getString("percentage");
model.addRow(new Object[]{id,rollno,examyear,nameofexam,sub1,sub2,sub3,sub4,sub5,sub6,percentage});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}}catch(Exception ev){}
			}}catch(Exception ev){}
					
			
			try{
			if(e.getSource()==log){
				JOptionPane.showMessageDialog(dashboard,"YOU ARE LOGGED OUT SUCCESFULLY");
				dashboard.dispose();
			new Login();}}catch(Exception ev){}
		    try{
			if(e.getSource()==add){
			new Stadd();}}catch(Exception ev){}
		try{
			if(e.getSource()==pro){
				imgan.setVisible(true);
				//scrollpane.setVisible(false);
				new Adadd();
				}}catch(Exception ev){}
				try{if(e.getSource()==up){
				imgan.setVisible(true);
				//scrollpane.setVisible(false);
				new Stupdate();
				}}catch(Exception ev){}
				try{
			if(e.getSource()==addr){
				imgan.setVisible(true);
				new Resultadd();
				}}catch(Exception ev){}
				try{if(e.getSource()==rem){
				imgan.setVisible(true);
				
				new Rstu();
				}}catch(Exception ev){}
				try{if(e.getSource()==rad){
				imgan.setVisible(true);
				
				new Radm();
}}catch(Exception ev){}
try{if(e.getSource()==addn){
				imgan.setVisible(true);
				
				new Anotice();
}}catch(Exception ev){}
try{if(e.getSource()==remn){
				imgan.setVisible(true);
				
				new Rnotice();
}}catch(Exception ev){}
	}
	public static void main(String[] args){
		new Addash();
	}		
}