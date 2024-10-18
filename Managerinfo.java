package cvproject;
import cvproject.*;
import java.util.*;
public class Managerinfo
{
static Scanner sc = new Scanner(System.in);
	static  Random r=new Random();
	static ManagerLogin obj=new ManagerLogin();
	Managerinfo obj1=this;
	public static boolean login()
	{
	System.out.println("\u001b[34;1mEnter your uname and password:\u001b[00;1m\u001b[36;1m");
	System.out.print(" \u001b[34;1m\t\t   Uname Id  :\u001b[36;1m");
	String Mname =sc.next();
	System.out.print(" \u001b[34;1m\t\t   Passwod   :\u001b[36;1m");
	String pass =sc.next();
	System.out.println("\u001b[00;1m");
	if(Mname.equals(obj.get1()) && pass.equals(obj.get2()))
	{
		System.out.println("\u001b[33;1mLogin Successfully");
		return true;
	}
	else if(!Mname.equals(obj.get1()) && !pass.equals(obj.get2())){
		System.out.println("\u001b[31;1mBoth Username PassWord is incorrect");
		while(true){
		System.out.println("\u001b[34;1mEnter your mobile number\u001b[36;1m");
		long Mob =sc.nextLong();
		 if (Mob == obj.get3())
		{
			Otp();
			System.out.println(obj.get1());
			System.out.println("\u001b[35;1mLogin Again");
			login();
			
			
		}
		else
		{
		System.out.println(" \u001b[31;1mUser name not Found");
		System.out.println("\n\u001b[32;1m1 Re-enter \n2 exit\u001b[36;1m");
		int n1=sc.nextInt();
		if(n1==1){
	
		}
		else{
		System.out.println("\u001b[35;1mexit");
		return false;
		}
		}
		}
	}
	else if(!Mname.equals(obj.get1()))
	{
	System.out.println("\u001b[31;1mUsrename is Incorrect");
	System.out.println("\u001b[32;1m1 Reset username \n2 Exit\u001b[36;1m");
	int n2 = sc.nextInt();
		if(n2==1)
		{
		System.out.println("\u001b[34;1mEnter your new Username:\u001b[36;1m");
		obj.set1(sc.next());
		System.out.println("\u001b[34;1mYour Updated username is  :\u001b[36;1m"+obj.get1());
		System.out.println("\u001b[35;1mLogin Again");
		login();
		}
		else
		{
		System.out.println("\u001b[31;1mexit App");
		return false;
		}
	}
	else if(!pass.equals(obj.get2()))
	{
	System.out.println("\u001b[31;1mPassword is Incorrect");
	System.out.println("\u001b[31;1m1. Reset password \n2. Exit\u001b[36;1m");
	int n2 = sc.nextInt();
		if(n2==1)
		{
		System.out.println("\u001b[34;1mEnter your new Password:\u001b[36;1m");
		obj.set2(sc.next());
		System.out.println("\u001b[34;1mYour Updated Password is  : \u001b[36;1m"+obj.get2());
		System.out.println("\u001b[35;1mLogin Again");
		login();
		}
		else
		{
		System.out.println("\u001b[31;1mexit App");
		return false;
		}
	}
	return true;
}
	static void Otp()
	{
	int n=r.nextInt(8999)+1000;
	System.out.println("\u001b[34;1mYour Otp is : \u001b[36;1m"+n);
	System.out.println("\u001b[34;1mEnter otp : \u001b[36;1m");
	int n1=sc.nextInt();
	if(n1==n)
	{
	}
	else{
	System.out.println("\u001b[31;1mWrong otp And Re-Enter Otp");
	Otp();
	}
	}
}		