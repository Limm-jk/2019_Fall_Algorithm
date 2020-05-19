import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Dijkstra extends Search {
	public void Dijkstra(int [][] graph, vertex[] ver, int startVertex) {
		int Scount = 0;
		vertex[] S = new vertex[ver.length];
		for(int i = 0; i < ver.length; i++) {
			ver[i].setd(MAX_VALUE);
			ver[i].setpi(null);
			ver[i].directed();
		}
		ver[startVertex].setd(0);
		ver[startVertex].setpi(ver[startVertex]);
		this.temp.directed();
		this.UseQueue(ver);
		while(!que.isEmpty()) {
			vertex minvertex = this.que.remove();
			S[Scount] = minvertex;
			Scount++;
			for(int adjIndex = 0; adjIndex < ver.length; adjIndex++) {
				if(this.isAdj(graph, minvertex.index(), adjIndex) && !SearchVertex(S, ver[adjIndex])) {
					this.Relax(graph, minvertex, ver[adjIndex]);
				}
			}
			this.que.offer(temp);
			que.poll();//ÃÖ½ÅÈ­
		}
		
	}
	
	public void printDijkstra(vertex[] SearchVertex, int Start) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("./result_Dijkstra.txt"));
		vertex currentV = new vertex();
		for(int i = 0; i < SearchVertex.length; i++) {
			bw.write(SearchVertex[i].index()+"");
			if(Start == SearchVertex[i].index()) {
				bw.write("\t"+ SearchVertex[i].d());
				bw.newLine();
				continue;
			}
			currentV = SearchVertex[i].pi();
			while(true) {
				if(currentV.index() == Start) {
					bw.write(" <- "+currentV.index());
					break;
				}
				bw.write(" <- "+currentV.index());
				currentV = currentV.pi();
			}
			bw.write("\t"+ SearchVertex[i].d());
			bw.newLine();
		}
		bw.close();
	}
	
	
	
}
