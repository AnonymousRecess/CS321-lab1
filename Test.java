import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		if(args.length < 3 || args.length > 4)
		{
			System.out.println("Incorrect number of arguments.");
			Usage();
		}
		if(args.length == 3 && Integer.parseInt(args[0]) != 1)
		{
			Usage();
		}
		if(args.length == 4 && Integer.parseInt(args[0]) != 2)
		{
			Usage();
		}
		if(Integer.parseInt(args[0]) == 1)
		{
			try {
			Cache<String> myCache = new Cache<String>(1, Integer.parseInt(args[1]), args[2]);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
			
		}
		if(Integer.parseInt(args[0]) == 2)
		{
			try {
				Cache<String> myCache = new Cache<String>(2, Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
	public static void Usage()
	{
		System.out.println("To create a 1st level cache provide the following arguments, in order:");
		System.out.println("(1, size of cache, name of textfile to populate cache)\n");
		System.out.println("To create a 2nd level cache provide the following arguments, in order:");
		System.out.println("(2, size of cache1, size of cache2, name of textfile to populate cache)");
		System.exit(0);
	}
	
}