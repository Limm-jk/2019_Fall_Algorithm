
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
		
		this.UseQueue(ver);
		while(!que.isEmpty()) {
			vertex minvertex = this.que.remove();
			S[Scount] = minvertex;
			Scount++;
			for(int adjIndex = 0; adjIndex < ver.length; adjIndex++) {
				if(this.isAdj(graph, adjIndex, minvertex.index()) && !SearchVertex(S, ver[adjIndex])) {
					this.Relax(graph, minvertex, ver[adjIndex]);
				}
			}
		}
		
	}
	
	public void printDijkstra(vertex[] SearchVertex, int Start) {
		vertex currentV = new vertex();
		for(int i = 0; i < SearchVertex.length; i++) {
			System.out.print(SearchVertex[i].index());
			currentV = SearchVertex[i].pi();
			while(true) {
				if(currentV.index() == Start) {
					System.out.print(" <- "+currentV.index());
					break;
				}
				System.out.print(" <- "+currentV.index());
				currentV = currentV.pi();
			}
			System.out.println("\t"+ SearchVertex[i].d());
		}
	}
	
	
	
}
