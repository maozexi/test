//package market;

import java.awt.*;
import java.util.*;

import javax.swing.*;



public class testTimer extends JFrame {
	private JLabel l1=new JLabel("时间");
	private JTextField field1=new JTextField(30);
	java.util.Timer timer=new java.util.Timer();//1.计时器
	
	testTimer(){
		this.setTitle("时间显示");
		this.setBounds(5, 5, 400, 150);
		this.setLayout(null);
		//this.add(l1);
		field1.setBounds(50,10, 300, 50);
		field1.setFont(new Font(null,Font.PLAIN,25 ));
		this.add(field1);
		
	   timer.schedule(new RemindTask(), 0, 1000);      //2.计时器的计划任务
	   
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	class RemindTask extends TimerTask {
         public void run() {
             field1.setText(GetTime.getTime());        	  
         }
     } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new testTimer();
	}

}

   //时间格式转换
