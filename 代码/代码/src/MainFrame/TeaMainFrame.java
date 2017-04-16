package MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DetailFrame.tbulletin;
import DetailFrame.tclassnum;
import DetailFrame.teainfo;
import DetailFrame.tranking;
import DetailFrame.tscoreadd;
import DetailFrame.tscoresearch;
import DetailFrame.tserinfo;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TeaMainFrame extends JFrame implements ActionListener{
	public final static String ip="jdbc:mysql://115.159.185.157:3306/superinfo?characterEncoding=UTF-8";
	public final static String ip_L="jdbc:mysql://localhost:3306/info?characterEncoding=UTF-8";
    public final static String Database_name = "hydb";
    public final static String Data_password = "123456";
	private JPanel contentPane_stu;
	String a[]=new String[20];
	String copy[] = new String[20];
	String courseid;
    int i=0;
    int b=0,c=0,d=0,g=0,f=0;
    public String s;
    int re = 0;
	public double alcre = 0;
	public String alrcre;
	public double alcre2 = 0;
	public String alrcre2;
	public double tocre;
	public String totcre;
	public double tocre2;
	public String totcre2;
	public double alcreg = 0;
	public String alrcreg;
	public double alcre2g = 0;
	public String alrcre2g;
	public double tocreg;
	public String totcreg;
	public double tocre2g;
	public String totcre2g;
	public double result;
	public String result2;
	public double result3;
	public String result4;
	JButton btn_sinfoser,btn_scoreadd,btn_scrser,btn_srank,btn_score,btn_sbul,btn_sinfo;
	JLabel lab_stu;
	public String id1;
	private JLabel label;
	private JLabel label_s;
	private JLabel label_sbul;
	private JLabel label_sinfo;
	private JLabel label_serinfo;
	private JLabel label_ranking;
	private JLabel label_scoreadd;
	private JLabel lab_imagelog;
	private JLabel lab_left;
	private JLabel lab_right;
	private JLabel lab_bottom;
	private JLabel lab_info;
	private JLabel lab_info2;
	private JLabel label_classnum;
	JButton btn_scancel;
	JLabel lab_tinfo;
	JLabel lab_tid;
	JTextField txt_tid;
	JTextField txt_tinfo;
	JLabel lab_taddscore;
	JLabel lab_tid_addscore;
	JLabel lab_tscore;
	JLabel lab_tcourseid;
	JTextField txt_tcourseid;
	JTextField txt_tid_addscore;
	JTextField txt_tscore;
	JButton btn_treset_info;	
	JButton btn_tsend_info;
	JButton btn_add_sbul;
	JButton btn_taddscore;
	JButton btn_treset_score;
	
	JLabel labelyouxiu,labellianghao,labelzhongdeng,labeljige,labelbujige;
	JTextField lianghao,youxiu,zhongdeng,jige,bujige;
	private JTextField txt_add_sbul;
	private JTextField txt_num_sbul;
	private JLabel lab_num_sbul;
	private JLabel lab_con_sbul;
	
	
	private JTextArea show;
	private JTextArea show_ranking;
	private JTextArea show_rankingt;
	
	   JLabel lab_sname = new JLabel("������",JLabel.CENTER);
	   JLabel lab_sage=new JLabel("���䣺",JLabel.CENTER);
	   JLabel lab_ssex = new JLabel("�Ա�",JLabel.CENTER);
	   JLabel lab_sclass = new JLabel("�༶��",JLabel.CENTER);
	   JLabel label_smajor = new JLabel("רҵ��",JLabel.CENTER);
	   JTextField txt_sage = new JTextField();
	   JTextField txt_skey = new JTextField();
	   JTextField txt_ssex = new JTextField();
	   JTextField txt_sname = new JTextField();
	   JTextField txt_sclass = new JTextField();
	   JTextField txt_smajor = new JTextField();
	   
	   
	   JLabel lab_sid = new JLabel("������ѧ��ѧ�ţ�",JLabel.CENTER);
	   JButton btn_tquery = new JButton("��ѯ");
	   JTextField txt_sid = new JTextField();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	StuMainFrame frame = new StuMainFrame();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeaMainFrame(String id) {
		super("��ʦ����");
		id1 = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane_stu = new JPanel();
		contentPane_stu.setLayout(null);
		setContentPane(contentPane_stu);
		
		
		ImageIcon image_bac = new ImageIcon(getClass().getResource("/images/block.jpg"));
		lab_imagelog = new JLabel("");
		lab_imagelog.setLocation(0,-15);
		lab_imagelog.setSize(600,400);
		lab_imagelog.setIcon(image_bac);
		contentPane_stu.add(lab_imagelog);
		
		lab_left = new JLabel();
		lab_left.setLocation(0,-5);
		lab_left.setSize(150,400);
		lab_imagelog.add(lab_left);
		
		lab_right = new JLabel();
		lab_right.setLocation(160,15);
		lab_right.setSize(403,400);
		lab_right.setOpaque(false);
		lab_imagelog.add(lab_right);
		
		lab_bottom = new JLabel();
		lab_bottom.setLocation(160,330);
		lab_bottom.setSize(403,50);
		lab_imagelog.add(lab_bottom);
		
	    btn_scancel=new JButton("����");
		btn_scancel.addActionListener(this);
		btn_scancel.setBounds(330,0,67,30);
		btn_scancel.setContentAreaFilled(false);
		btn_scancel.setForeground(Color.WHITE);
		btn_scancel.setFont(new Font("����", Font.BOLD, 15));
		lab_bottom.add(btn_scancel);
		btn_scancel.addActionListener(this);
		
		lab_stu=new JLabel("");
		lab_stu.setFont(new Font("����_GB2312",Font.BOLD,24));
		lab_stu.setForeground(Color.black);
		setBounds(300,100,600,400);
	//	lab_imagelog.add(lab_stu);
		
		
		btn_sbul=new JButton("��������");
		btn_sinfoser=new JButton("ѧ����Ϣ");
		btn_scoreadd=new JButton("�ɼ�¼��");
		btn_scrser=new JButton("�����ȼ�");
		btn_score=new JButton("ƽ����");
		btn_srank=new JButton("���а�");
				
		ImageIcon imgbtn_news = new ImageIcon(getClass().getResource("/images/news.png"));
	    
	    btn_sbul.setBounds(21,100,106,20);
	    btn_sinfoser.setBounds(21,135,106,20);
	    btn_scoreadd.setBounds(21,170,106,20);
	    btn_scrser.setBounds(21,205,106,20);
	    btn_srank.setBounds(21,240,106,20);
	    btn_score.setBounds(21,273,106,20);
	    
	    lab_left.add(btn_sbul);
	    btn_sbul.setContentAreaFilled(false);
	    btn_sbul.setForeground(Color.WHITE);
	    btn_sbul.addActionListener(this);
	    lab_left.add(btn_sinfoser);
	    btn_sinfoser.setContentAreaFilled(false);
	    btn_sinfoser.setForeground(Color.WHITE);
	    btn_sinfoser.addActionListener(this);
	   // lab_imagelog.add(btn_sinfoser);
	    lab_left.add(btn_scoreadd);
	    btn_scoreadd.setContentAreaFilled(false);
	    btn_scoreadd.setForeground(Color.WHITE);
	    btn_scoreadd.addActionListener(this);
	    lab_left.add(btn_scrser);
	    btn_scrser.setContentAreaFilled(false);
	    btn_scrser.setForeground(Color.WHITE);
	    btn_scrser.addActionListener(this);
	    lab_left.add(btn_srank);
	    btn_srank.setContentAreaFilled(false);
	    btn_srank.setForeground(Color.WHITE);
	    btn_srank.addActionListener(this);
	    lab_left.add(btn_score);
	    btn_score.setContentAreaFilled(false);
	    btn_score.setForeground(Color.WHITE);
	    btn_score.addActionListener(this);
	    
	    
	    lab_info = new JLabel();
	    lab_info.setBounds(30,60,25,20);
	    lab_info.setIcon(imgbtn_news);
	    lab_left.add(lab_info);

	    lab_info2 = new JLabel("����Ϣ");
	    lab_info2.setOpaque(false);
	    lab_info2.setFont(new Font("����", Font.BOLD, 15));
	    lab_info2.setForeground(Color.WHITE);
	    lab_info2.setBounds(58,55,60,35);
	    lab_left.add(lab_info2);
	    

		
	    

	    label = new JLabel("��ӭ������ʦ���ģ��������鿴�޸���Ӧ��Ϣ");
	    label.setBounds(20,0,400,260);
	    label.setFont(new Font("����", Font.PLAIN, 15));
	    label.setForeground(Color.WHITE);
	    lab_right.add(label);
	    
	    
	    label_s = new JLabel();
	    label_s.setBounds(5,5,400,298);
	    label_s.setFont(new Font("����", Font.PLAIN, 15));
	    label_s.setOpaque(false);
	    label_s.setForeground(Color.WHITE);
	    
		lab_tinfo = new JLabel("������Ҫ���͵�ѧ��id����Ϣ");
		lab_tinfo.setBounds(60,20,300,40);
		lab_tinfo.setForeground(Color.WHITE);
		lab_tinfo.setOpaque(false);
		lab_tinfo.setFont(new Font("����", Font.PLAIN, 18));
		label_s.add(lab_tinfo);
		
		
		lab_tid = new JLabel("id��",JLabel.CENTER);
		lab_tid.setBounds(20,130,70,40);
		lab_tid.setForeground(Color.WHITE);
		lab_tid.setOpaque(false);
		lab_tid.setFont(new Font("����", Font.BOLD, 15));
		label_s.add(lab_tid);
		
	    txt_tid = new JTextField(20);
		txt_tid.setBounds(110,130,140,40);
		txt_tid.setForeground(Color.WHITE);
		txt_tid.setOpaque(false);
		txt_tid.setFont(new Font("����", Font.BOLD, 15));
		label_s.add(txt_tid);
		
		lab_tinfo=new JLabel("��Ϣ��",JLabel.CENTER);
		lab_tinfo.setBounds(20,200,70,40);
		lab_tinfo.setForeground(Color.WHITE);
		lab_tinfo.setOpaque(false);
		lab_tinfo.setFont(new Font("����", Font.BOLD, 17));
		label_s.add(lab_tinfo);
		
		txt_tinfo = new JTextField(20);
		txt_tinfo.setBounds(110,200,140,40);
		txt_tinfo.setForeground(Color.WHITE);
		txt_tinfo.setOpaque(false);
		txt_tinfo.setFont(new Font("����", Font.BOLD, 17));
		label_s.add(txt_tinfo);
		
		   label_scoreadd = new JLabel();
		   label_scoreadd.setBounds(5,5,400,298);
		   label_scoreadd.setFont(new Font("����", Font.PLAIN, 15));
		   label_scoreadd.setOpaque(false);
		   label_scoreadd.setForeground(Color.WHITE);
		    
			lab_taddscore = new JLabel("������Ҫ��ӵĿγ̺ţ�ѧ�źͳɼ�");
			lab_taddscore.setBounds(60,20,300,40);
			lab_taddscore.setForeground(Color.WHITE);
			lab_taddscore.setOpaque(false);
			lab_taddscore.setFont(new Font("����", Font.PLAIN, 18));
			label_scoreadd.add(lab_taddscore);
			
			
			lab_tcourseid = new JLabel("�γ̺ţ�",JLabel.CENTER);
			lab_tcourseid.setBounds(40,120,70,30);
			lab_tcourseid.setForeground(Color.WHITE);
			lab_tcourseid.setOpaque(false);
			lab_tcourseid.setFont(new Font("����", Font.BOLD, 15));
			label_scoreadd.add(lab_tcourseid);
			
		    txt_tcourseid = new JTextField(20);
		    txt_tcourseid.setBounds(140,120,140,30);
		    txt_tcourseid.setForeground(Color.WHITE);
		    txt_tcourseid.setOpaque(false);
		    txt_tcourseid.setFont(new Font("����", Font.BOLD, 15));
			label_scoreadd.add(txt_tcourseid);
			
			lab_tid_addscore=new JLabel("ѧ�ţ�",JLabel.CENTER);
			lab_tid_addscore.setBounds(50,170,70,30);
			lab_tid_addscore.setForeground(Color.WHITE);
			lab_tid_addscore.setOpaque(false);
			lab_tid_addscore.setFont(new Font("����", Font.BOLD, 17));
			label_scoreadd.add(lab_tid_addscore);
			
			txt_tid_addscore = new JTextField(20);
			txt_tid_addscore.setBounds(140,170,140,30);
			txt_tid_addscore.setForeground(Color.WHITE);
			txt_tid_addscore.setOpaque(false);
			txt_tid_addscore.setFont(new Font("����", Font.BOLD, 17));
			label_scoreadd.add(txt_tid_addscore);
			
			lab_tscore=new JLabel("�ɼ���",JLabel.CENTER);
			lab_tscore.setBounds(50,220,70,30);
			lab_tscore.setForeground(Color.WHITE);
			lab_tscore.setOpaque(false);
			lab_tscore.setFont(new Font("����", Font.BOLD, 17));
			label_scoreadd.add(lab_tscore);
			
			txt_tscore = new JTextField(20);
			txt_tscore.setBounds(140,220,140,30);
			txt_tscore.setForeground(Color.WHITE);
			txt_tscore.setOpaque(false);
			txt_tscore.setFont(new Font("����", Font.BOLD, 17));
			label_scoreadd.add(txt_tscore);
			
			
			btn_treset_score = new JButton("����");
			btn_treset_score.setContentAreaFilled(false);
			btn_treset_score.setForeground(Color.WHITE);
			btn_treset_score.addActionListener(this);
			btn_treset_score.setBounds(80,66,90,30);
			label_scoreadd.add(btn_treset_score);
			
			btn_taddscore = new JButton("����");
			btn_taddscore.setContentAreaFilled(false);
			btn_taddscore.setForeground(Color.WHITE);
			btn_taddscore.addActionListener(this);
			btn_taddscore.setBounds(200,66,90,30);
			label_scoreadd.add(btn_taddscore);
			
			
			
		btn_treset_info = new JButton("����");  
		btn_treset_info.setContentAreaFilled(false);
		btn_treset_info.setForeground(Color.WHITE);
		btn_treset_info.addActionListener(this);
		btn_treset_info.setBounds(80,66,90,30);
		
		label_s.add(btn_treset_info);
		
		btn_tsend_info = new JButton("����");
		btn_tsend_info.setContentAreaFilled(false);
		btn_tsend_info.setForeground(Color.WHITE);
		btn_tsend_info.addActionListener(this);
		btn_tsend_info.setBounds(200,66,90,30);
		label_s.add(btn_tsend_info);
	    
	    label_sinfo = new JLabel();
	    label_sinfo.setBounds(5,5,400,298);
	    label_sinfo.setFont(new Font("����", Font.PLAIN, 15));
	    label_sinfo.setForeground(Color.WHITE);
	    
	    
	    
	    label_classnum = new JLabel();
	    label_classnum.setBounds(5,5,400,298);
	    label_classnum.setFont(new Font("����", Font.PLAIN, 15));
	    label_classnum.setOpaque(false);
	    label_classnum.setForeground(Color.WHITE);
	    
		labelyouxiu=new JLabel("��������(90~100)");
		labellianghao=new JLabel("��������(80~90)");
		labelzhongdeng=new JLabel("�е�����(70~80)");
		labeljige=new JLabel("��������(60~70)");
		labelbujige=new JLabel("����������(<60)");
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
		labelyouxiu.setBounds(110,100,120,20);
		labellianghao.setBounds(110,140,120,20);
		labelzhongdeng.setBounds(110,180,120,20);
		labeljige.setBounds(110,220,120,20);
		labelbujige.setBounds(110,260,120,20);
		labelyouxiu.setFont(new Font("����", Font.BOLD, 13));
		labelyouxiu.setForeground(Color.WHITE);
		labellianghao.setFont(new Font("����", Font.BOLD, 13));
		labellianghao.setForeground(Color.WHITE);
		labelzhongdeng.setFont(new Font("����", Font.BOLD, 13));
		labelzhongdeng.setForeground(Color.WHITE);
		labeljige.setFont(new Font("����", Font.BOLD, 13));
		labeljige.setForeground(Color.WHITE);
		labelbujige.setFont(new Font("����", Font.BOLD, 13));
		labelbujige.setForeground(Color.WHITE);
		youxiu.setBounds(230,100,60,20);
		lianghao.setBounds(230,140,60,20);
		zhongdeng.setBounds(230,180,60,20);
		jige.setBounds(230,220,60,20);
		bujige.setBounds(230,260,60,20);
		youxiu.setOpaque(false);
		youxiu.setFont(new Font("����", Font.PLAIN, 13));
		youxiu.setForeground(Color.WHITE);
		lianghao.setOpaque(false);
		lianghao.setFont(new Font("����", Font.PLAIN, 13));
		lianghao.setForeground(Color.WHITE);
		zhongdeng.setOpaque(false);
		zhongdeng.setFont(new Font("����", Font.PLAIN, 13));
		zhongdeng.setForeground(Color.WHITE);
		jige.setOpaque(false);
		jige.setFont(new Font("����", Font.PLAIN, 13));
		jige.setForeground(Color.WHITE);
		bujige.setOpaque(false);
		bujige.setFont(new Font("����", Font.PLAIN, 13));
		bujige.setForeground(Color.WHITE);
		label_classnum.add(labelyouxiu);
		label_classnum.add(labellianghao);
		label_classnum.add(labelzhongdeng);
		label_classnum.add(labeljige);
		label_classnum.add(labelbujige);
		label_classnum.add(youxiu);
		label_classnum.add(lianghao);
		label_classnum.add(zhongdeng);
		label_classnum.add(jige);
		label_classnum.add(bujige);
		
		
		
		
	    
		show=new JTextArea(100,60);
		
		show.setBounds(0,0,397,340);
		show.setEditable(false);
		show.setLineWrap(true);
		show.setOpaque(false);
		show.setFont(new Font("����", Font.PLAIN, 15));
		show.setForeground(Color.WHITE);
		
		JScrollPane jsc = new JScrollPane(show);
		
		jsc.setBounds(0,10,397,340);
		label_sinfo.add(jsc);
		jsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsc.getViewport().setOpaque(false);
		jsc.setOpaque(false);
		
	    
	    label_ranking = new JLabel();
	    label_ranking.setBounds(5,5,400,298);
	    label_ranking.setFont(new Font("����", Font.PLAIN, 15));
	    label_ranking.setForeground(Color.WHITE);
	    
		show_ranking=new JTextArea(100,60);
		show_ranking.setBounds(0,60,400,300);
		show_ranking.setEditable(false);
		show_ranking.setLineWrap(true);
		show_ranking.setOpaque(false);
		show_ranking.setFont(new Font("����",Font.PLAIN , 15));
		show_ranking.setForeground(Color.WHITE);
		
		show_rankingt=new JTextArea(100,60);
		show_rankingt.setBounds(0,60,400,300);
		show_rankingt.setEditable(false);
		show_rankingt.setLineWrap(true);
		show_rankingt.setOpaque(false);
		show_rankingt.setFont(new Font("����",Font.PLAIN , 15));
		show_rankingt.setForeground(Color.WHITE);
		JScrollPane jsc2 = new JScrollPane(show_ranking);
		jsc2.setBounds(0,60,400,300);
		jsc2.setOpaque(false);
		jsc2.getViewport().setOpaque(false);
		jsc2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane jsc3 = new JScrollPane(show_rankingt);
		jsc3.setBounds(0,60,400,300);
		jsc3.setOpaque(false);
		jsc3.getViewport().setOpaque(false);
		label_ranking.add(jsc3);
		jsc3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsc3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		label_sbul = new JLabel();
		label_sbul.setBounds(5,5,400,298);
		label_sbul.setFont(new Font("����", Font.PLAIN, 15));
		label_sbul.setForeground(Color.WHITE);
		label_sbul.setOpaque(false);
	    label_sbul.add(jsc2);
	    
		btn_add_sbul = new JButton("���");
		btn_add_sbul.addActionListener(this);
		btn_add_sbul.setBounds(300, 15, 104, 30);
		btn_add_sbul.setContentAreaFilled(false);
		btn_add_sbul.setForeground(Color.WHITE);
		label_sbul.add(btn_add_sbul);
		
		txt_add_sbul = new JTextField();
		txt_add_sbul.setBounds(76, 15, 360, 30);
		txt_add_sbul.setFont(new Font("����", Font.PLAIN, 15));
	    txt_add_sbul.setForeground(Color.WHITE);
	    txt_add_sbul.setOpaque(false);
		label_sbul.add(txt_add_sbul);
		txt_add_sbul.setColumns(10);
		
		txt_num_sbul = new JTextField();
		txt_num_sbul.setBounds(0, 15, 76, 30);
		txt_num_sbul.setFont(new Font("����", Font.PLAIN, 15));
	    txt_num_sbul.setForeground(Color.WHITE);
	    txt_num_sbul.setOpaque(false);
		label_sbul.add(txt_num_sbul);
		txt_num_sbul.setColumns(10);
	
		
		lab_con_sbul = new JLabel("����");
		lab_con_sbul.setBounds(446, 15, 36, 30);
		lab_con_sbul.setFont(new Font("����", Font.PLAIN, 15));
	    lab_con_sbul.setForeground(Color.WHITE);
	    lab_con_sbul.setOpaque(false);
		label_sbul.add(lab_con_sbul);
		
		
	    label_serinfo = new JLabel();
	    label_serinfo.setBounds(5,5,400,298);
	    label_serinfo.setFont(new Font("����", Font.PLAIN, 15));
	    label_serinfo.setForeground(Color.WHITE);
	    label_serinfo.setOpaque(false);
	    
		lab_sid.setBounds(80,25,123,20);
		lab_sid.setForeground(Color.WHITE);
		lab_sid.setFont(new Font("����", Font.PLAIN, 15));
		lab_sid.setOpaque(false);
		label_serinfo.add(lab_sid);
		txt_sid.setBounds(60,55,140,20);
		txt_sid.setForeground(Color.WHITE);
		txt_sid.setFont(new Font("����", Font.PLAIN, 15));
		txt_sid.setOpaque(false);
		label_serinfo.add(txt_sid);
		btn_tquery.setBounds(215,55,90,20);
		btn_tquery.setContentAreaFilled(false);
		btn_tquery.setForeground(Color.WHITE);
		btn_tquery.setFont(new Font("����", Font.PLAIN, 15));
		btn_tquery.addActionListener(this);
		label_serinfo.add(btn_tquery);
		
		lab_sname.setBounds(70,100,70,20);
		lab_sname.setFont(new Font("����", Font.PLAIN, 15));
		lab_sname.setForeground(Color.WHITE);
		lab_sname.setOpaque(false);
		label_serinfo.add(lab_sname);
		txt_sname.setBounds(180,100,140,20);
		txt_sname.setFont(new Font("����", Font.PLAIN, 15));
	    txt_sname.setForeground(Color.WHITE);
	    txt_sname.setOpaque(false);
	    txt_sname.setEditable(false);
		label_serinfo.add(txt_sname);
		lab_ssex.setBounds(70,140,70,20);
		lab_ssex.setFont(new Font("����", Font.PLAIN, 15));
		lab_ssex.setForeground(Color.WHITE);
		lab_ssex.setOpaque(false);
		label_serinfo.add(lab_ssex);
		txt_ssex.setBounds(180,140,140,20);
		txt_ssex.setFont(new Font("����", Font.PLAIN, 15));
		txt_ssex.setForeground(Color.WHITE);
		txt_ssex.setOpaque(false);
		txt_ssex.setEditable(false);
		label_serinfo.add(txt_ssex);
		lab_sage.setBounds(70,180,70,20);
		lab_sage.setFont(new Font("����", Font.PLAIN, 15));
		lab_sage.setForeground(Color.WHITE);
		lab_sage.setOpaque(false);
		label_serinfo.add(lab_sage);
		txt_sage.setBounds(180,180,140,20);
		txt_sage.setFont(new Font("����", Font.PLAIN, 15));
		txt_sage.setForeground(Color.WHITE);
		txt_sage.setOpaque(false);
		txt_sage.setEditable(false);
		label_serinfo.add(txt_sage);
        lab_sclass.setBounds(70,220,70,20);
        lab_sclass.setFont(new Font("����", Font.PLAIN, 15));
        lab_sclass.setForeground(Color.WHITE);
        lab_sclass.setOpaque(false);
        label_serinfo.add(lab_sclass);
		txt_sclass.setBounds(180,220,140,20);
		txt_sclass.setFont(new Font("����", Font.PLAIN, 15));
	    txt_sclass.setForeground(Color.WHITE);
	    txt_sclass.setOpaque(false);
	    txt_sclass.setEditable(false);
		label_serinfo.add(txt_sclass);
		label_smajor.setBounds(70,260,70,20);
		label_smajor.setFont(new Font("����", Font.PLAIN, 15));
		label_smajor.setForeground(Color.WHITE);
		label_smajor.setOpaque(false);
		label_serinfo.add(label_smajor);
		txt_smajor.setBounds(180,260,140,20);
		txt_smajor.setFont(new Font("����", Font.PLAIN, 15));
		txt_smajor.setForeground(Color.WHITE);
		txt_smajor.setOpaque(false);
		txt_smajor.setEditable(false);
		label_serinfo.add(txt_smajor);  
	
		
	    lab_info.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		lab_right.removeAll();
	    		lab_imagelog.add(lab_right);
	    		lab_right.add(label_s);
	    		repaint();
	    	}
		});
	    lab_info2.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		// TODO Auto-generated method stub
	    		lab_right.removeAll();
	    		lab_imagelog.add(lab_right);
	    		lab_right.add(label_s);
	    		repaint();
	    	}
		});
	}
	
	
	
	
	public void actionPerformed(ActionEvent ee){
    	if(ee.getSource()==btn_scancel){      
    		dispose();
    	}
    	if(ee.getSource()==btn_treset_info){         
			   txt_tid.setText(null);
			   txt_tinfo.setText(null);
 	}
       	if(ee.getSource()== btn_tsend_info){                 //����
    		 try {
    			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
    			ip,Database_name,Data_password);
    			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
    			 Statement stmt = connect.createStatement();
    			 ResultSet rs1 = stmt.executeQuery("select* from student where id = '"+txt_tid.getText()+"'");
	             if(rs1.next())
	             {
	            	 
	            	 stmt.execute("insert ignore into info(stuid,info,teaid)values('"+txt_tid.getText()+"','"+txt_tinfo.getText()+"','"+id1+"')");
	    			 //user Ϊ��������
	    				JOptionPane.showMessageDialog(null, "���ͳɹ�", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
	    				txt_tid.setText(null);
	    				txt_tinfo.setText(null);
	            	 }
	             else
	             {
	            	 JOptionPane.showMessageDialog(null, "��ѧ�������ڣ�����������", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
	             }
    			
    			 }
    		 
    		 
    			 catch (Exception e) {
    			 System.out.print("get data error!");
    			 e.printStackTrace();
    			 }
    	}
    	
    	if(ee.getSource()==btn_sinfoser){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_serinfo);
    		repaint();
    	}
    	if(ee.getSource()==btn_tquery){            //��ѯ����
	   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();
   			 ResultSet rs = stmt.executeQuery("select * from student where student.id = '"+txt_sid.getText()+"'");
   			 //user Ϊ��������
   			if (rs.next()) {
    				 txt_sname.setText(rs.getString("name"));
    				 txt_ssex.setText(rs.getString("sex"));
    				 txt_smajor.setText(rs.getString("major"));
    				 txt_sage.setText(rs.getString("age"));
    				 txt_sclass.setText(rs.getString("class"));
   			 }
   			else{
   				JOptionPane.showMessageDialog(null, "��ѧ�������ڣ�����������", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
   			}
   			 }
   		 
   		 
   			 catch (Exception e) {
   			 System.out.print("get data error!");
   			 e.printStackTrace();
   			 }
		}
    	if(ee.getSource()==btn_scoreadd){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_scoreadd);
    		repaint();
    	}
    	if(ee.getSource()== btn_taddscore){                 //���
	   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();
   			 ResultSet rs = stmt.executeQuery("select * from student where id = '"+txt_tid_addscore.getText()+"' ");
   			 //user Ϊ��������
   			if (rs.next()) {
   			 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   		   			 ip,Database_name,Data_password);
   		   			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
   		   			 Statement stmt2 = connect2.createStatement();
   		   			 ResultSet rs2 = stmt2.executeQuery("select * from course where courseid = '"+txt_tcourseid.getText()+"' ");
   				stmt.execute("update sc set score = '"+txt_tscore.getText()+"' where stuid = '"+txt_tid_addscore.getText()+"' and courseid = '"+txt_tcourseid.getText()+"'");
   				if(rs2.next())
   				{
   				JOptionPane.showMessageDialog(null,"��ӳɹ�", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
   				
   				}
   			 }
   			else{
   				JOptionPane.showMessageDialog(null, "�γ̺Ż�ѧ���Ŵ�������������", "��ܰ��ʾ", JOptionPane.INFORMATION_MESSAGE);
   			}
   			 }
   		 
   		 
   			 catch (Exception e) {
   			 System.out.print("get data error!");
   			 e.printStackTrace();
   			 }
	   		txt_tid_addscore.setText(null);
	   		txt_tscore.setText(null);
	   		txt_tcourseid.setText(null);
   	}
    	if(ee.getSource()==btn_treset_score){             //����
	   		txt_tid_addscore.setText(null);
	   		txt_tscore.setText(null);
	   		txt_tcourseid.setText(null);
 	}
    	if(ee.getSource()==btn_scrser){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_classnum);
    		JComboBox comboBox = new JComboBox();

   		 try {
   			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
   			 ip,Database_name,Data_password);
   			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
   			 Statement stmt = connect.createStatement();

   				 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from tc where teacherid = '"+id1+"')");
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

   		comboBox.setBounds(135, 45, 110, 21);
   		label_classnum.add(comboBox);
		 try {
				 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				ip,Database_name,Data_password);
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt1 = connect1.createStatement();

					 	 ResultSet rs1 = stmt1.executeQuery("select score from sc where courseid = '"+copy[0]+"'");
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
   					ip,Database_name,Data_password);
   					 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
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
    		repaint();
    	}
    	if(ee.getSource()==btn_score){      
    		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sinfo);
   		 try {
   			    show.setText(null);
				show.append("�γ̺�");
				show.append("            ");
				show.append("�γ���");
				show.append("               ");
				show.append("ƽ����");
				show.append("\n");
				
			 
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,Database_name,Data_password);
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();

				 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from tc where teacherid = '"+id1+"')");
				 	 while(rs1.next())
				 	 {
							show.append(rs1.getString("courseid"));
							show.append("            ");
							show.append(rs1.getString("course"));
							show.append("            ");
							Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									 ip,Database_name,Data_password);
									 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
									 Statement stmt1 = connect1.createStatement();

									 ResultSet rs12 = stmt1.executeQuery("select AVG(score) from superinfo.sc where courseid = ' "+rs1.getString("courseid")+" '  ");
									// System.out.print(rs12.toString());
									 rs12.first();
									 System.out.print(rs12.getString(1));
									 //System.out.print(rs12.getString("AVG(score)"));
							show.append(rs12.getString(1));
							show.append("\n");
				 	 }
			
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
			
    		repaint();
    	}
    	if(ee.getSource()==btn_srank){      
      		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_ranking);
    		
			JComboBox comboBox = new JComboBox();

			 try {
				 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				 ip,Database_name,Data_password);
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt = connect.createStatement();

					 	 ResultSet rs1 = stmt.executeQuery("select* from course where course.courseid in( select courseid from tc where teacherid = '"+id1+"')");
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

			comboBox.setBounds(50, 20, 119, 21);
			//comboBox.setSelectedItem(a[0]);
			label_ranking.add(comboBox);
			 try {
				 show_rankingt.setText(null);
				 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
				ip,Database_name,Data_password);
				 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
				 Statement stmt1 = connect1.createStatement();

				 show_rankingt.append("  ");
				 show_rankingt.append("ѧ��");
				 show_rankingt.append("                    ");
				 show_rankingt.append("����");
			 		show_rankingt.append("\n");
					 	 ResultSet rs1 = stmt1.executeQuery("select* from sc where courseid = '"+copy[0]+"' order by score desc");
					 	 while(rs1.next())
					 	 {
							 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
									ip,Database_name,Data_password);
									 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
									 Statement stmt2 = connect2.createStatement();

										 	 ResultSet rs2 = stmt2.executeQuery("select name from student where id = '"+rs1.getString("stuid")+"' ");
										 	 if(rs2.next())
										 	 {
										 		show_rankingt.append("  ");
										 		show_rankingt.append(rs2.getString("name"));
										 		show_rankingt.append("                    ");
										 		show_rankingt.append(rs1.getString("score"));
										 		show_rankingt.append("\n");
										 	 }

					 	 }
				
			 }
			 
			 
			 
				 catch (Exception e) {
				 System.out.print("get data error!");
				 e.printStackTrace();
				 }
			
			

			comboBox.addItemListener(new ItemListener() {
				
				public void itemStateChanged(ItemEvent evt) {
					if(evt.getStateChange() == evt.SELECTED)
					{
					 s=evt.getItem().toString();
					for(int j=0;j<=i;j++)
					{
						if(a[j] == s)
						{
							courseid = copy[j];
						}
					}
					 try {
						 show_rankingt.setText(null);
						 Connection connect1 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
						ip,Database_name,Data_password);
						 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
						 Statement stmt1 = connect1.createStatement();

						 show_rankingt.append("  ");
						 show_rankingt.append("ѧ��");
						 show_rankingt.append("                    ");
						 show_rankingt.append("����");
						 show_rankingt.append("\n");
							 	 ResultSet rs1 = stmt1.executeQuery("select* from sc where courseid = '"+courseid+"' order by score desc");
							 	 while(rs1.next())
							 	 {
									 Connection connect2 = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
											ip,Database_name,Data_password);
											 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
											 Statement stmt2 = connect2.createStatement();

												 	 ResultSet rs2 = stmt2.executeQuery("select name from student where id = '"+rs1.getString("stuid")+"' ");
												 	 if(rs2.next())
												 	 {
												 		show_rankingt.append("  ");
												 		show_rankingt.append(rs2.getString("name"));
														 show_rankingt.append("                    ");
												 		show_rankingt.append(rs1.getString("score"));
												 		show_rankingt.append("\n");
												 	 }
	    
							 	 }
						
					 }
					 
					 
					 
						 catch (Exception e) {
						 System.out.print("get data error!");
						 e.printStackTrace();
						 }
					}
				}
			});
			
			
			
    		repaint();
    	}
    	if(ee.getSource()==btn_sbul){      
      		lab_right.removeAll();
    		lab_imagelog.add(lab_right);
    		lab_right.add(label_sbul);
    		
   		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,Database_name,Data_password);
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
     
			 
			 ResultSet rs = stmt.executeQuery("select* from bulletin");
			// String s = rs.toString();
			 //user Ϊ��������
			while (rs.next()) {
				show_ranking.append(rs.getString("id"));
				show_ranking.append("         ");
				show_ranking.append(rs.getString("content"));
				show_ranking.append("\n");
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
    		repaint();
    	}

	
	if(ee.getSource()==btn_add_sbul){      
		 try {
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			ip,Database_name,Data_password);
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
             ResultSet rs1 = stmt.executeQuery("select* from bulletin where id = '"+txt_num_sbul.getText()+"'");
             if(rs1.next())
             {
            	 JOptionPane.showMessageDialog(null,"�ù����Ѵ��ڣ���������","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
             }
             else{
            	 stmt.execute("insert ignore into bulletin(id,content)values('"+txt_num_sbul.getText()+"','"+txt_add_sbul.getText()+"')");
            	 JOptionPane.showMessageDialog(null,"��������ɹ�","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
			     //user Ϊ��������
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
   		lab_right.removeAll();
 		lab_imagelog.add(lab_right);
 		lab_right.add(label_sbul);
  		 try {
  			 show_ranking.setText(null);
			 Connection connect = DriverManager.getConnection(// http://1f746286.ngrok.io/myapp/index.jsp
			 ip,Database_name,Data_password);
			 //����URLΪ jdbc:mysql//��������ַ/���ݿ��� �������2�������ֱ��ǵ�½�û���������</p> <p> System.out.println("Success connect Mysql server!");
			 Statement stmt = connect.createStatement();
    
			 
			 ResultSet rs = stmt.executeQuery("select* from bulletin");
			// String s = rs.toString();
			 //user Ϊ��������
			while (rs.next()) {
				show_ranking.append(rs.getString("id"));
				show_ranking.append("         ");
				show_ranking.append(rs.getString("content"));
				show_ranking.append("\n");
			 }
		 }
		 
		 
			 catch (Exception e) {
			 System.out.print("get data error!");
			 e.printStackTrace();
			 }
 		repaint();
	}

	}
}

