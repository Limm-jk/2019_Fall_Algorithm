
public class bellman extends Search {

	public boolean Bellman_Ford(int[][] graph, vertex[] ver, int startVertex) {
		for(int verIndex = 0; verIndex < ver.length; verIndex++ ) {
			ver[verIndex].setd(MAX_VALUE);
		}
		ver[startVertex].setd(0);
		
		for(int i =0; i < ver.length; i++) {
			for(int j =0; j < ver.length; j++) {
				if(isAdj(graph, i, j)) {
					this.Relax(graph, ver[i], ver[j]);
				}
			}
		}
		for(int i =0; i < ver.length; i++) {
			for(int j =0; j < ver.length; j++) {
				if(isAdj(graph, i, j)) {
					if(ver[j].d() > ver[i].d()+graph[i][j])
						return false;
				}
			}
		}
		return true;
	}

}
