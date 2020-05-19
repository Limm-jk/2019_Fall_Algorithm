

import java.io.IOException;


public class AppController {
	private Union_set _us1, _us2;
	
	public AppController() {
		this._us1 = new Union_set();
		this._us2 = new Union_set();
	}
	
	public void run() throws IOException {
		System.out.println("_________________________Data_1_________________________");
		this._us1.fileInput("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습9주차\\data1.txt");
		this._us1.printele("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습9주차\\output_1.txt");
		System.out.println("_________________________Data_2_________________________");
		this._us2.fileInput("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습9주차\\data2.txt");
		this._us2.printele("C:\\Users\\Free\\Desktop\\Algorithm\\[Al]실습9주차\\output_2.txt");
	}
	
	
}
