

import java.util.*;

public class Search {
	protected final static int MAX_VALUE = 10000;
	vertex temp = new vertex();
	protected PriorityQueue<vertex> que = new PriorityQueue<>();
	
	protected boolean isAdj(int [][] graph, int i, int j) {
		if(graph[i][j] != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	protected void UseQueue(vertex[] ver) {
		temp.setkey(0);//heap의 update를 위한 넣었다 빼줄 값
		temp.setd(0);//heap의 update를 위한 넣었다 빼줄 값
		for(int addIndex = 0; addIndex < ver.length; addIndex++) {
			que.offer(ver[addIndex]);
		}
	}
	protected void Relax(int[][] graph, vertex u, vertex v) {
		if(v.d() > u.d() + graph[u.index()][v.index()] && u.d() != MAX_VALUE) {
			v.setd(u.d() + graph[u.index()][v.index()]);
			v.setpi(u);
		}
	}
	protected boolean SearchVertex(vertex[] vertexArray, vertex SearchVertex) {
		for(int i = 0; i < vertexArray.length; i++) {
			if(vertexArray[i] == SearchVertex) {
				return true;
			}
		}
		return false;
	}
}
