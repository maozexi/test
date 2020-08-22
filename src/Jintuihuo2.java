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
	java.util.Timer timer=new java.util.Timer();    //1.计时器
	private JLabel l1=new JLabel("类别：");
	private JLabel l2=new JLabel("时间：");  
	private JLabel l3=new JLabel("制单人：");
	private JLabel l4=new JLabel("商品编号：");
	private JLabel l5=new JLabel("数量：");
	private JLabel l6=new JLabel("进货单价：");
	private JLabel l7=new JLabel("仓库号：");
	private JLabel l8=new JLabel("总金额：");  
	private JLabel l9=new JLabel("经手人：");
	
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel p4=new JPanel();
	
	
	String    str1[ ]={"入库","出库"};
	JComboBox   cb1=new JComboBox(str1);
	String    str2[ ]={"牛康康"};
	JComboBox   cb2=new JComboBox(str2);
	String    str3[ ]={"CK0001"};
	JComboBox   cb3=new JComboBox(str3);
	
	private JTextField f1=new JTextField(10);
	private JTextField f2=new JTextField(10);
	private JTextField f3=new JTextField(10);
	private JTextField f4=new JTextField(10);
	private JTextField f5=new JTextField(10);
	private JTextField f6=new JTextField(10);
	
	private JScrollPane spane=new JScrollPane();	    //带滚动条窗口
	DefaultTableModel model=new DefaultTableModel();     //表格模型
	private JTable table=new JTable();              //new 一个表格对象，空表	
	Vector lieming=new Vector();              //容器lieming, 存放表格标题（表头）
	Vector vdata=new Vector();             //容器vdata,存放表格中数据	
	
	private JButton b1=new JButton("确认");
	private JButton b3=new JButton("删除");
	private JButton b2=new JButton("重置");
	private JButton b4=new JButton("提交");
	
	
	Jintuihuo2(){
		
		this.setTitle("进/出货表");		
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
		p2.setBorder(BorderFactory.createTitledBorder("货单录入"));
				
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		
		p4.setLayout(new BorderLayout());
		p4.add(p1,BorderLayout.NORTH);
		p4.add(p2);
		this.add(p3,BorderLayout.SOUTH);
		this.add(p4,BorderLayout.NORTH);
		
		
		lieming.add("编号");
		lieming.add("数量");
		lieming.add("进货价");
		lieming.add("总金额");
		lieming.add("日期");
		lieming.add("仓库号");
		lieming.add("经手人");
		lieming.add("填单人");
		
		
		this.add(spane,BorderLayout.CENTER);
		spane.setViewportView(table);
		spane.getViewport().add(table);
		spane.setBounds(200,30,280,80);
		model.setColumnIdentifiers(lieming);        //替换模型中的列标识符
		table.setModel(model);
		
	    b1.addActionListener(this);
		b2.addActionListener(this);	
		b3.addActionListener(this);
		b4.addActionListener(this);	
	
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//继承JDialog
		this.setVisible(true);		
	}
	class RemindTask extends TimerTask {
        public void run() {
            f2.setText(GetTime.getTime());	  
        }
    }
		
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成方法存根
     
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		new Jintuihuo2();
	}
	
	

}
