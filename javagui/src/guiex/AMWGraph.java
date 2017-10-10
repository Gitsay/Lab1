package guiex;

import java.util.*;
import java.lang.*;

public class AMWGraph {
	public String[] vertex;
	public int numvertex;//存储点的个数
	public int[][] edges;//邻接矩阵，用来存储边
	public int numOfEdges;//边的数目

    public AMWGraph() {
    	
    }
    
    public AMWGraph(String[] array1,String[] array2,int n) {
        //初始化矩阵，一维数组，和边的数目
    	vertex=new String[array1.length];
    	//System.arraycopy(array1, 0, vertex, 0, array1.length);
        edges=new int[array1.length][array1.length];
        numOfEdges=0;
        numvertex=array1.length;
        for(int i=0;i<array1.length;i++) {
        	Arrays.fill(edges[i], 0);    //清空数组
        }
        Arrays.sort(array1);         //将数组进行排序，用于后面数组内的查找
        System.arraycopy(array1, 0, vertex, 0, array1.length);
        for(int i=0;i<n-1;i++) {
        	int x=Arrays.binarySearch(array1, array2[i]);  //查找在数组内的位置
        	int c=Arrays.binarySearch(array1, array2[i+1]);
        	//System.out.println(x);
        	//System.out.println(c);
        	edges[x][c]=edges[x][c]+1;    //改变权值
        	numOfEdges++;
        }
    }
    
   
}
