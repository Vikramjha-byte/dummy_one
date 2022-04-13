import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
 class Landing_it  implements ActionListener{
	JFrame login;
	JLabel welcome,vip,profile,logtag,name,password,about;
	JTextField user;
	JPasswordField pass;
	JPanel title,container;
	JCheckBox agree;
	JButton btn,sign,forgot,min,close;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	 String usernamee,passwor,id,almuni;
	 int check;
	Landing_it() throws Exception{
				login= new JFrame("Login_page_BNBC_J2SE");
															ImageIcon Background= new ImageIcon("back.jpg");
															Image imag = Background.getImage();
															Image temp_imge = imag.getScaledInstance(600,768,Image.SCALE_SMOOTH);
															Background= new ImageIcon(temp_imge);
															welcome = new JLabel("",Background,JLabel.CENTER);
															welcome.setForeground(Color.white);
															welcome.setBounds(0,0,600,768);
				login.add(welcome);
															title= new JPanel();
															title.setBounds(1,1,600,50);
															title.setBackground(new Color(0,0,0,80));
															title.setForeground(Color.white);
															title.setLayout(null);
				welcome.add(title);
															container= new JPanel();
															container.setBounds(50,342,500,170);
															container.setBackground(new Color(0,0,0,80));
															container.setForeground(Color.white);
															container.setLayout(null);
				welcome.add(container);
															min= new JButton("-");
															min.setBounds(510,0,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
				title.add(min);											
															close= new JButton("x");
															close.setBounds(550,0,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
				title.add(close);
															vip= new JLabel("VIRTUAL INFORMATION PORTAL");
															vip.setBounds(10,5,535,30);
															vip.setForeground(new Color(248, 148, 6));
															vip.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
				title.add(vip);
															ImageIcon log= new ImageIcon("log.png");
															Image temp= log.getImage();
															Image tempimage=temp.getScaledInstance(263,192,Image.SCALE_SMOOTH);
															log=new ImageIcon(tempimage);
															profile= new JLabel("",log,JLabel.CENTER);
															profile.setBounds(100,150,263,192);
				welcome.add(profile);
															logtag= new JLabel("LOGIN HERE!");
															logtag.setBounds(300,250,180,70);
															logtag.setForeground(new Color(247, 202, 24));
															logtag.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
				welcome.add(logtag);
															name= new JLabel("ENTER USERNAME :");
															name.setBounds(20,20,180,30);
															name.setForeground(new Color(247, 202, 24));
															name.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				container.add(name);
															user= new JTextField();
															user.setBounds(200,20,250,30);
															user.setBackground(new Color(0,0,0) );
															user.setForeground(new Color(247, 202, 24));
															user.setCaretColor(new Color(247, 202, 24));
															user.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															user.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
				container.add(user);
															password= new JLabel("ENTER PASSWORD :");
															password.setBounds(20,70,180,30);
															password.setForeground(new Color(247, 202, 24));
															password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				container.add(password);
															pass= new JPasswordField();
															pass.setBounds(200,70,250,30);
															pass.setBackground(new Color(0,0,0) );
															pass.setCaretColor(new Color(247, 202, 24));
															pass.setForeground(new Color(247, 202, 24));
															pass.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															pass.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
				container.add(pass);
															agree= new JCheckBox("I AGREE ALL THE TERMS AND CONDITIONS");
															agree.setBounds(20,120,300,30);
															agree.setBackground(new Color(0,0,0));
															agree.setForeground(new Color(247, 202, 24));
															agree.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															agree.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
															agree.addItemListener(new ItemListener(){
															public void itemStateChanged(ItemEvent e){
															check=e.getStateChange();
															}});
				container.add(agree);
															btn= new JButton("LOGIN");
															btn.setBounds(370,120,70,30);
															btn.setBackground(new Color(0,0,60));
															btn.setForeground(new Color(247, 202, 24));
															btn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															btn.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															btn.addActionListener(this);
				container.add(btn);
															sign= new JButton("REGISTER ME");
															sign.setBounds(270,550,100,30);
															sign.setBackground(new Color(0,0,60));
															sign.setForeground(new Color(247, 202, 24));
															sign.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															sign.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															sign.addActionListener(this);
				welcome.add(sign);
															forgot= new JButton("FORGOT PASSWORD");
															forgot.setBounds(380,550,150,30);
															forgot.setBackground(new Color(0,0,60));
															forgot.setForeground(new Color(247, 202, 24));
															forgot.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															forgot.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															forgot.addActionListener(this);
				welcome.add(forgot);
															about= new JLabel("CREATED BY|VIKRAM KUMAR JHA|GAYATRI KUMARI|J@SE1.0.2018");
															about.setBounds(5,680,450,50);
															about.setForeground(new Color(247, 202, 24));
															about.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
				welcome.add(about);
				login.setUndecorated(true);
				login.setSize(600,768);
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				login.setLayout(null);
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if(e.getSource()==min){login.setState(JFrame.ICONIFIED);}
		if(e.getSource()==close){System.exit(0);}
		if(e.getSource()==forgot){
			try{login.dispose();
			new Forgotadp();}catch(Exception ee){ee.getMessage();}}
		if(e.getSource() == btn){
		try{
		System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
		String username = user.getText();
		String passwords = pass.getText();
    		  String sql;
    		  sql = "SELECT * FROM loginmember WHERE username='"+username +"' AND password='"+passwords+"'";
		ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
		id  = rs.getString("id");
		usernamee=rs.getString("username");
		passwor=rs.getString("password");
		almuni=rs.getString("almuni");
		
}
if(almuni.equals("student")){
if(username.equals("")&&passwords.equals("")&& check==0){
	JOptionPane.showMessageDialog(login,"username and password can't be blank ");
}
else if(check==0){
	JOptionPane.showMessageDialog(login,"please accept terms and conditions");
}
else if (username.equals(usernamee)&&passwords.equals(passwor)&&check==1) {
 JOptionPane.showMessageDialog(login,"hello!student your id is : "+id);
  }
  else{
	  JOptionPane.showMessageDialog(login,"invalid credentials");
  }
}
if(almuni.equals("admin")){
if(username.equals("")&&passwords.equals("")&& check==0){
	JOptionPane.showMessageDialog(login,"username and password can't be blank ");
}
else if(check==0){
	JOptionPane.showMessageDialog(login,"please accept terms and conditions");
}
else if (username.equals(usernamee)&&passwords.equals(passwor)&&check==1) {
 JOptionPane.showMessageDialog(login,"hello!admin your id is : "+id);
  }
  else{
	  JOptionPane.showMessageDialog(login,"invalid credentials");
  }
}
      
      

   }
   catch(SQLException se){
      se.printStackTrace();
   }
	}}
	
	public static void main(String[] args)throws Exception{
		new Landing_it();
	}
}