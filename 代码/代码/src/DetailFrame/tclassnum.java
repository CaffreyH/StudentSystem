package DetailFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class tclassnum extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane;
	JLabel label,labelyouxiu,labellianghao,labelzhongdeng,labeljige,labelbujige;
	JButton button1;
	JTextField lianghao,youxiu,zhongdeng,jige,bujige;
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
				//	tclassnum frame = new tclassnum();
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
	public tclassnum(String id) {
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
		labelyouxiu=new JLabel("优秀人数(90~100)");
		labellianghao=new JLabel("良好人数(80~90)");
		labelzhongdeng=new JLabel("中等人数(70~80)");
		labeljige=new JLabel("及格人数(60~70)");
		labelbujige=new JLabel("不及格人数(<60)");
		labelbujige.setForeground(Color.red);
		youxiu=new JTextField();
		lianghao=new JTextField();
		zhongdeng=new JTextField();
		jige=new JTextField();
		bujige=new JTextField();
		youxiu.setEditable(false);
		lianghao.setEditable(false);
		zhongdeng.setEditable(false);
		jige.setEditable(false);
		bujige.setEditable(false);
		labelyouxiu.setBounds(220,100,120,20);
		labellianghao.setBounds(220,140,120,20);
		labelzhongdeng.setBounds(220,180,120,20);
		labeljige.setBounds(220,220,120,20);
		labelbujige.setBounds(220,260,120,20);
		youxiu.setBounds(340,100,60,20);
		lianghao.setBounds(340,140,60,20);
		zhongdeng.setBounds(340,180,60,20);
		jige.setBounds(340,220,60,20);
		bujige.setBounds(340,260,60,20);
		jp.add(labelyouxiu);
		jp.add(labellianghao);
		jp.add(labelzhongdeng);
		jp.add(labeljige);
		jp.add(labelbujige);
		jp.add(youxiu);
		jp.add(lianghao);
		jp.add(zhongdeng);
		jp.add(jige);
		jp.add(bujige);
		button1=new JButton("返回");
		button1.setBounds(350,300,100,20);
		button1.addActionListener(this);
		jp.add(button1);
		
		JComboBox comboBox = new JComboBox();

		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();

				 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from tc where teacherid = '"+id2+"')");
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

		comboBox.setBounds(250, 50, 110, 21);
		jp.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent evt) {
				 s=evt.getItem().toString();
				for(int j=0;j<=i;j++)
				{
					if(a[j] == s)
					{
						courseid = copy[j];
					}
				}
				 try {
					 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
					 ip,"root","123456");
					 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
					 Statement stmt1 = connect1.createStatement();

						 	 ResultSet rs1 = stmt1.executeQuery("select score from sc where courseid = '"+courseid+"'");
						 	 while(rs1.next())
						 	 {
						 		 double hah = Double.parseDouble(rs1.getString("score"));
						 		 if(hah< 60)
						 		 {
						 			 f++;
						 		 }
						 		 else if(hah < 70)
						 		 {
						 			 g++;
						 		 }
						 		 else if(hah < 80)
						 		 {
						 			 d++;
						 		 }
						 		 else if(hah < 90)
						 		 {
						 			 c++;
						 		 }
						 		 else
						 		 {
						 			 b++;
						 		 }

						 	 }
						 	 
						 	 youxiu.setText(String.valueOf(b));
						 	 lianghao.setText(String.valueOf(c));
						 	 zhongdeng.setText(String.valueOf(d));
						 	 jige.setText(String.valueOf(g));
						 	 bujige.setText(String.valueOf(f));
						 	b=0;
						 	c=0;
						 	d=0;
						 	g=0;
						 	f=0;
					
				 }
				 
				 
				 
					 catch (Exception e) {
					 System.out.print("get data error!");
					 e.printStackTrace();
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
