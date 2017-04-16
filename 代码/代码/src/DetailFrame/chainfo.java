package DetailFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class chainfo extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	JLabel lab_sinfo = new JLabel("添加基本信息",JLabel.CENTER);
	JLabel lab_skey=new JLabel("密码：",JLabel.CENTER);
	JLabel lab_sage=new JLabel("年龄：",JLabel.CENTER);
	JLabel lab_sname=new JLabel("姓名：",JLabel.CENTER);
	JLabel lab_sclass=new JLabel("班级：",JLabel.CENTER);
	JLabel lab_smajor=new JLabel("专业：",JLabel.CENTER);
	JLabel lab_ssex = new JLabel("性别：",JLabel.CENTER);
	JTextField txt_sname=new JTextField(20);
	JTextField txt_ssex=new JTextField(18);
	JTextField txt_skey=new JTextField(20);
	JTextField txt_sage=new JTextField(20);
	JTextField txt_sclass=new JTextField(20);
	JTextField txt_smajor=new JTextField(20);
	JTextField txt_smz=new JTextField(20);
	JButton btn_sadd=new JButton("添加");
	JButton btn_scancel=new JButton("返回");
	JButton btn_sreset = new JButton("重置");
	JPanel contentPane_schainfo=new JPanel();
	public String id2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	chainfo frame = new chainfo();
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
	public chainfo(String id) {
		id2 = id;
		this.setResizable(false);
		this.setSize(600,400);
		this.setVisible(true);
		this.setLocation(300,100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPane_schainfo);
		contentPane_schainfo.setLayout(null);
		btn_sadd.addActionListener(this);
		btn_sreset.addActionListener(this);
		btn_scancel.addActionListener(this);
		lab_sinfo.setBounds(100,20,300,20);
		contentPane_schainfo.add(lab_sinfo);
		lab_skey.setBounds(100,50,70,20);
		contentPane_schainfo.add(lab_skey);
		txt_skey.setBounds(190,50,140,20);
		contentPane_schainfo.add(txt_skey);
		lab_sname.setBounds(100,90,70,20);
		contentPane_schainfo.add(lab_sname);
		txt_sname.setBounds(190,90,140,20);
		contentPane_schainfo.add(txt_sname);
		lab_ssex.setBounds(110,130,60,20);
		contentPane_schainfo.add(lab_ssex);
		txt_ssex.setBounds(190,130,140,20);
		contentPane_schainfo.add(txt_ssex);
	    lab_sage.setBounds(100,170,70,20);
		contentPane_schainfo.add(lab_sage);
		txt_sage.setBounds(190,170,140,20);
		contentPane_schainfo.add(txt_sage);
		lab_sclass.setBounds(100,210,70,20);
		contentPane_schainfo.add(lab_sclass);
		txt_sclass.setBounds(190,210,140,20);
		contentPane_schainfo.add(txt_sclass);
		lab_smajor.setBounds(100,250,70,20);
		contentPane_schainfo.add(lab_smajor);
		txt_smajor.setBounds(190,250,140,20);
		contentPane_schainfo.add(txt_smajor);
		btn_sreset.setBounds(80,340,90,20);
		btn_sadd.setBounds(200,340,90,20);
		btn_scancel.setBounds(320,340,90,20);
		contentPane_schainfo.add(btn_sreset);
		contentPane_schainfo.add(btn_sadd);
		contentPane_schainfo.add(btn_scancel);
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==btn_sreset){        //重置
			   txt_skey.setText(null);
			   txt_sname.setText(null);
			   txt_ssex.setText(null);
			   txt_sage.setText(null);
			   txt_sclass.setText(null);
			   txt_smajor.setText(null);
		}
		if(ee.getSource()==btn_scancel){     //返回
			dispose();
		}
		if(ee.getSource()==btn_sadd){
   		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
			 if(!txt_sname.getText().toString().equals(""))
			 {
			 stmt.execute("update student set name = '"+txt_sname.getText()+"' where id = '"+id2+"'");
			 }
			 if(!txt_skey.getText().toString().equals(""))
			 {
			 stmt.execute("update student set password = '"+txt_skey.getText()+"' where id = '"+id2+"'");
			 }
			 if(!txt_sclass.getText().toString().equals(""))
			 {
			 stmt.execute("update student set class = '"+txt_sclass.getText()+"' where id = '"+id2+"'");
			 }

			 if(!txt_ssex.getText().toString().equals(""))
			 {
			 stmt.execute("update student set sex = '"+txt_ssex.getText()+"' where id = '"+id2+"'");
			 }
			 if(!txt_sage.getText().toString().equals(""))
			 {
			 stmt.execute("update student set age = '"+txt_sage.getText()+"' where id = '"+id2+"'");
			 }
			 if(!txt_smajor.getText().toString().equals(""))
			 {
			 stmt.execute("update student set major = '"+txt_smajor.getText()+"' where id = '"+id2+"'");
			 }

			 JOptionPane.showMessageDialog(null,"已成功添加","温馨提示",JOptionPane.INFORMATION_MESSAGE);
			 //user 为你表的名称
			 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
			
		}
	}
}
