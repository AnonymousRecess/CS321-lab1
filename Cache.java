import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Cache<T> {
	LinkedList<T> cache1;
	LinkedList<T> cache2;
	Scanner fileScan, lineScan;
	private int c1Size, c2Size, hR1, hR2, nR, index;
	int testNumber;
	public Cache (int testNumber, int c1Size, String fileName) throws FileNotFoundException
	{
		this.testNumber = testNumber;
		cache1 = new LinkedList<T>();
		setC1Size(c1Size);
		fileScan = new Scanner(new File(fileName));
		while(fileScan.hasNextLine())
		{
			StringTokenizer token = new StringTokenizer(fileScan.nextLine());
			while(token.hasMoreElements())
			{
				nR++;
				T word = (T) token.nextToken();
				getObject(word);
				
				//Call functions for rest of functionality
			}
		}
		System.out.println(hR1);
		
	}
	public Cache (int testNumber, int c1Size, int c2Size, String fileName) throws FileNotFoundException
	{
		this.testNumber = testNumber;
		cache1 = new LinkedList<T>();
		setC1Size(c1Size);
		cache2 = new LinkedList<T>();
		setC2Size(c2Size);
		System.out.println("First level cache with " + c1Size + " has been created");
		System.out.println("Second level cache with " + c2Size + " has been created");
		fileScan = new Scanner(new File(fileName));
		while(fileScan.hasNextLine())
		{
			StringTokenizer token = new StringTokenizer(fileScan.nextLine());
			while(token.hasMoreElements())
			{
				nR++;
				T word = (T) token.nextToken();
				getObject(word);
				//Call functions for rest of functionality
				if(nR % 10 == 0)
				{
					System.out.println(nR);
				}
			}
		}
		System.out.println(hR1);
		System.out.println(hR2);
	}
	public void getObject(T word)
	{
		if(testNumber == 1)
		{
			
			int i=0;
			
			if(cache1.indexOf(word)!=-1)
			{
				hR1++;
				cache1.remove(i);
				cache1.addFirst(word);
				
			}
			else
			{
				cache1.addFirst(word);
			}
		}
		else if(testNumber == 2)
		{
			if(cache1.size() < c1Size)
			{
				index = cache1.indexOf(word);
			}
			else
			{
				index = cache1.subList(0, c1Size-1).indexOf(word);
			}
			if(index!=-1)
			{
				hR1++;
				cache1.remove(index);
				cache2.remove(index);
				cache1.addFirst(word);
				cache2.addFirst(word);
			}
			else
			{
				if(cache2.size() < c2Size)
				{
					index = cache2.indexOf(word);
				}
				else
				{
					index = cache2.subList(0, c2Size-1).indexOf(word);
				}
				if(index!=-1)
				{
					hR2++;
					cache2.remove(index);
					cache2.addFirst(word);
					cache1.addFirst(word);
					//System.out.println(word);
				}
				else
				{
					cache1.addFirst(word);
					cache2.addFirst(word);
				}
			}
		}
	}

	public void clearCache()
	{
		
	}
	private int getC1Size()
	{
		return c1Size;
	}
	private int getC2Size()
	{
		return c2Size;
	}
	private void setC1Size(int c1Size)
	{
		this.c1Size = c1Size;
	}
	private void setC2Size(int c2Size)
	{
		this.c2Size = c2Size;
	}
}
	