import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class Jintuihuo2 extends JFrame implements ActionListener {
	java.util.Timer timer=new java.util.Timer();    //1.��ʱ��
	private JLabel l1=new JLabel("���");
	private JLabel l2=new JLabel("ʱ�䣺");  
	private JLabel l3=new JLabel("�Ƶ��ˣ�");
	private JLabel l4=new JLabel("��Ʒ��ţ�");
	private JLabel l5=new JLabel("������");
	private JLabel l6=new JLabel("�������ۣ�");
	private JLabel l7=new JLabel("�ֿ�ţ�");
	private JLabel l8=new JLabel("�ܽ�");  
	private JLabel l9=new JLabel("�����ˣ�");
	
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel p4=new JPanel();
	
	
	String    str1[ ]={"���","����"};
	JComboBox   cb1=new JComboBox(str1);
	String    str2[ ]={"ţ����"};
	JComboBox   cb2=new JComboBox(str2);
	String    str3[ ]={"CK0001"};
	JComboBox   cb3=new JComboBox(str3);
	
	private JTextField f1=new JTextField(10);
	private JTextField f2=new JTextField(10);
	private JTextField f3=new JTextField(10);
	private JTextField f4=new JTextField(10);
	private JTextField f5=new JTextField(10);
	private JTextField f6=new JTextField(10);
	
	private JScrollPane spane=new JScrollPane();	    //������������
	DefaultTableModel model=new DefaultTableModel();     //���ģ��
	private JTable table=new JTable();              //new һ�������󣬿ձ�	
	Vector lieming=new Vector();              //����lieming, ��ű����⣨��ͷ��
	Vector vdata=new Vector();             //����vdata,��ű��������	
	
	private JButton b1=new JButton("ȷ��");
	private JButton b3=new JButton("ɾ��");
	private JButton b2=new JButton("����");
	private JButton b4=new JButton("�ύ");
	
	
	Jintuihuo2(){
		
		this.setTitle("��/������");		
	    this.setBounds(100,100, 1000,600);
		this.setLayout(null);
		f2.setBounds(50,10, 300, 50);
		timer.schedule(new RemindTask(), 0, 1000);
		
		
		p1.add(l1);
		p1.add(cb1);
		p1.add(l2);
		p1.add(f1);
		p1.add(l3);
		p1.add(cb2);
		p1.setLayout(new GridLayout(1,3));
		p1.setBorder(BorderFactory.createTitledBorder("")); 
		
		
		p2.add(l4);
		p2.add(f2);
		p2.add(l5);
		p2.add(f3);
		p2.add(l6);
		p2.add(f4);
		p2.add(l7);
		p2.add(cb3);
		p2.add(l8);
		p2.add(f5);
		p2.add(l9);
		p2.add(f6);
		p2.setLayout(new GridLayout(2,3));
		p2.setBorder(BorderFactory.createTitledBorder("����¼��"));
				
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		
		p4.setLayout(new BorderLayout());
		p4.add(p1,BorderLayout.NORTH);
		p4.add(p2);
		this.add(p3,BorderLayout.SOUTH);
		this.add(p4,BorderLayout.NORTH);
		
		
		lieming.add("���");
		lieming.add("����");
		lieming.add("������");
		lieming.add("�ܽ��");
		lieming.add("����");
		lieming.add("�ֿ��");
		lieming.add("������");
		lieming.add("���");
		
		
		this.add(spane,BorderLayout.CENTER);
		spane.setViewportView(table);
		spane.getViewport().add(table);
		spane.setBounds(200,30,280,80);
		model.setColumnIdentifiers(lieming);        //�滻ģ���е��б�ʶ��
		table.setModel(model);
		
	    b1.addActionListener(this);
		b2.addActionListener(this);	
		b3.addActionListener(this);
		b4.addActionListener(this);	
	
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//�̳�JDialog
		this.setVisible(true);		
	}
	class RemindTask extends TimerTask {
        public void run() {
            f2.setText(GetTime.getTime());	  
        }
    }
		
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɷ������
     
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɷ������
		new Jintuihuo2();
	}
	
	

}
