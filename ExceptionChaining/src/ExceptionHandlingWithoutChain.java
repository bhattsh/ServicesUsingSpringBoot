import java.io.IOException;

public class ExceptionHandlingWithoutChain {

	public static void main(String[] args)
	{
		try {
			m1();
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
	}

	private static void m1() throws Throwable {
		
			m2();		
	}

	private static void m2() throws Throwable {
		
		try {
			m3();
		}
		catch(Exception e)
		{
			throw e.initCause(new IOException("second parameter is zero"));
		}
			}

	private static void m3() throws Exception {
		throw new ArithmeticException("divide by zero");		
	}
}
