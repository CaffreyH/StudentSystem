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
import javax.xml.transform.TransformerConfigurationException;

public class sercourse extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_scourse;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//sercourse frame = new sercourse();
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
	public sercourse(String id) {
		id2 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,100,600,400);
		contentPane_scourse = new JPanel();
		contentPane_scourse.setLayout(null);
		setContentPane(contentPane_scourse);
		show=new JTextArea(100,60);
		show.setBounds(0,76,584,212);
		show.setEditable(false);
		show.setLineWrap(true);
		JScrollPane jsc = new JScrollPane(show);
		jsc.setBounds(0,76,584,212);
		contentPane_scourse.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		btn_cancel = new JButton("����");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(491, 0, 93, 23);
		contentPane_scourse.add(btn_cancel);
		
		JLabel label = new JLabel("�γ���Ϣ");
		label.setFont(new Font("����_GB2312",Font.BOLD,24));
		label.setForeground(Color.black);
		label.setBounds(251,26,247,40);
		contentPane_scourse.add(label);
		
		btn_ref = new JButton("ˢ��");
		btn_ref.addActionListener(this);
		btn_ref.setBounds(251, 298, 104, 41);
		contentPane_scourse.add(btn_ref);
		
		 try {
				show.append("                                             ");
				show.append("�γ̺�");
				show.append("            ");
				show.append("�γ���");
				show.append("            ");
				show.append("ƽ����");
				show.append("               ");
				show.append("ѧ��");
				show.append("\n");
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,"root","123456");
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();

				 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from sc where stuid = '"+id2+"')");
				 	 while(rs1.next())
				 	 {
							show.append("                                             ");
							show.append(rs1.getString("courseid"));
							show.append("            ");
							show.append(rs1.getString("course"));
							show.append("            ");
							show.append(rs1.getString("avescore"));
							show.append("                    ");
							show.append(rs1.getString("credit"));
							show.append("\n");
							alcre += Double.parseDouble(rs1.getString("credit"));
				 	 }
					 	ResultSet rs2 = stmt.executeQuery("select* from student where id = '"+id2+"'");
					 	 while(rs2.next())
					 	 {
								tocre = Double.parseDouble(rs2.getString("totalcre"));
					 	 }
			
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
	 	 alrcre = String.valueOf(alcre);
	 	 totcre = String.valueOf(tocre);
	 	show.append("\n");
	 	show.append("                                                    ");
	 	 show.append("���޶�ѧ��Ϊ: ");
	 	show.append(totcre);
	 	 show.append(",");
	 	 show.append("���޶�ѧ��Ϊ: ");
	 	 show.append(alrcre);
	 	 show.append("\n");
		
		
	}
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource() == btn_ref){
			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				ip,"root","123456");
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();
				 show.setText(null);
					show.append("                                             ");
					show.append("�γ̺�");
					show.append("            ");
					show.append("�γ���");
					show.append("            ");
					show.append("ƽ����");
					show.append("               ");
					show.append("ѧ��");
					show.append("\n");
			 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from sc where stuid = '"+id2+"')");
			 	 while(rs1.next())
			 	 {
						show.append("                                             ");
						show.append(rs1.getString("courseid"));
						show.append("            ");
						show.append(rs1.getString("course"));
						show.append("            ");
						show.append(rs1.getString("avescore"));
						show.append("                    ");
						show.append(rs1.getString("credit"));
						show.append("\n");
						alcre2 += Double.parseDouble(rs1.getString("credit"));
						
			 	 }
			 	ResultSet rs2 = stmt.executeQuery("select* from student where id = '"+id2+"'");
			 	 while(rs2.next())
			 	 {
						tocre2 = Double.parseDouble(rs2.getString("totalcre"));
			 	 }
			 	

			 }


				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
		 	 alrcre2 = String.valueOf(alcre2);
		 	 totcre2 = String.valueOf(tocre2);
		 	show.append("\n");
		 	show.append("                                                    ");
		 	 show.append("���޶�ѧ��Ϊ: ");
		 	show.append(totcre2);
		 	 show.append(",");
		 	 show.append("���޶�ѧ��Ϊ: ");
		 	 show.append(alrcre2);
		 	 show.append("\n");
		}
		if(ee.getSource() == btn_cancel){
			dispose();
		}
	}
}
