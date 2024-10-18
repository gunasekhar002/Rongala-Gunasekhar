package cvproject;
import cvproject.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;

public class BankManagementSystem9{
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();
    static BankManagementSystem9 obj = new BankManagementSystem9();
    static String IFSC = "CV168002748";
    //static File file = new File("Bank.txt");
    static ArrayList<BankAccount> accountsList = new ArrayList<>();
     static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    static Date cd = new Date();
    static int otp = 0;
	int c=0;
	static int m=0;
	static String n=null;
    public static void main(String[] args) {
	Logo.homePage();
        try {
            loadAccounts();
            int choice=1;
	    int n1=0;
	    while(true){
		
            System.out.println("\t\t\u001b[34;1m1. Already An User\u001b[00;1m");
            System.out.println("\t\t\u001b[35;1m2. New User\u001b[00;1m");
		n = System.console().readLine();
		break;
	   }
            if (n.equals("1")) {
		while(true){
		try{
                System.out.println("\t\t\u001b[34;1m1. Manager\u001b[00;1m");
                System.out.println("\t\t\u001b[35;1m2. User\u001b[00;1m");
		System.out.println("\t\t\u001b[33;1m3. Home");
                n1 = sc.nextInt();
		break;
		}
		catch(Exception e){
		System.out.println("Invalid , Please choose Valid Option");
		sc.nextLine();
		}
		}
                if (n1==1) {
		boolean M=Managerinfo.login();
                    do {
			if(M){
			while(choice!=0){
			try{
			displayMenuManager();
                        choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                obj.createAccount();
                                break;
                            case 2:
                                obj.displayAllAccounts1();
                                break;
                            case 3:
                                obj.searchAccount();
                                break;
                            case 4:
                                obj.deleteAccountM();
                                break;
                            case 5:
                                obj.updateAccount();
                                break;
                            case 6:
                                obj.sortAndDisplayAccounts();
                                break;
                            case 7:
                                obj.sortAndSaveAccounts();
                                break;
                            case 8:
                                obj.bankAccountClose();
                                break;
                            case 9:
                                obj.miniStatement();
                                break;
			    case 10:
				loanClear();
				break;
			    case 11:
				main(null);
				System.exit(0);
                            case 0:
                                System.out.println("\u001b[31;1mExiting...\u001b[00;1m");
                                break;
                            default:
                                System.out.println("\u001b[31;1mInvalid choice. Please try again.\u001b[00;1m");
				break;
				}
			}	
                        catch(Exception e)
			{
				System.out.println("\u001b[31;1mInvalid Input,\u001b[34;1mPlease Enter Your choice:\u001b[00;1m");
			}
			}
			}
			else{
					System.out.println("\u001b[31;1mLogin Failed \u001b[00;1m");
					System.exit(0);
			}
			
                    } while (choice != 0);
                } else if (n1==2) {
                	boolean b=false;
                	System.out.print("\u001b[34;1mEnter you Mobile Number :\u001b[36;1m");
                	String mobile=sc.next();
                	 for (BankAccount account : accountsList) {
                         if (account.mobile.equals(mobile)) {
                             OTP();
                           
                             b = true;   
                         }
                     }
                	if(b) {
                    do {
                        
			while(choice!=0){
			displayMenuUser();
			try{
                        choice = sc.nextInt();
			
                        switch (choice) {
                            case 1:
                                obj.searchAccount();
                                break;
                            case 2:
                                obj.deleteAccount();
                                break;
                            case 3:
                                obj.updateAccount();
                                break;
                            case 4:
                                obj.deposit();
                                break;
                            case 5:
                                obj.withdraw();
                                break;
                            case 6:
                                obj.balanceEnquiry();
                                break;
                            case 7:
                                atmPinGenerate();
                                break;
                            case 8:
                                obj.bankAccountClose();
                                break;
                            case 9:
                                obj.goldLoan();
                                break;
                            case 10:
                                obj.miniStatement();
                                break;
                            case 11:
                                obj.mobileNumberChange();
                                break;
                            case 12:
                                obj.accountConverter();
                                break;
                            case 13:
                                obj.panCardUpdate();
                                break;
			    case 14:
                                obj.emailUpdate();
                                break;
                            case 15:
                                obj.addressUpdate();
                                break;
			    case 16:
				atmWithdraw();
				break;
			    case 17:
				loanClear();
				break;
			    case 18:
				forgotPin();
				break;
			    case 19:
				main(null);
				System.exit(0);
                            case 0:
                                System.out.println("\u001b[31;1mExiting...\u001b[00;1m");
                                break;
                            default:
                                System.out.println("\u001b[31;1mInvalid choice. Please try again.\u001b[00;1m");
                        }
			}
			catch(Exception e)
			{
				System.out.println("\u001b[31;1mInvalid Input,\u001b[34;1mPlease Enter Your choice:\u001b[00;1m");
			}
			}
                    } while (choice != 0);
                }
                	else
                	{
                		System.out.println("\u001b[31;1mRecord Not Found\n");
                		main(null);
				System.exit(0);
                	}
                }
		else if(n1==3)
		{
			main(null);
			System.exit(0);
		}
            }
            else if (n.equals("2")) {
                obj.createAccount();
		loadAccounts();
		saveAccounts();
		main(null);
		System.exit(0);
            } else {
                System.out.println("\u001b[31;1mI don't know who you are ?\u001b[00;1m");
		main(null);
		System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void displayMenuManager() {
        System.out.println("\u001b[32;1m\t\tManager Options: ");
        System.out.println("\t\t1. Create New Account");
        System.out.println("\t\t2. Display All Accounts");
        System.out.println("\t\t3. Search Account");
        System.out.println("\t\t4. Delete Account");
        System.out.println("\t\t5. Update Account");
        System.out.println("\t\t6. Sort Accounts On Screen");
        System.out.println("\t\t7. Sort Accounts In File");
        System.out.println("\t\t8. Bank Account Close");
        System.out.println("\t\t9. Bank Statement");
	System.out.println("\t\t10. Loan Payment");
	System.out.println("\t\t11. Home");
        System.out.println("\t\t0. Exit\u001b[00;1m");
        System.out.print("\u001b[34;1mEnter your choice: \u001b[00;1m");
    }

    static void displayMenuUser() {
        System.out.println("\u001b[32;1m\t\tUser Options: ");
        System.out.println("\t\t1. Your Account Information");
        System.out.println("\t\t2. Delete Account");
        System.out.println("\t\t3. Update Account");
        System.out.println("\t\t4. Deposit");
        System.out.println("\t\t5. Withdraw");
        System.out.println("\t\t6. Balance Enquiry");
        System.out.println("\t\t7. ATM Pin Generate");
        System.out.println("\t\t8. Bank Account Close");
        System.out.println("\t\t9. Gold Loan");
        System.out.println("\t\t10. Bank Statement");
        System.out.println("\t\t11. Mobile Number Change");
        System.out.println("\t\t12. Account Converter");
        System.out.println("\t\t13. Pan Card Update");
        System.out.println("\t\t14. Email Update");
        System.out.println("\t\t15. Address Update");
	System.out.println("\t\t16. Atm To Withdraw");
	System.out.println("\t\t17. Loan Payment");
        System.out.println("\t\t18. Forgot Atm Pin");
	System.out.println("\t\t19. Home");
        System.out.println("\t\t0. Exit\u001b[00;1m");
        System.out.print("\u001b[34;1mEnter your choice: \u001b[00;1m");
    }

    public void createAccount() {
        try {
            String name = Name();
            int age = Age();
            String dob = DateOfBirth(age);
            String gender = Gender();
            String email = Email();
            String adhaar = Adhaar();
            String mobile = Mobile();
            String pan = Pan();
            String address = Address();
            String accountType = AccountType();

            int AccNo = gAccNo();
            String fd = df.format(cd);
	    String Mini="";
	    double loan =0;
	    double loanAmount =0;
	    int atmPin=0;
	    double intrest=0;
	    double simin=0;

            System.out.print("\u001b[34;1mEnter initial deposit amount (min 500)  : \u001b[36;1m");
            double iniDep = sc.nextDouble();
            while (iniDep < 500) {
                System.out.print("\u001b[31;1mEntered amount must be 500 or more. Please enter again: \u001b[36;1m");
                iniDep = sc.nextDouble();
            }
	    System.out.println("\u001b[34;1mYour Account Number is \t\t\t: \u001b[36;1m"+AccNo+"\u001b[00;1m"); 
            int atm=generateATM();
	    BankAccount account = new BankAccount(AccNo, name, iniDep, age, dob, accountType, gender, email, adhaar, mobile, pan, address,fd,atm,atmPin,Mini,loan,loanAmount,intrest,simin);
            accountsList.add(account);
            saveAccounts();	
            OTP();
   	    System.out.println("\u001b[33;1mAccount created successfully!");
        } catch (Exception e) {
            System.out.println("\u001b[31;1mError creating account: " + e.getMessage()+"\u001b[00;1m");
        }
    } 
    
    private int gAccNo() {
        int currentAccNo = r.nextInt(890000000) + 1000000000;
        for (BankAccount account : accountsList) {
        	if (account.AccNo == currentAccNo) {
        		gAccNo();
        	}
        }
        return currentAccNo;
	}

	public void displayAllAccounts1() {
        System.out.println("-----------------------------");
        for (BankAccount account : accountsList) {
            System.out.println("\t\t\t"+account.toString());
        }
        System.out.println("-----------------------------");
    }

    public void searchAccount() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number to search\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        System.out.println("\u001b[00;1m-----------------------------");
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.println("\t\t\t"+account.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mRecord Not Found\u001b[00;1m");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
        System.out.println("-----------------------------");
    }

    public void deleteAccount() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number to delete \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        System.out.println("\u001b[00;1m-----------------------------");
        boolean found = false;
        Iterator<BankAccount> iterator = accountsList.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.AccNo == AccNo) {
		if(account.loan!=0){
			System.out.println("\u001b[31;1mSorry!,Your Loan is Pending");
			while(true){
			System.out.println("\u001b[34Do you want to close the loan\u001b[36;1m\n1. yes \n2.No");
			int n=sc.nextInt();
			if(n==1)
			{
			loanClear();
			break;
			}
			else if(n==2){
				System.out.println("\u001b[31;1mSorry! Please clear your Loan");
				return;
			}
			}
		}
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            saveAccounts();
            System.out.println("\u001b[33;1mRecord Deleted Successfully");
		main(null);
	    System.exit(0);
        } else {
            System.out.println("\u001b[31;1mRecord Not Found");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
        System.out.println("-----------------------------");
    }
 public void deleteAccountM() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number to delete \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        System.out.println("\u001b[00;1m-----------------------------");
        boolean found = false;
        Iterator<BankAccount> iterator = accountsList.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.AccNo == AccNo) {
		if(account.loan!=0){
			System.out.println("\u001b[31;1mSorry!,Your Loan is Pending");
			while(true){
			System.out.println("\u001b[34Do you want to close the loan\u001b[36;1m\n1. yes \n2.No");
			int n=sc.nextInt();
			if(n==1)
			{
			loanClear();
			break;
			}
			else if(n==2){
				System.out.println("\u001b[31;1mSorry! Please clear your Loan");
				return;
			}
			}
		}
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            saveAccounts();
            System.out.println("\u001b[33;1mRecord Deleted Successfully");
        } else {
            System.out.println("\u001b[31;1mRecord Not Found");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
        System.out.println("-----------------------------");
    }


    public void updateAccount() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number to update \t\t\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
	sc.nextLine();
        boolean found = false;
        ListIterator<BankAccount> iterator = accountsList.listIterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter New Account Holder Name \t\t\t: \u001b[36;1m");
                String name = sc.nextLine();
                System.out.print("\u001b[34;1mEnter New Balance\t\t\t\t: \u001b[36;1m");
                double balance = sc.nextDouble();
                System.out.print("\u001b[34;1mEnter New Account Type (Savings/Current)       : \u001b[36;1m");
                String accountType = sc.next();
               iterator.set(new BankAccount(AccNo, name, balance, account.age, account.dateOfBirth, accountType, account.gender, account.Email, account.adhar, account.mobile, account.pan, account.address,account.fd,account.atm,account.atmPin,account.Mini,account.loan,account.loanAmount,account.intrest,account.simin));
                found = true;
                break;
            }
        }
        if (found) {
            saveAccounts();
            System.out.println("\u001b[33;1mRecord Updated Successfully");
        } else {
            System.out.println("\u001b[31;1mRecord Not Found");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
        System.out.println("\u001b[00;1m-----------------------------");
    }

    public void sortAndDisplayAccounts() {
        Collections.sort(accountsList, new Comparator<BankAccount>() {
            public int compare(BankAccount a1, BankAccount a2) {
                return (int) (a1.AccNo - a2.AccNo);
            }
        });
        displayAllAccounts1();
    }

    public void sortAndSaveAccounts() {
        Collections.sort(accountsList, new Comparator<BankAccount>() {
            public int compare(BankAccount a1, BankAccount a2) {
                return (int) (a1.AccNo - a2.AccNo);
            }
        });
        saveAccounts();
        System.out.println("\u001b[33;1mAccounts sorted and saved successfully!\u001b[00;1m");
    }

    public void deposit() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number \t\t\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter amount to deposit \t\t: \u001b[36;1m");
                double amount = sc.nextDouble();
                account.balance += amount;
                System.out.println("\u001b[33;1mDeposit successful.  \u001b[34;1m\t   New balance  : \u001b[36;1m" + account.balance);
                found = true;
                account.fd = df.format(cd);
                account.Mini=account.Mini+"\u001b[34;1m\t\t\tdeposit Amount           : \u001b[36;1m"+amount+"\n"+"\u001b[34;1m\t\t\ttotal Balance is         :\u001b[36;1m "+ account.balance+"  \n\u001b[34;1m\t\t\tTransaction Time is      : \u001b[36;1m"+account.fd+"\n\t\t\t--------------------------------\n";
		
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
    }

    public void withdraw() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number\t\t\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
	sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter amount to withdraw \t\t: \u001b[36;1m");
                double amount = sc.nextDouble();
                if (amount > account.balance) {
                    System.out.println("\u001b[31;1mInsufficient balance.");
                } else {
                    account.balance -= amount;
                    System.out.println("\u001b[34;1mWithdrawal successful. \u001b[34;1m\t   New balance: \u001b[36;1m" + account.balance);
                }
                found = true;
                account.fd= df.format(cd);
                account.Mini=account.Mini+"\u001b[34;1m\t\t\tWithdrawn Amount         \u001b[36;1m: "+amount+"\n"+"\u001b[34;1m\t\t\ttotal Balance is         : \u001b[36;1m"+ account.balance+"  \n\u001b[34;1m\t\t\tTransaction Time is      : \u001b[36;1m"+account.fd+"\n\t\t\t------------------------------\n";
		saveAccounts();
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public void balanceEnquiry() {
	try{
        System.out.print("\u001b[34;1 mEnter Account Number \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.println("\t\t\t\u001b[34;1mAccount Number           : \u001b[36;1m" + account.AccNo);
                System.out.println("\t\t\t\u001b[34;1mAccount Holder Name      : \u001b[36;1m" + account.AccName);
                System.out.println("\t\t\t\u001b[34;1mAccount balance          : \u001b[36;1m" + account.balance);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public static void atmPinGenerate() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
		OTP();
		while(true){
                System.out.print("\u001b[34;1mEnter new ATM PIN \t: \u001b[36;1m");
		 Console console = System.console();
   		 char[] passwordArray = console.readPassword();
      		 String password = new String(passwordArray);
       		 try
        	{
		if(password.length()==4){
        		account.atmPin =Integer.parseInt(password);
			System.out.println("\u001b[33;1mATM PIN generated successfully.");
                	found = true;
			saveAccounts();
                	break;
		}
		else{
			System.out.println("\u001b[31;1mInvalid Pin");
		}
        }
        catch(Exception e)
        {
        	System.out.println("\u001b[31;1mPin Contains numbers only");
        }
	}
        }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }
    public void bankAccountClose() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number to close \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        boolean found = false;
	int c=0;
        Iterator<BankAccount> iterator = accountsList.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            if (account.AccNo == AccNo) {
		if(account.balance==0){
		if(account.loan!=0){
			System.out.println("\u001b[31;1mSorry!,Your Loan is Pending");
			while(true){
			System.out.println("\u001b[34Do you want to close the loan\u001b[36;1m\n1. yes \n2.No");
			int n=sc.nextInt();
			if(n==1)
			{
			loanClear();
			break;
			}
			else if(n==2){
				System.out.println("\u001b[31;1mSorry! Please clear your Loan");
				return;
			}
			}
		}
                iterator.remove();
                found = true;
                break;
	     }
		else{
			System.out.println("\u001b[31;1mSorry! You have an Amount of\u001b[36;1m\t\t"+account.balance);
			System.out.println(" \u001b[35;1mPlease Withdraw Your Amount Otherwise You Choose \u001b[32;1mDelete Account Option");
			c=-1;
			break;
		}
            }
        }
        if (found) {
            saveAccounts();
            System.out.println("\u001b[31;1mAccount closed successfully.");
        } else {
		if(c==-1);
		else
           	 System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public void miniStatement() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number \t\t\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        boolean found = false;
        for (BankAccount account : accountsList) {
        if (account.AccNo == AccNo) {
                System.out.println("\t\t\t\u001b[34;1mMini statement :");
                System.out.println("\t\t\t\u001b[34;1mAccount Number           : \u001b[36;1m" + account.AccNo);
                System.out.println("\t\t\t\u001b[34;1mAccount Holder Name      : \u001b[36;1m" + account.AccName);
		System.out.println("\n\t\t\t---------------------------------");
                System.out.println(account.Mini);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }
 public void goldLoan() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t\t\t: \u001b[36;1m");
        int AccNo = sc.nextInt();
	int d=0;
	saveAccounts();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
		if(account.loan==0){
                System.out.print("\u001b[34;1mEnter gold weight \t\t\t: \u001b[36;1m");
                double weight = sc.nextDouble();
                account.loanAmount = weight * 30000;
		System.out.println("\u001b[34;1mGold loan amount \t\t\t: \u001b[36;1m" + account.loanAmount);
		}
		if(account.loanAmount==account.loan)
		{
			System.out.println("\u001b[31;1mSorry, You Don't Have Any Extended Loan Amount");
			return;
		}
		if(account.loan!=0){
			System.out.println("\u001b[35;1myou are Already taken a Loan.");
			System.out.println("\u001b[33;1mDo You Want extend Your Loan? \u001b[35;1m\n1. Yes \n2. No");
			d=sc.nextInt();
			if(d==1)
			{
			System.out.println("\u001b[34;1mYour Remaining Loan Amount is \t:\u001b[36;1m"+(account.loanAmount-account.loan));
			}
			else if(d==2)
			{
				System.out.println("\u001b[33;1mYour Loan Cancelled");
				return;
			}
			
		}
                while(true){
		System.out.print("\u001b[34;1mEnter How Much You Want \t\t: \u001b[36;1m");
                Double psloan=sc.nextDouble();
                if(psloan<=account.loanAmount-account.loan){
                    found = true;
                     String fd = df.format(cd);
                    account.Mini= account.Mini+" \u001b[34;1m\t\t\tLoan Amount              :\u001b[36;1m"+psloan+"\n\u001b[34;1m\t\t\tLoan  date is            :\u001b[36;1m"+fd+" \n\t\t\t-----------------------------\n";
			while(true){
				System.out.println("\u001b[34;1m\t\t\t1. Cash  \n\t\t\t2. Bank");
				int s=sc.nextInt();
				if(s==1)
				{
					System.out.println("\u001b[33;1mgo to counter 1\u001b[00;1m");
					break;
				}
				else if(s==2){
					account.balance=account.balance+psloan;
					System.out.println("\u001b[33;1mSuccessfully deposit");
					account.loan+=psloan;
					return;
				}
			}
			System.out.println("\u001b[33;1mYour Loan Process Successfully Completed \n \u001b[35;1mGo to The Counter 2");
			account.loan+=psloan;
			saveAccounts();
                    break;
                }
		else if(account.loan!=0){
			System.out.println("\u001b[31;1mSorry! You have \u001b[36;1m"+(account.loanAmount-account.loan)+" \u001b[31;1mAmount only\u001b[00;1m");
		}
                else{
                    System.out.println("\u001b[34;1mYour Loan Ammount below the \u001b[36;1m"+account.loanAmount+"\u001b[34;1m  amount");
                    c++;
                    if(c==3)
                    {
                        System.out.println("\u001b[31;1mSorry ! Your Loan is Cancelled due to your Loan attemps more than 3 ");
                        break;
                    }
                }
            }
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");
		sc.nextLine();  
	}
    }
public static void loanClear()
{
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t\t\t: \u001b[00;1m");
        int AccNo = sc.nextInt();
	int d=0;
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
		found =true;
		System.out.println("\u001b[34;1mYour Loan Amount is \t\t\t: \u001b[36;1m"+account.loan);
		account.intrest=((account.loan)*12)/100;
		account.simin=account.loan+account.intrest;
		while(true){
		System.out.println("\u001b[32;1m\t\t1. Loan clear \n\t\t2. Intrest check \n\t\t3. Total loan check \n\t\t4. Home");
		int n=sc.nextInt();
		if(n==1)
		{
			while(true){
			System.out.println("\u001b[35;1m\t\t\t1. Cash \n\t\t\t2. Bank");
			int n1=sc.nextInt();
			if(n1==1)
			{
				System.out.println("\u001b[34;1mYour total Loan is \t\t\t:\u001b[36;1m "+account.simin+"\n\u001b[34;1mActual Amount is \t\t\t: \u001b[36;1m"+account.loan+"\n\u001b[34;1mIntrest \t\t\t\t: \u001b[36;1m"+account.intrest);
				System.out.print("\u001b[34;1mEnter amount to pay loan\t\t:\u001b[36;1m");
				double amt=sc.nextDouble();
				System.out.println("\u001b[35;1mGo to the counter 3");
				if(account.simin==amt){
					System.out.println("\u001b[33;1myour Loan Successfully Completed");
					account.fd= df.format(cd);
                account.Mini=account.Mini+"\u001b[34;1m\t\t\tClear Loan Amount        \u001b[36;1m: "+account.loan+"  \n\u001b[34;1m\t\t\tTransaction Time is      : \u001b[36;1m"+account.fd+"\n\t\t\t------------------------------\n";
		saveAccounts();
					account.loan=0;
					account.intrest=0;
					account.simin=0;
					return;
				}
				
			}
			else if(n1==2)
			{
				System.out.println("\u001b[35;1mYour Loan payment is Processing .....:");
				if(account.balance<account.simin)
				{
					new Thread().start();
					try{
					Thread.sleep(2000);
					System.out.println("\u001b[31;1mInsufficient balance");
					}
					catch(Exception e){
					}
					return;
				}
				account.balance-=account.simin;
				account.fd= df.format(cd);
               			account.Mini=account.Mini+"\u001b[34;1m\t\t\tClear Loan Amount        \u001b[36;1m: "+account.loan+"  \n\u001b[34;1m\t\t\tTransaction Time is      : \u001b[36;1m"+account.fd+"\n\t\t\t------------------------------\n";
		saveAccounts();
					account.loan=0;
					account.intrest=0;
					account.simin=0;
				System.out.println("\u001b[33;1myour Loan Successfully Completed");
				return;
			}
			}
		}
		else if(n==2)
		{
			System.out.println("\u001b[34;1mYour Intrest is \t\t\t:\u001b[36;1m"+account.intrest);
			
		}
		else if(n==3)
		{
			System.out.println("\u001b[34;1mYour total Loan is \t\t\t:\u001b[36;1m"+account.simin+"\n\u001b[34;1mActual Amount is \t\t\t:\u001b[36;1m"+account.loan+"\n\u001b[34;1mIntrest \t\t\t\t:\u001b[36;1m "+account.intrest);
			System.out.println("\u001b[35;1mDo you want Close your loan \u001b[32;1m\n1. yes \n2. No");
			int n2=sc.nextInt();
			if(n2==1){
				System.out.println("\u001b[34;1mYour Loan payment is Processing .....:");
				if(account.balance<account.simin)
				{
					System.out.println("\u001b[31;1mInsufficient balance");
					return;
				}
				account.balance-=account.simin;
				account.fd= df.format(cd);
                		account.Mini=account.Mini+"\u001b[34;1m\t\t\tClear Loan Amount        \u001b[36;1m: "+account.loan+"  \n\u001b[34;1m\t\t\tTransaction Time is      : \u001b[36;1m"+account.fd+"\n\t\t\t------------------------------\n";
		saveAccounts();
					account.loan=0;
					account.intrest=0;
					account.simin=0;
				System.out.println("\u001b[33;1myour Loan Successfully Completed");
				return;
			}
			else if(n2==2)
			{
					
			}
		}
		else if(n==4)
		{
			main(null);
			System.exit(0);
		}
		}
	}
	}
	if(!found)
	{
		System.out.println("\u001b[31;1mRecord Not Found");
	}
	}
	catch(Exception e)
	{
		System.out.println("\u001b[31;1mInvalid Input, please try again later");
		sc.nextLine();
		return;
	}
}

    public void mobileNumberChange() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter new mobile number \t: \u001b[36;1m");
                String mobile = sc.nextLine();
                account.mobile = mobile;
                System.out.println("\u001b[33;1mMobile number changed successfully.");
                found = true;
		saveAccounts();
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
    }

    public void accountConverter() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter new account type (Savings/Current)  : \u001b[36;1m");
                String accountType = sc.next();
                account.acctype = accountType;
                System.out.println("\u001b[33;1mAccount type changed successfully.");
                found = true;
		saveAccounts();
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public void panCardUpdate() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
               int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter new PAN card number  \t: \u001b[36;1m");
                String pan = sc.next();
                account.pan = pan;
                System.out.println("\u001b[33;1mPAN card number updated successfully.");
                found = true;
		saveAccounts();
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public void aadharCardUpdate() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter new Aadhar card number  \t: \u001b[36;1m");
                String s =System.console().readLine();
                if (s.startsWith("0")) {
                    System.out.println("\u001b[31;1mInvalid! Aadhar number cannot start with 0.");
			continue;
                } 
		int dc=0;
		if(s.length()==12|| s.length()==14)
		{
		    for(int i=0;i<s.length();i++)
		    {
		        char ch=s.charAt(i);
		        if(Character.isDigit(ch))
		          dc++;
		        else if((i==4||i==9)&&(s.charAt(4)==' '&&s.charAt(9)==' '));
		        else
		        {
		            dc=-1;
		            break;
		        }
		    }
		}
        	if (dc==12) {
           	 account.adhar=s;
               	System.out.println("\u001b[33;1mAadhar card number updated successfully.");
                found = true;
		saveAccounts();
                break;
        	} else {
            	System.out.println("\u001b[31;1mIncorrect! The Aadhaar number is not valid.");
		return;
        	}
            }
        }
        if (!found) {
            System.out.println("\u001b[31 ;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again"); 
	}
    }

    public void emailUpdate() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                System.out.print("\u001b[34;1mEnter new email \t\t: \u001b[36;1m");
                String email = sc.next();
                account.Email = email;
                System.out.println("\u001b[33;1mEmail updated successfully.");
                found = true;
		saveAccounts();
                break;
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are a Name  Please Try Again"); 
	}
    }

    public void addressUpdate() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
	sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
                while(true){
                System.out.print("\u001b[34;1mEnter new address  \t\t: \u001b[36;1m");
                String address = System.console().readLine();;
                Pattern pattern = Pattern.compile("^[[A-Z][a-z],]*(?: ,[A-Z][a-z]*)*$");
                Matcher matcher = pattern.matcher(address);
                if(matcher.find()){
                     account.address = address;
                    System.out.println("\u001b[33;1mAddress updated successfully.");
                    found = true;
		saveAccounts();
                    break;
                }
                else{
                    System.out.println("\u001b[31;1mInvalid address format Like : Hyderabad");
                }
            }
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
    }

    public void displayAllAccounts() {
        for (BankAccount account : accountsList) {
            System.out.println(account.toString());
        }
    }

    public static void saveAccounts() {
        try {
            FileOutputStream fos = new FileOutputStream("accounts.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountsList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("\u001b[31;1mError saving accounts: " + e.getMessage());
        }
    }

	@SuppressWarnings("unchecked")
	public static void loadAccounts() {
        try {
            FileInputStream fis = new FileInputStream("accounts.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            accountsList = (ArrayList<BankAccount>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            accountsList = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            System.out.println("\u001b[31;1mError loading accounts: " + e.getMessage());
        }
    }
    static String Name() {
        String a="";
        String b="";
        String c="";
        while (true) {
            System.out.print("\u001b[34;1mEnter Account Holder Full Name  : ");
            System.out.println("\u001b[35;1m" + "Note: Words Start With Uppercase and Remaining Letters Should be Small (e.g., Abdul Kalam)" + "\u001b[36;1m");
            System.out.println("\u001b[31;1m\t\t\t\t  if you don't have any middle name enter \u001b[33;1mNone");
            while(true){
            System.out.print("\u001b[34;1m\t\t\t   first name   : \u001b[36;1m");
            a = sc.next();
               Pattern pattern = Pattern.compile("^[A-Z][a-z]*(?: [A-Z][a-z]*)*$");
                Matcher matcher = pattern.matcher(a);
                if (matcher.matches()) {
                   break;
                } else {
                    System.out.println("\u001b[31;1mInvalid Name, Please Enter a Valid Name (e.g., \u001b[33;1mAbdul).");
                }
            }
            while(true){
            System.out.print("\u001b[34;1m\t\t\t   middle name  : \u001b[36;1m");
            b = sc.next();
               Pattern pattern = Pattern.compile("^[A-Z][a-z]*(?: [A-Z][a-z]*)*$");
                Matcher matcher = pattern.matcher(b);
                if (matcher.matches()) {
                    break;
                } else {
                    System.out.println("\u001b[31;1mInvalid name, if you don't have any middle name enter \u001b[33;1mNone \u001b[31;1mOtherwise enter Like\u001b[33;1mAbdul");
                }
            }
            while(true){
            System.out.print("\u001b[34;1m\t\t\t   last name    : \u001b[36;1m");
            c = sc.next();
               Pattern pattern = Pattern.compile("^[A-Z][a-z]*(?: [A-Z][a-z]*)*$");
                Matcher matcher = pattern.matcher(c);
                if (matcher.matches()) {
                    break;
                } else {
                    System.out.println("\u001b[31;1mInvalid Name, Please Enter a Valid Name (e.g., \u001b[33;1mAbdul).");
                }
            }
            String s="";
            if(b.equals("None"))
                s = a.concat(" "+c);
            else
                s=a.concat(" "+b).concat(" "+c);
             return s;
            }
        }
   static int Age() {
        while(true){
        try{
        System.out.print("\u001b[34;1mEnter Your Age  \t\t\t: \u001b[36;1m");
        int age = sc.nextInt();
        if(age<=5 ||age>100) {
            System.out.println("\u001b[31;1mYou Are Not Eligible  Please Enter Valid Age  ");
        }
	else
        return age;
    }
    catch(Exception e)
    {
            System.out.println("\u001b[31;1mYou are Enter Non Integer Number.");
    }
    }
    }

    static String DateOfBirth(int age) {
           while (true) {
        try {
            System.out.print("\u001b[34;1mEnter date of Birth (dd/mm/yyyy) \t:\u001b[36;1m ");
            String dob = sc.next();
            String[] parts = dob.split("/");
            if (parts.length != 3) {
                throw new IllegalArgumentException("\u001b[31;1mDate format should be dd/mm/yyyy.");
            }
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            if (2024 - year == age) {
                if (isValidDate(day, month, year)) {
                    return dob;
                } else {
                    System.out.println("\u001b[31;1mInvalid Date of Birth. Please enter a valid one.");
                }
            } else {
                System.out.println("\u001b[31;1mAge does not match the provided Date of Birth.");
            }
        } catch (NumberFormatException e) {
            System.out.println("\u001b[31;1mInvalid input. Please enter date in numeric format.");
        } catch (IllegalArgumentException e) {
            System.out.println("\u001b[31;1m"+e.getMessage());
        }
    }
}
static boolean isValidDate(int day, int month, int year) {
    if (month < 1 || month > 12) return false;
    if (day < 1 || day > 31) return false;
    if (month == 2) {
        if (LeapYear(year)) {
            return day <= 29;
        } else {
            return day <= 28;
        }
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
        return day <= 30;
    }
    return true;
}

static boolean LeapYear(int year) {
    return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
}

   static String Gender() {
        System.out.print("\u001b[34;1mEnter Gender (Male/Female)  \t\t: \u001b[36;1m");
        String gender = sc.next();
        while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            System.out.print("\u001b[31;1mInvalid gender. Please enter Male or Female: \u001b[36;1m");
            gender = sc.next();
        }
        return gender;
    }


    static String Email() {
       while(true){
	System.out.print("\u001b[34;1mEnter Your Email \t\t\t: \u001b[36;1m");
	 String email = sc.next();
        String pattern = "^[A-Za-z0-9._%+-]+@[egmail]+\\.[cominorg]{2,}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);

        if (m.find()) {
		return email;
        } else {
            System.out.println("\u001b[31;1mIncorrect! The email address is not valid.");
        }
	}	
    }
    static String Adhaar() {
        while (true) {
                System.out.print("\u001b[34;1mEnter your Adhar Card Number \t\t: \u001b[36;1m");
                    String s =System.console().readLine();
                if (s.startsWith("0")) {
                    System.out.println("\u001b[31;1mInvalid! Aadhar number cannot start with 0.");
			continue;
                } 
		int dc=0;
		if(s.length()==12|| s.length()==14)
		{
		    for(int i=0;i<s.length();i++)
		    {
		        char ch=s.charAt(i);
		        if(Character.isDigit(ch))
		          dc++;
		        else if((i==4||i==9)&&(s.charAt(4)==' '&&s.charAt(9)==' '));
		        else
		        {
		            dc=-1;
		            break;
		        }
		    }
		}
        	if (dc==12) {
           	 return s;
        	} else {
            	System.out.println("\u001b[31;1mIncorrect! The Aadhaar number is not valid.");
        	}
            
        }
    }
    static String Mobile() {
        while (true) {
          System.out.print("\u001b[34;1mEnter your Mobile Number  \t\t: \u001b[36;1m");
          String mobile = sc.next();
               
       	 if (mobile.startsWith("0")) {
            System.out.println("\u001b[31;1mInvalid! Mobile number cannot start with 0.");
        } 
	else {
            String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(mobile);

            if (m.find()) {
                return mobile;
            } else {
                System.out.println("\u001b[31;1mIncorrect! The mobile number is not valid.");
            }
        }
        }
    }
    static String Pan() {
	while(true){
	 System.out.print("\u001b[34;1mEnter your Pan Card Number  \t\t: \u001b[36;1m");
	 String pancard = sc.next();
        String pattern =  "[A-Z]{5}[0-9]{4}[A-Z]{1}";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pancard);

        if (m.find()) {
            return pancard;
        } else {
            System.out.println("\u001b[31;1mIncorrect! The Pan Card Number is not valid.");
        }
	}
    }
    static String Address() {
         while (true) {
            System.out.print("\u001b[34;1mEnter your Address \t\t\t: \u001b[36;1m");
	sc.nextLine();
        String address1 = System.console().readLine();
	    
	char ch=address1.charAt(0);
        if (ch>='A' || ch<='Z') {
        return address1;
        }
        else 
        System.out.println("\u001b[31;1mInvalid Name,Please Enter Valid Name");
        }
    }
    static String AccountType() {
        System.out.print("\u001b[34;1mEnter Account Type (Savings/Current) \t: \u001b[36;1m");
        String acctype = sc.next();
        while (!acctype.equalsIgnoreCase("Savings") && !acctype.equalsIgnoreCase("Current")) {
            System.out.print("\u001b[31;1mInvalid account type. Please enter  Savings or Current: ");
            AccountType();
        }
        return acctype;
    }

    static int generateATM() {
        int atm = r.nextInt(890000000) + 1000000000;
        for(BankAccount account : accountsList)
        {
            if(account.atm==atm)
              generateATM();
        }
        System.out.println("\u001b[34;1mYour ATM Card Number is \t\t:\u001b[36;1m " + atm);
	return atm;
    }
	static void atmWithdraw()
	{
		try{
		System.out.print("\u001b[34;1mEnter Your Atm Number   \t:\u001b[36;1m ");
		int atm = sc.nextInt();
		boolean found =false;
		for(BankAccount account : accountsList)
		{  
			if(account.atm==atm)
			{
				found = true;
				if(account.acctype.equals("Savings"))
				{
					int c=0;
					while(true){
					if(account.atmPin!=0){
					int atmpin=0;
					while(true) {
					System.out.print("\u001b[34;1mEnter Your 4 digit Atm Pin \t:\u001b[36;1m");
					 Console console = System.console();
   		 			char[] passwordArray = console.readPassword();
      		 			String password = new String(passwordArray);
      		 			try {
      		 				atmpin=Integer.parseInt(password);
      		 				break;
      		 		 	}
      		 	       		 catch(Exception e)
      		 	       		 {
      		 	       		 	System.out.println("\u001b[31;1mPin Contains numbers only");
      		 	       		 }
					}
					if(account.atmPin==atmpin){
					System.out.print("\u001b[34;1mEnter amount to withdraw \t: \u001b[36;1m");
              				double amount = sc.nextDouble();
                			if (amount > account.balance) {
                    			System.out.println("\u001b[31;1mInsufficient balance.");
               				 } 
					else if(amount <=account.balance && amount <=50000){
                   				account.balance -= amount;
                    				System.out.println("\u001b[33;1mWithdrawal successful. \u001b[34;1mNew balance: \u001b[36;1m" + account.balance);
						String fd= df.format(cd);
                			account.Mini=account.Mini+"\u001b[34;1mWithdrawn Amount         : \u001b[36;1m"+amount+"\n"+"\u001b[34;1mtotal Balance is         : \u001b[36;1m"+ account.balance+"  \n\u001b[34;1mTransaction Time is      : \u001b[36;1m"+fd+"\n\t\t\t\u001b[00;1m------------------------------------\n";
					break;
                			}else{
						System.out.println("\u001b[31;1mYour withdraw amount Must be 50,000 ");
						}
					found = true;
					}
					else{
						if(c==2){
							System.out.println("\u001b[31;1mYour Pin Attempts Is Over Please Try Again Later");
							break;
						}
						System.out.println("\u001b[31;1mEnter Wrong Pin Please Try Again");
						c++;
						}
                	}
					
					else{
						System.out.println("\u001b[31;1mYou Don't have Atmpin Generator");
						System.out.println("\u001b[33;1mDo You Want Atm Pin Generator \n\u001b[35;1m1. Yes \n2. No\n");
						int a=sc.nextInt();
						if(a==1)
						{
						atmPinGenerate();	
						}
						else
						break;
					}	
				}
				}
				else if(account.acctype.equals("Current"))
				{
					int c=0;
					while(true){
					if(account.atmPin!=0){
					int atmpin=0;
					while(true) {
					System.out.print("\u001b[34;1mEnter Your 4 digit Atm Pin \t:\u001b[36;1m");
					 Console console = System.console();
   		 			char[] passwordArray = console.readPassword();
      		 			String password = new String(passwordArray);
      		 			try {
      		 				atmpin=Integer.parseInt(password);
      		 				break;
      		 		 	}
      		 	       		 catch(Exception e)
      		 	       		 {
      		 	       		 	System.out.println("\u001b[31;1mPin Contains numbers only");
      		 	       		 }
					}
					if(account.atmPin==atmpin){
					System.out.print("\u001b[34;1m\t\t\tEnter amount to withdraw \t: \u001b[36;1m");
              				double amount = sc.nextDouble();
                			if (amount > account.balance) {
                    			System.out.println("\u001b[31;1mInsufficient balance.");
               				 } 
					else if(amount <=account.balance && amount <=100000){
                   				account.balance -= amount;
                    				System.out.println("\u001b[33;1mWithdrawal successful. \u001b[34;1m\t\tNew balance: \u001b[36;1m" + account.balance);
						String fd= df.format(cd);
                			account.Mini=account.Mini+"\u001b[34;1mWithdrawn Amount         : \u001b[36;1m"+amount+"\n"+"\u001b[34;1mtotal Balance is         : \u001b[36;1m"+ account.balance+"  \n\u001b[34;1mTransaction Time is      : \u001b[36;1m"+fd+"\n\t\t\t\u001b[00;1m------------------------------------\n";
					break;
                			}else{
						System.out.println("\u001b[31;1mYour withdraw amount Must be 50,000 ");
						}
					found = true;
					}
					else{
						if(c==2){
							System.out.println("\u001b[31;1mYour Otp Attempts Is Over Please Try Again Later");
							break;
						}
						System.out.println("\u001b[31;1mEnter Wrong Otp Please Try Again");
						c++;
						}
                	}
					
					else{
						System.out.println("\u001b[31;1mYou Don't have Atmpin Generator");
						System.out.println("\u001b[33;1mDo You Want Atm Pin Generator \n\u001b[35;1m1. Yes \n2.No\n");
						int a=sc.nextInt();
						if(a==1)
						{
						atmPinGenerate();	
						}
						else
						break;
					}	
				}
				}
			}
		}
			if(!found)
			{
			System.out.println(" \u001b[31;1mRecord Not Found ");
			}
	
		
		}
	catch(Exception e)
	{
		System.out.println("\u001b[31;1mSorry ! Your are Invalid ");
	}

	}


public static void forgotPin() {
	try{
        System.out.print("\u001b[34;1mEnter Account Number  \t: \u001b[36;1m");
        int AccNo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (BankAccount account : accountsList) {
            if (account.AccNo == AccNo) {
            		System.out.print("\u001b[34;1mEnter Your atm Number   : \u001b[36;1m");
            		int atm=sc.nextInt();
            		System.out.print("\u001b[34;1mEnter Your Phone Number : \u001b[36;1m");
            		String mobile=sc.next();
            		if(account.mobile.equals(mobile) && account.atm==atm)
            		{
            			 System.out.print("\u001b[34;1mEnter new ATM PIN \t: \u001b[36;1m");
            			 Console console = System.console();
            	   		 char[] passwordArray = console.readPassword();
            	      		 String password = new String(passwordArray);
            	      		 try
            	         	{
            	 		if(password.length()==4){
            	         		account.atmPin =Integer.parseInt(password);
            	 			System.out.println("\u001b[33;1mATM PIN generated successfully.");
            	                 	found = true;
            	                 	saveAccounts();
            	                 	break;
            	 		}
            	 		else{
            	 			System.out.println("\u001b[31;1mInvalid Pin");
            	 		}
            	         }
            	         catch(Exception e)
            	         {
            	         	System.out.println("\u001b[31;1mPin Contains numbers only");
            	         }
            		}
            }
        }
        if (!found) {
            System.out.println("\u001b[31;1mAccount not found.");
        }
	}
	catch(Exception e){
		System.out.println("\u001b[31;1m Sorry! You are Enter a Name ,Please Try Again");  
	}
    }


    static void OTP() {
	while(true){
        otp = r.nextInt(8999)+1000;
        System.out.println("\u001b[34;1mYour OTP is\t\t\t\t: \u001b[36;1m" + otp);
        System.out.print("\u001b[34;1mEnter Your OTP\t\t\t\t: ");
        String otpInput = sc.next();
	String otpString = String.format("%04d", otp);
	if (otpInput.equals(otpString)) {
            System.out.println("\u001b[33;1mOTP verification is successfully completed!");
		break;
        }
        else

            System.out.println("\u001b[31;1mInvalid OTP\u001b[");
			m++;
			
		
        }
	}
    }

