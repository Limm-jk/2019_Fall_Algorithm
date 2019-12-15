

import java.io.*;

public class AppController {
	private prim _prim = new prim();
	private Dijkstra _dijk = new Dijkstra();
	private fileInput fi = new fileInput();
	private int[][] prim_graph, dijkstra_graph, bellman_graph;
	private vertex[] prim_ver, kruskal_ver, dijkstra_ver, bellman_ver;
	
	public AppController() {
		this.fi = new fileInput();
		this._prim = new prim();
	}
	public void run() throws NumberFormatException, IOException {
		this.fi.fileInput("./graph_sample_prim_kruskal.txt", 0);
		this.prim_graph = this.fi.getGraph();
		this.prim_ver = this.fi.getVertex();
		this.kruskal_ver = this.fi.getVertex();
		this.fi.fileInput("./graph_sample_dijkstra.txt", 1);
		this.dijkstra_graph = this.fi.getGraph();
		this.dijkstra_ver = this.fi.getVertex();
		this.fi.fileInput("./graph_sample_bellman.txt",1);
		this.bellman_graph = this.fi.getGraph();
		this.bellman_ver = this.fi.getVertex();
		this._prim.MST_Prim(prim_graph, prim_ver, 0);
		//this.printg(prim_graph);
		this._prim.printPrim(prim_ver);
		this._dijk.Dijkstra(dijkstra_graph, dijkstra_ver, 0);
		this._dijk.printDijkstra(dijkstra_ver, 0);
	}
	private void printg(int[][] graph) {//µð¹ö±ë¿ë
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
