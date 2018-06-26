import java.lang.*;
import java.util.*;
class Process
{
	int pid;
	int sta;
	int pri;
}
class Token
{
	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	int n,i;
        int temp;
	System.out.println("Enter the number of processes = ");
	n = sc.nextInt();
	Process[] obj = new Process[n];
	for(i = 0; i < n; i++)
	{
		obj[i] = new Process();
		obj[i].pid = i+1;
		System.out.println("Enter the status(0 or 1) for Process no " + (i+1) + " = ");
		obj[i].sta = sc.nextInt(); 
		System.out.println("Enter the priority for Process no " + (i+1) + " = ");
		obj[i].pri = sc.nextInt();
	}
        System.out.println("\n\n\n\n\n");
	System.out.println(" All processes and their process id,status and priority");
	for(i = 0; i < n; i++)
	{
	System.out.print(" Process no = " + obj[i].pid);
	System.out.print(" \t Status = ");
	if(obj[i].sta == 1)
		System.out.print("ON");
	else
		System.out.print("OFF");
	System.out.print(" \tPriority = " + obj[i].pri);
	System.out.print("\n");
	}
        System.out.println("\n\n\n Lets find the process coordinator ");
	int tmp = 0;
	for(i = 0; i < n; i++)
	{	
		if(obj[i].sta == 1)
		{
		if(obj[tmp].pri <= obj[i].pri)
		{
                     tmp = i;
                 }
		}
	}

	System.out.println(" Process Id of the Process Coordinator = " + (tmp+1));
	System.out.println(" Its priority  = " + obj[tmp].pri);
        System.out.println("Do you want to start an election(1,0) = ");
	int choi = sc.nextInt();
	if(choi == 1)
{
	int newstart = 0;
	System.out.println("\n Enter the process Id to start election ");
	newstart = sc.nextInt();

	System.out.println("\n\n Closing the current Process Coordinator");
	obj[tmp].sta = 0;
	System.out.println("\n\n Election takes place.....\n.\n.\n.");
	System.out.println("\n\n\n Lets find the new process coordinator ");
        int tmp2 = newstart+1;
        for(i = 0; i < n; i++)
	{	
		if(obj[i].sta == 1)
		{
		if(obj[tmp2].pri <= obj[i].pri)
		{tmp2 = i;}
		}
	}
        if(tmp2+1 != newstart)
	{
		System.out.println("It Lost the election");
	}
	else
	{
	System.out.println(" Process Id of the new Process Coordinator = " + (tmp2+1));
	System.out.println(" Its priority  = " + obj[tmp2].pri);
	for(int j = 0; j < n; j++)
	{
		if(obj[j].sta == 1 && obj[j].pri < obj[tmp2].pri)
		{
		System.out.println("Process No " + (j+1) + " has been notified of the new Coordinator");
		}
	}
	}
}
	else
	{	
	System.out.println("The coordinator remains same = ");
	System.out.println(" Process Id of the Process Coordinator = " + (tmp+1));
	System.out.println(" Its priority  = " + obj[tmp].pri);
	}	
}
}
        

