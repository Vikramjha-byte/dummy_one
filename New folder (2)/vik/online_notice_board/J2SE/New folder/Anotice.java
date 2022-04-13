import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
//import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Anotice implements ActionListener{
	JFrame screen;
	JLabel header;
	JTextField title,description,branch ,year ,almuni,type;
	JTextArea textt;
	 JDateChooser chooser;
	 JButton add,cancel;
	  String f,l,m,sd,pop,mum,smobile;
	  static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	Anotice() throws Exception{
		screen=new JFrame();
	    header=new JLabel("VIRTUAL INFORMATION PORTAL");
		header.setBounds(150,10,600,50);
		header.setForeground(Color.red);
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("TITLE :");
		header.setBounds(40,140,180,30);
		//header.setForeground(Color.blue);
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("DESCRIPTION :");
		header.setBounds(40,180,180,30);
		//header.setForeground(Color.blue);
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("BRANCH :");
		header.setBounds(40,360,180,30);
		//header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("YEAR :");
		header.setBounds(40,400,180,30);
		//header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("NAME OF ALMUNI :");
		header.setBounds(40,440,200,30);
		//header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("DEPARTMENT :");
		header.setBounds(40,480,180,30);
		//header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("DATE :");
		header.setBounds(40,510,180,30);
		//header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		header=new JLabel("ADD NEW NOTICE");
		header.setBounds(220,80,200,50);
		header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		title=new JTextField();
		title.setBounds(230,140,300,30);
	    screen.add(title);
		branch=new JTextField();
		branch.setBounds(230,360,300,30);
	    screen.add(branch);
		year=new JTextField();
		year.setBounds(230,400,300,30);
	    screen.add(year);
		almuni=new JTextField();
		almuni.setBounds(230,440,300,30);
	    screen.add(almuni);
		type=new JTextField();
		type.setBounds(230,480,300,30);
	    screen.add(type);
		chooser = new JDateChooser();
		chooser.setBounds(230,520,300,30);
		//chooser.setVisible(false);
		screen.add(chooser);
		textt=new JTextArea();
		textt.setBounds(230,180,300,170);
		textt.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		textt.setLineWrap(true);
	    screen.add(textt);
	    add=new JButton("ADD");
		add.setBounds(370,570,70,30);
		add.setBackground(Color.white);
		add.addActionListener(this);
		screen.add(add);
	    cancel=new JButton("CANCEL");
		cancel.setBounds(450,570,80,30);
		cancel.setBackground(Color.white);
		cancel.addActionListener(this);
		screen.add(cancel);
	
	
	
		screen.setSize(600,650);
		screen.setLayout(null);
		screen.setUndecorated(true);
		screen.setLocationRelativeTo(null);
		screen.setVisible(true);
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
		if(e.getSource()==cancel){screen.dispose();}
		if(e.getSource()==add){
			 String f=title.getText();
			  String  l=textt.getText();
			  String  m=branch.getText();
			   String pop=year.getText();
			   String mum=almuni.getText();
			   Date BirthDate=(Date) chooser.getDate();
			   SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			   String  sd = oDateFormat.format(BirthDate);
			   String smobile=type.getText();
			try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="INSERT INTO notice(title,description,branch,year,almuni,date,type) VALUES ('"+f+"','"+l+"','"+m+"','"+pop+"','"+mum+"','"+sd+"','"+smobile+"')";
			  stmt.executeUpdate(sql);
			  System.out.println(f+l+m+pop+mum+sd+smobile);
		        JOptionPane.showMessageDialog(screen,"NOTICE ADDED SUCCESSFULLY");
		}catch(SQLException ev){ev.printStackTrace();}}
			
		
		
		
	}
	public static void main(String[] args)throws Exception{
		
		new Anotice();
	}
}