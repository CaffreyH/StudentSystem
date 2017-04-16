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
import MainFrame.TeaMainFrame;

public class teainfo extends JFrame implements ActionListener{
	static final String ip ="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
	private JPanel contentPane_tinfo;
	private JLabel lab_tid;
	private JLabel lab_tinfo;
	private static JTextField txt_tid;
	private JTextField txt_tinfo;
	private JButton btn_tsend;
	private JButton btn_tcancel;
	private JButton btn_treset;
	public static String id2;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//	TeaLogFrame teaLogFrame = new TeaLogFrame();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//teainfo frame = new teainfo();
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
	public teainfo(String id) {
		id2=id;
        
		this.setSize(600,400);
		this.setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane_tinfo = new JPanel();
		contentPane_tinfo.setLayout(null);
		setContentPane(contentPane_tinfo);
		lab_tinfo=new JLabel("请输入要发送的学生id和信息");
		lab_tinfo.setBounds(100,20,300,40);
		contentPane_tinfo.add(lab_tinfo);
		
		
		lab_tid=new JLabel("id：",JLabel.CENTER);
		lab_tid.setBounds(100,100,70,40);
		contentPane_tinfo.add(lab_tid);
		
		txt_tid=new JTextField(20);
		txt_tid.setBounds(190,100,140,40);
		contentPane_tinfo.add(txt_tid);
		
		lab_tinfo=new JLabel("信息：",JLabel.CENTER);
		lab_tinfo.setBounds(100,200,70,40);
		contentPane_tinfo.add(lab_tinfo);
		
		txt_tinfo=new JTextField(20);
		txt_tinfo.setBounds(190,200,140,40);
		contentPane_tinfo.add(txt_tinfo);
		
		
		btn_treset = new JButton("重置");  
		btn_treset.addActionListener(this);
		btn_treset.setBounds(80,300,90,40);
		contentPane_tinfo.add(btn_treset);
		
		btn_tsend=new JButton("发送");
		btn_tsend.addActionListener(this);
		btn_tsend.setBounds(200,300,90,40);
		contentPane_tinfo.add(btn_tsend);
		
		btn_tcancel=new JButton("返回");
		btn_tcancel.addActionListener(this);
		btn_tcancel.setBounds(320,300,90,40);
		contentPane_tinfo.add(btn_tcancel);
	}
	public void actionPerformed(ActionEvent ee){
		 
		
    	if(ee.getSource()==btn_treset){             //重置
			   txt_tid.setText(null);
			   txt_tinfo.setText(null);
    	}
    	if(ee.getSource()==btn_tcancel){     //返回
    		dispose();
    	}
    	if(ee.getSource()== btn_tsend){                 //发送
    		String s;
    		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			 ip,"root","123456");
    			 //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
    			 ResultSet rs1 = stmt.executeQuery("select* from student where id = '"+txt_tid.getText()+"'");
	             if(rs1.next())
	             {
	            	 ResultSet rs2 = stmt.executeQuery("select* from teacher where teacherid = '"+id2+"'");
	            	 if(rs2.next()){
	            		 s = rs2.getString("name");
	            	 
	            	 stmt.execute("insert ignore into info(stuid,info,teaid)values('"+txt_tid.getText()+"','"+txt_tinfo.getText()+"','"+s+"')");
	    			 //user 为你表的名称
	    				JOptionPane.showMessageDialog(null, "发送成功", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
	    				txt_tid.setText(null);
	    				txt_tinfo.setText(null);
	            	 }
	             }
	             else
	             {
	            	 JOptionPane.showMessageDialog(null, "该学生不存在，请重新输入", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
	             }
    			
    			 }
    		 
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    	}
	}

}
