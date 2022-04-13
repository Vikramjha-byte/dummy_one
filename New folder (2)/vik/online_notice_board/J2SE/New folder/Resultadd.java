import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
public class Resultadd implements ActionListener{
	JFrame screen;
	JPanel title,contain;
	JLabel head,tag,noe,roll,fname,father,mother,tscore,percent,ricon,mark5,mark6,Percent;
	JTextField exam,reg,fullname,fathername,mothername,totalscore,percentage,Mark5,Mark6,Percentage;
	JButton min,close,add,back;
	String f,l,m,sd,pop,mum,smobile,mi,mu,mo;
	  static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	Resultadd() throws Exception{
	screen=new JFrame("add result");
	title=new JPanel();
	title.setBounds(1,1,500,50);
	title.setForeground(new Color(247,202,24));
	title.setBackground(new Color(0,0,0,60));
	title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	title.setLayout(null);
	screen.add(title);
	contain=new JPanel();
	contain.setBounds(1,52,500,549);
	//contain.setForeground(new Color(255,255,255));
	//contain.setBackground(new Color(140,145,248));
	contain.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.setLayout(null);
	screen.add(contain);
	head=new JLabel("VIRTUAL INFORMATION PORTAL");
	head.setBounds(2,10,300,50);
	head.setForeground(new Color(255,255,255));
	head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	title.add(head);
	noe=new JLabel("NAME OF EXAM :");
	noe.setBounds(2,70,300,30);
	//noe.setForeground(new Color(255,255,255));
	noe.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(noe);
	roll=new JLabel("ENTER REGISTRATION NUMBER");
	roll.setBounds(2,110,300,30);
	//roll.setForeground(new Color(255,255,255));
	roll.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(roll);
	fname=new JLabel("YEAR");
	fname.setBounds(2,150,300,30);
	//fname.setForeground(new Color(255,255,255));
	fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(fname);
	father=new JLabel("MARKS IN SUBJECT 1 :");
	father.setBounds(2,190,300,30);
	//father.setForeground(new Color(255,255,255));
	father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(father);
	mother=new JLabel("MARKS IN SUBJECT 2 :");
	mother.setBounds(2,230,300,30);
	//mother.setForeground(new Color(255,255,255));
	mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(mother);
	tscore=new JLabel("MARKS IN SUBJECT 3 :");
	tscore.setBounds(2,270,300,30);
	//tscore.setForeground(new Color(255,255,255));
	tscore.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(tscore);
	percent=new JLabel(" MARKS IN SUBJECT 4 :");
	percent.setBounds(2,310,300,30);
	//percent.setForeground(new Color(255,255,255));
	percent.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(percent);
	mark5=new JLabel(" MARKS IN SUBJECT 5 :");
	mark5.setBounds(2,350,300,30);
	//mark5.setForeground(new Color(255,255,255));
	mark5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(mark5);
	mark6=new JLabel(" MARKS IN SUBJECT 6 :");
	mark6.setBounds(2,390,300,30);
	//mark6.setForeground(new Color(255,255,255));
	mark6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(mark6);
	Percent=new JLabel(" PERCENTAGE :");
	Percent.setBounds(2,430,300,30);
	//Percent.setForeground(new Color(255,255,255));
	Percent.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
	contain.add(Percent);
	exam=new JTextField();
	exam.setBounds(310,70,180,30);
	/*exam.setForeground(new Color(247,202,24));
	exam.setBackground(new Color(0,0,0));
	exam.setCaretColor(new Color(247,202,24));
	exam.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	exam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(exam);
	reg=new JTextField();
	reg.setBounds(310,110,180,30);
	/*reg.setForeground(new Color(247,202,24));
	reg.setBackground(new Color(0,0,0));
	reg.setCaretColor(new Color(247,202,24));
	reg.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	reg.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(reg);
	fullname=new JTextField();
	fullname.setBounds(310,150,180,30);
	/*fullname.setForeground(new Color(247,202,24));
	fullname.setBackground(new Color(0,0,0));
	fullname.setCaretColor(new Color(247,202,24));
	fullname.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	fullname.setFont(new Font("times new roman",Font.BOLD,14));
	contain.add(fullname);
	fathername=new JTextField();
	fathername.setBounds(310,190,180,30);
	/*fathername.setForeground(new Color(247,202,24));
	fathername.setBackground(new Color(0,0,0));
	fathername.setCaretColor(new Color(247,202,24));
	fathername.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	fathername.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(fathername);
	mothername=new JTextField();
	mothername.setBounds(310,230,180,30);
	/*mothername.setForeground(new Color(247,202,24));
	mothername.setBackground(new Color(0,0,0));
	mothername.setCaretColor(new Color(247,202,24));
	mothername.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	mothername.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(mothername);
	totalscore=new JTextField();
	totalscore.setBounds(310,270,180,30);
	/*totalscore.setForeground(new Color(247,202,24));
	totalscore.setBackground(new Color(0,0,0));
	totalscore.setCaretColor(new Color(247,202,24));
	totalscore.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	totalscore.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(totalscore);
	percentage=new JTextField();
	percentage.setBounds(310,310,180,30);
/*percentage.setForeground(new Color(247,202,24));
	percentage.setBackground(new Color(0,0,0));
	percentage.setCaretColor(new Color(247,202,24));
	percentage.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	percentage.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(percentage);
	Mark5=new JTextField();
	Mark5.setBounds(310,350,180,30);
	//Mark5.setForeground(new Color(247,202,24));
	//Mark5.setBackground(new Color(0,0,0));
	//Mark5.setCaretColor(new Color(247,202,24));
	//Mark5.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	Mark5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(Mark5);

	Mark6=new JTextField();
	Mark6.setBounds(310,390,180,30);
	//Mark6.setForeground(new Color(247,202,24));
	//Mark6.setBackground(new Color(0,0,0));
	//Mark6.setCaretColor(new Color(247,202,24));
	//Mark6.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	Mark6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(Mark6);

	Percentage=new JTextField();
	Percentage.setBounds(310,430,180,30);
	//Percentage.setForeground(new Color(247,202,24));
	//Percentage.setBackground(new Color(0,0,0));
	//Percentage.setCaretColor(new Color(247,202,24));
	//Percentage.setBorder(BorderFactory.createMatteBorder(0,0,5,0,new Color(247,202,24)));*/
	Percentage.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
	contain.add(Percentage);

	ImageIcon re=new ImageIcon("result.png");
	Image imag=re.getImage();
	Image imagetemp=imag.getScaledInstance(70,70,Image.SCALE_SMOOTH);
	re=new ImageIcon(imagetemp);
	ricon=new JLabel("",re,JLabel.CENTER);
	ricon.setBounds(2,2,70,70);
	contain.add(ricon);
															min= new JButton("-");
															min.setBounds(420,0,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
				title.add(min);											
															close= new JButton("x");
															close.setBounds(460,0,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
				title.add(close);
															add= new JButton("ADD");
															add.setBounds(300,490,70,30);
															//add.setForeground(Color.white);
															//add.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															add.setBackground(Color.white );
															//add.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															add.addActionListener(this);
				contain.add(add);
															back= new JButton("CANCEL");
															back.setBounds(380,490,80,30);
															//back.setForeground(Color.white);
															//back.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															back.setBackground(Color.white );
															//back.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															back.addActionListener(this);
				contain.add(back);
	
		        
		
		
		
	screen.setSize(500,600);
	screen.setLayout(null);
	screen.setUndecorated(true);
	screen.setVisible(true);
	screen.setLocationRelativeTo(null);
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
		if(e.getSource()==min){screen.setState(JFrame.ICONIFIED);}
		try{if(e.getSource()==close){screen.dispose();}}catch(Exception ex){}
		try{if(e.getSource()==back){screen.dispose();}}catch(Exception ex){}
		if(e.getSource()==add){
			 String f=exam.getText();
			  String  l=reg.getText();
			  String  m=fullname.getText();
			   String pop=fathername.getText();
			   String mum=mothername.getText();
			   String mi=totalscore.getText();
			   String mu=percentage.getText();
			   String mo=Mark5.getText();
			   String smobile=Mark6.getText();
			   String sd=Percentage.getText();
			try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="INSERT INTO result(rollno,examyear,nameofexam,sub1,sub2,sub3,sub4,sub5,sub6,percentage) VALUES ('"+l+"','"+m+"','"+f+"','"+pop+"','"+mum+"','"+mi+"','"+mu+"','"+mo+"','"+smobile+"','"+sd+"')";
			  stmt.executeUpdate(sql);
			  System.out.println(f+l+m+pop+mum+mi+mu+mo+sd+smobile);
		        JOptionPane.showMessageDialog(screen,"RESULT ADDED SUCCESSFULLY");
		}catch(SQLException ev){ev.printStackTrace();}}
		JTextField exam,reg,fullname,fathername,mothername,totalscore,percentage,Mark5,Mark6,Percentage;
	}
	public static void main(String[] args) throws Exception{
		new Resultadd();
	}
}