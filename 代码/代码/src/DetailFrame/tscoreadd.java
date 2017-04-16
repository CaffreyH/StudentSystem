package DetailFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;

public class tscoreadd extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_tscoreadd;
	private JLabel lab_tid;
	private JLabel lab_tscore;
	private static JTextField txt_tid;
	private JTextField txt_tscore;
	private JButton btn_tsend;
	private JButton btn_tcancel;
	private JButton btn_treset;
	public static String id2;
	private JTextField txt_tcourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tscoreadd frame = new tscoreadd();
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
	public tscoreadd() {
        
		this.setSize(600,400);
		this.setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane_tscoreadd = new JPanel();
		contentPane_tscoreadd.setLayout(null);
		setContentPane(contentPane_tscoreadd);
		lab_tscore=new JLabel("������Ҫ��ӵĿγ̺š�ѧ���źͳɼ�");
		lab_tscore.setBounds(100,20,300,40);
		contentPane_tscoreadd.add(lab_tscore);
		
		
		lab_tid=new JLabel("ѧ���ţ�",JLabel.CENTER);
		lab_tid.setBounds(100,155,70,40);
		contentPane_tscoreadd.add(lab_tid);
		
		txt_tid=new JTextField(20);
		txt_tid.setBounds(190,156,140,40);
		contentPane_tscoreadd.add(txt_tid);
		
		lab_tscore=new JLabel("������",JLabel.CENTER);
		lab_tscore.setBounds(100,216,70,40);
		contentPane_tscoreadd.add(lab_tscore);
		
		txt_tscore=new JTextField(20);
		txt_tscore.setBounds(190,217,140,40);
		contentPane_tscoreadd.add(txt_tscore);
		
		
		btn_treset = new JButton("����");  
		btn_treset.addActionListener(this);
		btn_treset.setBounds(80,300,90,40);
		contentPane_tscoreadd.add(btn_treset);
		
		btn_tsend=new JButton("���");
		btn_tsend.addActionListener(this);
		btn_tsend.setBounds(200,300,90,40);
		contentPane_tscoreadd.add(btn_tsend);
		
		btn_tcancel=new JButton("����");
		btn_tcancel.addActionListener(this);
		btn_tcancel.setBounds(320,300,90,40);
		contentPane_tscoreadd.add(btn_tcancel);
		
		txt_tcourse = new JTextField(20);
		txt_tcourse.setBounds(190, 93, 140, 40);
		contentPane_tscoreadd.add(txt_tcourse);
		
		JLabel lab_scourse = new JLabel("�γ̺�", SwingConstants.CENTER);
		lab_scourse.setBounds(100, 92, 70, 40);
		contentPane_tscoreadd.add(lab_scourse);
	}
	public void actionPerformed(ActionEvent ee){
		 
		
    	if(ee.getSource()==btn_treset){             //����
			   txt_tid.setText(null);
			   txt_tscore.setText(null);
    	}
    	if(ee.getSource()==btn_tcancel){     //����
    		dispose();
    	}
    	if(ee.getSource()== btn_tsend){                 //���
	   		 try {
	   			 Double s = Double.parseDouble(txt_tid.getText())+1;
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,"root","123456");
    			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
    			 ResultSet rs = stmt.executeQuery("select * from sc where stuid = '"+txt_tid.getText()+"' and courseid = '"+txt_tcourse.getText()+"'");
    			 //user Ϊ��������
    			if (rs.next()) {
    				stmt.execute("update sc set score = '"+txt_tscore.getText()+"' where stuid = '"+txt_tid.getText()+"' and courseid = '"+txt_tcourse.getText()+"'");
    				JOptionPane.showMessageDialog(null,"��ӳɹ�", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
    				txt_tid.setText(String.valueOf(s));
    			 }
    			else{
    				JOptionPane.showMessageDialog(null, "�γ̺Ż�ѧ���Ŵ�������������", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
    			}
    			 }
    		 
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    	}
	}
}
