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

public class saward extends JFrame implements ActionListener{

	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_saward;
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
				//	Saward frame = new Saward();
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
	public saward(String id) {
		id2 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,600,400);
		contentPane_saward = new JPanel();
		contentPane_saward.setLayout(null);
		setContentPane(contentPane_saward);
		show=new JTextArea(100,60);
		show.setBounds(0,76,584,212);
		show.setEditable(false);
		show.setLineWrap(true);
		JScrollPane jsc = new JScrollPane(show);
		jsc.setBounds(0,76,584,212);
		contentPane_saward.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		btn_cancel = new JButton("����");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_saward.add(btn_cancel);
		
		JLabel label = new JLabel("�����");
		label.setFont(new Font("����_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_saward.add(label);
		
		btn_ref = new JButton("ˢ��");
		btn_ref.addActionListener(this);
		btn_ref.setBounds(251, 298, 104, 41);
		contentPane_saward.add(btn_ref);
		
		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from award where stuid = '"+id2+"'");
			 //user Ϊ��������
			while (rs.next()) {
				show.append("                                                                    ");
				show.append(rs.getString("name"));
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
				 ip,"root","123456");
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
	     
				 
				 ResultSet rs = stmt.executeQuery("select* from award where stuid = '"+id2+"'");
				 //user Ϊ��������
				 show.setText(null);
				while (rs.next()) {
					show.append("                                                                    ");
					show.append(rs.getString("name"));
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
