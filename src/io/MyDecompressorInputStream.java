package io;

import java.io.IOException;
import java.io.InputStream;
/**
 * this class is presented the way we read byte and byte arr to maze3d
 * MyDecompressorInputStream Class - read byte array of maze and decompress him
 * them with OutputStream and make maze3d arr
 */
public class MyDecompressorInputStream extends InputStream {

	InputStream in;
	int count;
	int lastByte;

	
	/**
	 * ctor of our class - set the InputStream of the class
	 * @param in - InputStream to set to the class
	 */
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
		this.count = 1;
	}
	/**
	 * this method read from the file
	 */
	@Override
	public int read() throws IOException {
		if(count>1)
		{
		    count--;
		    return lastByte;
		}
		lastByte=in.read();
		count=in.read();
		
		return lastByte;
		
	}

}
