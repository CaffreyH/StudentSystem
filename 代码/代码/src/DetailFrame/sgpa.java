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

public class sgpa extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_sgpa;
	private JTextArea show;
	JButton btn_ref;
	JButton btn_cancel;
	public String id2;
	public double alcre = 0;
	public String alrcre;
	public double alcre2 = 0;
	public String alrcre2;
	public double tocre;
	public String totcre;
	public double tocre2;
	public String totcre2;
	public double result;
	public String result2;
	public double result3;
	public String result4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//sgpa frame = new sgpa();
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
	public sgpa(String id) {
		id2 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,600,400);
		contentPane_sgpa = new JPanel();
		contentPane_sgpa.setLayout(null);
		setContentPane(contentPane_sgpa);
		show=new JTextArea(100,60);
		show.setBounds(0,76,584,212);
		show.setEditable(false);
		show.setLineWrap(true);
		JScrollPane jsc = new JScrollPane(show);
		jsc.setBounds(0,76,584,212);
		contentPane_sgpa.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		btn_cancel = new JButton("返回");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_sgpa.add(btn_cancel);
		
		JLabel label = new JLabel("课程信息");
		label.setFont(new Font("宋体_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_sgpa.add(label);
		
		btn_ref = new JButton("刷新");
		btn_ref.addActionListener(this);
		btn_ref.setBounds(251, 298, 104, 41);
		contentPane_sgpa.add(btn_ref);
		
		 try {
				show.append("                                             ");
				show.append("课程号");
				show.append("            ");
				show.append("课程名");
				show.append("            ");
				show.append("绩点");
				show.append("\n");
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
		 	 ResultSet rs1 = stmt.executeQuery("select* from course where courseid in(select courseid from sc where stuid = '"+id2+"')");
		 	 while(rs1.next())
		 	 {
		 		 
					show.append("                                             ");
					show.append(rs1.getString("courseid"));
					show.append("            ");
					show.append(rs1.getString("course"));
					String s = rs1.getString("courseid");
					 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
							 ip,"root","123456");
					 Statement stmt2 = connect2.createStatement();
				 	ResultSet rs2 = stmt2.executeQuery("select* from sc where stuid = '"+id2+"' and courseid = '"+s+"'");
				 	 if(rs2.next())
				 	 {
				 		String s2 = rs2.getString("score");
				 		 Connection connect3 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
								 ip,"root","123456");
						 Statement stmt3 = connect3.createStatement();
					 	ResultSet rs3 = stmt3.executeQuery("select* from gpa where score = '"+s2+"'");
				 		 if(rs3.next())
				 		 {
							show.append("          ");
							show.append(rs3.getString("gpa"));
							show.append("\n");
							tocre += Double.parseDouble(rs3.getString("gpa"));
							alcre += 1;
				 		 }
				 	 }

		 	 }
			
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
		
		 result = (double)tocre/alcre;
	 	 alrcre = String.valueOf(alcre);
	 	 totcre = String.valueOf(tocre);
	 	 result2 = String.valueOf(result);
	 	 
	 	show.append("\n");
	 	show.append("                                                    ");
	 	 show.append("总绩点为: ");
	 	show.append(totcre);
	 	 show.append(",");
	 	 show.append("平均绩点为: ");
	 	 show.append(result2);
	 	 show.append("\n");
		
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource() == btn_ref){
			 try {
					show.append("                                             ");
					show.append("课程号");
					show.append("            ");
					show.append("课程名");
					show.append("            ");
					show.append("绩点");
					show.append("\n");
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,"root","123456");
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
			 	 ResultSet rs1 = stmt.executeQuery("select* from course where courseid in(select courseid from sc where stuid = '"+id2+"')");
			 	 while(rs1.next())
			 	 {
			 		 
						show.append("                                             ");
						show.append(rs1.getString("courseid"));
						show.append("            ");
						show.append(rs1.getString("course"));
						String s = rs1.getString("courseid");
						 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
								ip,"root","123456");
						 Statement stmt2 = connect2.createStatement();
					 	ResultSet rs2 = stmt2.executeQuery("select* from sc where stuid = '"+id2+"' and courseid = '"+s+"'");
					 	 if(rs2.next())
					 	 {
					 		 Connection connect3 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									 ip,"root","123456");
							 Statement stmt3 = connect3.createStatement();
						 	ResultSet rs3 = stmt3.executeQuery("select* from gpa where score = '"+rs2.getString("score")+"'");
					 		 
								show.append("            ");
								show.append(rs3.getString("gpa"));
								show.append("\n");
								tocre += Double.parseDouble(rs3.getString("gpa"));
								alcre += 1;
					 	 }

			 	 }
			 }
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
			
			 result3 = (double)tocre/alcre;
		 	 alrcre = String.valueOf(alcre);
		 	 totcre = String.valueOf(tocre);
		 	 result4 = String.valueOf(result);
		 	 
		 	show.append("\n");
		 	show.append("                                                    ");
		 	 show.append("总绩点为: ");
		 	show.append(totcre);
		 	 show.append(",");
		 	 show.append("平均绩点为: ");
		 	 show.append(result4);
		 	 show.append("\n");
		}
		if(ee.getSource() == btn_cancel){
			dispose();
		}
	}
}