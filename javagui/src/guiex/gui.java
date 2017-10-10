package guiex;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class gui extends text{
	public static int num = 0;
	public List<String> liste1 = new ArrayList<String>();
	public JFrame frame;
	public JPanel function1;
	public JPanel function2;
	public JPanel function3;
	public JPanel function4;
	public JPanel function5;
	public JPanel function6;
	
	//定义内容面板
	
	public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	public JButton b6;
	public JButton b7;
	public JButton b8;
	public JButton s2;//定义功能按键
	
	public JTextField textField;
	public JTextField textField2;
	public JTextField textField3;
	public JTextArea textField4;
	public JTextField textField5;
	public JTextField textField6;
	public JTextField function4_word1;
	public JTextField function4_word2;
	public JTextField function5_sentence;//定义文本显示框
	
	 
	private text final_t;
	 gui()
	{
		    
		    frame = new JFrame("lab1");
			frame.setLayout(null);
			
			
			function1  = new JPanel();
			function1.setLayout(null);
			function1.setBounds(0, 0, 300, 100);
			function1.setBorder(BorderFactory.createRaisedBevelBorder());;
			function2  = new JPanel();
			function2.setLayout(null);
			function2.setBounds(0,100, 300, 100);
			function2.setBorder(BorderFactory.createRaisedBevelBorder());
			/*function2.setBackground(Color.CYAN);*/
			function3  = new JPanel();
			function3.setLayout(null);
			function3.setBounds(0,200, 300, 100);
			function3.setBorder(BorderFactory.createRaisedBevelBorder());
			
			function4 = new JPanel();
			function4.setLayout(null);
			function4.setBounds(0, 300, 300, 100);
			function4.setBorder(BorderFactory.createRaisedBevelBorder());
			
			function5 = new JPanel();
			function5.setLayout(null);
			function5.setBounds(0, 400, 300, 100);
			function5.setBorder(BorderFactory.createRaisedBevelBorder());
			
			function6 = new JPanel();
			function6.setLayout(null);
			function6.setBounds(0, 500, 300, 100);
			function6.setBorder(BorderFactory.createRaisedBevelBorder());
			
			
			
			
			
		    b1 = new JButton("确认");
		    textField = new JTextField("请输入文件地址");
			b1.setBounds(80,40,100,20);
			textField.setBounds(0, 0, 300, 20);
			
			textField2 = new JTextField();
			textField3 = new JTextField();
			textField4 = new JTextArea(3,10);
			textField4.setEditable(false);
			textField4.setBorder(BorderFactory.createEtchedBorder());;
			b2 = new JButton("桥接词");
			b2.setBounds(80, 40,100, 20);
			textField2.setBounds(10,60,50,20);
			textField3.setBounds(10,20,50,20);
			textField4.setBounds(190,20,100,60);
			
			textField5 = new JTextField();
			textField5.setBounds(0,20,300,20);
			b3= new JButton("生成新文本");
			b3.setBounds(80, 60, 100, 20);
			
			b4 = new JButton("查询最短路径");
			b4.setBounds(90, 50 ,120,20);
			function4_word1 = new JTextField();
			function4_word2 = new JTextField();
			function4_word1.setBounds(190, 20, 100, 20);
			function4_word2.setBounds(10, 20, 100, 20);
			
			b5 = new JButton("随机游走");
			b5.setBounds(80, 40, 120, 20);
			
			textField6 = new JTextField();
			textField6.setBounds(0,20,300,20);
			b6 = new JButton("单个单词最短路径");
			b6.setBounds(80, 50, 150, 20);
			
			b7 = new JButton("显示最短路径");
			b7.setBounds(90, 80 ,120,20);
			
			b8 = new JButton("查看图片");
			b8.setBounds(80, 80 ,150,20);
			
			SimpleListener ourListener = new SimpleListener();
			b1.addActionListener(ourListener);
			b2.addActionListener(ourListener);
			b3.addActionListener(ourListener);
			b4.addActionListener(ourListener);
			b5.addActionListener(ourListener);
			b6.addActionListener(ourListener);
			b7.addActionListener(ourListener);
			b8.addActionListener(ourListener);
			
			textField4.setLineWrap(true);
	}
	
	 text te = new text();
	private void func(String s)
	{
		JFrame frame_Newtext = new JFrame("生成结果");
    	JLabel l1 = new JLabel(s);
    	frame_Newtext.getContentPane().add(l1, BorderLayout.CENTER);
    	frame_Newtext.setBounds(500,300,400,200);
    	frame_Newtext.setResizable(true);
    	frame_Newtext.setVisible(true);
	}
	private void func2(ArrayList<String> s)
	{
		JFrame frame_Newtext = new JFrame("生成结果");
   
    	JTextArea t4 = new JTextArea(3,10);
    	JScrollPane scroll = new JScrollPane(t4);
    	t4.setBounds(0,0,500,100);
    	t4.setLineWrap(true);
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	frame_Newtext.add(scroll);
    	frame_Newtext.setBounds(500,300,500,200);
    	frame_Newtext.setResizable(true);
    	frame_Newtext.setVisible(true);
    	for(int c = 0; c < s.size();c++)
    	{
    		t4.append(s.get(c)+'\n');
    	}
	}
	private void grap()
	{
		
		JFrame frame_New = new JFrame("图片显示");
		JPanel picture;
		JLabel lblImage ;
		picture = new JPanel();
		picture.setLayout(null);
		picture.setBounds(300, 0, 300, 500);
		picture.setBorder(BorderFactory.createRaisedBevelBorder());
		lblImage = new JLabel(new ImageIcon("D:/workspace/javagui/graph.jpg/"));
		lblImage.setBounds(0, 0, 750,650);
    	picture.add(lblImage);
    	frame_New.add(picture);
    	frame_New.setBounds(0,0,750,680);
    	frame_New.setResizable(true);
    	frame_New.setVisible(true);
	}
	private void grap2()
	{
		JFrame frame_N = new JFrame("图片显示");
	    JPanel picture2;
	    
		ImageIcon p2 = new ImageIcon(); 
		p2 = null;
		p2 = new ImageIcon("D:/workspace/javagui/"+sureth+".jpg/");
		JLabel lb = new JLabel(p2);
		lb.setIcon(p2);
		lb.setBounds(0, 0, 750,650);
		
		picture2 = new JPanel();
		picture2.setLayout(null);
		picture2.setBounds(300, 0, 300, 500);
		picture2.setBorder(BorderFactory.createRaisedBevelBorder());
    	picture2.add(lb);
    	
    	frame_N.add(picture2);
    	frame_N.setBounds(0,0,750,680);
    	frame_N.setResizable(true);
    	frame_N.setVisible(true);
    	p2 = null;
    	num = num + 1;
    	
	}

	private void grap3(ImageIcon p_n) {
		JFrame frame_N = new JFrame("图片显示");
	    JPanel picture2;
	    
		JLabel lb = new JLabel(p_n);
		lb.setIcon(p_n);
		lb.setBounds(0, 0, 750,650);
		
		picture2 = new JPanel();
		picture2.setLayout(null);
		picture2.setBounds(300, 0, 300, 500);
		picture2.setBorder(BorderFactory.createRaisedBevelBorder());
    	picture2.add(lb);
  
    	
    	frame_N.add(picture2);
    	frame_N.setBounds(0,0,750,680);
    	frame_N.setResizable(true);
    	frame_N.setVisible(true);
    	num = num + 1;
	}
	int c = 0;
	private class SimpleListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            // 利用getActionCommand获得按钮名称
            // 也可以利用getSource()来实现
            // if (e.getSource() ==button1)
            String buttonName = e.getActionCommand();
            if (buttonName.equals("确认")){
            	te.fileName = textField.getText();
            	te.readfiles();
            	te.showDirectedGraph(te.graph);
            	grap();
            }
            else if (buttonName.equals("桥接词")){
            	String f2 = textField2.getText();
            	String f3 = textField3.getText();
            	textField4.setText(te.queryBridgeWords(f2, f3));
            	
            }
            else if (buttonName.equals("生成新文本")){
            	String  str1; 
            	str1 = te.generateNewText(textField5.getText());
            	func(str1);
            }
            else if (buttonName.equals("查询最短路径")){
            	String f4 = function4_word2.getText();
            	String f5 = function4_word1.getText();
            	String str2;
            	str2 = te.calcShortestPath(f4, f5);
            	func(str2);
            }
            else if (buttonName.equals("显示最短路径")){        
            	grap2();
            }
            else if (buttonName.equals("随机游走")){
            	String str3;
            	str3 = te.randomWalk();
            	func(str3);
            	
            }
            else if (buttonName.equals("单个单词最短路径")) {
            	ArrayList<String> list6 = new ArrayList<String>();
            	list6 = OnecalcShortestPath(textField6.getText());
            	func2(list6);
            }
            if(c < te.liste0.size())     {
            if (buttonName.equals("查看图片")) {
            	ImageIcon p_new = new ImageIcon();
  	    		p_new = new ImageIcon("D:/workspace/javagui/"+te.liste0.get(c++)+".jpg/");
  	            
            	grap3(p_new);
            }
            } 
            
        }
    }
	
	private void createandshowgui(){
		/*JPanel function4  = new JPanel(new BorderLayout());
		JPanel function5  = new JPanel(new BorderLayout());
		JPanel function6  = new JPanel(new BorderLayout());
		JPanel picture  = new JPanel(new BorderLayout());*/
		function1.add(textField);
		function1.add(b1);
		frame.add(function1);//功能一的各项组件
		
		
		function2.add(textField2);
		function2.add(textField3);
		function2.add(textField4);
		function2.add(b2);
       
		frame.add(function2);//功能二的各项组件及内容面板
		
		
		function3.add(textField5);
		function3.add(b3);
		frame.add(function3);//功能三得各项组件及内容面板
		
		
		
		function4.add(b4);
		function4.add(b7);
		function4.add(function4_word1);
		function4.add(function4_word2);
		frame.add(function4);//功能四的各项组件及内容面板
		
		
		function5.add(b5);
		
		frame.add(function5);//功能五的各项组件及内容面板
		
		function6.add(b6);
		function6.add(b8);
		function6.add(textField6);
		frame.add(function6);//功能五的各项组件及内容面板
		
          
        frame.setBounds(400,50,320,640);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	 public static void main(String[] args){
		 gui ma = new gui();
		 ma.createandshowgui();
	 }
}
