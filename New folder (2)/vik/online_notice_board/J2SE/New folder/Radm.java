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
public class Radm implements ActionListener{
	JFrame screen;
	JPanel title,d,d2,pi,ld,fd,dec,photo;
	JButton min,close,register,back,button,get;
	JLabel head,pinfo,logdet,famdet,decl,label,idd,declare;
	JLabel fnamee,fname,mname,lname,area,nation,username,password,email,smbno,father,foccup,faddress,fmbno,mother,moccup,maddress,mmbno,regno,gender,state,dobb,branh;
	JLabel first,middle,last,Area,Nation,Username,Email,Smbno,Father,Foccup,Faddress,Fmbno,Mother,Moccup,Mmbno,Maddress;
	JTextField id;
	JLabel Password,genderrr;
	JLabel combobox1,comboboxbranch,comboboxyear;
	JLabel chooser;
	//String states[] = new String[50];
	//String branch[] = new String[5];
	//String YEar[] = new String[5];
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	 java.sql.Date sqldate;
	// Date sm;
	 String f,l,m,pop,mum,sm,smobile,fmobile,mmobile,Foccupp,Moccupp,Maddresss,Faddresss,designation,almuni,session,mail,user,pas,reg,gend,branchh,statess,Areaa,Nationn,pic,regis;
	Radm() throws Exception{
															screen= new JFrame("ADD STUDENT");
															title=new JPanel();
															title.setBounds(0,0,1366,70);
															title.setForeground(new Color(247,202,24));
															title.setBackground(new Color(0,0,0,60));
															title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															title.setLayout(null);
												screen.add(title);
															d=new JPanel();
															d.setBounds(400,0,50,70);
															d.setForeground(new Color(247,202,24));
															d.setBackground(Color.white);
															d.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															d.setLayout(null);
															
												title.add(d);
															d2=new JPanel();
															d2.setBounds(1,71,50,695);
															d2.setForeground(new Color(247,202,24));
															d2.setBackground(new Color(1,50,67));
															d2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															d2.setLayout(null);
												screen.add(d2);
															pi=new JPanel();
															pi.setBounds(52,71,250,30);
															pi.setForeground(new Color(247,202,24));
															pi.setBackground(new Color(1,50,67));
															pi.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															pi.setLayout(null);
															pi.setVisible(false);
												screen.add(pi);
															ld=new JPanel();
															ld.setBounds(52,273,250,30);
															ld.setForeground(new Color(247,202,24));
															ld.setBackground(new Color(1,50,67));
															ld.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															ld.setLayout(null);
															ld.setVisible(false);
												screen.add(ld);
															fd=new JPanel();
															fd.setBounds(52,455,250,30);
															fd.setForeground(new Color(247,202,24));
															fd.setBackground(new Color(1,50,67));
															fd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fd.setLayout(null);
															fd.setVisible(false);
												screen.add(fd);
												dec=new JPanel();
															dec.setBounds(52,647,250,30);
															dec.setForeground(new Color(247,202,24));
															dec.setBackground(new Color(1,50,67));
															dec.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															dec.setLayout(null);
															dec.setVisible(false);
												screen.add(dec);
															min= new JButton("-");
															min.setBounds(1260,10,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
												title.add(min);											
															close= new JButton("x");
															close.setBounds(1310,10,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
												title.add(close);
															register= new JButton("DELETE");
															register.setBounds(1100,730,120,30);
															register.setForeground(Color.white);
															register.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															register.setBackground(new Color(0,0,0) );
															register.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															register.addActionListener(this);
															register.setVisible(false);
												screen.add(register);
															back= new JButton("BACK");
															back.setBounds(1230,730,120,30);
															back.setForeground(Color.white);
															back.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															back.setBackground(new Color(0,0,0) );
															back.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															back.addActionListener(this);
															back.setVisible(false);
												screen.add(back);
															head=new JLabel("VIRTUAL INFORMATION PORTAL");
															head.setBounds(2,10,1000,50);
															head.setForeground(new Color(0,0,0));
															head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
												title.add(head);
															pinfo=new JLabel("PERSONAL INFORMATION :");
															pinfo.setBounds(2,0,200,30);
															pinfo.setForeground(new Color(255,255,255));
															pinfo.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												pi.add(pinfo);
															logdet=new JLabel("LOGIN DETAILS :");
															logdet.setBounds(2,0,200,30);
															logdet.setForeground(new Color(255,255,255));
															logdet.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												ld.add(logdet);
															famdet=new JLabel("FAMILY DETAILS :");
															famdet.setBounds(2,0,200,30);
															famdet.setForeground(new Color(255,255,255));
															famdet.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												fd.add(famdet);
															decl=new JLabel("DECLARATION :");
															decl.setBounds(2,0,200,30);
															decl.setForeground(new Color(255,255,255));
															decl.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												dec.add(decl);
															fnamee=new JLabel("FIRST NAME :");
															fnamee.setBounds(170,105,180,30);
															fnamee.setForeground(new Color(0, 0, 0));
															fnamee.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fnamee.setVisible(false);
												screen.add(fnamee);
															mname=new JLabel("MIDDLE NAME :");
															mname.setBounds(147,139,180,30);
															mname.setForeground(new Color(0, 0, 0));
															mname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mname.setVisible(false);
												screen.add(mname);
															lname=new JLabel("LAST NAME :");
															lname.setBounds(174,173,180,30);
															lname.setForeground(new Color(0, 0, 0));
															lname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															lname.setVisible(false);
												screen.add(lname);
															gender=new JLabel("GENDER :");
															gender.setBounds(205,207,180,30);
															gender.setForeground(new Color(0, 0, 0));
															gender.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															gender.setVisible(false);
												screen.add(gender);
															state=new JLabel("STATE :");
															state.setBounds(225,241,180,30);
															state.setForeground(new Color(0, 0, 0));
															state.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															state.setVisible(false);
												screen.add(state);
												            dobb=new JLabel("DOB:");
															 dobb.setBounds(740,105,180,30);
															 dobb.setForeground(new Color(0, 0, 0));
															 dobb.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															 dobb.setVisible(false);
												screen.add( dobb);
															branh=new JLabel("BRANCH :");
															branh.setBounds(695,139,180,30);
															branh.setForeground(new Color(0, 0, 0));
															branh.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															branh.setVisible(false);
												screen.add(branh);
															fname=new JLabel("DESIGNATION :");
															fname.setBounds(640,173,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fname.setVisible(false);
												screen.add(fname);
															area=new JLabel("AREA :");
															area.setBounds(725,207,180,30);
															area.setForeground(new Color(0, 0, 0));
															area.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															area.setVisible(false);
												screen.add(area);
															nation=new JLabel("NATIONALITY :");
															nation.setBounds(640,241,180,30);
															nation.setForeground(new Color(0, 0, 0));
															nation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															nation.setVisible(false);
												screen.add(nation);
															username=new JLabel("USERNAME :");
															username.setBounds(178,307,180,30);
															username.setForeground(new Color(0, 0, 0));
															username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															username.setVisible(false);
												screen.add(username);
															password=new JLabel("PASSWORD :");
															password.setBounds(178,341,180,30);
															password.setForeground(new Color(0, 0, 0));
															password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															password.setVisible(false);
												screen.add(password);
															email=new JLabel("EMAIL ID :");
															email.setBounds(197,375,180,30);
															email.setForeground(new Color(0, 0, 0));
															email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															email.setVisible(false);
												screen.add(email);
															smbno=new JLabel("MOBILE NUMBER :");
															smbno.setBounds(117,409,200,30);
															smbno.setForeground(new Color(0, 0, 0));
															smbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															smbno.setVisible(false);
												screen.add(smbno);
															father=new JLabel("FATHER NAME :");
															father.setBounds(144,490,200,30);
															father.setForeground(new Color(0, 0, 0));
															father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															father.setVisible(false);
												screen.add(father);
															foccup=new JLabel("OCCUPATION :");
															foccup.setBounds(153,524,200,30);
															foccup.setForeground(new Color(0, 0, 0));
															foccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															foccup.setVisible(false);
												screen.add(foccup);
															faddress=new JLabel("ADDRESS :");
															faddress.setBounds(195,557,200,30);
															faddress.setForeground(new Color(0, 0, 0));
															faddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															faddress.setVisible(false);
												screen.add(faddress);
															fmbno=new JLabel("MOBILE NUMBER :");
															fmbno.setBounds(117,591,200,30);
															fmbno.setForeground(new Color(0, 0, 0));
															fmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fmbno.setVisible(false);
												screen.add(fmbno);
															mother=new JLabel("MOTHER NAME :");
															mother.setBounds(657,490,200,30);
															mother.setForeground(new Color(0, 0, 0));
															mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mother.setVisible(false);
												screen.add(mother);
															moccup=new JLabel("OCCUPATION :");
															moccup.setBounds(676,524,200,30);
															moccup.setForeground(new Color(0, 0, 0));
															moccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															moccup.setVisible(false);
												screen.add(moccup);
															maddress=new JLabel("ADDRESS :");
															maddress.setBounds(718,557,200,30);
															maddress.setForeground(new Color(0, 0, 0));
															maddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															maddress.setVisible(false);
												screen.add(maddress);
															mmbno=new JLabel("MOBILE NUMBER :");
															mmbno.setBounds(640,591,200,30);
															mmbno.setForeground(new Color(0, 0, 0));
															mmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															mmbno.setVisible(false);
												screen.add(mmbno);
															/*button = new JButton("Browse");
															button.setBounds(1125,261,100,30);
															button.setForeground(Color.white);
															button.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															button.setBackground(new Color(0,0,0) );
															button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															button.addActionListener(this);
												screen.add(button);
												            photo=new JPanel();
															photo.setBounds(1100,105,150,150);
															photo.setBackground(new Color(0,0,0,80));
															label = new JLabel();
															label.setBounds(1100,105,150,150);
		
		                                        screen.add(label);
											    screen.add(photo);*/
															first=new JLabel();
															first.setBounds(327,105,210,30);
															//first.setForeground(new Color(255, 255, 255));
															//first.setBackground(new Color(0,0,0));
															first.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//first.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															first.setVisible(false);
												screen.add(first);

															middle=new JLabel();
															middle.setBounds(327,139,210,30);
															//middle.setForeground(new Color(255, 255, 255));
															//middle.setBackground(new Color(0,0,0));
															middle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//middle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															middle.setVisible(false);
												screen.add(middle);
															last=new JLabel();
															last.setBounds(327,173,210,30);
															//last.setForeground(new Color(255, 255, 255));
															//last.setBackground(new Color(0,0,0));
															last.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//last.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															last.setVisible(false);
												screen.add(last);
															Area=new JLabel();
															Area.setBounds(830,207,210,30);
															//Area.setForeground(new Color(255, 255, 255));
															//Area.setBackground(new Color(0,0,0));
															Area.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Area.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Area.setVisible(false);
												screen.add(Area);
															Nation=new JLabel();
															Nation.setBounds(830,241,210,30);
															//Nation.setForeground(new Color(255, 255, 255));
															//Nation.setBackground(new Color(0,0,0));
															Nation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Nation.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Nation.setVisible(false);
												screen.add(Nation);
															Username=new JLabel();
															Username.setBounds(327,307,210,30);
															//Username.setForeground(new Color(255, 255, 255));
															//Username.setBackground(new Color(0,0,0));
															Username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Username.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Username.setVisible(false);
												screen.add(Username);
															Password=new JLabel();
															Password.setBounds(327,341,210,30);
															//Password.setForeground(new Color(255, 255, 255));
															//Password.setBackground(new Color(0,0,0));
															Password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Password.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Password.setVisible(false);
												screen.add(Password);
															Email=new JLabel();
															Email.setBounds(327,375,210,30);
															//Email.setForeground(new Color(255, 255, 255));
															//Email.setBackground(new Color(0,0,0));
															Email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Email.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Email.setVisible(false);
												screen.add(Email);
															Smbno=new JLabel();
															Smbno.setBounds(327,409,210,30);
															//Smbno.setForeground(new Color(255, 255, 255));
															//Smbno.setBackground(new Color(0,0,0));
															Smbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Smbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Smbno.setVisible(false);
												screen.add(Smbno);
															Father=new JLabel();
															Father.setBounds(327,490,210,30);
															//Father.setForeground(new Color(255, 255, 255));
															//Father.setBackground(new Color(0,0,0));
															Father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Father.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Father.setVisible(false);
												screen.add(Father);
															Foccup=new JLabel();
															Foccup.setBounds(327,527,210,30);
															//Foccup.setForeground(new Color(255, 255, 255));
															//Foccup.setBackground(new Color(0,0,0));
															Foccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Foccup.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Foccup.setVisible(false);
												screen.add(Foccup);
															Faddress=new JLabel();
															Faddress.setBounds(327,557,210,30);
															//Faddress.setForeground(new Color(255, 255, 255));
															//Faddress.setBackground(new Color(0,0,0));
															Faddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Faddress.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Faddress.setVisible(false);
												screen.add(Faddress);
															Fmbno=new JLabel();
															Fmbno.setBounds(327,591,210,30);
															//Fmbno.setForeground(new Color(255, 255, 255));
															//Fmbno.setBackground(new Color(0,0,0));
															Fmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Fmbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Fmbno.setVisible(false);
												screen.add(Fmbno);
															Mother=new JLabel();
															Mother.setBounds(830,490,210,30);
															//Mother.setForeground(new Color(255, 255, 255));
															//Mother.setBackground(new Color(0,0,0));
															Mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Mother.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Mother.setVisible(false);
												screen.add(Mother);
															Moccup=new JLabel();
															Moccup.setBounds(830,524,210,30);
															//Moccup.setForeground(new Color(255, 255, 255));
															//Moccup.setBackground(new Color(0,0,0));
															Moccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Moccup.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Moccup.setVisible(false);
												screen.add(Moccup);
															Maddress=new JLabel();
															Maddress.setBounds(830,557,210,30);
															//Maddress.setForeground(new Color(255, 255, 255));
															//Maddress.setBackground(new Color(0,0,0));
															Maddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Maddress.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Maddress.setVisible(false);
												screen.add(Maddress);
															Mmbno=new JLabel();
															Mmbno.setBounds(830,591,210,30);
															//Mmbno.setForeground(new Color(255, 255, 255));
															//Mmbno.setBackground(new Color(0,0,0));
															Mmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Mmbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															Mmbno.setVisible(false);
												screen.add(Mmbno);

												            //radiobutton2=new javax.swing.JRadioButton("MALE");
															genderrr=new JLabel();
															genderrr.setFont(new Font("Dialog", Font.BOLD, 16));
															genderrr.setBounds(325,207,100,30);
															genderrr.setVisible(false);
												screen.add(genderrr);

															/*radiobutton3=new javax.swing.JRadioButton("FEMALE");
															radiobutton3.setFont(new Font("Dialog", Font.BOLD, 16));
															radiobutton3.setBounds(435,207,100,30);
															radiobutton3.setVisible(false);
												screen.add(radiobutton3);

															ButtonGroup jb = new ButtonGroup();
															jb.add(radiobutton2);
															jb.add(radiobutton3);*/
															combobox1 = new JLabel();
combobox1.setBounds(330,241,200,30);
combobox1.setFont(new Font("Dialog",Font.BOLD,18));
combobox1.setVisible(false);
screen.add(combobox1);


															
														 chooser = new JLabel();
														//chooser.setLocale(Locale.US);
														chooser.setBounds(830,105,200,30);
														chooser.setVisible(false);

														//JPanel panel = new JPanel();
//panel.add(new JLabel("Date of Birth:"));
											screen.add(chooser);
														comboboxbranch = new JLabel();
														comboboxbranch.setBounds(830,139,200,30);
														comboboxbranch.setFont(new Font("Dialog",Font.BOLD,18));
														comboboxbranch.setVisible(false);
											screen.add(comboboxbranch);


														comboboxyear = new JLabel();
														comboboxyear.setBounds(830,173,200,30);
														comboboxyear.setFont(new Font("Dialog",Font.BOLD,18));
														comboboxyear.setVisible(false);
											screen.add(comboboxyear);


															idd=new JLabel("REGISTRATION NO.:");
															idd.setBounds(800,7,150,50);
															idd.setBackground(new Color(0,0,60) );
															idd.setForeground(Color.white);
															idd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															//idd.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				title.add(idd);
															id=new JTextField();
															id.setBounds(960,15,120,30);
															id.setBackground(new Color(255,255,255) );
															id.setForeground(Color.black);
															id.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															//id.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				title.add(id);	
															get = new JButton("GET");
															get.setBounds(1120,15,40,30);
															get.setForeground(Color.white);
															get.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															get.setBackground(new Color(0,0,0) );
															get.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															get.addActionListener(this);
												title.add(get);
															declare=new JLabel("By Clicking on Register, I agree that i have given all the correct details that is given by student.");
															declare.setBounds(170,680,1000,50);
															//declare.setBackground(new Color(0,0,60) );
															//declare.setForeground(Color.white);
															declare.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															declare.setVisible(false);
															//declare.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				screen.add(declare);	
		        //Random ran= new Random();
		//int n=ran.nextInt(100000)+1;
		//String val=String.valueOf(n);
		//id.setText("STREG"+val+"2018");
		
		       screen.setSize(1366,768);
			   screen.setUndecorated(true);
			   screen.setLayout(null);
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
	/*public void randomnumbers(){
		Random ran= new Random();
		int n=ran.nextInt(100000)+1;
		String val=String.valueOf(n);
		id.setText("STREG"+val+"2018");
	}*/
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==min){screen.setState(JFrame.ICONIFIED);}
		try{if(e.getSource()==close){screen.dispose();}}catch(Exception ex){ex.getMessage();}
		try{if(e.getSource()==back){screen.dispose();}}catch(Exception ex){ex.getMessage();}
		/*try{if(e.getSource()==button){JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
		  label.setIcon(ResizeImage(path));
		  photo.setVisible(false);}
		  else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }}catch(Exception ex){}*/
	  if(e.getSource()==get){
			
			    reg=id.getText();
			   
			   // File image = new File(label);
            //inputStream = new FileInputStream(image);
			//String pic=label.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
			//JTextField first,middle,last,Area,Nation,Username,Password,Email,Smbno,Father,Foccup,Faddress,Fmbno,Mother,Moccup,Mmbno,Maddress;
			try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="SELECT * FROM member WHERE regno='"+reg+"'";
			 ResultSet rs= stmt.executeQuery(sql);
			 while(rs.next()){
			 f=rs.getString("firstname");
			  l=rs.getString("lastname");
			  m=rs.getString("middlename");
			   pop=rs.getString("fathername");
			   mum=rs.getString("mothername");

			   //String birth=chooser.getString();

				sm= rs.getDate("dob").toString();

				//obj.setStartDate(sd);
			  smobile=rs.getString("mobileno");
			   fmobile=rs.getString("fmbno");
			    mmobile=rs.getString("mmbno");
			    Foccupp=rs.getString("foccupation");
			    Moccupp=rs.getString("moccupation");
			    Maddresss=rs.getString("maddress");
			   Faddresss=rs.getString("faddress");
			   designation=rs.getString("designation");
			    mail=rs.getString("emailid");
			   user=rs.getString("username");
			   pas=rs.getString("password");
			  gend=rs.getString("gender");
			   //String gend=gender.getSelectedItem().toString();
			    branchh=rs.getString("branch");
			    statess=rs.getString("state");
			    Areaa=rs.getString("area");
			    Nationn=rs.getString("nationality");
				regis=rs.getString("regno");
				almuni=rs.getString("almuni");

			 }
			try{if(regis.equals(reg)&& (!almuni.equals("admin"))){JOptionPane.showMessageDialog(screen,"INVALID CREDENTIAlS");}
			else if(reg.equals("")){JOptionPane.showMessageDialog(screen,"PLEASE ENTER REGISTRATION NUMBER");}
				else if(regis.equals(reg)&& almuni.equals("admin")){
				 												pi.setVisible(true);
												
															ld.setVisible(true);
												
															fd.setVisible(true);
												
															dec.setVisible(true);
												
															register.setVisible(true);
												

															back.setVisible(true);
												        fnamee.setVisible(true);
												
															mname.setVisible(true);
												
															lname.setVisible(true);
												
															fname.setVisible(true);
												
															gender.setVisible(true);
												
															state.setVisible(true);
	
					dobb.setVisible(true);
												
							branh.setVisible(true);
												
								area.setVisible(true);
												
															nation.setVisible(true);
	
						username.setVisible(true);
												
															password.setVisible(true);
												
				email.setVisible(true);
												
					smbno.setVisible(true);
												
															father.setVisible(true);
												
															foccup.setVisible(true);
												
															faddress.setVisible(true);
												
															fmbno.setVisible(true);
	
					mother.setVisible(true);
															moccup.setVisible(true);
												
															maddress.setVisible(true);
												
															mmbno.setVisible(true);
												
					first.setVisible(true);
												
															middle.setVisible(true);
												
			
										last.setVisible(true);
	
					Area.setVisible(true);
												screen.add(Area);
																		
															Nation.setVisible(true);
	
															Username.setVisible(true);
	
															Password.setVisible(true);
												
															Email.setVisible(true);
												
						Smbno.setVisible(true);
															Father.setVisible(true);
												
															Foccup.setVisible(true);
												
															Faddress.setVisible(true);
												
															Fmbno.setVisible(true);
												
					Mother.setVisible(true);
												
															Moccup.setVisible(true);
											
							Maddress.setVisible(true);
															Mmbno.setVisible(true);
												
															genderrr.setVisible(true);
	
															//radiobutton3.setVisible(true);
	
combobox1.setVisible(true);
								chooser.setVisible(true);

		
								comboboxbranch.setVisible(true);
											
							comboboxyear.setVisible(true);
	
															declare.setVisible(true);
			


			 first.setText(f);
			  last.setText(l);			   
			  middle.setText(m);			
			  Father.setText(pop);
			   Mother.setText(mum);
			   chooser.setText(sm);
			   Smbno.setText(smobile);
			   Fmbno.setText(fmobile);
			   Mmbno.setText(mmobile);
			   Foccup.setText(Foccupp);
			   Moccup.setText(Moccupp);
			   
                
			   Faddress.setText(Faddresss);
			  Maddress.setText(Maddresss);
			 comboboxyear.setText(designation);
			   Email.setText(mail);
			   Username.setText(user);
			  Password.setText(pas);

              comboboxbranch.setText(branchh);
			   combobox1.setText(statess);
			   Area.setText(Areaa);
			 Nation.setText(Nationn);
			 genderrr.setText(gend);
			 /*if("MALE".equals(gend)) 
			   {radiobutton2.setSelected(true);}
				else if("FEMALE".equals(gend))
				{radiobutton3.setSelected(true);}*/

			  System.out.println(f+l+m+pop+mum+ smobile+fmobile+mmobile+Foccupp+Moccupp+Maddresss+Faddresss+session+mail+user+pas+reg+gend+branchh+statess+Areaa+Nationn);
			}}catch(Exception ex){}
			 
			 }catch(SQLException ev){ev.printStackTrace();}}
			 if(e.getSource()==register){
				 try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="DELETE  FROM member WHERE regno='"+reg+"'";
			  stmt.executeUpdate(sql);
			  //System.out.println(f+l+m+pop+mum+sd+smobile+fmobile+mmobile+Foccupp+Moccupp+Maddresss+Faddresss+session+mail+user+pas+reg+gend+branchh+statess+Areaa+Nationn);
		        JOptionPane.showMessageDialog(screen,"ADMIN REMOVED SUCCESSFULLY");
				try{screen.dispose();new Addash();}catch(Exception ex){}
	}catch(SQLException ev){ev.printStackTrace();}}
			 
			
			 
		
	}
	 /*public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }*/
	public static void main(String[] args) throws Exception{
		new Radm();
	}
}