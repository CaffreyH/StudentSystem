package MainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.soap.Text;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;

public class MainFrame extends JFrame implements ActionListener{
	public final static String ip="jdbc:mysql://115.159.185.157:3306/superinfo";
	public final static String ip_L="jdbc:mysql://localhost:3306/info";
    public final static String Database_name = "hydb";
    public final static String Data_password = "123456";
    static String a;
    private ImageIcon image_bac;
    private ImageIcon image_user;
    private ImageIcon image_password;
    private ImageIcon image_line;
    private JLabel lab_line1;
    private JLabel lab_line2;
    private JLabel lab_line3;
	private JPanel contentPane_slog;
	private JLabel lab_imagelog;
	private JLabel lab_slog;
	private JLabel lab_slog1;
	private JLabel lab_slog2;
	JLabel lab_suser;
	private JLabel lab_skey;
	private JLabel lab_skey2;
	private JTextField txt_suser;
	private JTextField txt_skey;
	private JTextField txt_skey2;
	private JButton btn_slog;
	private JButton btn_tlog;
	private JButton btn_sreg;
	private JButton btn_treg;
	private JButton btn_sreset;   
	private JButton btn_sreset2;  
	private JButton btn_scancel;  
	private JButton btn_tcancel; 
	public String id;
	public String id1;
	ButtonGroup bg;
	JRadioButton jrb1;
	JRadioButton jrb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("学生信息管理系统");
		this.setSize(600,400);
		this.setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		image_bac = new ImageIcon(getClass().getResource("/images/logbac.jpg"));
		contentPane_slog = new JPanel();
		contentPane_slog.setBackground(Color.LIGHT_GRAY);
		contentPane_slog.setLayout(null);
		setContentPane(contentPane_slog);
		

		
		lab_imagelog = new JLabel("");
		lab_imagelog.setLocation(0,-15);
		lab_imagelog.setSize(600,400);
		lab_imagelog.setIcon(image_bac);
		contentPane_slog.add(lab_imagelog);
	
	
		
		bg = new ButtonGroup();
		jrb1 = new JRadioButton("学生");
		jrb2 = new JRadioButton("教师");
		jrb1.setSelected(true);
		bg.add(jrb1);
		bg.add(jrb2);
		lab_imagelog.add(jrb1);
		lab_imagelog.add(jrb2);
		jrb1.setBounds(250, 50, 55, 20);
		jrb1.setText("学生");
		jrb1.setFont(new Font("宋体", Font.PLAIN, 15));
		jrb1.setOpaque(false);
		jrb1.setForeground(Color.WHITE);
		jrb2.setBounds(320, 50, 55, 20);
		jrb2.setText("教师");
		jrb2.setFont(new Font("宋体", Font.PLAIN, 15));
		jrb2.setOpaque(false);
		jrb2.setForeground(Color.WHITE);

		
		image_line = new ImageIcon(getClass().getResource("/images/line.png"));
		lab_line1 = new JLabel("");
		lab_line1.setLocation(250,140);
		lab_line1.setSize(200,1);
		lab_line1.setIcon(image_line);
		lab_imagelog.add(lab_line1);
		lab_line2 = new JLabel("");
		lab_line2.setLocation(250,240);
		lab_line2.setSize(200,1);
		lab_line2.setIcon(image_line);
		lab_imagelog.add(lab_line2);

		
		lab_slog=new JLabel("帐号类型：");
		lab_slog.setBounds(100,40,200,40);
		lab_slog.setForeground(Color.WHITE);
		lab_slog.setFont(new Font("宋体", Font.PLAIN, 13));
		lab_imagelog.add(lab_slog);
		
		
		
		lab_slog1=new JLabel("没有帐号？点击注册");
		lab_slog1.setBounds(250,240,300,40);
		lab_slog1.setForeground(Color.WHITE);
		lab_slog1.setFont(new Font("宋体", Font.PLAIN, 12));
		lab_imagelog.add(lab_slog1);
		lab_slog1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				lab_imagelog.remove(jrb1);
				lab_imagelog.remove(lab_slog);
				lab_imagelog.remove(jrb2);
				lab_imagelog.remove(lab_skey);
				lab_imagelog.remove(lab_line2);
				lab_imagelog.remove(txt_skey);
				lab_imagelog.remove(btn_slog);
				lab_imagelog.remove(lab_slog1);
				lab_imagelog.remove(btn_sreset);
				lab_line2.setLocation(250,210);
				lab_line2.setSize(200,1);
				lab_line2.setIcon(image_line);
				lab_imagelog.add(lab_line2);
				lab_line3 = new JLabel("");
				lab_line3.setLocation(250,280);
				lab_line3.setSize(200,1);
				lab_line3.setIcon(image_line);
				lab_imagelog.add(lab_line3);
				
				lab_imagelog.add(lab_skey);
				lab_skey.setIcon(image_password);
				lab_skey.setBounds(186,170,70,40);
				lab_imagelog.add(lab_skey);
				lab_skey2=new JLabel("",JLabel.CENTER);
				lab_imagelog.add(lab_skey2);
				lab_skey2.setIcon(image_password);
				lab_skey2.setBounds(186,240,70,40);
				
				
				txt_skey.setText("password");
				txt_skey.setOpaque(false);
				txt_skey.setBorder(null);
				txt_skey.setForeground(Color.WHITE);
				txt_skey.setFont(new Font("宋体", Font.PLAIN, 25));
				txt_skey.setBounds(266,170,200,40);
				lab_imagelog.add(txt_skey);
				
				txt_skey2=new JTextField(20);
				txt_skey2.setText("repeat");
				txt_skey2.setOpaque(false);
				txt_skey2.setBorder(null);
				txt_skey2.setForeground(Color.WHITE);
				txt_skey2.setFont(new Font("宋体", Font.PLAIN, 25));
				txt_skey2.setBounds(266,240,200,40);
				
				lab_imagelog.add(lab_skey2);
				lab_imagelog.add(lab_line3);
				lab_imagelog.add(txt_skey2);
				lab_imagelog.add(btn_sreg);
				lab_imagelog.add(btn_sreset2);
				lab_imagelog.add(btn_scancel);
				repaint();
			}
		});
		
		
		
		lab_slog2=new JLabel("没有帐号？点击注册");
		lab_slog2.setBounds(250,240,300,40);
		lab_slog2.setForeground(Color.WHITE);
		lab_slog2.setFont(new Font("宋体", Font.PLAIN, 12));
		//lab_imagelog.add(lab_slog2);
		lab_slog2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				lab_imagelog.remove(jrb1);
				lab_imagelog.remove(jrb2);
				lab_imagelog.remove(lab_skey);
				lab_imagelog.remove(btn_sreset);
				lab_imagelog.remove(lab_line2);
				lab_imagelog.remove(txt_skey);
				lab_imagelog.remove(lab_slog2);
				lab_imagelog.remove(lab_slog);
				lab_imagelog.remove(btn_tlog);
				lab_line2.setLocation(250,210);
				lab_line2.setSize(200,1);
				lab_line2.setIcon(image_line);
				lab_imagelog.add(lab_line2);
				lab_line3 = new JLabel("");
				lab_line3.setLocation(250,280);
				lab_line3.setSize(200,1);
				lab_line3.setIcon(image_line);
				lab_imagelog.add(lab_line3);
				
				lab_imagelog.add(lab_skey);
				lab_skey.setIcon(image_password);
				lab_skey.setBounds(186,170,70,40);
				lab_imagelog.add(lab_skey);
				lab_skey2=new JLabel("",JLabel.CENTER);
				lab_imagelog.add(lab_skey2);
				lab_skey2.setIcon(image_password);
				lab_skey2.setBounds(186,240,70,40);
				
				
				txt_skey.setText("password");
				txt_skey.setOpaque(false);
				txt_skey.setBorder(null);
				txt_skey.setForeground(Color.WHITE);
				txt_skey.setFont(new Font("宋体", Font.PLAIN, 25));
				txt_skey.setBounds(266,170,200,40);
				lab_imagelog.add(txt_skey);
				
				txt_skey2=new JTextField(20);
				txt_skey2.setText("repeat");
				txt_skey2.setOpaque(false);
				txt_skey2.setBorder(null);
				txt_skey2.setForeground(Color.WHITE);
				txt_skey2.setFont(new Font("宋体", Font.PLAIN, 25));
				txt_skey2.setBounds(266,240,200,40);
				
				lab_imagelog.add(lab_skey2);
				lab_imagelog.add(lab_line3);
				lab_imagelog.add(txt_skey2);
				lab_imagelog.add(btn_sreset2);
				lab_imagelog.add(btn_treg);
				lab_imagelog.add(btn_tcancel);
				repaint();
			}
		});
		
		image_user = new ImageIcon(getClass().getResource("/images/user.png"));
		
		image_password = new ImageIcon(getClass().getResource("/images/password.png"));
		
		
		btn_sreset = new JButton("重置");  
		btn_sreset.addActionListener(this);
		btn_sreset.setBounds(220,300,90,40);
		btn_sreset.setContentAreaFilled(false);
		btn_sreset.setForeground(Color.WHITE);
		btn_sreset.setFont(new Font("宋体", Font.BOLD, 20));
		lab_imagelog.add(btn_sreset);
		
		btn_sreset2 = new JButton("重置");  
		btn_sreset2.addActionListener(this);
		btn_sreset2.setBounds(220,300,90,40);
		btn_sreset2.setContentAreaFilled(false);
		btn_sreset2.setForeground(Color.WHITE);
		btn_sreset2.setFont(new Font("宋体", Font.BOLD, 20));
		
		btn_slog=new JButton("登陆");
		btn_slog.addActionListener(this);
		btn_slog.setBounds(340,300,90,40);
		btn_slog.setContentAreaFilled(false);
		btn_slog.setForeground(Color.WHITE);
		btn_slog.setFont(new Font("宋体", Font.BOLD, 20));
		lab_imagelog.add(btn_slog);
		
		btn_tlog=new JButton("登陆");
		btn_tlog.addActionListener(this);
		btn_tlog.setBounds(340,300,90,40);
		btn_tlog.setContentAreaFilled(false);
		btn_tlog.setForeground(Color.WHITE);
		btn_tlog.setFont(new Font("宋体", Font.BOLD, 20));
		
		btn_sreg=new JButton("注册");
		btn_sreg.addActionListener(this);
		btn_sreg.setBounds(340,300,90,40);
		btn_sreg.setContentAreaFilled(false);
		btn_sreg.setForeground(Color.WHITE);
		btn_sreg.setFont(new Font("宋体", Font.BOLD, 20));
	//	lab_imagelog.add(btn_sreg);
		
		btn_treg=new JButton("注册");
		btn_treg.addActionListener(this);
		btn_treg.setBounds(340,300,90,40);
		btn_treg.setContentAreaFilled(false);
		btn_treg.setForeground(Color.WHITE);
		btn_treg.setFont(new Font("宋体", Font.BOLD, 20));
		
		
		btn_scancel=new JButton("返回");
		btn_scancel.addActionListener(this);
		btn_scancel.setBounds(490,330,67,30);
		btn_scancel.setContentAreaFilled(false);
		btn_scancel.setForeground(Color.WHITE);
		btn_scancel.setFont(new Font("宋体", Font.BOLD, 15));
		//lab_imagelog.add(btn_scancel);
		
		btn_tcancel=new JButton("返回");
		btn_tcancel.addActionListener(this);
		btn_tcancel.setBounds(490,330,67,30);
		btn_tcancel.setContentAreaFilled(false);
		btn_tcancel.setForeground(Color.WHITE);
		btn_tcancel.setFont(new Font("宋体", Font.BOLD, 15));
	//	lab_imagelog.add(btn_tcancel);
		
		lab_suser=new JLabel("",JLabel.CENTER);
		lab_imagelog.add(lab_suser);
		lab_suser.setIcon(image_user);
		lab_suser.setBounds(186,100,70,40);
		
		txt_skey=new JTextField(20);
		lab_imagelog.add(txt_skey);
		txt_skey.setText("password");
		txt_skey.setOpaque(false);
		txt_skey.setBorder(null);
		txt_skey.setForeground(Color.WHITE);
		txt_skey.setFont(new Font("宋体", Font.PLAIN, 25));
		txt_skey.setBounds(266,199,200,40);
		lab_skey=new JLabel("",JLabel.CENTER);
		lab_imagelog.add(lab_skey);
		lab_skey.setIcon(image_password);
		lab_skey.setBounds(186,199,70,40);
		
		txt_suser=new JTextField(20);
		lab_imagelog.add(txt_suser);
		txt_suser.setText("username");
		txt_suser.setOpaque(false);
		txt_suser.setBorder(null);
		txt_suser.setForeground(Color.WHITE);
		txt_suser.setFont(new Font("宋体", Font.PLAIN, 25));
		txt_suser.setBounds(266,100,200,40);
	//	lab_imagelog.add(comboBox);
        jrb2.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == evt.SELECTED)
				{
					lab_imagelog.remove(btn_slog);
					lab_imagelog.remove(lab_slog1);
					lab_imagelog.add(lab_slog2);
					lab_imagelog.add(btn_tlog);
					lab_imagelog.add(lab_slog2);
					repaint();
				
				}
			}
		});
 jrb1.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent evt) {
				if(evt.getStateChange() == evt.SELECTED)
				{
					lab_imagelog.remove(lab_slog2);
					lab_imagelog.remove(btn_tlog);


					lab_imagelog.add(btn_slog);
					lab_imagelog.add(lab_slog1);
					//lab_imagelog.add(lab_slog1);
					repaint();
				}
			}
		});

	}
	public void actionPerformed(ActionEvent ee){
		 
		
    	if(ee.getSource()==btn_sreset){             //重置
			   txt_suser.setText("username");
			   txt_skey.setText("password");
    	}
    	if(ee.getSource()==btn_sreset2){             //重置
			   txt_suser.setText("username");
			   txt_skey.setText("password");
			   txt_skey2.setText("repeat");
 	}
    	if(ee.getSource()== btn_scancel){
			lab_imagelog.remove(lab_skey);
			lab_imagelog.remove(lab_line2);
			lab_imagelog.remove(txt_skey);
			lab_imagelog.remove(lab_skey2);
			lab_imagelog.remove(lab_line3);
			lab_imagelog.remove(txt_skey2);
			lab_imagelog.remove(btn_sreg);
			lab_imagelog.remove(btn_scancel);
			
			lab_line2.setLocation(250,240);
			lab_line2.setSize(200,1);
			lab_line2.setIcon(image_line);
			
			lab_skey.setIcon(image_password);
			lab_skey.setBounds(186,199,70,40);
			
			txt_skey.setText("password");
			txt_skey.setOpaque(false);
			txt_skey.setBorder(null);
			txt_skey.setForeground(Color.WHITE);
			txt_skey.setFont(new Font("宋体", Font.PLAIN, 25));
			txt_skey.setBounds(266,199,200,40);
			lab_imagelog.add(txt_skey);
			lab_imagelog.add(lab_skey);
			lab_imagelog.add(lab_line2);
			lab_imagelog.add(btn_slog);
			lab_imagelog.add(lab_slog1);
			lab_imagelog.add(jrb1);
			lab_imagelog.add(jrb2);
			lab_imagelog.add(lab_slog);

			repaint();
    	}
    	if(ee.getSource()== btn_tcancel){
			lab_imagelog.remove(lab_skey);
			lab_imagelog.remove(lab_line2);
			lab_imagelog.remove(txt_skey);
			lab_imagelog.remove(lab_skey2);
			lab_imagelog.remove(lab_line3);
			lab_imagelog.remove(txt_skey2);
			lab_imagelog.remove(btn_treg);
			lab_imagelog.remove(btn_tcancel);


			
			lab_line2.setLocation(250,240);
			lab_line2.setSize(200,1);
			lab_line2.setIcon(image_line);
			
			lab_skey.setIcon(image_password);
			lab_skey.setBounds(186,199,70,40);
			
			txt_skey.setText("password");
			txt_skey.setOpaque(false);
			txt_skey.setBorder(null);
			txt_skey.setForeground(Color.WHITE);
			txt_skey.setFont(new Font("宋体", Font.PLAIN, 25));
			txt_skey.setBounds(266,199,200,40);
			lab_imagelog.add(txt_skey);
			lab_imagelog.add(lab_skey);
			lab_imagelog.add(lab_line2);
			lab_imagelog.add(btn_tlog);
			lab_imagelog.add(lab_slog2);
			lab_imagelog.add(lab_slog);
			lab_imagelog.add(jrb1);
			lab_imagelog.add(jrb2);
			repaint();
    	}
    	if(ee.getSource()== btn_tlog){
    		
   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();
        
   			 
   			 ResultSet rs = stmt.executeQuery("select * from teacher where teacher.teacherid = '"+txt_suser.getText()+"'and teacher.password = '"+txt_skey.getText()+"'");
   			 //user 为你表的名称
   			if (rs.next()) {
   				id1 = txt_suser.getText();
   				new TeaMainFrame(id1).setVisible(true);
   				
   			 }
   			else{
   				JOptionPane.showMessageDialog(null, "用户名或密码错误", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
   			}
   			
   			 }
   		 
   		 
   			 catch (Exception e) {
   			 System.out.print("get data error!");
   			 e.printStackTrace();
   			 }
   	}
    	if(ee.getSource()== btn_slog){
    		
    		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,Database_name,Data_password);
    			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
         
    			 
    			 ResultSet rs = stmt.executeQuery("select * from student where student.id = '"+txt_suser.getText()+"'and student.password = '"+txt_skey.getText()+"'");
    			 //user 为你表的名称
    			if (rs.next()) {
    				id = txt_suser.getText();
    				new StuMainFrame(id).setVisible(true);
    			 }
    			else{
    				JOptionPane.showMessageDialog(null, "用户名或密码错误", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
    			}
    			 }
    		 
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    	}
    	if(ee.getSource()== btn_treg){

   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();
   			 ResultSet rs = stmt.executeQuery("select * from teacher where teacher.teacherid = '"+txt_suser.getText()+"'");
   			 //user 为你表的名称
    			if (txt_suser.getText().toString().equals("")){
			           JOptionPane.showMessageDialog(null, "请输入账号", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }
	             else if (txt_skey.getText().toString().equals("")){
			            JOptionPane.showMessageDialog(null, "请输入密码", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }
	             else if (txt_skey2.getText().toString().equals("")){
			            JOptionPane.showMessageDialog(null, "请重复输入密码", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }    
	             else if(!txt_skey.getText().toString().equals(txt_skey2.getText().toString())){
	            	 JOptionPane.showMessageDialog(null, "两次输入密码不一致", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
	             }
	             else if (rs.next()) {
				JOptionPane.showMessageDialog(null, "此账户已注册，请登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			 }
	             else if (rs.next()) {
   				JOptionPane.showMessageDialog(null, "此账户已注册，请登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
   			 }
   			else{
   				
   				stmt.execute("insert ignore into teacher(teacherid,password)values('"+txt_suser.getText()+"','"+txt_skey.getText()+"')");
   				JOptionPane.showMessageDialog(null, "注册成功，请登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
   			}
   			 }
   		 
   		 
   			 catch (Exception e) {
   			 System.out.print("get data error!");
   			 e.printStackTrace();
   			 }
   	}
    	if(ee.getSource()== btn_sreg){

   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();
   			 ResultSet rs = stmt.executeQuery("select * from student where student.id = '"+txt_suser.getText()+"'");
   			 //user 为你表的名称

   			if (txt_suser.getText().toString().equals("")){
			           JOptionPane.showMessageDialog(null, "请输入账号", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }
	             else if (txt_skey.getText().toString().equals("")){
			            JOptionPane.showMessageDialog(null, "请输入密码", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }
	             else if (txt_skey2.getText().toString().equals("")){
			            JOptionPane.showMessageDialog(null, "请重复输入密码", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
			         }    
	             else if(!txt_skey.getText().toString().equals(txt_skey2.getText().toString())){
	            	 JOptionPane.showMessageDialog(null, "两次输入密码不一致", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
	             }
	             else if (rs.next()) {
   				JOptionPane.showMessageDialog(null, "此账户已注册，请登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
   			 }
   			else {
   				
   				stmt.execute("insert ignore into student(id,password)values('"+txt_suser.getText()+"','"+txt_skey.getText()+"')");
   				JOptionPane.showMessageDialog(null, "注册成功，请登陆", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
   			}
   			 }
   		  
   		 
   			 catch (Exception e) {
   			 System.out.print("get data error!");
   			 e.printStackTrace();
   			 }
   	}
	}
}
	


