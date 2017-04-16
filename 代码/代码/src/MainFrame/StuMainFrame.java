package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;

import DetailFrame.saward;
import DetailFrame.chainfo;
import DetailFrame.sbulletin;
import DetailFrame.sercourse;
import DetailFrame.serinfo;
import DetailFrame.serscore;
import DetailFrame.sgpa;
import DetailFrame.sranking;
import DetailFrame.stuinfo;
import DetailFrame.teainfo;

public class StuMainFrame extends JFrame implements ActionListener{

	public final static String ip="jdbc:mysql://115.159.185.157:3306/superinfo?characterEncoding=UTF-8";
	public final static String ip_L="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
    public final static String Database_name = "hydb";
    public final static String Data_password = "123456";
	private JPanel contentPane_stu;
	String a[]=new String[20];
	String copy[] = new String[20];
	String courseid;
    int i=0;
    int b=0,c=0,d=0,g=0,f=0;
    public String s;
    int re = 0;
	public double alcre = 0;
	public String alrcre;
	public double alcre2 = 0;
	public String alrcre2;
	public double tocre;
	public String totcre;
	public double tocre2;
	public String totcre2;
	public double alcreg = 0;
	public String alrcreg;
	public double alcre2g = 0;
	public String alrcre2g;
	public double tocreg;
	public String totcreg;
	public double tocre2g;
	public String totcre2g;
	public double result;
	public String result2;
	public double result3;
	public String result4;
	JButton btn_sinfoadd,btn_sinfoser,btn_scouser,btn_scrser,btn_srank,btn_sgpa,btn_saward,btn_sbul,btn_sinfo;
	JLabel lab_stu;
	public String id1;
	private JLabel label;
	private JLabel label_sinfo;
	private JLabel label_serinfo;
	private JLabel label_ranking;
	private JLabel lab_imagelog;
	private JLabel lab_left;
	private JLabel lab_right;
	private JLabel lab_bottom;
	private JLabel lab_info;
	private JLabel lab_info2;
	JButton btn_scancel;
	JButton btn_sreset = new JButton("重置");
	JButton btn_sadd=new JButton("添加");

	
	private JTextArea show;
	private JTextArea show_ranking;
	
	   JLabel lab_sname = new JLabel("姓名：",JLabel.CENTER);
	   JLabel lab_sage=new JLabel("年龄：",JLabel.CENTER);
	   JLabel lab_skey=new JLabel("登录密码：",JLabel.CENTER);
	   JLabel lab_ssex = new JLabel("性别：",JLabel.CENTER);
	   JLabel lab_sclass = new JLabel("班级：",JLabel.CENTER);
	   JLabel label_smajor = new JLabel("专业：",JLabel.CENTER);
	   JTextField txt_sage = new JTextField();
	   JTextField txt_skey = new JTextField();
	   JTextField txt_ssex = new JTextField();
	   JTextField txt_sname = new JTextField();
	   JTextField txt_sclass = new JTextField();
	   JTextField txt_smajor = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	StuMainFrame frame = new StuMainFrame();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StuMainFrame(String id) {
		super("学生中心");
		id1 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane_stu = new JPanel();
		contentPane_stu.setLayout(null);
		setContentPane(contentPane_stu);
		
		
		ImageIcon image_bac = new ImageIcon(getClass().getResource("/images/block.jpg"));
		lab_imagelog = new JLabel("");
		lab_imagelog.setLocation(0,-15);
		lab_imagelog.setSize(600,400);
		lab_imagelog.setIcon(image_bac);
		contentPane_stu.add(lab_imagelog);
		
		lab_left = new JLabel();
		lab_left.setLocation(0,-5);
		lab_left.setSize(150,400);
		lab_imagelog.add(lab_left);
		
		lab_right = new JLabel();
		lab_right.setLocation(160,15);
		lab_right.setSize(403,400);
		lab_right.setOpaque(false);
		lab_imagelog.add(lab_right);
		
		lab_bottom = new JLabel();
		lab_bottom.setLocation(160,330);
		lab_bottom.setSize(403,50);
		lab_imagelog.add(lab_bottom);
		
	    btn_scancel=new JButton("返回");
		btn_scancel.addActionListener(this);
		btn_scancel.setBounds(330,0,67,30);
		btn_scancel.setContentAreaFilled(false);
		btn_scancel.setForeground(Color.WHITE);
		btn_scancel.setFont(new Font("宋体", Font.BOLD, 15));
		lab_bottom.add(btn_scancel);
		btn_scancel.addActionListener(this);
		
		lab_stu=new JLabel("");
		lab_stu.setFont(new Font("宋体_GB2312",Font.BOLD,24));
		lab_stu.setForeground(Color.black);
		setBounds(300,100,600,400);
	//	lab_imagelog.add(lab_stu);
		
		
		btn_sbul=new JButton("学校公告");
		btn_sinfoadd=new JButton("个人信息");
		btn_sinfoser=new JButton("查找或删除信息");
		btn_scouser=new JButton("课程信息");
		btn_scrser=new JButton("成绩查询");
		btn_srank=new JButton("成绩排序");
		btn_sgpa=new JButton("绩点查询");
		btn_saward=new JButton("获奖情况");
				
		ImageIcon imgbtn_news = new ImageIcon(getClass().getResource("/images/news.png"));
	    
	    btn_sinfoser.setBounds(268,76,150,20);
	    btn_sbul.setBounds(21,100,106,20);
	    btn_sinfoadd.setBounds(21,132,106,20);
	    btn_scouser.setBounds(21,164,106,20);
	    btn_scrser.setBounds(21,196,106,20);
	    btn_srank.setBounds(21,228,106,20);
	    btn_sgpa.setBounds(21,260,106,20);
	    btn_saward.setBounds(21,292,106,20);
	    
	    lab_left.add(btn_sbul);
	    btn_sbul.setContentAreaFilled(false);
	    btn_sbul.setForeground(Color.WHITE);
	    btn_sbul.addActionListener(this);
	    lab_left.add(btn_sinfoadd);
	    btn_sinfoadd.setContentAreaFilled(false);
	    btn_sinfoadd.setForeground(Color.WHITE);
	    btn_sinfoadd.addActionListener(this);
	   // lab_imagelog.add(btn_sinfoser);
	    btn_sinfoser.addActionListener(this);
	    lab_left.add(btn_scouser);
	    btn_scouser.setContentAreaFilled(false);
	    btn_scouser.setForeground(Color.WHITE);
	    btn_scouser.addActionListener(this);
	    lab_left.add(btn_scrser);
	    btn_scrser.setContentAreaFilled(false);
	    btn_scrser.setForeground(Color.WHITE);
	    btn_scrser.addActionListener(this);
	    lab_left.add(btn_srank);
	    btn_srank.setContentAreaFilled(false);
	    btn_srank.setForeground(Color.WHITE);
	    btn_srank.addActionListener(this);
	    lab_left.add(btn_sgpa);
	    btn_sgpa.setContentAreaFilled(false);
	    btn_sgpa.setForeground(Color.WHITE);
	    btn_sgpa.addActionListener(this);
	    lab_left.add(btn_saward);
	    btn_saward.setContentAreaFilled(false);
	    btn_saward.setForeground(Color.WHITE);
	    
	    
	    lab_info = new JLabel();
	    lab_info.setBounds(30,60,25,20);
	    lab_info.setIcon(imgbtn_news);
	    lab_left.add(lab_info);

	    lab_info2 = new JLabel("新消息");
	    lab_info2.setOpaque(false);
	    lab_info2.setFont(new Font("宋体", Font.BOLD, 15));
	    lab_info2.setForeground(Color.WHITE);
	    lab_info2.setBounds(58,55,60,35);
	    lab_left.add(lab_info2);
	    
	    

	    label = new JLabel("欢迎来到学生信息中心，请点击左侧查看相应信息");
	    label.setBounds(20,0,400,260);
	    label.setFont(new Font("宋体", Font.PLAIN, 15));
	    label.setForeground(Color.WHITE);
	    lab_right.add(label);
	    
	    label_sinfo = new JLabel();
	    label_sinfo.setBounds(5,5,400,298);
	    label_sinfo.setFont(new Font("宋体", Font.PLAIN, 15));
	    label_sinfo.setForeground(Color.WHITE);
	    
		show=new JTextArea(100,60);
		
		show.setBounds(0,0,397,340);
		show.setEditable(false);
		show.setLineWrap(true);
		show.setOpaque(false);
		show.setFont(new Font("宋体", Font.PLAIN, 15));
		show.setForeground(Color.WHITE);
		
		JScrollPane jsc = new JScrollPane(show);
		
		jsc.setBounds(0,10,397,340);
		label_sinfo.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsc.getViewport().setOpaque(false);
		jsc.setOpaque(false);
		
	    
	    label_ranking = new JLabel();
	    label_ranking.setBounds(5,5,400,298);
	    label_ranking.setFont(new Font("宋体", Font.PLAIN, 15));
	    label_ranking.setForeground(Color.WHITE);
	    
		show_ranking=new JTextArea(100,60);
		show_ranking.setBounds(0,60,400,300);
		show_ranking.setEditable(false);
		show_ranking.setLineWrap(true);
		show_ranking.setOpaque(false);
		show_ranking.setFont(new Font("宋体",Font.PLAIN , 15));
		show_ranking.setForeground(Color.WHITE);
		JScrollPane jsc2 = new JScrollPane(show_ranking);
		jsc2.setBounds(0,60,400,300);
		jsc2.setOpaque(false);
		jsc2.getViewport().setOpaque(false);
		label_ranking.add(jsc2);
		jsc2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
	    label_serinfo = new JLabel();
	    label_serinfo.setBounds(5,5,400,298);
	    label_serinfo.setFont(new Font("宋体", Font.PLAIN, 15));
	    label_serinfo.setForeground(Color.WHITE);
	    label_serinfo.setOpaque(false);
	    
		lab_sname.setBounds(70,60,70,20);
		lab_sname.setFont(new Font("宋体", Font.PLAIN, 15));
		lab_sname.setForeground(Color.WHITE);
		lab_sname.setOpaque(false);
		label_serinfo.add(lab_sname);
		txt_sname.setBounds(180,60,140,20);
		txt_sname.setFont(new Font("宋体", Font.PLAIN, 15));
	    txt_sname.setForeground(Color.WHITE);
	    txt_sname.setOpaque(false);
		label_serinfo.add(txt_sname);
		lab_ssex.setBounds(70,100,70,20);
		lab_ssex.setFont(new Font("宋体", Font.PLAIN, 15));
		lab_ssex.setForeground(Color.WHITE);
		lab_ssex.setOpaque(false);
		label_serinfo.add(lab_ssex);
		txt_ssex.setBounds(180,100,140,20);
		txt_ssex.setFont(new Font("宋体", Font.PLAIN, 15));
		txt_ssex.setForeground(Color.WHITE);
		txt_ssex.setOpaque(false);
		label_serinfo.add(txt_ssex);
		lab_sage.setBounds(70,140,70,20);
		lab_sage.setFont(new Font("宋体", Font.PLAIN, 15));
		lab_sage.setForeground(Color.WHITE);
		lab_sage.setOpaque(false);
		label_serinfo.add(lab_sage);
		txt_sage.setBounds(180,140,140,20);
		txt_sage.setFont(new Font("宋体", Font.PLAIN, 15));
		txt_sage.setForeground(Color.WHITE);
		txt_sage.setOpaque(false);
		label_serinfo.add(txt_sage);
        lab_sclass.setBounds(70,180,70,20);
        lab_sclass.setFont(new Font("宋体", Font.PLAIN, 15));
        lab_sclass.setForeground(Color.WHITE);
        lab_sclass.setOpaque(false);
        label_serinfo.add(lab_sclass);
		txt_sclass.setBounds(180,180,140,20);
		txt_sclass.setFont(new Font("宋体", Font.PLAIN, 15));
	    txt_sclass.setForeground(Color.WHITE);
	    txt_sclass.setOpaque(false);
		label_serinfo.add(txt_sclass);
		label_smajor.setBounds(70,220,70,20);
		label_smajor.setFont(new Font("宋体", Font.PLAIN, 15));
		label_smajor.setForeground(Color.WHITE);
		label_smajor.setOpaque(false);
		label_serinfo.add(label_smajor);
		txt_smajor.setBounds(180,220,140,20);
		txt_smajor.setFont(new Font("宋体", Font.PLAIN, 15));
		txt_smajor.setForeground(Color.WHITE);
		txt_smajor.setOpaque(false);
		label_serinfo.add(txt_smajor);
		lab_skey.setBounds(40,260,95,20);
		lab_skey.setFont(new Font("宋体", Font.PLAIN, 15));
		lab_skey.setForeground(Color.WHITE);
		lab_skey.setOpaque(false);
		label_serinfo.add(lab_skey);
		txt_skey.setBounds(180,260,140,20);
		txt_skey.setFont(new Font("宋体", Font.PLAIN, 15));
		txt_skey.setForeground(Color.WHITE);
		txt_skey.setOpaque(false);
		label_serinfo.add(txt_skey);   
		btn_sadd.addActionListener(this);
		btn_sadd.setBounds(250,20,90,20);
		btn_sadd.setContentAreaFilled(false);
		btn_sadd.setForeground(Color.WHITE);
		label_serinfo.add(btn_sadd);   
		btn_sreset.addActionListener(this);
		btn_sreset.setBounds(100,20,90,20);
		btn_sreset.setContentAreaFilled(false);
		btn_sreset.setForeground(Color.WHITE);
		label_serinfo.add(btn_sreset);   
	
		
		
	    btn_saward.addActionListener(this);
	    lab_info.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		lab_right.removeAll();
	    		lab_imagelog.add(lab_right);
	    		lab_right.add(label_sinfo);
	    		 try {
	    			 show.setText(null);
	 				show.append("          ");
	 				show.append("教师");
	 				show.append("            ");
	 				show.append("通知内容");
	 				show.append("\n");
	 			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
	 			 ip,Database_name,Data_password);
	 			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
	 			 Statement stmt = connect.createStatement();
	     
	 			 
	 			 ResultSet rs = stmt.executeQuery("select* from info where stuid = '"+id1+"'");
	 			// String s = rs.toString();
	 			 //user 为你表的名称
	 			while (rs.next()) {
		 			 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
		 		 			 ip,Database_name,Data_password);
		 		 			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
		 		 			 Statement stmt2 = connect2.createStatement();
		 		     
		 		 			 
		 		 			 ResultSet rs2 = stmt2.executeQuery("select* from teacher where teacherid = '"+rs.getString("teaid")+"'");
		 		 			 if(rs2.next())
		 		 			 {
		 		 				show.append("          ");
		 		 				show.append(rs2.getString("name"));
		 		 			 }
	 			
	 				show.append("         ");
	 				show.append(rs.getString("info"));
	 				show.append("\n");
	 			 }
	 		 }
	 		 
	 		 
	 			 catch (Exception ee) {
	 			 System.out.print("get data error!");
	 			 ee.printStackTrace();
	 			 }
	    		repaint();
	    	}
		});
	    lab_info2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		lab_right.removeAll();
	    		lab_imagelog.add(lab_right);
	    		lab_right.add(label_sinfo);
	    		 try {
	    			 show.setText(null);
	 				show.append("          ");
	 				show.append("教师");
	 				show.append("            ");
	 				show.append("通知内容");
	 				show.append("\n");
	 			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
	 			 ip,Database_name,Data_password);
	 			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
	 			 Statement stmt = connect.createStatement();
	     
	 			 
	 			 ResultSet rs = stmt.executeQuery("select* from info where stuid = '"+id1+"'");
	 			// String s = rs.toString();
	 			 //user 为你表的名称
	 			while (rs.next()) {
		 			 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
		 		 			 ip,Database_name,Data_password);
		 		 			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
		 		 			 Statement stmt2 = connect2.createStatement();
		 		     
		 		 			 
		 		 			 ResultSet rs2 = stmt2.executeQuery("select* from teacher where teacherid = '"+rs.getString("teaid")+"'");
		 		 			 if(rs2.next())
		 		 			 {
		 		 				show.append("          ");
		 		 				show.append(rs2.getString("name"));
		 		 			 }
	 			
	 				show.append("         ");
	 				show.append(rs.getString("info"));
	 				show.append("\n");
	 			 }
	 		 }
	 		 
	 		 
	 			 catch (Exception ee) {
	 			 System.out.print("get data error!");
	 			 ee.printStackTrace();
	 			 }
	    		repaint();
	    	}
		});
	}
	
	public void actionPerformed(ActionEvent ee){
    	if(ee.getSource()==btn_scancel){      
    		dispose();
    	}
    	if(ee.getSource()==btn_sinfoadd){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_serinfo);
      		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,Database_name,Data_password);
    			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();

    			 ResultSet rs = stmt.executeQuery("select * from student where id = '"+id1+"'");
     			if (rs.next()) {
     				 txt_skey.setText(rs.getString("password"));
     				 txt_sname.setText(rs.getString("name"));
     				 txt_ssex.setText(rs.getString("sex"));
     				 txt_smajor.setText(rs.getString("major"));
     				 txt_sage.setText(rs.getString("age"));
     				 txt_sclass.setText(rs.getString("class"));
    			 }
    			 }
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    		repaint();
    	}
    	if(ee.getSource()==btn_sreset){      
			   txt_skey.setText(null);
			   txt_sname.setText(null);
			   txt_ssex.setText(null);
			   txt_sage.setText(null);
			   txt_sclass.setText(null);
			   txt_smajor.setText(null);
    	}
    	if(ee.getSource()==btn_sadd){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_serinfo);
     		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,Database_name,Data_password);
    			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
    			 if(!txt_sname.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set name = '"+txt_sname.getText()+"' where id = '"+id1+"'");
    			 }
    			 if(!txt_skey.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set password = '"+txt_skey.getText()+"' where id = '"+id1+"'");
    			 }
    			 if(!txt_sclass.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set class = '"+txt_sclass.getText()+"' where id = '"+id1+"'");
    			 }

    			 if(!txt_ssex.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set sex = '"+txt_ssex.getText()+"' where id = '"+id1+"'");
    			 }
    			 if(!txt_sage.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set age = '"+txt_sage.getText()+"' where id = '"+id1+"'");
    			 }
    			 if(!txt_smajor.getText().toString().equals(""))
    			 {
    			 stmt.execute("update student set major = '"+txt_smajor.getText()+"' where id = '"+id1+"'");
    			 }

    			 JOptionPane.showMessageDialog(null,"已成功添加","温馨提示",JOptionPane.INFORMATION_MESSAGE);
    			 //user 为你表的名称
    			 }
    		 
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    			
    		repaint();
    	}
    	if(ee.getSource()==btn_scouser){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
   		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			ip,Database_name,Data_password);
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
			 show.setText(null);
				show.append("课程号");
				show.append("    ");
				show.append("课程名");
				show.append("           ");
				show.append("平均分");
				show.append("      ");
				show.append("学分");
				show.append("\n");
		 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from sc where stuid = '"+id1+"')");
		 	 while(rs1.next())
		 	 {
					show.append(rs1.getString("courseid"));
					show.append("    ");
					show.append(rs1.getString("course"));
					show.append("           ");
					show.append(rs1.getString("avescore"));
					show.append("         ");
					show.append(rs1.getString("credit"));
					show.append("\n");
					alcre2 += Double.parseDouble(rs1.getString("credit"));
					
		 	 }
		 	ResultSet rs2 = stmt.executeQuery("select* from student where id = '"+id1+"'");
		 	 if(rs2.next())
		 	 {
					tocre2 = Double.parseDouble(rs2.getString("totalcre"));
		 	 }
		 	

		 }


			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
	 	 alrcre2 = String.valueOf(alcre2);
	 	 totcre2 = String.valueOf(tocre2);
	 	show.append("\n");
	 	show.append("\n");
	 	show.append("\n");
	 	 show.append("总修读学分为: ");
	 	show.append(totcre2);
	 	 show.append(",");
	 	 show.append("已修读学分为: ");
	 	 show.append(alrcre2);
	 	 show.append("\n");
	 	 repaint();
    	}
    	if(ee.getSource()==btn_scrser){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
    		 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
				 show.setText(null);
					show.append("课程号");
					show.append("            ");
					show.append("课程名");
					show.append("            ");
					show.append("分数");
					show.append("\n");
				 	 ResultSet rs1 = stmt.executeQuery("select* from course where courseid in(select courseid from sc where stuid = '"+id1+"')");
				 	 while(rs1.next())
				 	 {
				 		 
							show.append(rs1.getString("courseid"));
							show.append("            ");
							show.append(rs1.getString("course"));
							String s = rs1.getString("courseid");
							 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									 ip,Database_name,Data_password);
							 Statement stmt2 = connect2.createStatement();
						 	ResultSet rs2 = stmt2.executeQuery("select* from sc where stuid = '"+id1+"' and courseid = '"+s+"'");
						 	 if(rs2.next())
						 	 {
									show.append("            ");
									show.append(rs2.getString("score"));
									show.append("\n");
						 	 }

			 }
			 }


				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
    		repaint();
    	}
    	if(ee.getSource()==btn_saward){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
	 try {
				 show.setText(null);
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
	     
				 
				 ResultSet rs = stmt.executeQuery("select* from award where stuid = '"+id1+"'");
				 //user 为你表的名称
				 show.setText(null);
				while (rs.next()) {
					show.append("                    ");
					show.append(rs.getString("name"));
					show.append("\n");
				 }
			 }
			 
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
    		repaint();
    	}
    	if(ee.getSource()==btn_sgpa){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
			 try {
				    show.setText(null);
					show.append("课程号");
					show.append("            ");
					show.append("课程名");
					show.append("            ");
					show.append("绩点");
					show.append("\n");
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
			 	 ResultSet rs1 = stmt.executeQuery("select* from course where courseid in(select courseid from sc where stuid = '"+id1+"')");
			 	 while(rs1.next())
			 	 {
			 		 
					
						show.append(rs1.getString("courseid"));
						show.append("            ");
						show.append(rs1.getString("course"));
						String s = rs1.getString("courseid");
						 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
								 ip,Database_name,Data_password);
						 Statement stmt2 = connect2.createStatement();
					 	ResultSet rs2 = stmt2.executeQuery("select* from sc where stuid = '"+id1+"' and courseid = '"+s+"'");
					 	 if(rs2.next())
					 	 {
					 		 Connection connect3 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									 ip,Database_name,Data_password);
							 Statement stmt3 = connect3.createStatement();
						 	ResultSet rs3 = stmt3.executeQuery("select* from gpa where score = '"+rs2.getString("score")+"'");
						 	if(rs3.next())
						 	{
					 		 
								show.append("            ");
								show.append(rs3.getString("gpa"));
								show.append("\n");
								tocreg += Double.parseDouble(rs3.getString("gpa"));
								alcreg += 1;
						 	}
					 	 }

			 	 }
			 }
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
			
			 result3 = (double)tocreg/alcreg;
		 	 alrcreg = String.valueOf(alcreg);
		 	 totcreg = String.valueOf(tocreg);
		 	 result4 = String.valueOf(result3);
		 	show.append("\n");
		 	show.append("\n");
		 	show.append("\n");
		 	 show.append("总绩点为: ");
		 	show.append(totcreg);
		 	 show.append(",");
		 	 show.append("平均绩点为: ");
		 	 show.append(result4);
		 	 show.append("\n");
    		repaint();
    	}
    	if(ee.getSource()==btn_srank){      
      		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_ranking);
    		
			JComboBox comboBox = new JComboBox();

			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();

					 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from sc where stuid = '"+id1+"')");
					 	 while(rs1.next())
					 	 {
					 		 a[i] = rs1.getString("course");
					 		 copy[i] = rs1.getString("courseid");
					 		 i++;
					 	 }
				
			 }
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
				for(int j=0;j<=i;j++)
				{
					comboBox.addItem(a[j]);
				}

			comboBox.setBounds(50, 20, 119, 21);
			//comboBox.setSelectedItem(a[0]);
			label_ranking.add(comboBox);
			 try {
				 show_ranking.setText(null);
				 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt1 = connect1.createStatement();
				 show_ranking.append("  ");
				 show_ranking.append("学生");
				 show_ranking.append("                    ");
				 show_ranking.append("分数");
				 show_ranking.append("\n");
					 	 ResultSet rs1 = stmt1.executeQuery("select* from sc where courseid = '"+copy[0]+"' order by score desc");
					 	 while(rs1.next())
					 	 {
							 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									 ip,Database_name,Data_password);
									 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
									 Statement stmt2 = connect2.createStatement();

										 	 ResultSet rs2 = stmt2.executeQuery("select name from student where id = '"+rs1.getString("stuid")+"' ");
										 	 if(rs2.next())
										 	 {
										 		show_ranking.append("  ");
										 		show_ranking.append(rs2.getString("name"));
										 		show_ranking.append("                    ");
										 		show_ranking.append(rs1.getString("score"));
										 		show_ranking.append("\n");
										 	 }

					 	 }
				
			 }
			 
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
			

			comboBox.addItemListener(new ItemListener() {
				
				public void itemStateChanged(ItemEvent evt) {
					if(evt.getStateChange() == evt.SELECTED)
					{
					 s=evt.getItem().toString();
					for(int j=0;j<=i;j++)
					{
						if(a[j] == s)
						{
							courseid = copy[j];
						}
					}
					 try {
						 show_ranking.setText(null);
						 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
						ip,Database_name,Data_password);
						 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
						 Statement stmt1 = connect1.createStatement();
						 show_ranking.append("  ");
						 show_ranking.append("学生");
						 show_ranking.append("                    ");
						 show_ranking.append("分数");
						 show_ranking.append("\n");
							 	 ResultSet rs1 = stmt1.executeQuery("select* from sc where courseid = '"+courseid+"' order by score desc");
							 	 while(rs1.next())
							 	 {
									 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
											 ip,Database_name,Data_password);
											 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
											 Statement stmt2 = connect2.createStatement();

												 	 ResultSet rs2 = stmt2.executeQuery("select name from student where id = '"+rs1.getString("stuid")+"' ");
												 	 if(rs2.next())
												 	 {
												 		show_ranking.append("  ");
												 		show_ranking.append(rs2.getString("name"));
												 		show_ranking.append("                    ");
												 		show_ranking.append(rs1.getString("score"));
												 		show_ranking.append("\n");
												 	 }
	    
							 	 }
						
					 }
					 
					 
					 
						 catch (Exception e) {
						 System.out.print("get data error!");
						 e.printStackTrace();
						 }
					}
				}
			});
			
			
			
    		repaint();
    	}
    	if(ee.getSource()==btn_sbul){      
      		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
   		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,Database_name,Data_password);
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from bulletin");
			// String s = rs.toString();
			 //user 为你表的名称
			 show.setText(null);
			while (rs.next()) {
			//	show.append("            ");
				show.append(rs.getString("content"));
				show.append("\n");
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
    		repaint();
    	}

	}

}
