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

public class tserinfo extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	JPanel contentPane_tserinfo = new JPanel();
	   JLabel lab_tserinfo = new JLabel("查询学生信息",JLabel.CENTER);
	   JLabel lab_sid = new JLabel("请输入学生学号：",JLabel.CENTER);
	   JButton btn_tquery = new JButton("查询");
	   JLabel lab_stxt_sname = new JLabel("姓名：",JLabel.CENTER);
	   JLabel lab_sage=new JLabel("年龄：",JLabel.CENTER);
	   JLabel lab_ssex = new JLabel("性别：",JLabel.CENTER);
	   JLabel lab_stxt_txt_smajorasss = new JLabel("班级：",JLabel.CENTER);
	   JLabel lab_smajor = new JLabel("专业：",JLabel.CENTER);
	   JTextField txt_sage = new JTextField();
	   JTextField txt_ssex = new JTextField();
	   JTextField txt_sid = new JTextField();
	   JTextField txt_sname = new JTextField();
	   JTextField txt_sclass = new JTextField();
	   JTextField txt_smajor = new JTextField();
	   JButton btn_scancel = new JButton("取消");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tserinfo frame = new tserinfo();
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
	public tserinfo() {
		super();
	    this.setSize(600,400);
	    setLocation(300,100);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().add(contentPane_tserinfo);
		
		contentPane_tserinfo.setLayout(null);
		btn_tquery.addActionListener(this);
		btn_scancel.addActionListener(this);
		lab_tserinfo.setBounds(100,20,300,20);
		contentPane_tserinfo.add(lab_tserinfo);
		lab_sid.setBounds(47,60,123,20);
		contentPane_tserinfo.add(lab_sid);
		txt_sid.setBounds(190,60,140,20);
		contentPane_tserinfo.add(txt_sid);
		btn_tquery.setBounds(164,100,90,20);
		btn_scancel.setBounds(301,100,90,20);
		contentPane_tserinfo.add(btn_tquery);
		contentPane_tserinfo.add(btn_scancel);
		lab_stxt_sname.setBounds(100,150,70,20);
		contentPane_tserinfo.add(lab_stxt_sname);
		txt_sname.setBounds(190,150,140,20);
		contentPane_tserinfo.add(txt_sname);
		lab_sage.setBounds(100,210,70,20);
		contentPane_tserinfo.add(lab_sage);
		txt_sage.setBounds(190,210,140,20);
		contentPane_tserinfo.add(txt_sage);
		lab_ssex.setBounds(100,180,70,20);
		contentPane_tserinfo.add(lab_ssex);
		txt_ssex.setBounds(190,180,140,20);
		contentPane_tserinfo.add(txt_ssex);
  lab_stxt_txt_smajorasss.setBounds(100,240,70,20);
		contentPane_tserinfo.add(lab_stxt_txt_smajorasss);
		txt_sclass.setBounds(190,240,140,20);
		contentPane_tserinfo.add(txt_sclass);
		lab_smajor.setBounds(100,270,70,20);
		contentPane_tserinfo.add(lab_smajor);
		txt_smajor.setBounds(190,270,140,20);
		contentPane_tserinfo.add(txt_smajor);
	    txt_sname.setEditable(false);
	    txt_sage.setEditable(false);
	    txt_ssex.setEditable(false);
	    txt_smajor.setEditable(false);
	    txt_sclass.setEditable(false);
	    setVisible(true);
	    txt_sid.requestFocus();
	}
	
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==btn_tquery){            //查询操作
	   		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,"root","123456");
    			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
    			 ResultSet rs = stmt.executeQuery("select * from student where student.id = '"+txt_sid.getText()+"'");
    			 //user 为你表的名称
    			if (rs.next()) {
     				 txt_sname.setText(rs.getString("name"));
     				 txt_ssex.setText(rs.getString("sex"));
     				 txt_smajor.setText(rs.getString("major"));
     				 txt_sage.setText(rs.getString("age"));
     				 txt_sclass.setText(rs.getString("class"));
    			 }
    			else{
    				JOptionPane.showMessageDialog(null, "该学生不存在，请重新输入", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
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
