import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.*;
// JTree ��ʹ�÷���  ��   JToolBar ��ʹ�÷���,  JTree���ʵ����������




  public class Test extends JFrame{
	
	private JPanel contentpane=null;
	
	JToolBar jToolBar = new JToolBar();
	JButton jButton1 = new JButton();    
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    
    private JMenuBar menubar=new JMenuBar();
	private JMenu wenjian=new JMenu("�ļ�");
    private JMenu caigou=new JMenu("�ɹ�����");
    private JMenu shangpin=new JMenu("��Ʒ����");
    private JMenu zhanghu=new JMenu("�˻�����");
    private JMenu xinxi=new JMenu("��Ϣ��ѯ");
    private JMenu bangzhu=new JMenu("����");

    private JPanel panel1=new JPanel();
	
	
    private  JScrollPane jspane1=new JScrollPane();   // ����������������
	private JTree jtree1 = null; //1.������ jtree1
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("���������");
    
    
    private JScrollPane spane=new JScrollPane();	    //������������
	DefaultTableModel model=new DefaultTableModel();     //���ģ��
	private JTable table=new JTable();              //new һ�������󣬿ձ�	
	Vector lieming=new Vector();              //����lieming, ��ű����⣨��ͷ��
	Vector vdata=new Vector();             //����vdata,��ű��������	
	
	Test(){
		this.setBounds(20, 20, 1300,900);
		
		this.setJMenuBar(menubar);
		menubar.add(wenjian);
		menubar.add(caigou);
		menubar.add(shangpin);
		menubar.add(zhanghu);
		menubar.add(xinxi);
		menubar.add(bangzhu);



		this.setLayout(null);
		this.add(panel1);
		
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


		this.add(spane);
		spane.setViewportView(table);
		spane.setBounds(200,30,580,680);
		model.setColumnIdentifiers(lieming);     //�滻ģ���е��б�ʶ��
		table.setModel(model);	
		
		
		
				
		
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("���۹���");
		DefaultMutableTreeNode node2=new DefaultMutableTreeNode("������");
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("�û�����");
		DefaultMutableTreeNode node4=new DefaultMutableTreeNode("��Ϣ��ѯ");
		DefaultMutableTreeNode node5=new DefaultMutableTreeNode("��Ʒ����");
		
		DefaultMutableTreeNode node11=new DefaultMutableTreeNode("����ͳ��");    
		
		DefaultMutableTreeNode node21=new DefaultMutableTreeNode("�����Ϣ���");
		DefaultMutableTreeNode node22=new DefaultMutableTreeNode("�������Ʒ��Ų�ѯ");
		
		DefaultMutableTreeNode node31=new DefaultMutableTreeNode("����޸��û�");
		DefaultMutableTreeNode node32=new DefaultMutableTreeNode("�����˻���ѯ");
		
		DefaultMutableTreeNode node41=new DefaultMutableTreeNode("����Ʒ���Ʋ�ѯ");
		DefaultMutableTreeNode node42=new DefaultMutableTreeNode("����Ʒ��Ų�ѯ");
		DefaultMutableTreeNode node43=new DefaultMutableTreeNode("���������ѯ");
		DefaultMutableTreeNode node44=new DefaultMutableTreeNode("����Ʒ����ѯ");
		DefaultMutableTreeNode node45=new DefaultMutableTreeNode("��ʾȫ����Ʒ");
		
		DefaultMutableTreeNode node441=new DefaultMutableTreeNode("�������ѯ");
		DefaultMutableTreeNode node442=new DefaultMutableTreeNode("��Ʒ���ѯ");
		DefaultMutableTreeNode node443=new DefaultMutableTreeNode("����Ʒ��ѯ");
		DefaultMutableTreeNode node444=new DefaultMutableTreeNode("�߲����ѯ");
		DefaultMutableTreeNode node445=new DefaultMutableTreeNode("ʳƷ���ѯ");
		DefaultMutableTreeNode node446=new DefaultMutableTreeNode("�������ѯ");
		
		DefaultMutableTreeNode node51=new DefaultMutableTreeNode("�������");
		DefaultMutableTreeNode node52=new DefaultMutableTreeNode("���˻�");
		DefaultMutableTreeNode node53=new DefaultMutableTreeNode("������Ʒ");
		
		root.add(node1);        //��һ���ڵ�node1��ӵ����ĸ��ڵ�
		root.add(node2);        //��һ���ڵ�node2��ӵ����ĸ��ڵ�
		root.add(node3);
		root.add(node4);
		root.add(node5);
		
		node1.add(node11);      //�������ڵ�node11��ӵ�����һ���ڵ�node1
		node2.add(node21);
		node2.add(node22);
		node3.add(node31);
		node3.add(node32);
		node4.add(node41);
		node4.add(node42);
		node4.add(node43);
		node4.add(node45);
		node4.add(node44);
		node5.add(node51);
		node5.add(node52);
		node5.add(node53);
		
		node44.add(node441);    //�������ڵ�node44��ӵ����Ķ����ڵ�node4
		node44.add(node442);
		node44.add(node443);
		node44.add(node444);
		node44.add(node445);
		node44.add(node446);
		



		jtree1=new JTree(root);               //������jtree1,���ڵ���root
		jspane1.getViewport().add(jtree1);    //�����ӵ�����������jspane1
		jspane1.setBounds(5, 30, 200, 850);
		
		jToolBar.setBounds(new Rectangle(0, 0, 800, 29));   //���ù�����jToolBar ��λ�ã�����
		jToolBar.add(jButton1);   //����ťjButton1��ӵ�������jToolBar
	    jToolBar.add(jButton2);
		
	    
	    this.add(jToolBar, null);            //��������jToolBar �ӵ�����
	    this.add(jspane1);                   //���������Ĺ�����jspane1 �ӵ�����
	    
	    jtree1.addTreeSelectionListener(new  treeListener());//	ע������¼������λ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɷ������
		new Test();
		
		
	}
	class treeListener implements TreeSelectionListener  {

		public void valueChanged(TreeSelectionEvent e) {      //ÿ��ѡ��ֵ��������ʱ���á�
			// TODO Auto-generated method stub
			 Object obj1 = jtree1.getLastSelectedPathComponent();    //���ص�ǰѡ��ĵ�һ���ڵ��е����һ��·�����
		        String s = null;
		        if (obj1 != null) {
		            s = obj1.toString();
		            if(s.equals("������Ʒ"))
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	new Xinzeng();
					if(s.equals("�������"))
						new Churu();
					if(s.equals("���˻�"))
						new Jintuihuo();
		            else if(s.equals("����Ʒ���Ʋ�ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("����Ʒ��Ų�ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdbianhao(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		        	}
		            else if(s.equals("���������ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdtiaoxingma(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("��ʾȫ����Ʒ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	vdata=dataSelect.comdquanbu();
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("�������ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"������");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("��Ʒ���ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"��Ʒ��");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("����Ʒ��ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"����Ʒ");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("�߲����ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"�߲���");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("ʳƷ���ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"ʳƷ��");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("�������ѯ")){
		            	//JOptionPane.showMessageDialog(null, "����ͳ��"); 
		            	String name = JOptionPane.showInputDialog(this,"������");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            
		        
		}		
	}

}
	}