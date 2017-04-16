package DetailFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.Source;

import MainFrame.TeaMainFrame;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sbulletin extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_sbul;
	private JTextArea show;
	JButton btn_ref;
	JButton btn_cancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sbulletin frame = new sbulletin();
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
	public sbulletin() {
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
		
		
		btn_cancel = new JButton("����");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_sbul.add(btn_cancel);
		
		JLabel label = new JLabel("ѧУ����");
		label.setFont(new Font("����_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_sbul.add(label);
		
		btn_ref = new JButton("ˢ��");
		btn_ref.addActionListener(this);
		btn_ref.setBounds(251, 298, 104, 41);
		contentPane_sbul.add(btn_ref);
		
		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from bulletin");
			// String s = rs.toString();
			 //user Ϊ��������
			while (rs.next()) {
				show.append("                                                                    ");
				show.append(rs.getString("content"));
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
			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 "jdbc:mysql://localhost:3306/info","root","");
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
	     
				 
				 ResultSet rs = stmt.executeQuery("select* from bulletin");
				// String s = rs.toString();
				 //user Ϊ��������
				 show.setText(null);
				while (rs.next()) {
					show.append("                                                                    ");
					show.append(rs.getString("content"));
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
