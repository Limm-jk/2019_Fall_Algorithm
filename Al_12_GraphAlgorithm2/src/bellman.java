import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bellman extends Search {

	public boolean Bellman_Ford(int[][] graph, vertex[] ver, int startVertex) {
		for (int verIndex = 0; verIndex < ver.length; verIndex++) {
			ver[verIndex].setd(MAX_VALUE);
			ver[verIndex].directed();
		}
		ver[startVertex].setd(0);
		for (int k = 0; k < ver.length - 1; k++) {
			for (int i = 0; i < ver.length; i++) {
				for (int j = 0; j < ver.length; j++) {
					if (isAdj(graph, i, j)) {
						this.Relax(graph, ver[i], ver[j]);
					}
				}
			}
		}
		for (int i = 0; i < ver.length; i++) {
			for (int j = 0; j < ver.length; j++) {
				if (isAdj(graph, i, j)) {
					if (ver[j].d() > ver[i].d() + graph[i][j])
						return false;
				}
			}
		}
		return true;
	}

	public void printBellman(vertex[] SearchVertex, int Start) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("./result_bellman.txt"));
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
