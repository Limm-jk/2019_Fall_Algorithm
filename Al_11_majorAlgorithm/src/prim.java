
public class prim extends Search {
	
	
	public prim() {
		
	}
	
	public void MST_Prim(int[][] graph, vertex[] ver, int startVertex){
		System.out.println();
		int Scount = 0;
		vertex[] S = new vertex[ver.length];
		for(int verIndex = 0; verIndex < ver.length; verIndex++ ) {
			ver[verIndex].setkey(MAX_VALUE);
			ver[verIndex].setpi(ver[0]);
			ver[verIndex].undirected();
		}
		ver[startVertex].setkey(0);

		this.UseQueue(ver);
		
		vertex temp = new vertex();
		temp.setkey(0);//heap의 update를 위한 넣었다 빼줄 값
		
		while(!que.isEmpty()) {
			vertex minvertex = que.poll();
			S[Scount] = minvertex;
			Scount++;
			for(int adjIndex = 0; adjIndex < ver.length; adjIndex++) {
				if(this.isAdj(graph, adjIndex, minvertex.index()) && !SearchVertex(S, ver[adjIndex]) && graph[adjIndex][minvertex.index()] < ver[adjIndex].key()) {
					ver[adjIndex].setpi(minvertex);
					ver[adjIndex].setkey(graph[adjIndex][minvertex.index()]);
				}
			}
			this.que.offer(temp);
			que.poll();//최신화
		}
	}
	public void printPrim(vertex[] ver) {
		for(int i = 0; i < ver.length; i++)
			System.out.println(ver[i].index()+" "+ver[i].pi().index()+" "+ver[i].key());
	}
}
