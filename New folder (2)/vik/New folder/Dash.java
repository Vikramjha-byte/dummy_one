import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Dash extends JApplet implements ActionListener {
	//JTextField jlab;
	JLabel welcome,log,background,help,bran,yearr,idd;
	JPanel dashtitle,buttonpane,content,vieww,sortt,deletee;
	JButton view,sort,delete,logout,search,del,con,can;
	JFrame dashboard,frame1;
	JTextField branch,year,delet;
	JLabel no,head,desc,cl,se,fac,dat,type,confirm;
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "";
   	Connection conn = null;
  	 Statement stmt = null;
	 static JTable table;
	 String[] columnNames = {"id", "title", "description", "branch","year","almuni","date","type"};
	Dash(){
		dashboard= new JFrame("Dashboardstudent-E_Notice-Vikram_Kumar_Jha");
		dashtitle= new JPanel();
		dashtitle.setLayout(null);
		dashtitle.setBounds(1,2,250,50);
		dashtitle.setBackground(Color.white);
		//tile= new JLabel();
		//tile.setForeground(Color.black);
		dashtitle.setBackground(new Color(253, 227, 167));
		//tile.setBounds(100,10,120,30);
		//dashtitle.add(tile);
		dashboard.add(dashtitle);
		buttonpane= new JPanel();
		buttonpane.setLayout(null);
		buttonpane.setBounds(1,54,250,700);
		buttonpane.setBackground(new Color(244, 179, 80));
		dashboard.add(buttonpane);
		content= new JPanel();
		content.setLayout(null);
		content.setBounds(257,2,1100,700);
		content.setBackground(new Color(0,0,0,60));
		dashboard.add(content);
		vieww= new JPanel();
		vieww.setLayout(null);
		vieww.setBounds(257,2,1100,700);
		vieww.setBackground(new Color(0,0,60));
		    
			
		sortt= new JPanel();
		sortt.setLayout(null);
		sortt.setBounds(257,2,1100,700);
		sortt.setBackground(new Color(0,0,60));
		deletee= new JPanel();
		deletee.setLayout(null);
		deletee.setBounds(257,2,1100,700);
		deletee.setBackground(new Color(0,0,80));
		ImageIcon das= new ImageIcon("studen.jpg");
		Image ima = das.getImage();
		Image temp_image = ima.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		das= new ImageIcon(temp_image);
		 log = new JLabel("",das,JLabel.CENTER);
		log.setBounds(25,40,200,200);
		buttonpane.add(log);
		view= new JButton("VIEW NOTICES");
		view.setBounds(5,280,240,50);
		view.addActionListener(this);
		buttonpane.add(view);
		sort= new JButton("SORT NOTICES");
		sort.setBounds(5,340,240,50);
		sort.addActionListener(this);
		buttonpane.add(sort);
		delete= new JButton("DELETE NOTICES");
		delete.setBounds(5,400,240,50);
		delete.addActionListener(this);
		buttonpane.add(delete);
		logout= new JButton("LOGOUT");
		logout.setBounds(5,460,240,50);
		logout.addActionListener(this);
		buttonpane.add(logout);
		//jlab=new JTextField();
		//jlab.setBounds(200,400,520,70);
		JMenuBar jmb=new JMenuBar();
		JMenu jmfile= new JMenu("FILE");
		JMenuItem jminotice = new JMenuItem("NOTICES",KeyEvent.VK_N);
		jminotice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiresult = new JMenuItem("RESULTS",KeyEvent.VK_R);
		jmiresult.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiexit = new JMenuItem("EXIT",KeyEvent.VK_E);
		jmiexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));
		jmfile.add(jminotice);
		jmfile.add(jmiresult);
		jmfile.addSeparator();
		jmfile.add(jmiexit);
		JMenu jmoption= new JMenu("OPTION");
		JMenuItem jmiprofile = new JMenuItem("SHOW PROFILES",KeyEvent.VK_G);
		jmiprofile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmidresult = new JMenuItem("PRINT RESULTS",KeyEvent.VK_P);
		jmidresult.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiupdatepro = new JMenuItem("UPDATE PROFILES",KeyEvent.VK_U);
		jmiupdatepro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmideletenotice = new JMenuItem("DELETE NOTICE",KeyEvent.VK_D);
		jmideletenotice.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmireset = new JMenuItem("RESET PASSWORD",KeyEvent.VK_T);
		jmireset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_DOWN_MASK));
		jmoption.add(jmiprofile);
		jmoption.add(jmidresult);
		jmoption.add(jmiupdatepro);
		jmoption.add(jmideletenotice);
		jmoption.add(jmireset);
		JMenu jmhelp= new JMenu("HELP");
		JMenuItem jmiabout = new JMenuItem("ABOUT ME",KeyEvent.VK_A);
		jmiabout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_DOWN_MASK));
		jmhelp.add(jmiabout);
		jmb.add(jmfile);
		jmb.add(jmoption);
		jmb.add(jmhelp);
		jminotice.addActionListener(this);
		jmiresult.addActionListener(this);
		jmiexit.addActionListener(this);
		jmiprofile.addActionListener(this);
		jmidresult.addActionListener(this);
		jmiupdatepro.addActionListener(this);
		jmideletenotice.addActionListener(this);
		jmireset.addActionListener(this);
		jmiabout.addActionListener(this);
		ImageIcon background_image= new ImageIcon("back.jpg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1366,768,Image.SCALE_SMOOTH);
		background_image= new ImageIcon(temp_img);
		background = new JLabel("",background_image,JLabel.CENTER);
		background.setBounds(0,0,1366,768);
		//dashboard.add(jlab);
		
		ImageIcon complement= new ImageIcon("login.png");
		Image imag = complement.getImage();
		Image temp_imge = imag.getScaledInstance(50,50,Image.SCALE_SMOOTH);
		complement= new ImageIcon(temp_imge);
		 welcome = new JLabel("RAJESH KUMAR",complement,JLabel.CENTER);
		 welcome.setForeground(Color.white);
		welcome.setBounds(1050,10,400,50);
		dashboard.add(welcome);
		dashboard.add(background);
		help=new JLabel("ENTER DETAILS TO SEARCH NOTICES");
		help.setBounds(200,150,600,40);
		help.setForeground(new Color(248, 148, 6));
		help.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,25));
		vieww.add(help);
		bran=new JLabel("ENTER BRANCH :");
		bran.setBounds(260,230,200,40);
		bran.setForeground(new Color(248, 148, 6));
		bran.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		vieww.add(bran);
		yearr=new JLabel("ENTER YEAR :");
		yearr.setBounds(260,330,200,40);
		yearr.setForeground(new Color(248, 148, 6));
		yearr.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		vieww.add(yearr);
		branch= new JTextField();
		branch.setBounds(400,280,250,30);
		branch.setBackground(new Color(0,0,0) );
		branch.setForeground(new Color(247, 202, 24));
		branch.setCaretColor(new Color(247, 202, 24));
		branch.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
		branch.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
		vieww.add(branch);
		year= new JTextField();
		year.setBounds(400,380,250,30);
		year.setBackground(new Color(0,0,0) );
		year.setForeground(new Color(247, 202, 24));
		year.setCaretColor(new Color(247, 202, 24));
		year.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
		year.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
		vieww.add(year);
		search= new JButton("SEARCH");
		search.setBounds(600,450,100,30);
		search.setBackground(new Color(0,0,60));
		search.setForeground(new Color(247, 202, 24));
		search.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		search.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
		search.addActionListener(this);
		vieww.add(search);
		idd=new JLabel("ENTER ID TO DELETE:");
		idd.setBounds(260,130,200,40);
		idd.setForeground(new Color(248, 148, 6));
		idd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(idd);
		delet= new JTextField();
		delet.setBounds(470,130,250,30);
		delet.setBackground(new Color(0,0,0) );
		delet.setForeground(new Color(247, 202, 24));
		delet.setCaretColor(new Color(247, 202, 24));
		delet.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
		delet.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(247, 202, 24)));
		deletee.add(delet);
		del= new JButton("DELETE");
		del.setBounds(740,130,100,30);
		del.setBackground(new Color(0,0,60));
		del.setForeground(new Color(247, 202, 24));
		del.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		del.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
		del.addActionListener(this);
		deletee.add(del);
		
		dashboard.setJMenuBar(jmb);
		dashboard.setLayout(null);
		dashboard.setSize(1366,768);
		dashboard.setVisible(true);
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public void actionPerformed(ActionEvent e){
		try{
		if(e.getSource()==view){
			background.removeAll();
		background.add(vieww);
		background.revalidate();
background.repaint();
//showTableData(); 
 
		}
	if(e.getSource()==search)
	{
		showTableData();
	}
		if(e.getSource()==sort){
			background.removeAll();
		background.add(sortt);
		background.revalidate();
background.repaint();}

			if(e.getSource()==delete){
			background.removeAll();
		background.add(deletee);
		background.revalidate();
	background.repaint();}
	if(e.getSource()==del){showLabelData();}
	}
	catch(Exception se){}}

public void showTableData()
{

frame1 = new JFrame("Notices Search Result");

frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String textval = branch.getText();
String yearval = year.getText();
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
String sql = "select * from notice WHERE branch='"+textval+"'AND year='"+yearval+"'";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
if(rs.next())
{
int id = rs.getInt("id");
title = rs.getString("title");
description= rs.getString("description");
branch = rs.getString("branch"); 
year=rs.getString("year");
almuni= rs.getString("almuni");
date=rs.getString("date");
type=rs.getString("type");
model.addRow(new Object[]{id,title,description,branch,year,almuni,date,type});
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
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(400,300);
}
public void showLabelData()
{
no=new JLabel();
		no.setBounds(260,170,700,40);
		no.setForeground(new Color(248, 148, 6));
		no.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(no);
		head=new JLabel();
		head.setBounds(260,220,700,40);
		head.setForeground(new Color(248, 148, 6));
		head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(head);
		desc=new JLabel();
		desc.setBounds(260,270,700,40);
		desc.setForeground(new Color(248, 148, 6));
		desc.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(desc);
		cl=new JLabel();
		cl.setBounds(260,320,700,40);
		cl.setForeground(new Color(248, 148, 6));
		cl.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(cl);
		se=new JLabel();
		se.setBounds(260,370,700,40);
		se.setForeground(new Color(248, 148, 6));
		se.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(se);
		fac=new JLabel();
		fac.setBounds(260,420,700,40);
		fac.setForeground(new Color(248, 148, 6));
		fac.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(fac);
		dat=new JLabel();
		dat.setBounds(260,470,700,40);
		dat.setForeground(new Color(248, 148, 6));
		dat.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(dat);
		type=new JLabel();
		type.setBounds(260,510,700,40);
		type.setForeground(new Color(248, 148, 6));
		type.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(type);
		con= new JButton();
		con.setBounds(740,560,100,30);
		con.setBackground(new Color(0,0,60));
		con.setForeground(new Color(247, 202, 24));
		con.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		con.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
		con.addActionListener(this);
	    deletee.add(con);
		can= new JButton();
		can.setBounds(630,560,100,30);
		can.setBackground(new Color(0,0,60));
		can.setForeground(new Color(247, 202, 24));
		can.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		can.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(247, 202, 24)));
		can.addActionListener(this);
	    deletee.add(can);
		confirm=new JLabel();
		confirm.setBounds(260,560,300,40);
		confirm.setForeground(new Color(248, 148, 6));
		confirm.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,15));
		deletee.add(confirm);
String textval = delet.getText();
String title= "";
String description= "";
String branch= "";
String almuni = "";
String date = "";
String type= "";
String year="";
String id="";
try
{ 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
String sql = "select * from notice WHERE id='"+textval+"'";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
if(rs.next())
{
 id = rs.getString("id");
title = rs.getString("title");
description= rs.getString("description");
branch = rs.getString("branch"); 
year=rs.getString("year");
almuni= rs.getString("almuni");
date=rs.getString("date");
type=rs.getString("type");
}
if(id.equals(textval)){
	no.setText("ID :"+id);
	head.setText("TITLE :"+title);
	desc.setText("DESCRIPTION :"+description);
	cl.setText("BRANCH :"+branch);
	se.setText("YEAR :"+year);
	fac.setText("ALMUNI :"+almuni);
	dat.setText("DATE :"+date);
	confirm.setText("ARE YOU SURE TO DELETE :");
	//type.setText("TYPE :"+type);

}
if(!id.equals(textval)){
	JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(textval.equals("")){
	JOptionPane.showMessageDialog(null, "ENTER ID TO DELETE","Error",
JOptionPane.ERROR_MESSAGE);
}

}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}

}
	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Dash();
			}
		});
	}
}