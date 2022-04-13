import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Random;
public class Sregister  implements ActionListener{
	JFrame login;
	JLabel welcome,vip,profile,logtag;
	JButton min,close,add,reset;
	JPanel title;
	JTextField fname,lname,mname,father,mother,dob,mb,email,username,capt;
	JLabel fnam,lnam,mnam,dad,mom,gen,bran,doB,Mob,Year,Email,Username,Password,Repass,idd,id,captcha;
	JPasswordField password,repassword;
	JComboBox<String> branch;
	JComboBox<String> gender;
	JComboBox<String> year;
	String vall;
	String first,last,middle,pop,mum,birth,mobile,session,mail,user,pas,reg,gend,branchh,captt;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	public Sregister() throws Exception{
				login= new JFrame("Login_page_BNBC_J2SE");
															ImageIcon Background= new ImageIcon("backk.jpg");
															Image imag = Background.getImage();
															Image temp_imge = imag.getScaledInstance(1366,768,Image.SCALE_SMOOTH);
															Background= new ImageIcon(temp_imge);
															welcome = new JLabel("",Background,JLabel.CENTER);
															welcome.setForeground(Color.white);
															welcome.setBounds(0,0,1366,768);
				login.add(welcome);
															title= new JPanel();
															title.setBounds(1,1,1366,50);
															title.setBackground(new Color(0,0,0,80));
															title.setForeground(Color.white);
															title.setLayout(null);
				welcome.add(title);
															min= new JButton("-");
															min.setBounds(1280,0,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
				title.add(min);											
															close= new JButton("x");
															close.setBounds(1320,0,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
				title.add(close);
															vip= new JLabel("VIRTUAL INFORMATION PORTAL");
															vip.setBounds(10,5,735,30);
															vip.setForeground(new Color(248, 148, 6));
															vip.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30));
				title.add(vip);
															ImageIcon log= new ImageIcon("log.png");
															Image temp= log.getImage();
															Image tempimage=temp.getScaledInstance(100,50,Image.SCALE_SMOOTH);
															log=new ImageIcon(tempimage);
															profile= new JLabel("",log,JLabel.CENTER);
															profile.setBounds(10,60,100,50);
				welcome.add(profile);
															logtag= new JLabel("ADD STUDENT!");
															logtag.setBounds(90,60,180,70);
															logtag.setForeground(new Color(247, 202, 24));
															logtag.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(logtag);
															fnam=new JLabel("FIRST NAME :");
															fnam.setBounds(150,160,180,30);
															fnam.setForeground(new Color(247, 202, 24));
															fnam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(fnam);
															lnam=new JLabel("LAST NAME :");
															lnam.setBounds(510,160,180,30);
															lnam.setForeground(new Color(247, 202, 24));
															lnam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(lnam);											
															mnam=new JLabel("MIDDLE NAME :");
															mnam.setBounds(840,160,180,30);
															mnam.setForeground(new Color(247, 202, 24));
															mnam.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(mnam);
															dad=new JLabel("FATHER NAME :");
															dad.setBounds(150,280,180,30);
															dad.setForeground(new Color(247, 202, 24));
															dad.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(dad);											
															mom=new JLabel("MOTHER NAME :");
															mom.setBounds(510,280,180,30);
															mom.setForeground(new Color(247, 202, 24));
															mom.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(mom);
															gen=new JLabel("GENDER  :");
															gen.setBounds(840,280,180,30);
															gen.setForeground(new Color(247, 202, 24));
															gen.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(gen);
															bran=new JLabel("BRANCH :");
															bran.setBounds(150,400,180,30);
															bran.setForeground(new Color(247, 202, 24));
															bran.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(bran);
															doB=new JLabel("DATE OF BIRTH :");
															doB.setBounds(510,400,180,30);
															doB.setForeground(new Color(247, 202, 24));
															doB.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(doB);											
															Mob=new JLabel("MOBILE NO. :");
															Mob.setBounds(840,400,180,30);
															Mob.setForeground(new Color(247, 202, 24));
															Mob.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(Mob);											
															Year=new JLabel("YEAR :");
															Year.setBounds(150,520,180,30);
															Year.setForeground(new Color(247, 202, 24));
															Year.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(Year);											
															Email=new JLabel("EMAIL ID :");
															Email.setBounds(510,520,180,30);
															Email.setForeground(new Color(247, 202, 24));
															Email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(Email);
															Username=new JLabel("USERNAME :");
															Username.setBounds(840,520,180,30);
															Username.setForeground(new Color(247, 202, 24));
															Username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(Username);
															Password=new JLabel("PASSWORD :");
															Password.setBounds(150,640,180,30);
															Password.setForeground(new Color(247, 202, 24));
															Password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
				welcome.add(Password);
															Repass=new JLabel("RETYPE PASSWORD :");
															Repass.setBounds(510,640,230,30);
															Repass.setForeground(new Color(247, 202, 24));
															Repass.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				welcome.add(Repass);
															fname=new JTextField();
															fname.setBounds(340,160,120,30);
															fname.setForeground(new Color(255, 255, 255));
															fname.setBackground(new Color(0,0,0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fname.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(fname);
															lname=new JTextField();
															lname.setBounds(700,160,120,30);
															lname.setForeground(new Color(255, 255, 255));
															lname.setBackground(new Color(0,0,0));
															lname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															lname.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(lname);											
															mname=new JTextField();
															mname.setBounds(1030,160,120,30);
															mname.setForeground(new Color(255, 255, 255));
															mname.setBackground(new Color(0,0,0));
															mname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mname.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(mname);
															father=new JTextField();
															father.setBounds(340,280,120,30);
															father.setForeground(new Color(255, 255, 255));
															father.setBackground(new Color(0,0,0));
															father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															father.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(father);											
															mother=new JTextField();
															mother.setBounds(700,280,120,30);
															mother.setForeground(new Color(255, 255, 255));
															mother.setBackground(new Color(0,0,0));
															mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mother.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(mother);
															gender=new JComboBox<String>();
															gender.addItem("SELECT");
															gender.addItem("MALE");
															gender.addItem("FEMALE");
															gender.setBounds(1030,280,120,30);
															gender.setForeground(new Color(255, 255, 255));
															gender.setBackground(new Color(0,0,0));
															gender.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															gender.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(gender);
															branch=new JComboBox<String>();
															branch.addItem("SELECT");
															branch.addItem("CSE");
															branch.addItem("CE");
															branch.addItem("ME");
															branch.addItem("EE");
															branch.addItem("ECE");
															branch.setBounds(340,400,120,30);
															branch.setForeground(new Color(255, 255, 255));
															branch.setBackground(new Color(0,0,0));
															branch.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															branch.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(branch);
															dob=new JTextField();
															dob.setBounds(700,400,120,30);
															dob.setForeground(new Color(255, 255, 255));
															dob.setBackground(new Color(0,0,0));
															dob.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															dob.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(dob);											
															mb=new JTextField();
															mb.setBounds(1030,400,120,30);
															mb.setForeground(new Color(255, 255, 255));
															mb.setBackground(new Color(0,0,0));
															mb.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mb.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(mb);											
															year=new JComboBox<String>();
															year.addItem("SELECT");
															year.addItem("FIRST");
															year.addItem("SECOND");
															year.addItem("THIRD");
															year.addItem("FINAL");
															year.setBounds(340,520,120,30);
															year.setForeground(new Color(255, 255, 255));
															year.setBackground(new Color(0,0,0));
															year.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															year.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(year);											
															email=new JTextField();
															email.setBounds(700,520,120,30);
															email.setForeground(new Color(255, 255, 255));
															email.setBackground(new Color(0,0,0));
															email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															email.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(email);
															username=new JTextField();
															username.setBounds(1030,520,120,30);
															username.setForeground(new Color(255, 255, 255));
															username.setBackground(new Color(0,0,0));
															username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															username.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(username);
															password=new JPasswordField();
															password.setBounds(340,640,120,30);
															password.setForeground(new Color(255, 255, 255));
															password.setBackground(new Color(0,0,0));
															password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															password.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(password);
															repassword=new JPasswordField();
															repassword.setBounds(700,640,120,30);
															repassword.setForeground(new Color(255, 255, 255));
															repassword.setBackground(new Color(0,0,0));
															repassword.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															repassword.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(repassword);
															add= new JButton("ADD");
															add.setBounds(1030,690,70,30);
															add.setBackground(new Color(0,0,60) );
															add.setForeground(Color.white);
															add.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															add.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															add.addActionListener(this);
				welcome.add(add);	
															reset= new JButton("BACK");
															reset.setBounds(1110,690,70,30);
															reset.setBackground(new Color(0,0,60) );
															reset.setForeground(Color.white);
															reset.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															reset.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															reset.addActionListener(this);
				welcome.add(reset);	
															id=new JLabel();
															id.setBounds(1100,60,120,50);
															id.setBackground(new Color(0,0,60) );
															id.setForeground(Color.white);
															id.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															id.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				welcome.add(id);	
															idd=new JLabel("REGISTRATION NO.:");
															idd.setBounds(950,60,150,50);
															idd.setBackground(new Color(0,0,60) );
															idd.setForeground(Color.white);
															idd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															idd.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				welcome.add(idd);
															captcha=new JLabel();
															captcha.setBounds(840,640,200,30);
															captcha.setBackground(new Color(0,0,0) );
															captcha.setForeground(new Color(247, 202, 24));
															captcha.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
															//captcha.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				welcome.add(captcha);
										                    capt=new JTextField();
															capt.setBounds(1030,640,120,30);
															capt.setForeground(new Color(255, 255, 255));
															capt.setBackground(new Color(0,0,0));
															capt.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															capt.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
				welcome.add(capt);
															Random random=new Random();
															int length=7+(Math.abs(random.nextInt())%3);
															StringBuffer captchaStrBuffer = new StringBuffer();
															for(int i=0;i<length;i++){
															int baseCharacterNumber= Math.abs(random.nextInt())%62;
															int characterNumber=0;
															if(baseCharacterNumber<26){
																characterNumber=65+baseCharacterNumber;
															}
															else if(baseCharacterNumber<52){
															characterNumber=97+(baseCharacterNumber-52);
															}
															else{
															characterNumber=48+(baseCharacterNumber-52);
															}
															captchaStrBuffer.append((char)characterNumber);
															vall=String.valueOf(captchaStrBuffer);
															captcha.setText(vall);
															}
				
				login.setUndecorated(true);
				login.setSize(1366,768);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				login.setLayout(null);
										try{
											Class.forName("com.mysql.cj.jdbc.Driver");
											System.out.println("Connecting to database...");
											conn = DriverManager.getConnection(DB_URL,USER,PASS);
											}
										catch(SQLException e){
											System.out.println(e.getMessage());
											}
	}
	/*public void  createCaptchaValue(){
		Random random=new Random();
		int length=7+(Math.abs(random.nextInt())%3);
		StringBuffer captchaStrBuffer = new StringBuffer();
		for(int i=0;i<length;i++){
			int baseCharacterNumber= Math.abs(random.nextInt())%62;
			int characterNumber=0;
			if(baseCharacterNumber<26){
				characterNumber=65+baseCharacterNumber;
			}
			else if(baseCharacterNumber<52){
				characterNumber=97+(baseCharacterNumber-52);
			}
			else{
				characterNumber=48+(baseCharacterNumber-52);
			}
			captchaStrBuffer.append((char)characterNumber);
			String vall=String.valueOf(captchaStrBuffer);
			captcha.setText("Captcha :"+vall);
		}
		
		
	}*/
	public void randomnumbers(){
		Random ran= new Random();
		int n=ran.nextInt(100000)+1;
		String val=String.valueOf(n);
		id.setText("STREG"+val+"2018");
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==min){login.setState(JFrame.ICONIFIED);}
		if(e.getSource()==close){System.exit(0);}
	    randomnumbers();
		//createCaptchaValue();
		if(e.getSource() == add){
			String captt=capt.getText();
			String first=fname.getText();
			   String last=lname.getText();
			   String middle=mname.getText();
			   String pop=father.getText();
			   String mum=mother.getText();
			   String birth=dob.getText().toString();
			   String mobile=mb.getText();
			   String session=year.getSelectedItem().toString();
			   String mail=email.getText();
			   String user=username.getText();
			   String pas=password.getText();
			   String reg=id.getText();
			   String gend=gender.getSelectedItem().toString();
			   String branchh=branch.getSelectedItem().toString();
		try{
			if(vall.equals(captt)){
		System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  
			 
			   System.out.println(first+","+last+","+middle+","+pop+","+mum+","+birth+","+mobile+","+session+","+mail+","+user+","+pas+","+reg+","+gend+","+branchh);
    		   String sql;
    		 // sql = "INSERT INTO student( firstname, middlename, lastname, fathername, mothername, gender, branch, dob, mobileno, year, emailid, username, password, regno) VALUES('"+first+"','"+middle+"','"+last+"','"+pop+"','"+mum+"','"+gender+"','"+branchh+"',"+birth+",'"+mobile+"','"+session+"','"+mail+"','"+user+"','"+pas+"','"+reg+"')";
		 //stmt.executeUpdate(sql);
		sql= "INSERT INTO student( firstname, middlename, lastname, fathername, mothername, gender, branch, dob, mobileno, year, emailid, username, password, regno) VALUES('"+first+"','"+middle+"','"+last+"','"+pop+"','"+mum+"','"+gend+"','"+branchh+"',"+birth+","+mobile+",'"+session+"','"+mail+"','"+user+"','"+pas+"','"+reg+"')";
        stmt.executeUpdate(sql);
		JOptionPane.showMessageDialog(login,"your registration number is :"+reg+"\n NAME:"+first+middle+last+"\n  USERNAME : "+pop+"\n PASSWORD:"+mum);
		login.dispose();
		}
		else if(!vall.equals(captt)){id.setText("");JOptionPane.showMessageDialog(login,"please  enter valid captcha");}
		//else if(first.equals("")||last.equals("")||pop.equals("")||mum.equals("")||birth.equals("")||mobile.equals("")||session.equals("")||mail.equals("")||user.equals("")||branchh.equals("")||pas.equals("")||gend.equals("")){
			//JOptionPane.showMessageDialog(login,"Fields can't be empty");
		//}
		}catch(Exception ex){}}
		try{
			if(e.getSource()==reset){
				login.dispose();
				new Addash();
			}
}catch(Exception ex){}}
	public static void main(String[] args)throws Exception{
		new Sregister();
		
	}

}