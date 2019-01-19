import java.io.EOFException;
import java.io.IOException;

public class ExceptionHandling {

	public static void main(String[] args)
	{
		try {
			m1();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	System.out.println(e.getCause());
		}
	}

	private static void m1() throws Throwable {
		try {
			m2();
		} catch (Exception e) {
			//e.printStackTrace();
			throw e.initCause(new NullPointerException("exception in method1"));
		}
		
	}

	private static void m2() throws Throwable {
		try {
			m3();
		} catch (Exception e) {
			//e.printStackTrace();
			throw  e.initCause( new EOFException("excetion inmethod two"));	
		}
		
	}

	private static void m3() throws Exception {
		throw new IOException("excetion from method three");		
	}
}
