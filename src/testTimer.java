//package market;

import java.awt.*;
import java.util.*;

import javax.swing.*;



public class testTimer extends JFrame {
	private JLabel l1=new JLabel("ʱ��");
	private JTextField field1=new JTextField(30);
	java.util.Timer timer=new java.util.Timer();//1.��ʱ��
	
	testTimer(){
		this.setTitle("ʱ����ʾ");
		this.setBounds(5, 5, 400, 150);
		this.setLayout(null);
		//this.add(l1);
		field1.setBounds(50,10, 300, 50);
		field1.setFont(new Font(null,Font.PLAIN,25 ));
		this.add(field1);
		
	   timer.schedule(new RemindTask(), 0, 1000);      //2.��ʱ���ļƻ�����
	   
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

   //ʱ���ʽת��
