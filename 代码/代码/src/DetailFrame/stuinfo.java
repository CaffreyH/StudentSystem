package DetailFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class stuinfo extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane;
	private JPanel contentPane_sbul;
	private JTextArea show;
	JButton btn_ref;
	JButton btn_cancel;
	public String id2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	stuinfo frame = new stuinfo();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public stuinfo(String id) {
		id2 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,600,400);
		contentPane_sbul = new JPanel();
		contentPane_sbul.setLayout(null);
		setContentPane(contentPane_sbul);
		show=new JTextArea(100,60);
		show.setBounds(0,76,584,212);
		show.setEditable(false);
		show.setLineWrap(true);
		JScrollPane jsc = new JScrollPane(show);
		jsc.setBounds(0,76,584,212);
		contentPane_sbul.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		btn_cancel = new JButton("返回");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_sbul.add(btn_cancel);
		
		JLabel label = new JLabel("教师通知");
		label.setFont(new Font("宋体_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_sbul.add(label);
		
		btn_ref = new JButton("刷新");
		btn_ref.addActionListener(this);
		btn_ref.setBounds(251, 298, 104, 41);
		contentPane_sbul.add(btn_ref);
		
		 try {
				show.append("                                                   ");
				show.append("教师");
				show.append("                                       ");
				show.append("通知内容");
				show.append("\n");
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from info where stuid = '"+id2+"'");
			// String s = rs.toString();
			 //user 为你表的名称
			while (rs.next()) {
				show.append("                                                   ");
				show.append(rs.getString("teaid"));
				show.append("                                       ");
				show.append(rs.getString("info"));
				show.append("\n");
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
		
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource() == btn_ref){
			show.setText(null);
			 try {
					show.append("                                                   ");
					show.append("教师");
					show.append("                                       ");
					show.append("通知内容");
					show.append("\n");
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,"root","123456");
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
	     
				 
				 ResultSet rs = stmt.executeQuery("select* from info where stuid = '"+id2+"'");
				// String s = rs.toString();
				 //user 为你表的名称
				 
				while (rs.next()) {
					show.append("                                                   ");
					show.append(rs.getString("teaid"));
					show.append("                                       ");
					show.append(rs.getString("info"));
					show.append("\n");
				 }
			 }
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
		}
		if(ee.getSource() == btn_cancel){
			dispose();
		}
	}
}
