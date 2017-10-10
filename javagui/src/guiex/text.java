package guiex;

import java.io.*;
import java.lang.*;
import java.util.*;

public class text {
	private static int max=Integer.MAX_VALUE;        //整数的最大值
	public static AMWGraph graph ;                   //声明一个存储有向图的类的全局变量
	public static String strle;
	public static String sureth;
	public static Stack <String>stack;               //声明一个栈，用来存储一个最短路径
	public static String fileName = new String();
	public static List<String> liste0 = new ArrayList<String>();//声明一个集合类用来存储图片的命名
	public static int i = 0;
	
	public static void CreatePicture(String pictureName) {   //生成最短路径的函数
		// create colored Path Picture
		GraphViz pr = new GraphViz("dot.exe");
		//Short_path tmpPath = spath.clone();
		Stack tmpPath;
		tmpPath = (Stack<String>)stack.clone();         //将栈完全赋予给tmpPath 
		//int i = 0;
		pr.clearTmpDotFile( pictureName + ".dot");//
		//while (tmpPath != null) {
			pr.setColorForPath(tmpPath,
					GraphViz.color[i % GraphViz.color.length], pictureName + ".dot");
			i++;                   //改变事物的颜色
			//tmpPath = tmpPath.next;
		//}
		pr.runAfterSetColor(pictureName, pictureName + ".dot");  //最短路径有色图片的生成
	}
	
	public static void readfiles() {           //读取文件函数
		//InputStreamReader rin = new InputStreamReader(System.in);     //获得控制台的输入流
		//System.out.println("请输入你要操作的文件路径：");
		//String fileName = new String();//声明一个字符串
		//Scanner scr = new Scanner(System.in);
		//fileName = scr.nextLine();
		/*try {
			char[] cs = new char[50];
			rin.read(cs);                                             //从输入流读取数据到字节数组
		    fileName = new String(cs).trim();
			rin.close();
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		//String fileName = "D:/workspace/test.txt/";
		//System.out.println(fileName);
		File file = new File(fileName);       //根据文件名建立相应的文件
		
		
		//AMWGraph graph = new AMWGraph();
		try {
			//System.out.println("以字符为单位读取文件内容，一次读一个字节：");
			FileReader fReader = new FileReader(file);    //建立文件的字符输入流
			String[] strarray = new String[128];
			List<String> list = new ArrayList<String>();    //集合类用来装顶点的
			Arrays.fill(strarray,"");
			char[] data = new char[128];                    //字符数组装从文件中读取的字符
			Arrays.fill(data, ' ');
			int rs = 0 , bs = 0 , cs = 0;
			while((rs=fReader.read()) != -1) {              //判断是否读取到最后
				if(Character.isLetter((char)rs) == true) {  //判断是否是26个英文呢字母以外的字符
					data[bs] = (char)rs;                    //强转为字符
					bs = bs + 1;
				}
				else {
					if(data[0]!=' ') {
						strarray[cs] = new String(data).trim();//去掉字符数组两端的空格
						strarray[cs] = strarray[cs].toLowerCase();//将数组内的字母全部最小化
						if(list.indexOf(strarray[cs])==-1) {   //判断集合内是否有该字符
							list.add(strarray[cs]);
						}
						//System.out.println(strarray[cs].length());
						Arrays.fill(data, ' ');                //刷新字符数组
						cs = cs + 1;
						bs = 0;
					}
				}
				//System.out.print((char)rs);
				}fReader.close();
				String[] str2 = list.toArray(new String[list.size()]);//将集合类转换为数组
				/*for(String z:strarray) {
					if(z != null) {
						System.out.println(z);
					}
				}*/
				for(String c:str2) {
					System.out.println(c);
				}
				//System.out.println(cs);
				System.out.println(str2.length);
				graph = new AMWGraph(str2,strarray,cs);     //存储进有向图的邻接矩阵中
			}catch (Exception e){
				e.printStackTrace();
		}
		//AMWGraph graph = new AMWGraph(str2,strarray,cs);
	}
	
	public static void showDirectedGraph(AMWGraph G) {    //生成有向图的图片，并且存储进硬盘中
		String cur_word=null;
		String word=null;
		//Node tmp_node=null;
		GraphViz gViz = new GraphViz("dot.exe");
		gViz.start_graph();                  //.dot文件的开端
		for(int num = 0;num < G.numvertex;num ++) {     //.dot内容撰写
			for(int num1 = 0;num1 < G.numvertex;num1 ++) {
				if(G.edges[num][num1]!=0) {
					word = G.vertex[num];
					cur_word = G.vertex[num1];
					gViz.addln("\"" + word + "\"->\"" + cur_word + "\"",
							G.edges[num][num1]);
				}
			}
		}
		/*for (String word : G.keySet()) {
			tmp_node=G.get(word).links;
			while (tmp_node != null) {
				cur_word = tmp_node.link_vertex.word;
				gViz.addln("\"" + word + "\"->\"" + cur_word + "\"",
						tmp_node.weight);
				tmp_node = tmp_node.next;
			}
		}*/
		gViz.end_graph();            //.dot文件的结尾
		try {
		gViz.run();                  //运行这个类
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String queryBridgeWords(String word1, String word2) {     //查找桥接词
		String strcct = "The bridge words from \""+word1+"\" to "+word2+" are:";
		//用来作为返回值的字符串
		String tsstr;
		//用来做无桥接词时的字符串
		List<Integer> list1 = new ArrayList<Integer>();
		int rum1 = Arrays.binarySearch(graph.vertex, word1);
		//查找该字符串在数组内的下标值
		int rum2 = Arrays.binarySearch(graph.vertex, word2);
		if(rum1 < 0||rum2 < 0) {
			if(rum1 < 0&&rum2 < 0) {     //两个单词都不存在
				tsstr = "No \""+word1+"\" and \""+word2+"\" in the graph!";
				return tsstr;
			}
			else if(rum1<0) {          //其中一个单词不存在
				tsstr = "No \""+word1+"\" in the graph!";
				return tsstr;
			}
			else {
				tsstr = "No \""+word2+"\" in the graph!";
				return tsstr;
			}
		}
		else {
			int zum=0;            //用来标记两个字符串之间是否存在桥接词
			for(int cum = 0;cum<graph.numvertex;cum++) {
				if(graph.edges[rum1][cum]!=0&&graph.edges[cum][rum2]!=0) {
					zum  = zum + 1;
					list1.add(cum);     //添加进字符类中
				}
			}
			if(zum==0) {
				tsstr = "No bridge words from \""+word1+"\" to \""+word2+"\"!";
				return tsstr;
			}
			else {
				for(int zc = 0;zc<list1.size();zc++) {
					int ts = list1.get(zc);
					strle = graph.vertex[ts];     //记录两个单词之间的桥接词，用于下一个生成新文本的函数
					strcct = strcct + graph.vertex[ts] + '.';
				}
				zum = 0;
				return strcct;
			}
		}
	}
	
	public static String generateNewText(String inputText) {    //生成新文本
		inputText = inputText + ' ';
		String stresult = new String();
		String opq;
		int zuc = 0 , zmc = 0;            
		//zmc用来记录下一个单词的起始点，便于从字符和数组中取出合成一个字符串，zuc用来记录单词的长度
		List<String>list2 = new ArrayList<String>();
		char[] exstr = new char[128];
		char[] exstr1 = new char[128];
		Arrays.fill(exstr, ' ');
		Arrays.fill(exstr1, ' ');
		exstr = inputText.toCharArray();
		//System.out.println(inputText.length());
		for(int cus = 0;cus < inputText.length(); cus++) {
			if(Character.isLetter(exstr[cus])==false) {
				//判断是否字符串内全部都是26个英文字母
				if(zuc!=0) {
					System.arraycopy(exstr, zmc , exstr1, 0, zuc);
					//赋值一定长度数组给另一个数组
					zmc = zmc + zuc + 1;
					//获取下一个数组的长度
					zuc = 0;
					list2.add(new String(exstr1).trim());
					//添加字符串进集合类当中去
					Arrays.fill(exstr1, ' ');
				}
				else {
					zmc = zmc +1;
				}
			}
			else {
				zuc = zuc + 1;
			}
		}
		String[] str3 = list2.toArray(new String[list2.size()]);
		//将集合类转换成数组
		stresult = str3[0];
		//System.out.println(list2.size());
		for(zuc = 0;zuc<list2.size()-1;zuc++) {
			opq = queryBridgeWords(str3[zuc],str3[zuc+1]);
			if(strle==null) {      //不存在桥接词
				stresult = stresult+' '+str3[zuc+1];
			}
			else {              //加入桥接词的情况
				stresult = stresult+' '+strle+' '+str3[zuc+1];
				strle = null;
			}
		}
		return stresult;
	}
	
	public static String calcShortestPath(String word1, String word2) {
		//查找最短路径
		Floyd f = new Floyd(graph.edges);
		String cureof ;          //最后返回最短路径的字符串
		int i = Arrays.binarySearch(graph.vertex, word1);
		int j = Arrays.binarySearch(graph.vertex, word2);
		if(i<0||j<0) {           //单词不存在的情况
			if(i<0&&j<0) {       //只有一个单词的存在的情况
				cureof = "No" + "\"" + word1 + "\"" + "and\"" + word2 +"\"";
			}
			else if(i<0) {
				cureof = "No" + "\"" + word1;
			}
			else {
				cureof = "No" + "\"" + word2;
			}
		}
		else {
			stack =new Stack();     //创立一个栈，用来存储最短路径
			stack.push(word1);
			f.findCheapestPath(i, j, graph.edges);
			/*for(int n = 0;n<10;n++) {
				for(int m = 0;m<10;m++) {
					System.out.print(f.dist[n][m]+":");
					System.out.print(f.path[n][m]+":");
				}
				System.out.println();
			}*/
			cureof = graph.vertex[i]+"-->"+graph.vertex[j]+"的最短路径：";
		    ArrayList<Integer>L=f.list;    //集合类用来存储最短路径上的单词在数组中的下标
		    cureof = cureof + graph.vertex[L.get(0)];
		    sureth = graph.vertex[L.get(0)] + "-" + graph.vertex[L.get(L.size() - 1)];
		    System.out.print(graph.vertex[i]+"-->"+graph.vertex[j]+":");
		    if(f.dist[i][j]==max){
		    	cureof = "之间没有最短路径";
		     System.out.println("之间没有最短路径");
		    System.out.println();
		    }
		    else{
		    	for(int cms = 1;cms < L.size(); cms++) {
		    		cureof = cureof + "->" + graph.vertex[L.get(cms)];
		    		stack.add(graph.vertex[L.get(cms)]);
		    	}
		    	liste0.add(sureth);
		    	CreatePicture(sureth);
		    	//cureof = cureof + '\n';
		    	cureof = cureof + " 路径长度：" + f.dist[i][j];
		     System.out.println("的最短路径是：");
		     System.out.print(L.toString()+" ");
		     System.out.println("路径长度:"+f.dist[i][j]);
		     System.out.println();             	
		   }
		}
	return cureof;
    }
	
	public static ArrayList<String> OnecalcShortestPath(String word1) {
		//输入一个单词时的最短路径
		ArrayList<String>list3 =new ArrayList<String>(); 
		int m = Arrays.binarySearch(graph.vertex, word1);
		for(int cus = 0;cus < graph.numvertex;cus++) {
			if(graph.vertex[cus]!=word1) {
				String zuli = calcShortestPath(word1,graph.vertex[cus]);
				list3.add(zuli);
			}
		}
		return list3;
	}
	
	public static String randomWalk() {
		//随机游走函数
		String random = "";
		int cav = 0 , can = 0 , duo;
		ArrayList<Integer>list0 = new ArrayList<Integer>();
		int []arrty = new int[graph.numvertex];
		int [][]Sterearray = new int[graph.numvertex][graph.numvertex];
		Arrays.fill(arrty, 0);
		for(int zr = 0;zr<graph.numvertex;zr++) {
			Arrays.fill(Sterearray[zr], 0);
		}
		int index = (int) (Math.random() * graph.numvertex);
		random = graph.vertex[index];
		arrty[index] = 1;
		duo = index;
		while(cav!=1 && can!=1) {
			int tuo ;
			list0.clear();             //清空集合类内的内容
			for(tuo = 0;tuo < graph.numvertex;tuo++) {
				if(graph.edges[duo][tuo]!=0) {
					list0.add(tuo);
				}
			}
			if(list0.size()==0) {
				can = 1;
			}
			else {
				int index1 = (int) (Math.random() * list0.size());
				if(Sterearray[duo][index1]==1) {
					cav = 1;
				}
				else {
					Sterearray[duo][list0.get(index1)]=1;
					random = random + " " + graph.vertex[list0.get(index1)];
					duo = list0.get(index1);
				}
			}
		}
		return random;
	}
}
