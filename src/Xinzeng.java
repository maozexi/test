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
	
	private JLabel label1=new JLabel("��Ʒ���룺");
	private JLabel label2=new JLabel("�����룺");
	private JLabel label3=new JLabel("����ţ�");
	private JLabel label4=new JLabel("��Ʒ���ƣ�");
	private JLabel label5=new JLabel("���ۼۣ�Ԫ����");
	private JLabel label6=new JLabel("��Ʒ���");
	private JLabel label7=new JLabel("������λ��");
	private JLabel label8=new JLabel("�����ۣ�");
	private JLabel label9=new JLabel("�����ڣ��죩��");
	private JLabel label10=new JLabel("��ע��");
	
	private JTextField field1=new JTextField(15);
	private JTextField field2=new JTextField(15);
	
	String    str1[ ]={"������","������","��Ʒ��","����Ʒ","�߲���","ʳƷ��"};
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
	private JButton b1=new JButton("���");
	private JButton b2=new JButton("����");
	private JButton b3=new JButton("ɾ��");
	private JButton b4=new JButton("�ύ");
	
	private JScrollPane spane=new JScrollPane();	    //������������
	DefaultTableModel model=new DefaultTableModel();     //���ģ��
	private JTable table=new JTable();              //new һ�������󣬿ձ�	
	Vector lieming=new Vector();              //����lieming, ��ű����⣨��ͷ��
	Vector vdata=new Vector();             //����vdata,��ű��������	
	
	
	Xinzeng(){
		
		this.setTitle("������Ʒ��");		
	    this.setBounds(200, 200, 700, 600);
		this.setLayout(null);
		
		this.add(panel1);
		this.add(panel2);
		
		this.setLayout(new BorderLayout(5,5));
		
		panel1.setLayout(new GridLayout(20,20,10,1));		
		panel1.add(label1);                 //��װpanel1
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
		
		lieming.add("��Ʒ���");	
		lieming.add("������");
		lieming.add("�����");
		lieming.add("��Ʒ����");
		lieming.add("���ۼ�");
		lieming.add("��Ʒ���");
		lieming.add("��λ");
		lieming.add("������");
		lieming.add("������");
		lieming.add("��ע");

		panel2.setLayout(new FlowLayout(50,100,20));
		
		this.add(spane);
		spane.setBounds(203,30,580,60);
		model.setColumnIdentifiers(lieming);     //�滻ģ���е��б�ʶ��
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
		// TODO �Զ����ɷ������
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
				JOptionPane.showMessageDialog(null,"û�����ݿ��ύ");
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
				JOptionPane.showMessageDialog(this,"�ɹ����");	
		}
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɷ������
		new Xinzeng();
	}

}
