package guiex;

import java.util.*;

public class Floyd {
	 /*
	  * 给出一个含有n个顶点的带权有向图，要求其每一对顶点之间的最短路径。
	  * 这里采用佛洛依德(Floyd)最短路径算法：
	  */

	 private static int max=Integer.MAX_VALUE;
	 public static int [][]dist;          //存储最短路径的长度
	 public static int [][]path;          //存储最短路径的中间点
	 public static ArrayList list=new ArrayList<Integer>();
	 
	 public Floyd(int Arrey[][]) {        //初始化二维数组
		 int amn = Arrey.length;
		 dist = new int[amn][amn];
		 path = new int[amn][amn];
	 }

	 public void findCheapestPath(int begin,int end,int Arcs[][]){   //寻找最短路径
	  floyd(Arcs);
	  list.clear();
	  list.add(begin);
	  findPath(begin,end);
	  list.add(end);
	 }

	 public void findPath(int i,int j){           //寻找两点之间是否存在中间点
	  int k=path[i][j];
	  if(k==-1)
	   return ;
	  findPath(i,k);
	  list.add(k);                        //将中间点添加到集合类中，用来输出
	  findPath(k,j);
	 }
	 public void floyd(int [][] Arcs){    //Floyd算法
	  int n=Arcs.length;
	  for(int i=0;i<n;i++) {
	   for(int j=0;j<n;j++){
	    path[i][j]=-1;                 //初始化当前的路径中间点表
	    if(Arcs[i][j]!=0) {
	            dist[i][j]=Arcs[i][j];         //初始化当前的路径长度表
	    }
	    else {
	    	dist[i][j]=max;
	    }
	   }
	  }

	  for(int k=0;k<n;k++)
	   for(int i=0;i<n;i++)
	    for(int j=0;j<n;j++){
	    if(dist[i][k]!=max && dist[k][j]!=max && dist[i][k]+dist[k][j]<=dist[i][j]){
	     dist[i][j]=dist[i][k]+dist[k][j];
	     path[i][j]=k;
	    }
	   }
	 }
}