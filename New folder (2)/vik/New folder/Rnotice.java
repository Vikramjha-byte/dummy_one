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
public class Rnotice implements ActionListener{
	JFrame screen;
	JLabel header,Title,Description,Branch,Year,Almuni,Type,ID;
	JLabel title,description,branch ,year ,almuni,type;
	JTextField id;
	JLabel textt;
	 JLabel chooser,DATE;
	 JButton add,cancel,get;
	  String f,l,m,sd,pop,mum,smobile,s1,ne,ey,branchh,Id;
	  static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	Rnotice() throws Exception{
		screen=new JFrame();
	    header=new JLabel("VIRTUAL INFORMATION PORTAL");
		header.setBounds(150,10,600,50);
		header.setForeground(Color.red);
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		Title=new JLabel("TITLE :");
		Title.setBounds(40,140,180,30);
		Title.setVisible(false);
		//header.setForeground(Color.blue);
		Title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Title);
		Description=new JLabel("DESCRIPTION :");
		Description.setBounds(40,180,180,30);
		Description.setVisible(false);
		//header.setForeground(Color.blue);
		Description.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Description);
		Branch=new JLabel("BRANCH :");
		Branch.setBounds(40,360,180,30);
		Branch.setVisible(false);
		//header.setForeground(new Color(0,0,60));
		Branch.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Branch);
		Year=new JLabel("YEAR :");
		Year.setBounds(40,400,180,30);
		Year.setVisible(false);
		//header.setForeground(new Color(0,0,60));
		Year.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Year);
		Almuni=new JLabel("NAME OF ALMUNI :");
		Almuni.setBounds(40,440,200,30);
		Almuni.setVisible(false);
		//header.setForeground(new Color(0,0,60));
		Almuni.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Almuni);
		Type=new JLabel("DEPARTMENT :");
		Type.setBounds(40,480,180,30);
		Type.setVisible(false);
		//header.setForeground(new Color(0,0,60));
		Type.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(Type);
		DATE=new JLabel("DATE :");
		DATE.setBounds(40,510,180,30);
		DATE.setVisible(false);
		//header.setForeground(new Color(0,0,60));
		DATE.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(DATE);
		header=new JLabel("DELETE OLD NOTICE");
		header.setBounds(200,80,220,50);
		header.setForeground(new Color(0,0,60));
		header.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		screen.add(header);
		title=new JLabel();
		title.setBounds(230,140,300,30);
		title.setVisible(false);
	    screen.add(title);
		ID=new JLabel("NOTICE ID :");
		ID.setBounds(40,140,180,30);
		ID.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		//ID.setVisible(false);
	    screen.add(ID);
		id=new JTextField();
		id.setBounds(230,140,200,30);
		//title.setVisible(false);
	    screen.add(id);
		branch=new JLabel();
		branch.setBounds(230,360,300,30);
		branch.setVisible(false);
	    screen.add(branch);
		year=new JLabel();
		year.setBounds(230,400,300,30);
		year.setVisible(false);
	    screen.add(year);
		almuni=new JLabel();
		almuni.setBounds(230,440,300,30);
		almuni.setVisible(false);
	    screen.add(almuni);
		type=new JLabel();
		type.setBounds(230,480,300,30);
		type.setVisible(false);
	    screen.add(type);
		chooser = new JLabel();
		chooser.setBounds(230,520,300,30);
		chooser.setVisible(false);
		//chooser.setVisible(false);
		screen.add(chooser);
		textt=new JLabel();
		textt.setBounds(230,180,300,170);
		textt.setVisible(false);
		textt.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.gray));
		//textt.setLineWrap(true);
	    screen.add(textt);
	    add=new JButton("DELETE");
		add.setBounds(370,570,70,30);
		add.setVisible(false);
		add.setBackground(Color.white);
		add.addActionListener(this);
		screen.add(add);
	    cancel=new JButton("CANCEL");
		cancel.setBounds(450,570,80,30);
		cancel.setVisible(false);
		cancel.setBackground(Color.white);
		cancel.addActionListener(this);
		screen.add(cancel);
		get=new JButton("GET");
		get.setBounds(450,140,80,30);
		//get.setVisible(false);
		get.setBackground(Color.white);
		get.addActionListener(this);
		screen.add(get);
	
	
	
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
		if(e.getSource()==get){
				
				
				 Id=id.getText();
				 if(Id.equals("")){JOptionPane.showMessageDialog(screen,"PLEASE TRY AGAIN");screen.dispose();}
				try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql=" SELECT * FROM notice  WHERE id='"+Id+"'";
			  ResultSet rs=stmt.executeQuery(sql);
			  while(rs.next()){
				  f=rs.getString("id");
			  l=rs.getString("title");
			  m=rs.getString("description");
			  pop=rs.getDate("date").toString();
			   branchh=rs.getString("branch");
			 //  regis=rs.getString("regno");
			   ey=rs.getString("year"); 
			   ne=rs.getString("type"); 
			   s1=rs.getString("almuni"); 
			   
			  }
			 try{ if(!Id.equals(f)){JOptionPane.showMessageDialog(screen,"NOTICE NOT FOUND");screen.dispose();}
			
				else if(Id.equals(f)){
			  		Title.setVisible(true);
		
		Description.setVisible(true);
		
		Branch.setVisible(true);
		
		Year.setVisible(true);
		
		Almuni.setVisible(true);
		
		Type.setVisible(true);
		
		DATE.setVisible(true);
		
		title.setVisible(true);
	    
		ID.setVisible(false);
	
		id.setVisible(false);
	
		branch.setVisible(true);
	
		year.setVisible(true);
	
		almuni.setVisible(true);
	    
		type.setVisible(true);
	
		chooser.setVisible(true);
		
		textt.setVisible(true);
		
	
		add.setVisible(true);
		
		cancel.setVisible(true);
		
		get.setVisible(false);
		title.setText(l);
		textt.setText("<html>"+m+"</html>");
		branch.setText(branchh);
		year.setText(ey);
		almuni.setText(s1);
		type.setText(ne);
		chooser.setText(pop);

			 }}catch(Exception ex){}
			  /*if(ne.equals(exam)&&regis.equals(registration)){
			  System.out.println(f+l+m+pop+branchh+ey+ne+s1);}*/
			  
			}catch(SQLException ex){ex.printStackTrace();}
			
		
		
		
	}
	if(e.getSource()==add){
		 try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="DELETE  FROM notice WHERE id='"+Id+"'";
			  stmt.executeUpdate(sql);
			  //System.out.println(f+l+m+pop+mum+sd+smobile+fmobile+mmobile+Foccupp+Moccupp+Maddresss+Faddresss+session+mail+user+pas+reg+gend+branchh+statess+Areaa+Nationn);
		        JOptionPane.showMessageDialog(screen,"NOTICE REMOVED SUCCESSFULLY");
				try{screen.dispose();new Addash();}catch(Exception ex){}
	}catch(SQLException ev){ev.printStackTrace();}}
	}
	
	public static void main(String[] args)throws Exception{
		
		new Rnotice();
	}
}