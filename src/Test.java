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
// JTree 的使用方法  ，   JToolBar 的使用方法,  JTree添加实践监听方法




  public class Test extends JFrame{
	
	private JPanel contentpane=null;
	
	JToolBar jToolBar = new JToolBar();
	JButton jButton1 = new JButton();    
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    
    private JMenuBar menubar=new JMenuBar();
	private JMenu wenjian=new JMenu("文件");
    private JMenu caigou=new JMenu("采购管理");
    private JMenu shangpin=new JMenu("商品管理");
    private JMenu zhanghu=new JMenu("账户管理");
    private JMenu xinxi=new JMenu("信息查询");
    private JMenu bangzhu=new JMenu("帮助");

    private JPanel panel1=new JPanel();
	
	
    private  JScrollPane jspane1=new JScrollPane();   // 创建带滚动条窗口
	private JTree jtree1 = null; //1.定义树 jtree1
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("进销存管理");
    
    
    private JScrollPane spane=new JScrollPane();	    //带滚动条窗口
	DefaultTableModel model=new DefaultTableModel();     //表格模型
	private JTable table=new JTable();              //new 一个表格对象，空表	
	Vector lieming=new Vector();              //容器lieming, 存放表格标题（表头）
	Vector vdata=new Vector();             //容器vdata,存放表格中数据	
	
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


		this.add(spane);
		spane.setViewportView(table);
		spane.setBounds(200,30,580,680);
		model.setColumnIdentifiers(lieming);     //替换模型中的列标识符
		table.setModel(model);	
		
		
		
				
		
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("销售管理");
		DefaultMutableTreeNode node2=new DefaultMutableTreeNode("库存管理");
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("用户管理");
		DefaultMutableTreeNode node4=new DefaultMutableTreeNode("信息查询");
		DefaultMutableTreeNode node5=new DefaultMutableTreeNode("商品管理");
		
		DefaultMutableTreeNode node11=new DefaultMutableTreeNode("销售统计");    
		
		DefaultMutableTreeNode node21=new DefaultMutableTreeNode("库存信息浏览");
		DefaultMutableTreeNode node22=new DefaultMutableTreeNode("按库存商品编号查询");
		
		DefaultMutableTreeNode node31=new DefaultMutableTreeNode("添加修改用户");
		DefaultMutableTreeNode node32=new DefaultMutableTreeNode("个人账户查询");
		
		DefaultMutableTreeNode node41=new DefaultMutableTreeNode("按商品名称查询");
		DefaultMutableTreeNode node42=new DefaultMutableTreeNode("按商品编号查询");
		DefaultMutableTreeNode node43=new DefaultMutableTreeNode("按条形码查询");
		DefaultMutableTreeNode node44=new DefaultMutableTreeNode("按商品类别查询");
		DefaultMutableTreeNode node45=new DefaultMutableTreeNode("显示全部商品");
		
		DefaultMutableTreeNode node441=new DefaultMutableTreeNode("电器类查询");
		DefaultMutableTreeNode node442=new DefaultMutableTreeNode("礼品类查询");
		DefaultMutableTreeNode node443=new DefaultMutableTreeNode("日用品查询");
		DefaultMutableTreeNode node444=new DefaultMutableTreeNode("蔬菜类查询");
		DefaultMutableTreeNode node445=new DefaultMutableTreeNode("食品类查询");
		DefaultMutableTreeNode node446=new DefaultMutableTreeNode("生鲜类查询");
		
		DefaultMutableTreeNode node51=new DefaultMutableTreeNode("出库入库");
		DefaultMutableTreeNode node52=new DefaultMutableTreeNode("进退货");
		DefaultMutableTreeNode node53=new DefaultMutableTreeNode("新增商品");
		
		root.add(node1);        //将一级节点node1添加到树的根节点
		root.add(node2);        //将一级节点node2添加到树的根节点
		root.add(node3);
		root.add(node4);
		root.add(node5);
		
		node1.add(node11);      //将二级节点node11添加到树的一级节点node1
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
		
		node44.add(node441);    //将三级节点node44添加到树的二级节点node4
		node44.add(node442);
		node44.add(node443);
		node44.add(node444);
		node44.add(node445);
		node44.add(node446);
		



		jtree1=new JTree(root);               //创建树jtree1,根节点是root
		jspane1.getViewport().add(jtree1);    //将树加到滚动条窗口jspane1
		jspane1.setBounds(5, 30, 200, 850);
		
		jToolBar.setBounds(new Rectangle(0, 0, 800, 29));   //设置工具条jToolBar 的位置，宽，高
		jToolBar.add(jButton1);   //将按钮jButton1添加到工具条jToolBar
	    jToolBar.add(jButton2);
		
	    
	    this.add(jToolBar, null);            //将工具条jToolBar 加到窗口
	    this.add(jspane1);                   //将包含树的滚动条jspane1 加到窗口
	    
	    jtree1.addTreeSelectionListener(new  treeListener());//	注意添加事件处理的位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		new Test();
		
		
	}
	class treeListener implements TreeSelectionListener  {

		public void valueChanged(TreeSelectionEvent e) {      //每当选择值发生更改时调用。
			// TODO Auto-generated method stub
			 Object obj1 = jtree1.getLastSelectedPathComponent();    //返回当前选择的第一个节点中的最后一个路径组件
		        String s = null;
		        if (obj1 != null) {
		            s = obj1.toString();
		            if(s.equals("新增商品"))
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	new Xinzeng();
					if(s.equals("出库入库"))
						new Churu();
					if(s.equals("进退货"))
						new Jintuihuo();
		            else if(s.equals("按商品名称查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("按商品编号查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdbianhao(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		        	}
		            else if(s.equals("按条形码查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"input");
		            	vdata=dataSelect.comdtiaoxingma(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("显示全部商品")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	vdata=dataSelect.comdquanbu();
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("电器类查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"电器类");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("礼品类查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"礼品类");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("日用品查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"日用品");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("蔬菜类查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"蔬菜类");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("食品类查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"食品类");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            else if(s.equals("生鲜类查询")){
		            	//JOptionPane.showMessageDialog(null, "销售统计"); 
		            	String name = JOptionPane.showInputDialog(this,"生鲜类");
		            	vdata=dataSelect.comdSele(name);		       	
		            	table = new JTable(vdata,lieming);		            	
		            	spane.setViewportView(table);
		            }
		            
		        
		}		
	}

}
	}