import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Cache<T> {
	LinkedList<T> cache1;
	LinkedList<T> cache2;
	Scanner fileScan, lineScan;
	private int c1Size, c2Size, hR1, hR2, nR;
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
			boolean found = false;
			while(i < getC1Size() && i <cache1.size() && !found && !cache1.isEmpty() )
			{
				if(cache1.get(i).toString().equals(word))
				{
					found = true;
				}
				else
				{
					i++;
				}
				
			}
			if(found)
			{
				hR1++;
				removeObject(1, i, cache1.get(i));
				
			}
			else
			{
				cache1.addFirst(word);
			}
		}
		else if(testNumber == 2)
		{
			int i=0;
			boolean foundC1 = false;
			boolean foundC2 = false;
			while(i < getC1Size() && !foundC1 && i <cache1.size() && !cache1.isEmpty())
			{
				if(cache1.get(i).toString().equals(word))
				{
					foundC1 = true;
				}
				else
				{
					i++;
				}
				
			}
			if(foundC1)
			{
				hR1++;
				removeObject(1, i, cache1.get(i));
				removeObject(2, i, cache2.get(i));
				
			}
			else
			{
				while(i < getC2Size() && !foundC2 && i <cache2.size() && !cache2.isEmpty())
				{
					if(cache2.get(i).toString().equals(word))
					{
						foundC2 = true;
						
					}
					else
					{
						i++;
					}
				}
				if(foundC2)
				{
					hR2++;
					removeObject(2,i, cache2.get(i));
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
	public void removeObject(int cacheNum, int i, T word)
	{
		if(cacheNum == 1)
		{
		cache1.remove(i);
		addObject(word, 1);
		}
		if(cacheNum == 2)
		{
			cache2.remove(i);
			addObject(word,2);
			
		}
	}
	public void addObject(T word, int cacheNum)
	{
		if(cacheNum==1)
		{
		cache1.addFirst(word);
		}
		if (cacheNum == 2)
		{
			cache2.addFirst(word);
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
	