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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MainFrame.StuMainFrame;

public class serinfo extends JFrame implements ActionListener{

	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	JPanel contentPane_serinfo = new JPanel();
	   JLabel lab_serinfo = new JLabel("查询个人信息",JLabel.CENTER);
	   JButton btn_squery = new JButton("查询");
	   JLabel lab_sname = new JLabel("姓名：",JLabel.CENTER);
	   JLabel lab_sage=new JLabel("年龄：",JLabel.CENTER);
	   JLabel lab_skey=new JLabel("登录密码：",JLabel.CENTER);
	   JLabel lab_ssex = new JLabel("性别：",JLabel.CENTER);
	   JLabel lab_txt_smajorass = new JLabel("班级：",JLabel.CENTER);
	   JLabel label_smajor = new JLabel("专业：",JLabel.CENTER);
	   JTextField txt_sage = new JTextField();
	   JTextField txt_skey = new JTextField();
	   JTextField txt_ssex = new JTextField();
	   JTextField txt_sname = new JTextField();
	   JTextField txt_sclass = new JTextField();
	   JTextField txt_smajor = new JTextField();

	   JButton btn_scancel = new JButton("返回");
	   public String id2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//serinfo frame = new serinfo();
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
	public serinfo(String id) {
		id2=id;
	    this.setSize(600,400);
	    setLocation(300,100);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPane_serinfo);
		
		contentPane_serinfo.setLayout(null);
		btn_squery.addActionListener(this);
		btn_scancel.addActionListener(this);
		lab_serinfo.setBounds(100,20,300,20);
		contentPane_serinfo.add(lab_serinfo);
		btn_squery.setBounds(121,64,90,20);
		btn_scancel.setBounds(277,64,90,20);
		contentPane_serinfo.add(btn_squery);
		contentPane_serinfo.add(btn_scancel);
		lab_sname.setBounds(100,116,70,20);
		contentPane_serinfo.add(lab_sname);
		txt_sname.setBounds(211,116,140,20);
		contentPane_serinfo.add(txt_sname);
		lab_sage.setBounds(100,197,70,20);
		contentPane_serinfo.add(lab_sage);
		txt_sage.setBounds(211,197,140,20);
		contentPane_serinfo.add(txt_sage);
		lab_ssex.setBounds(100,157,70,20);
		contentPane_serinfo.add(lab_ssex);
		txt_ssex.setBounds(211,157,140,20);
		contentPane_serinfo.add(txt_ssex);
        lab_txt_smajorass.setBounds(100,240,70,20);
		contentPane_serinfo.add(lab_txt_smajorass);
		txt_sclass.setBounds(211,240,140,20);
		contentPane_serinfo.add(txt_sclass);
		label_smajor.setBounds(100,282,70,20);
		contentPane_serinfo.add(label_smajor);
		txt_smajor.setBounds(211,282,140,20);
		contentPane_serinfo.add(txt_smajor);
		lab_skey.setBounds(113,322,70,20);
		contentPane_serinfo.add(lab_skey);
		txt_skey.setBounds(211,322,140,20);
		contentPane_serinfo.add(txt_skey);   
	    setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==btn_squery){            //查询操作
   		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();

			 ResultSet rs = stmt.executeQuery("select * from student where id = '"+id2+"'");
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
		}

		if(ee.getSource()==btn_scancel){      //返回
			 dispose();
		}
	}
}
