package Al_10_201602057_임준규;

import java.io.IOException;

public class AppController {
	private int sizea,sizeb;
	private LCS _lcs = new LCS();
	
	public AppController() {
		
	}
	
	public void run() throws IOException {
		this._lcs.fileInput("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습10주차\\LCS_Data.txt");
		this._lcs.LCS_length();
		sizea = this._lcs.sizex();
		sizeb = this._lcs.sizey();
		this._lcs.printLCS(sizea, sizeb);
		this._lcs.printele("C:\\\\Users\\\\Free\\\\Desktop\\\\Algorithm\\\\[Al]실습10주차\\\\output.txt");
	}
}
