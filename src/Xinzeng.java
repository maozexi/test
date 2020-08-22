import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import data.*;

public class Xinzeng extends JDialog implements ActionListener {
	
	private JLabel label1=new JLabel("商品编码：");
	private JLabel label2=new JLabel("条形码：");
	private JLabel label3=new JLabel("类别编号：");
	private JLabel label4=new JLabel("商品名称：");
	private JLabel label5=new JLabel("零售价（元）：");
	private JLabel label6=new JLabel("商品规格：");
	private JLabel label7=new JLabel("计量单位：");
	private JLabel label8=new JLabel("进货价：");
	private JLabel label9=new JLabel("保质期（天）：");
	private JLabel label10=new JLabel("备注：");
	
	private JTextField field1=new JTextField(15);
	private JTextField field2=new JTextField(15);
	
	String    str1[ ]={"生鲜类","电器类","礼品类","日用品","蔬菜类","食品类"};
	JComboBox   cb1=new JComboBox(str1);
	   
	private JTextField field4=new JTextField(15);
	private JTextField field5=new JTextField(15);
	private JTextField field6=new JTextField(15);
	private JTextField field7=new JTextField(15);
	private JTextField field8=new JTextField(15);
	private JTextField field9=new JTextField(15);
	private JTextField field10=new JTextField(15);
	
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JButton b1=new JButton("添加");
	private JButton b2=new JButton("重置");
	private JButton b3=new JButton("删除");
	private JButton b4=new JButton("提交");
	
	private JScrollPane spane=new JScrollPane();	    //带滚动条窗口
	DefaultTableModel model=new DefaultTableModel();     //表格模型
	private JTable table=new JTable();              //new 一个表格对象，空表	
	Vector lieming=new Vector();              //容器lieming, 存放表格标题（表头）
	Vector vdata=new Vector();             //容器vdata,存放表格中数据	
	
	
	Xinzeng(){
		
		this.setTitle("新增商品表");		
	    this.setBounds(200, 200, 700, 600);
		this.setLayout(null);
		
		this.add(panel1);
		this.add(panel2);
		
		this.setLayout(new BorderLayout(5,5));
		
		panel1.setLayout(new GridLayout(20,20,10,1));		
		panel1.add(label1);                 //组装panel1
		panel1.add(field1);
		panel1.add(label2);
		panel1.add(field2);
		panel1.add(label3);
		panel1.add(cb1);
		panel1.add(label4);
		panel1.add(field4);
		panel1.add(label5);
		panel1.add(field5);
		panel1.add(label6);
		panel1.add(field6);
		panel1.add(label7);
		panel1.add(field7);
		panel1.add(label8);
		panel1.add(field8);
		panel1.add(label9);
		panel1.add(field9);
		panel1.add(label10);
		panel1.add(field10);
		panel2.add(b1);
		panel2.add(b2);		
		panel2.add(b3);
		panel2.add(b4);		
		
		lieming.add("商品编号");	
		lieming.add("条形码");
		lieming.add("类别编号");
		lieming.add("商品名称");
		lieming.add("零售价");
		lieming.add("商品规格");
		lieming.add("单位");
		lieming.add("进货价");
		lieming.add("保质期");
		lieming.add("备注");

		panel2.setLayout(new FlowLayout(50,100,20));
		
		this.add(spane);
		spane.setBounds(203,30,580,60);
		model.setColumnIdentifiers(lieming);     //替换模型中的列标识符
		table.setModel(model);
		spane.setViewportView(table);
		
		
		panel1.setBounds(5,5,250,430);
		panel2.setBounds(30,250,500,500);
		this.add(panel1,BorderLayout.WEST);
		this.add(panel2,BorderLayout.SOUTH);
				
		b1.addActionListener(this);
		b2.addActionListener(this);	
		b3.addActionListener(this);
		b4.addActionListener(this);	
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
		
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成方法存根
		Object b=arg0.getSource();
		if(b==b1){						
			Vector vdata1=new Vector();
			vdata1.add(field1.getText());
			vdata1.add(cb1.getSelectedItem());
			vdata1.add(field2.getText());
			vdata1.add(field4.getText());
			vdata1.add(field5.getText());
			vdata1.add(field6.getText());
			vdata1.add(field7.getText());
			vdata1.add(field8.getText());
			vdata1.add(field9.getText());
			vdata1.add(field10.getText());
			
			vdata.add(vdata1);
			model.addRow(vdata1);
	}
		else if(b==b2){
			field1.setText(null);
			field2.setText(null);
			cb1.setSelectedItem(null);			
			field4.setText(null);
			field5.setText(null);		
			field6.setText(null);
			field7.setText(null);
			field8.setText(null);
			field9.setText(null);
			field10.setText(null);
			
			vdata.removeAllElements();
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			model.removeRow(table.getSelectedRow());
			
		
		}
		else if(b==b3){
			vdata.remove(table.getSelectedRow());
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			
		}
		
		else if(b==b4){
			int i=0,n=0,num=0;
			
			if(vdata.size()==0){
				JOptionPane.showMessageDialog(null,"没有数据可提交");
				return;
			}
			while(i<vdata.size()){
				Vector vdata1=new Vector();
				vdata1=(Vector)vdata.get(i);
				
				String cnum=vdata1.get(0).toString();
				String code=vdata1.get(1).toString();
				String knum=vdata1.get(2).toString();
				String cname=vdata1.get(3).toString();
				double price=Double.parseDouble(vdata1.get(4).toString());
				String guige=vdata1.get(5).toString();
				String danwei=vdata1.get(6).toString();
				double jinjia=Double.parseDouble(vdata1.get(7).toString());
				String baozhiqi=vdata1.get(8).toString();
				String beizhu=vdata1.get(9).toString();
		
				n=dataInsert.comdInsert(cnum,code,knum,cname,price,guige,danwei,jinjia,baozhiqi,beizhu);
				
				if(n==1)
				num++;
				i++;				
			}
			if(num==vdata.size())
				JOptionPane.showMessageDialog(this,"成功添加");	
		}
	}
	
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		new Xinzeng();
	}

}
