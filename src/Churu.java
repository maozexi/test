import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;
import java.util.Vector;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class Churu extends JDialog implements ActionListener {
	private JLabel l1=new JLabel("类别:");
	String str[]={"入库","出库"};
	
    private JComboBox f1=new JComboBox(str);
    private JLabel l2=new JLabel("时间:");
    private JTextField f2=new JTextField(30);
    java.util.Timer timer=new java.util.Timer();   
    private JLabel l3=new JLabel("制单人:");
    String str1[]={"牛康康","刘辉会","宋胖胖"};
    private JComboBox f3=new JComboBox(str1);
    private JLabel l4=new JLabel("商品编号:");
    private JTextField f4=new JTextField(10);
    private JLabel l5=new JLabel("数量:");
    private JTextField f5=new JTextField(10);
    private JLabel l6=new JLabel("进货单价:");
    private JTextField f6=new JTextField(10);
    private JLabel l7=new JLabel("仓库号:");
    String str2[]={"CK0001","CK0002"};
    private JComboBox f7=new JComboBox(str2);
    private JLabel l8=new JLabel("总金额");
    private JTextField f8=new JTextField(10);
    private JLabel l9=new JLabel("经手人");
    private JTextField f9=new JTextField(10);
    
    private JButton b1=new JButton("确认");
    private JButton b2=new JButton("删除");
    private JButton b3=new JButton("重置");
    private JButton b4=new JButton("提交");
    
    private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private JPanel p3=new JPanel();
	private JPanel p4=new JPanel();
	
	private JScrollPane spane=new JScrollPane();	    //带滚动条窗口
	DefaultTableModel model=new DefaultTableModel();     //表格模型
	private JTable table=new JTable();              //new 一个表格对象，空表	
	Vector lieming=new Vector();              //容器lieming, 存放表格标题（表头）
	Vector vdata=new Vector();             //容器vdata,存放表格中数据	
	Churu(){
		this.setBounds(20, 20,1250, 700);
		this.setTitle("出库入库");
		this.setLayout(new BorderLayout());
		
		f2.setBounds(50,10, 300, 50);
		f2.setFont(new Font(null,Font.PLAIN,25 ));
		timer.schedule(new RemindTask(), 0, 1000);
		p1.add(l1);
		p1.add(f1);
		p1.add(l2);
		p1.add(f2);
		p1.add(l3);
		p1.add(f3);
		p1.setLayout(new GridLayout(1,3));
		//p1.setBorder(BorderFactory.createTitledBorder(""));
		
		p2.add(l4);
		p2.add(f4);
		p2.add(l5);
		p2.add(f5);
		p2.add(l6);
		p2.add(f6);
		p2.add(l7);
		p2.add(f7);
		p2.add(l8);
		p2.add(f8);
		p2.add(l9);
		p2.add(f9);
		p2.setLayout(new GridLayout(2,3));
		p2.setBorder(BorderFactory.createTitledBorder("货单录入"));
		
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p4.setLayout(new BorderLayout());
		p4.add(p1,BorderLayout.NORTH);
		p4.add(p2);
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
		spane.setBounds(170, 30, 600, 400);
		model.setColumnIdentifiers(lieming);     //替换模型中的列标识符
		table.setModel(model);
		
		this.add(p3,BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//继承JDialog
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);继承JFrame
		this.setVisible(true);
	}
	  class RemindTask extends TimerTask {
	        public void run() {
	            f2.setText(GetTime.getTime());        	  
	        }
	    } 
	public void actionPerformed(ActionEvent x) {
		// TODO 自动生成方法存根
		Object b=x.getSource();
		if(b==b1){//添加
			Vector v=new Vector();
			v.add(f4.getText());
			v.add(f5.getText());
			v.add(f6.getText());
			v.add(f8.getText());
			v.add(f2.getText());
			v.add(f7.getSelectedItem());
			v.add(f9.getText());
			v.add(f3.getSelectedItem());

			System.out.print(v.size());
			vdata.add(v);
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			//model.addRow(v);
			}
		if(b==b2){//删除
			//model.removeRow(table.getSelectedRow());
			vdata.remove(table.getSelectedRow());
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			
			
		}
		if(b==b3){//重置
			f1.setSelectedItem(null);
			f2.setText(null);
			f3.setSelectedItem(null);
			f4.setText(null);
			f5.setText(null);
			f6.setText(null);
			f7.setSelectedItem(null);
			f8.setText(null);
			f9.setText(null);
			vdata.removeAllElements();
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			
		}
		if(b==b4){//提交
        	
        	//dataInsert.table_insert(Integer.parseInt(f1.getText()),f2.getText(),f3.getText(),(String)cb.getSelectedItem(),Double.parseDouble(f4.getText()),f5.getText(),f6.getText(),Double.parseDouble((f7.getText())),f8.getText(),f9.getText());	
        	int i=0,m=0,num=0;
        	if(vdata.size()==0){
        		JOptionPane.showMessageDialog(this, "没有信息可提交");
        		return;
        	}
        	while(i<vdata.size()){
        		Vector vdata1=new Vector();
        		vdata1= (Vector)vdata.get(i);
        		
        	    //int foodbianma=Integer.parseInt(vdata.get(0).toString());
        		double q=Double.parseDouble(vdata1.get(0).toString());
        		double w=Double.parseDouble(vdata1.get(1).toString());
        		double e=Double.parseDouble(vdata1.get(2).toString());
        		double r=Double.parseDouble(vdata1.get(3).toString());
        		String t=(String)vdata1.get(4);
        	    String y=(String) vdata1.get(5);
        		String u=(String)vdata1.get(6);
        		String o=(String)vdata1.get(7);


				//int n = data3.addgoodsInsert(q, w, e, r, t, y, u, o);

				//if(n==1)
        			num++;
        		i++;
        		}
        	
        			if(num==vdata.size())
        				//System.out.print("成功添加 ");
        			JOptionPane.showMessageDialog(this, "成功添加 ");
		}
			
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		new Churu();
	}

}
class qwer{
	 
    public qwer() {
    	
    }
    
   public static String getTime() {    //得到当前时间
        Date date1 = new Date();
        Calendar objcalendar;
        String time = "";
        objcalendar = Calendar.getInstance(); 
        int year = objcalendar.get(Calendar.YEAR);
        int Month = objcalendar.get(Calendar.MONTH);
        Month += 1;
        Integer Month1 = new Integer(Month);
        String Monthtos;
        if (Month < 10) {
            Monthtos = "0" + Month1.toString();
        } else {
            Monthtos = Month1.toString();
        }
        int Date = objcalendar.get(Calendar.DATE);
        Integer Date1 = new Integer(Date);
        String Datetos;
        if (Date < 10) {
            Datetos = "0" + Date1.toString();
        } else {
            Datetos = Date1.toString();
        }

        String time1 = date1.toString().substring(11, 19);
        time =year + "-" + Monthtos + "-" + Datetos + " " + time1;

        return time;

    }

}
