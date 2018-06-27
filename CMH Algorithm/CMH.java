import java.lang.*;
import java.util.*;
class CMH
{	
	public static void main(String args[])
          {
	Scanner sc = new Scanner(System.in);
	int n;
	System.out.println("\nEnter the number of processes = ");
	n = sc.nextInt();
	int[][] mat = new int[n][n];
	for(int i = 0; i < n; i++ )
	{
	System.out.println("Enter the row  (" + n + "  numbers)");
	for(int j = 0; j < n; j++)
	{	
	mat[i][j] = sc.nextInt();
	}
	}
	System.out.println(" Following are connections, Matrix form = \n\n");
	for(int i = 0; i < n; i++ )
	{
	for(int j = 0; j < n; j++)
	{
	System.out.print(mat[i][j] + "    ");
	}
	System.out.println();
	}
	int a;
	int b;
	int c;
	System.out.println("\n\nNow lets check for any deadlocks");
	System.out.println("Enter the Process number which would like to check the deadlock =  ");
	a = sc.nextInt();
	if(a > n  || a < 0 )
	{
		System.out.println(" No such process exists !!! Quiting....");
		System.exit(0);
	}
	System.out.println(" The process which will start the cycle is =  " + (a)); 
	int flag = 0;
	for(int j = 0; j < n; j++)
	{
		b = a;
		if(mat[a-1][j] == 1)
		if(j != b-1)
			{
			flag = 1;
			c = j+1;
			process(a,b,c,mat,n);
			}		

	}	
	if(flag == 0)
	{
                  System.out.println("NO DEADLOCK!!!!!");
             }
	System.out.println("NO DEADLOCK!!!!!");
	
}
public static void process(int a, int b, int c, int[][] mat, int n)
{
	int i;
	int j;
	int tmp;
	if( a == c)
	{
		System.out.println(" It has found a cycle, Hence Deadlock exists.....");
		System.exit(0);
	}
	else
	{	System.out.println(" Hasnt found deadlock yet.... Looking for deadlocks....");
	}
	for(j = 0; j < n; j++)
	{
		if(mat[b-1][j] == 1)
		{	
			if(j != b-1)
			{
			tmp = c;
			c = j+1;
			process(a,tmp,c,mat,n);
			}
		}		
	}
}}

