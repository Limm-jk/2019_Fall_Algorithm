package Al_10_201602057_¿”¡ÿ±‘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LCS {
	private int size1,size2;
	private int outcount = 0;
	private Node[][] table;
	private char[] st1,st2,output;
	public LCS() {
		outcount = 0;
	}
	public void fileInput(String filename) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader Buf = new BufferedReader(new FileReader(filename));

		size1 = Integer.parseInt(Buf.readLine());
		st1 = new char[size1];
		for(int i = 0; i<size1; i++) {
			st1[i] = (char)Buf.read();
		}
		Buf.readLine();
		size2 = Integer.parseInt(Buf.readLine());
		st2 = new char[size2];
		for(int i = 0; i<size2; i++) {
			st2[i] = (char)Buf.read();
		}
		this.output = new char[size1+size2];
	}
	public void printele(String filename) throws IOException {
		BufferedWriter file = new BufferedWriter(new FileWriter(filename));


		//for(int i = 0; i < this.output.length; i++) {
			file.write(output);
		//}
		file.close();
		this.outcount = 0;
	}
	public void LCS_length(){
		table = new Node[size1+1][size2+1];
		for(int i = 0; i<size1+1; i++) {
			for(int j = 0; j<size2+1; j++) {
				table[i][j] = new Node();
			}
		}
		for(int i = 1; i<size1+1; i++) {
			for(int j = 1; j<size2+1; j++) {
				if(st1[i-1] == st2[j-1]) {
					table[i][j].setmaxvalue(table[i-1][j-1].maxvalue()+1);
					table[i][j].setarrow(0);
				}
				else if(table[i-1][j].maxvalue()>=table[i][j-1].maxvalue()) {
					table[i][j].setmaxvalue(table[i-1][j].maxvalue());
					table[i][j].setarrow(1);
				}
				else {
					table[i][j].setmaxvalue(table[i][j-1].maxvalue());
					table[i][j].setarrow(2);
				}
			}
		}
	}
	public void printLCS(int i, int j) {
		if(i==0 || j==0) {
			return;
		}
		if(table[i][j].arrow() == 0) {
			this.printLCS(i-1, j-1);
			System.out.print(st1[i-1]);
			this.output[this.outcount] = st1[i-1];
			this.outcount++;
		}
		else if(table[i][j].arrow()==1) {
			this.printLCS(i-1, j);
		}
		else {
			this.printLCS(i, j-1);
		}

	}
	public int sizex() {
		return this.size1;
	}
	public int sizey() {
		return this.size2;
	}
}
