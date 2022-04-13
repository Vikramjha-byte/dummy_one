import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Landing implements ActionListener {
	JTextField username,password;
	JTextField 
	JLabel welcome,log;
	JPanel dashtitle,buttonpane,content;
	JButton login,forgotpassword,forgotusername,logout;
	Landing(){
		JFrame dashboard= new JFrame("Dashboardstudent-E_Notice-Vikram_Kumar_Jha");
		dashtitle= new JPanel();
		dashtitle.setLayout(null);
		dashtitle.setBounds(1,2,250,50);
		dashtitle.setBackground(Color.white);
		JLabel tile= new JLabel("E_NOTICE");
		tile.setForeground(Color.black);
		tile.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
		dashtitle.setBackground(new Color(253, 227, 167));
		tile.setBounds(80,10,120,30);
		dashtitle.add(tile);
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
		ImageIcon das= new ImageIcon("studen.jpg");
		Image ima = das.getImage();
		Image temp_image = ima.getScaledInstance(200,200,Image.SCALE_SMOOTH);
		das= new ImageIcon(temp_image);
		 log = new JLabel("",das,JLabel.CENTER);
		log.setBounds(25,40,200,200);
		buttonpane.add(log);
		username= new JTextField("ENTER USERNAME");
		username.setBounds(5,280,240,50);
		username.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,  Color.blue));
		username.setBackground(new Color(255, 255, 255));
		 username.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                username.setText("");
            }
        });
		username.setForeground(Color.black);
		buttonpane.add(username);
		password= new JPasswordField("*********");
		password.setBounds(5,340,240,50);
		password.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,  Color.blue));
		 password.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                password.setText("");
            }
        });
		password.setBackground(new Color(255,255, 255));
		password.setForeground(Color.black);
		buttonpane.add(password);
		login=new JButton("LOGIN");
		login.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,  Color.blue));
		login.setBounds(5,420,70,50);
		login.setBackground(new Color(255,255,255));
		login.setForeground(Color.black);
		buttonpane.add(login);
		forgotpassword= new JButton("FORGOT PASSWORD");
		forgotpassword.setBounds(80,420,160,50);
		forgotpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,  Color.blue));
		forgotpassword.setBackground(new Color(255,255,255));
		forgotpassword.setForeground(Color.black);
		buttonpane.add(forgotpassword);
		forgotusername= new JButton("FORGOT USERNAME");
		forgotusername.setBounds(30,480,160,50);
		forgotusername.setBackground(new Color(255,255,255));
		forgotusername.setForeground(Color.black);
		forgotusername.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0,  Color.blue));
		buttonpane.add(forgotusername);
		//jlab=new JTextField();
		//jlab.setBounds(200,400,520,70);
		ImageIcon background_image= new ImageIcon("back.jpg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(1366,768,Image.SCALE_SMOOTH);
		background_image= new ImageIcon(temp_img);
		JLabel background = new JLabel("",background_image,JLabel.CENTER);
		background.setBounds(0,0,1366,768);
		//dashboard.add(jlab);
		dashboard.add(background);
		dashboard.setLayout(null);
		dashboard.setSize(1366,768);
		dashboard.setVisible(true);
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		//String comstr = e.getActionCommand();
		//if(comstr.equals("EXIT"))
		//{
		//	System.exit(0);
		//}
		//jlab.setText(comstr+ " SELECTED");
	}
	public static void main (String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Landing();
			}
		});
	}
}