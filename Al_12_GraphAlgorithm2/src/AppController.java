

import java.io.*;

public class AppController {
	private prim _prim = new prim();
	private Dijkstra _dijk = new Dijkstra();
	private bellman _bell = new bellman();
	private fileInput fi = new fileInput();
	private int[][] prim_graph, dijkstra_graph, bellman_graph;
	private vertex[] prim_ver, dijkstra_ver, bellman_ver;
	
	private static final int StartVertex=0;//시작vertex를 지정해주도록 함
	
	public AppController() {
		this.fi = new fileInput();
		this._prim = new prim();
		this._dijk = new Dijkstra();
		this._bell = new bellman();
	}
	public void run() throws NumberFormatException, IOException {
		this.fi.fileInput("./graph_sample_prim_kruskal.txt", 0);
		this.prim_graph = this.fi.getGraph();
		this.prim_ver = this.fi.getVertex();
		this.fi.fileInput("./graph_sample_dijkstra.txt", 1);
		this.dijkstra_graph = this.fi.getGraph();
		this.dijkstra_ver = this.fi.getVertex();
		this.fi.fileInput("./graph_sample_bellman.txt",1);
		this.bellman_graph = this.fi.getGraph();
		this.bellman_ver = this.fi.getVertex();
		this._prim.MST_Prim(prim_graph, prim_ver, StartVertex);
		this._prim.printPrim(prim_ver);
		this._dijk.Dijkstra(dijkstra_graph, dijkstra_ver, StartVertex);
		this._dijk.printDijkstra(dijkstra_ver, StartVertex);
		if(!this._bell.Bellman_Ford(bellman_graph, bellman_ver, StartVertex)) {
			System.out.println("Error : 무한순환이 있습니다.");
		}
		this._bell.printBellman(bellman_ver, StartVertex);
		
	}
	private void printg(int[][] graph) {//디버깅용
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
