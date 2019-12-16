import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//String address,
public class fileInput {
	private int[][] graph;
	private vertex[] v;
	public void fileInput(String address, int indirected) throws NumberFormatException, IOException {
		BufferedReader buf = new BufferedReader(new FileReader(address));
	    int graphSize = Integer.parseInt(buf.readLine());
	     
	    graph = new int[graphSize][graphSize];
	    int start, end, weight;
	    while(true) {
	    	String str = buf.readLine();
	    	if(str == null) {
	    		break;
	    	}
	    	String[] strArr = str.split(" ");
	        
	    	start = Integer.parseInt(strArr[0]);
	    	end = Integer.parseInt(strArr[1]);
	    	weight = Integer.parseInt(strArr[2]);
	    	
	    	graph[start][end] = weight;
	    	if(indirected == 0) {
		    	graph[end][start] = weight;
	    	}
	    }
	    buf.close();
	    
	    v = new vertex[graphSize];
	    
	    this.vertexArray(v);
	}
	private void vertexArray(vertex[] v) {
		for(int i =0 ; i < v.length; i++) {
			v[i] = new vertex(i);
		}
	}
	
	public int[][] getGraph(){
		return graph;
	}
	public vertex[] getVertex() {
		return this.v;
	}
}
