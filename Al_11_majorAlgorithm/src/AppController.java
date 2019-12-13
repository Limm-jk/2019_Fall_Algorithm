

import java.io.*;

public class AppController {
	private BFS _bfs;
	private DFS _dfs;
	private AppView _view;
	private vertex v[];
	private int[][] graph;
	private int signal;
	
	public AppController() {
		this._bfs = new BFS();
		this._dfs = new DFS();
		this._view = new AppView();
		this.signal = 0;
	}
	
	public void run() throws NumberFormatException, IOException {
		fileInput();
		this._view.scan(signal);
		this._bfs.buildBFS(graph, v, signal);
		this._dfs.buildDFS(graph, v, signal);
	}
	
	private void fileInput() throws NumberFormatException, IOException {
		BufferedReader buf = new BufferedReader(new FileReader("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습11주차\\graph.txt"));

	    int graphSize = Integer.parseInt(buf.readLine());
	     
	    graph = new int[graphSize][graphSize];
	     
	    for(int i = 0; i < graphSize; i++) {
	    	String str = buf.readLine();
	    	String[] strArr = str.split(" ");
	        
	    	for(int j = 0; j < graphSize; j++) {
	    		graph[i][j] = Integer.parseInt(strArr[j]);
	    	}
	    }
	    buf.close();
	    
	    this.v = new vertex[graphSize];
	    
	    this.vertexArray();
	}
	
	
	private void vertexArray() {
		for(int i =0 ; i < this.v.length; i++) {
			v[i] = new vertex();
			v[i].index = i;
		}
	}
}
