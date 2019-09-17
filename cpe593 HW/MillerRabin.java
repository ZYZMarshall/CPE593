// I pledge my honor that I have abided by the Stevens Honor System.
//HW3 for cpe593 
//author yuzhen Zhang
/** Use the Miller Rabin algorithm together with power 
 * mod to determine weather a number, passed as a command line argument, is prime or composite.
*/
import java.util.Scanner;
import java.util.Random;
public class MillerRabin
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input a number:");
		String a = scanner.next();
		int i = Integer.parseInt(a); 
        System.out.println(i +" "+ millerRabin(i));
	}
	
	public static boolean millerRabin(long n)
	{
		if(n == 0L || n == 1L)              //L ensures that number store as integet not double
			return false;
		if(n == 2L || n == 3L)
			return true;
		if(n % 2L == 0L)
			return false;
		int d = 0;
		int s = 0;
		long m = n - 1;
		while ((m & 1) == 0)
		{
			s++;
			m = m >> 1;
		}
		d = (int) m;
		int temp = s;
		Random random = new Random();
		for (int i = 1; i <= 6; i++)
		{
			long a = (long)random.nextInt((int)n-3) + 2L;
			long x = PowerMod(a, d, n);
			if (x == 1 || x == (int) (n - 1))
				continue;
			boolean witness = false;
			s = temp;
			while(s > 1 && !witness)
			{
					x = (x * x) % n;
					if (x == 1)
						return false;
					if (x == n - 1)
					{
						witness = true;
						break;
					}
					s--;
			}
			if (!witness)
				return false;
		}
		return true;
	}

	public static long PowerMod(long a, int d, long n)
	{
		long prod = 1;
		while(d > 0)
		{
			if (d % 2 != 0)
				prod = (prod * a) % n;
			a = (a * a) % n;
			d = d / 2;
		}
		return prod;
	}
}
