package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {
	

	public MyObjectOutputStream() throws IOException, SecurityException {
		super();
}

	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	public void writeStreamHeader() {};

}
