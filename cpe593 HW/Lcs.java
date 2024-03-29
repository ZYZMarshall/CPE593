import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lcs {
	public static void main(String[] args) {
		char[] arr1 = readFile();
		char[] arr2 = readFile();
		int similarity = findLCS(arr1, arr2);
		System.out.println("The similarity of the two files is "+similarity+" byte(s) ");
	}

	public static char[] readFile()  {
		String path;
		StringBuffer sb = new StringBuffer();
		Scanner input = new Scanner(System.in);
		System.out.println("Please print one of the file paths（eg：src/packageName/fileName.txt）: ");
		path = input.nextLine();
		try {
			FileReader fr = new FileReader(path);
			int ch;
			while(( ch = fr.read()) != -1) {
				sb.append((char) ch);
			}
			String content = sb.toString();
			content = content.replace(" ", "");		// remove all the space 
			return content.toCharArray();
		} catch (IOException e) {
			System.out.println("The file doesn't exist.Please try again.");
			e.printStackTrace();
		}
		return null;
	}

	public static int findLCS(char[]a,char[]b) {
		int m = a.length, n = b.length;
		int[][]c = new int[m][n];
		c[0][0] = (a[0]==b[0]) ? 1 : 0;
		for (int i = 1; i < m; i++) {
			c[i][0] = (a[i] == b[0]) ? 1 : c[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			c[0][i] = (b[i] == a[0]) ? 1 : c[0][i-1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				c[i][j] = ((a[i] == b[j]) ? c[i-1][j-1]+1 : max(c[i-1][j],c[i][j-1]));
			}
		}
		return c[m-1][n-1];
	}
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static void sys(char[] arr1) {
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]);
		}
	}
}