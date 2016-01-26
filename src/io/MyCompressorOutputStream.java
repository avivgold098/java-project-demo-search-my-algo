package io;

import java.io.IOException;
import java.io.OutputStream;
/**
 * this class is presented the compress we make to array that presented our maze and print the new byte arr
 * MyCompressorOutputStream Class - compress byte array of maze and streaming
 * them with OutputStream 
 * 
 */
public class MyCompressorOutputStream extends OutputStream{
	
	OutputStream out;//with this date member we write to file
	int count;
	int lastByte;
	
	/**
	 * ctor of our class set the date member out with another one
	 * @param out - OutputStream the other OutPutStream with him we set our OutPutStream-out
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
		this.count = 0;
	}
	
	/**
	 * write - this method write the array
	 * @param this array we write
	 */
	public void write(byte[] byteArray) throws IOException{	
		super.write(byteArray);
		out.write(lastByte);
		out.write(count);
		count = 0;
	}
	/**
	 * this method write one bite into file
	 * @param the bit we want to write to the file
	 */
	@Override
	public void write(int b) throws IOException {
		if(count == 0){
			lastByte = b;
			count++;
		}
		else if(lastByte == b){
			count++;
		}
		else{
			while(count > 255){
				out.write(lastByte);
				out.write(255);
				count -= 255;
			}
			
			out.write(lastByte);
			out.write(count);
			lastByte = b;
			count = 1;
		}
	}

}
