import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import data.dataInsert;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Jintuihuo extends JFrame implements ActionListener {
	
	java.util.Timer timer=new java.util.Timer();    //1.��ʱ��
	
	private JLabel l1=new JLabel("���");
	private JLabel l2=new JLabel("ʱ�䣺");  
	private JLabel l3=new JLabel("�Ƶ��ˣ�");
	private JLabel l4=new JLabel("��Ʒ��ţ�");
	private JLabel l5=new JLabel("������");
	private JLabel l6=new JLabel("�������ۣ�");
	private JLabel l7=new JLabel("��ע��");
	
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();


	String    str1[ ]={"����","�˻�"};
	JComboBox   cb1=new JComboBox(str1);
	String    str2[ ]={"ţ����","���Ի�","������"};
	JComboBox   cb2=new JComboBox(str2);
	private JTextField f1=new JTextField(15);
	private JTextField f2=new JTextField(7);
	private JTextField f3=new JTextField(7);
	private JTextField f4=new JTextField(7);
	private JTextField f5=new JTextField(35);
	
	private JScrollPane spane=new JScrollPane();	    //������������
	DefaultTableModel model=new DefaultTableModel();     //���ģ��
	private JTable table=new JTable();              //new һ�������󣬿ձ�	
	Vector lieming=new Vector();              //����lieming, ��ű����⣨��ͷ��
	Vector vdata=new Vector();             //����vdata,��ű��������	
	
	private JButton b1=new JButton("ȷ��");
	private JButton b3=new JButton("ɾ��");
	private JButton b2=new JButton("����");
	private JButton b4=new JButton("�ύ");
	private JButton b5=new JButton("��ѯ");
	
	Jintuihuo(){
		this.setTitle("���˻�����");		
	    this.setBounds(100,100, 1000,600);
		this.setLayout(null);
		this.add(p1);
		this.add(p2);
		this.setLayout(new BorderLayout(5,5));
		
		
		p1.add(l1);
		p1.add(cb1);
		p1.add(l2);
		p1.add(f1);
		p1.add(l3);
		p1.add(cb2);
		p1.add(l4);
		p1.add(f2);
		p1.add(l5);
		p1.add(f3);
		p1.add(l6);
		p1.add(f4);
		p2.add(l7);
	    p2.add(f5);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		f5.setBounds(50,10, 500, 500);
		f5.setFont(new Font(null,Font.PLAIN,25 ));
		
		lieming.add("��Ʒ���");
		lieming.add("��Ʒ����");
		lieming.add("����");
		lieming.add("������");
		lieming.add("����");
		lieming.add("���");
		lieming.add("��ע");
		
		p1.setLayout(new GridLayout(2,1));
		//p1.setLayout(new FlowLayout(10,10,50));
		p2.setLayout(new GridLayout(1,1));
	
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
		
			this.add(spane);
			spane.setViewportView(table);
			spane.setBounds(200,30,280,80);
			model.setColumnIdentifiers(lieming);     //�滻ģ���е��б�ʶ��
			table.setModel(model);	
		
	    timer.schedule(new RemindTask(), 0, 1000);      //2.��ʱ���ļƻ�����
		
	    b1.addActionListener(this);
		b2.addActionListener(this);	
		b3.addActionListener(this);
		b4.addActionListener(this);	
		b5.addActionListener(this);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	class RemindTask extends TimerTask {
         public void run() {
             f1.setText(GetTime.getTime());	  
         }
     }

	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɷ������
		Object b=arg0.getSource();
		if(b==b1){
			Vector vdata1=new Vector();
			vdata1.add(f1.getText());
			vdata1.add(cb1.getSelectedItem());
			vdata1.add(f2.getText());
			vdata1.add(f4.getText());
			vdata1.add(f5.getText());
			
			vdata.add(vdata1);
			model.addRow(vdata1);
			
			
			
			
		}
		else if(b==b2){
			vdata.remove(table.getSelectedRow());
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			
		}
		else if(b==b3){
			f1.setText(null);
			f2.setText(null);
			cb1.setSelectedItem(null);			
			f4.setText(null);
			f5.setText(null);		
		
			
			vdata.removeAllElements();
			table=new JTable(vdata,lieming);
			spane.setViewportView(table);
			model.removeRow(table.getSelectedRow());
			
			
			
			
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
	
			
			
			
		
		else if(b==b5){
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	public static void main(String[] args) {
		// TODO �Զ����ɷ������
		new Jintuihuo();
	}

}

//ʱ���ʽת��
class GetTime {
	 
   public GetTime() {
   	
   }
   
  public static String getTime() {    //�õ���ǰʱ��
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
