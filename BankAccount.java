package cvproject;
import java.io.*;
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L; 
    int AccNo;
    String AccName;
    double balance;
    int age;
    String dateOfBirth;
    String acctype;
    String gender;
    String Email;
    String adhar;
    String mobile;
    String pan;
    String address;
    int atmPin;
    int atm;
    String fd;
    String Mini="";
    double loan;
    double loanAmount;
    double intrest;
    double simin;
    public BankAccount(int accNo2, String AccName, double balance, int age, String dateOfBirth, String acctype, String gender, String Email, String adhar, String mobile, String pan, String address,String fd,int atm,int atmPin,String Mini,double loan,double loanAmount,double intrest,double simin) {
        this.AccNo = accNo2;
        this.AccName = AccName;
        this.balance = balance;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.acctype = acctype;
        this.gender = gender;
        this.Email = Email;
        this.adhar = adhar;
        this.mobile = mobile;
        this.pan = pan;
        this.address = address;
	this.fd=fd;
	this.atm=atm;
	this.atmPin=atmPin;
	this.Mini=Mini;
	this.loan=loan;
	this.loanAmount=loanAmount;
	this.intrest=intrest;
	this.simin=simin;
	
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\u001b[31;1mAccount Number     : \u001b[36;1m").append(AccNo).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tAccount Holder Name: \u001b[36;1m").append(AccName).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tBalance            : \u001b[36;1m").append(balance).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tAccount Type       : \u001b[36;1m").append(acctype).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tEmail              : \u001b[36;1m").append(Email).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tMobile             : \u001b[36;1m").append(mobile).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tAddress            : \u001b[36;1m").append(address).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tAdhaar Number      : \u001b[36;1m").append(adhar).append("\n");
        sb.append("\u001b[31;1m\t\t\t\tPAN Number         : \u001b[36;1m").append(pan).append("\n");
	sb.append("\u001b[31;1m\t\t\t\tAtm Number         : \u001b[36;1m").append(atm).append("\n");
        sb.append("\u001b[33;1m\t\t\t\t-------------------------------\u001b[00;1m");
        return sb.toString();
    }

    public void setAccNo(int AccNo) {
        this.AccNo = AccNo;
    }

    public void setAccName(String AccName) {
        this.AccName = AccName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}