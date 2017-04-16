package DetailFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class sranking extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane;
	private JTextArea show;
	JLabel label;
	JButton button1;
	JPanel jp;
	public String id2;
	String a[]=new String[20];
	String copy[] = new String[20];
	String courseid;
    int i=0;
    int b=0,c=0,d=0,g=0,f=0;
    public String s;
    int re = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//sranking frame = new sranking();
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
		public sranking(String id) {
			id2 = id;
			setVisible(true);
			setResizable(true);
			setBounds(300,100,600,400);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jp=new JPanel();
			jp.setLayout(null);
			getContentPane().add(jp);
			label=new JLabel("各门课程各等级人数");
			label.setBounds(250,20,150,20);
			jp.add(label);
			button1=new JButton("返回");
			button1.setBounds(389,314,100,20);
			button1.addActionListener(this);
			jp.add(button1);
			show=new JTextArea(100,60);
			show.setBounds(0,76,584,212);
			show.setEditable(false);
			show.setLineWrap(true);
			JScrollPane jsc = new JScrollPane(show);
			jsc.setBounds(0,76,584,212);
			jp.add(jsc);
			jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			JComboBox comboBox = new JComboBox();

			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,"root","123456");
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();

					 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from sc where stuid = '"+id2+"')");
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

			comboBox.setBounds(241, 50, 119, 21);
			jp.add(comboBox);
			
			JTextArea textArea = new JTextArea(100, 60);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setBounds(0, 101, 584, 203);
			jp.add(textArea);
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
						 show.setText(null);
						 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
						 ip,"root","123456");
						 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
						 Statement stmt1 = connect1.createStatement();

					 		show.append("                                                                      ");
					 		 show.append("学生");
					 		 show.append("                           ");
	                           show.append("分数");
	                           show.append("\n");
							 	 ResultSet rs1 = stmt1.executeQuery("select* from sc where courseid = '"+courseid+"' order by score desc");
							 	 while(rs1.next())
							 	 {
									 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
											ip,"root","123456");
											 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
											 Statement stmt2 = connect2.createStatement();

												 	 ResultSet rs2 = stmt2.executeQuery("select name from student where id = '"+rs1.getString("stuid")+"' ");
												 	 if(rs2.next())
												 	 {
												 		show.append("                                                                      ");
												 		 show.append(rs2.getString("name"));
												 		 show.append("                           ");
						                                    show.append(rs1.getString("score"));
					                                        show.append("\n");
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
			

			

		}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==button1){
				dispose();
			}
		}
	}
