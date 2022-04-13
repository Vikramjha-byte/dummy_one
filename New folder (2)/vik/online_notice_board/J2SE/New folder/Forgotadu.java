import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.sql.*;
public class Forgotadu  implements ActionListener{
	JFrame login;
	JLabel welcome,vip,logtag,profile,emaill,newpass,repass,about,help,error;
	JButton min,close,res,cancel;
	JPanel title,reset,contain;
	JTextField email,newpas,repas;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	 String check,address;
	public Forgotadu() throws Exception{
				login= new JFrame("FORGOT_PASSWORD_BNBC_J2SE");
															ImageIcon Background= new ImageIcon("back.jpg");
															Image imag = Background.getImage();
															Image temp_imge = imag.getScaledInstance(400,400,Image.SCALE_SMOOTH);
															Background= new ImageIcon(temp_imge);
															welcome = new JLabel("",Background,JLabel.CENTER);
															welcome.setForeground(Color.white);
															welcome.setBounds(0,0,400,400);
				login.add(welcome);
															title= new JPanel();
															title.setBounds(1,1,400,50);
															title.setBackground(new Color(0,0,0,80));
															title.setForeground(Color.white);
															title.setLayout(null);
				welcome.add(title);
															reset= new JPanel();
															reset.setBounds(10,180,370,150);
															reset.setBackground(new Color(0,0,0,80));
															reset.setForeground(Color.white);
															reset.setLayout(null);
				//welcome.add(reset);
															contain= new JPanel();
															contain.setBounds(10,180,370,150);
															contain.setBackground(new Color(0,0,0,80));
															contain.setForeground(Color.white);
															contain.setLayout(null);
				welcome.add(contain);
															min= new JButton("-");
															min.setBounds(320,0,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
				title.add(min);											
															close= new JButton("x");
															close.setBounds(360,0,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
				title.add(close);
															res= new JButton("RESET");
															res.setBounds(250,120,70,30);
															res.setBackground(new Color(0,0,60));
															res.setForeground(new Color(247, 202, 24));
															res.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															res.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															res.addActionListener(this);
				reset.add(res);
															cancel= new JButton("CANCEL");
															cancel.setBounds(170,120,70,30);
															cancel.setBackground(new Color(0,0,60));
															cancel.setForeground(new Color(247, 202, 24));
															cancel.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
															cancel.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															cancel.addActionListener(this);
				reset.add(cancel);
															vip= new JLabel("VIRTUAL INFORMATION PORTAL");
															vip.setBounds(10,5,335,30);
															vip.setForeground(new Color(248, 148, 6));
															vip.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,16));
				title.add(vip);
															ImageIcon log= new ImageIcon("log.png");
															Image temp= log.getImage();
															Image tempimage=temp.getScaledInstance(70,70,Image.SCALE_SMOOTH);
															log=new ImageIcon(tempimage);
															profile= new JLabel("",log,JLabel.CENTER);
															profile.setBounds(10,52,70,70);
				welcome.add(profile);
															logtag= new JLabel("RESET PASSWORD!");
															logtag.setBounds(80,62,150,70);
															logtag.setForeground(new Color(247, 202, 24));
															logtag.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
				welcome.add(logtag);
															email= new JTextField();
															email.setBounds(170,142,220,30);
															email.setForeground(new Color(247, 202, 24));
															email.setBackground(new Color(0,0,0));
															email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															email.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															email.addActionListener(this);
				welcome.add(email);
															emaill= new JLabel("ENTER EMAIL ID :");
															emaill.setBounds(10,142,180,30);
															emaill.setForeground(new Color(247, 202, 24));
															emaill.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
				welcome.add(emaill);
															newpas= new JTextField();
															newpas.setBounds(200,10,190,30);
															newpas.setForeground(new Color(247, 202, 24));
															newpas.setBackground(new Color(0,0,0));
															newpas.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															newpas.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															newpas.addActionListener(this);
				reset.add(newpas);
															repas= new JTextField();
															repas.setBounds(200,60,190,30);
															repas.setForeground(new Color(247, 202, 24));
															repas.setBackground(new Color(0,0,0));
															repas.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															repas.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
															repas.addActionListener(this);
				reset.add(repas);
														    newpass= new JLabel("NEW PASSWORD :");
															newpass.setBounds(10,10,180,30);
															newpass.setForeground(new Color(247, 202, 24));
															newpass.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
				reset.add(newpass);
														    repass= new JLabel("RETYPE PASSWORD:");
															repass.setBounds(10,60,180,30);
															repass.setForeground(new Color(247, 202, 24));
															repass.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
				reset.add(repass);
															about= new JLabel("CREATED BY|VIKRAM KUMAR JHA|GAYATRI KUMARI|J@SE1.0.2018");
															about.setBounds(5,350,400,50);
															about.setForeground(new Color(247, 202, 24));
															about.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
				welcome.add(about);
															help= new JLabel("PRESS ENTER AFTER GIVING EMAIL ADDRESS");
															help.setBounds(10,60,400,50);
															help.setForeground(new Color(247, 202, 24));
															help.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
				contain.add(help);
															error= new JLabel();
															error.setBounds(10,80,400,50);
															error.setForeground(new Color(247, 202, 24));
															error.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,10));
				contain.add(error);
				
				login.setUndecorated(true);
				login.setSize(400,400);
				login.setVisible(true);
				login.setLayout(null);
				login.setLocationRelativeTo(null);
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
		try{
			
	//if(address.equals(check) ){
		System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
		      address=email.getText();
    		  String sql;
    		  sql = "SELECT * FROM loginmember WHERE email='"+address+"'";
			  ResultSet rs = stmt.executeQuery(sql);
			  
while(rs.next()){
	  check = rs.getString("email");
}
if(address.equals(check) ){
		welcome.remove(contain);
welcome.add(reset);
welcome.revalidate();
welcome.repaint();
}
      stmt.close();
	
if(e.getSource() == res){
		System.out.println("updating statement...");
    		  stmt = conn.createStatement();
			  String pasword=newpas.getText();
			  String repasword=repas.getText();
			  String address=email.getText();
		if(pasword.equals(repasword)){
    		  String sqll;
    		  sqll = "UPDATE member SET password='"+pasword+"' WHERE  email='"+address+"'";
			  stmt.executeUpdate(sqll);
			  login.dispose();
		}
        if(!pasword.equals(repasword)){
    		  JOptionPane.showMessageDialog(login,"Password doesn't matched");
		}
		
      stmt.close();
	}

   }
   catch(SQLException se){
      se.printStackTrace();
   }
   try{
   if(e.getSource() == cancel){
login.dispose();
Login bo = new Login();
    //bo.setVisible(true);
   }}
   catch(Exception er){}
}
   
	public static void main(String[] args)throws Exception{
		new Forgotadu();
	}
}