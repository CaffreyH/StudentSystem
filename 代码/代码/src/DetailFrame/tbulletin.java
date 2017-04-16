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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;;

public class tbulletin extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_tbul;
	private JTextArea show;
	JButton btn_add;
	private JTextField txt_add;
	private JTextField txt_num;
	private JLabel lab_num;
	private JLabel lab_con;
	private JButton btn_cancel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tbulletin frame = new tbulletin();
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
	public tbulletin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,600,400);
		contentPane_tbul = new JPanel();
		contentPane_tbul.setLayout(null);
		setContentPane(contentPane_tbul);
		show=new JTextArea(100,60);
		show.setBounds(0,76,584,212);
		show.setEditable(false);
		show.setLineWrap(true);
		JScrollPane jsc = new JScrollPane(show);
		jsc.setBounds(0,76,584,212);
		contentPane_tbul.add(jsc);
		//jsc.setVisible(true);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JLabel label = new JLabel("学校公告");
		label.setFont(new Font("宋体_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_tbul.add(label);
		
		btn_add = new JButton("添加");
		btn_add.addActionListener(this);
		btn_add.setBounds(480, 297, 104, 41);
		contentPane_tbul.add(btn_add);
		
		txt_add = new JTextField();
		txt_add.setBounds(76, 298, 360, 40);
		contentPane_tbul.add(txt_add);
		txt_add.setColumns(10);
		
		txt_num = new JTextField();
		txt_num.setBounds(35, 298, 42, 40);
		contentPane_tbul.add(txt_num);
		txt_num.setColumns(10);
		
		lab_num = new JLabel("序号");
		lab_num.setBounds(0, 298, 42, 40);
		contentPane_tbul.add(lab_num);
		
		lab_con = new JLabel("内容");
		lab_con.setBounds(446, 297, 36, 40);
		contentPane_tbul.add(lab_con);
		
		btn_cancel = new JButton("返回");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_tbul.add(btn_cancel);
		
		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			ip,"root","123456");
			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from bulletin");
			// String s = rs.toString();
			 //user 为你表的名称
			while (rs.next()) {
				show.append(rs.getString("id"));
				show.append("                                 ");
				show.append(rs.getString("content"));
				show.append("\n");
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
		 txt_num.setText(null);
		 txt_add.setText(null);
		
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource() == btn_add){
			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,"root","123456");
				 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
	             ResultSet rs1 = stmt.executeQuery("select* from bulletin where id = '"+txt_num.getText()+"'");
	             if(rs1.next())
	             {
	            	 JOptionPane.showMessageDialog(null,"该公告已存在，请更换序号","温馨提示",JOptionPane.INFORMATION_MESSAGE);
	             }
	             else{
	            	 stmt.execute("insert ignore into bulletin(id,content)values('"+txt_num.getText()+"','"+txt_add.getText()+"')");
				     ResultSet rs2 = stmt.executeQuery("select* from bulletin");
				     //user 为你表的名称
				     show.setText(null);
			    	while (rs2.next()) {
					show.append(rs2.getString("id"));
					show.append("                              ");
					show.append(rs2.getString("content"));
					show.append("\n");
			    	}
				 }
			 }
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			 txt_num.setText(null);
			 txt_add.setText(null);
			
		}
		if(ee.getSource() == btn_cancel){
			dispose();
		}
	}
	
}
