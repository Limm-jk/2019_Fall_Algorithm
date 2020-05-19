import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
		
		
		
		while(!que.isEmpty()) {
			vertex minvertex = que.poll();
			S[Scount] = minvertex;
			Scount++;
			for(int adjIndex = 0; adjIndex < ver.length; adjIndex++) {
				if(this.isAdj(graph, adjIndex, minvertex.index()) && !SearchVertex(S, ver[adjIndex]) &&
						graph[adjIndex][minvertex.index()] < ver[adjIndex].key()) {
					ver[adjIndex].setpi(minvertex);
					ver[adjIndex].setkey(graph[adjIndex][minvertex.index()]);
				}
			}
			this.que.offer(temp);
			que.poll();//ÃÖ½ÅÈ­
		}
	}
	public void printPrim(vertex[] ver) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("./result_prim.txt"));
		for(int i = 0; i < ver.length; i++) {
			bw.write(ver[i].index()+" "+ver[i].pi().index()+" "+ver[i].key());
			bw.newLine();
		}
		bw.close();
	}
}
