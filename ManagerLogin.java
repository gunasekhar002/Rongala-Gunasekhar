package cvproject;
public class ManagerLogin
{
	private String Mname ="Manager";
	private String pass="Mana";
	private long Mob=8688253219l;
	public void set1(String Mname){
		this.Mname=Mname;
	}
	public void set2(String pass)
	{
		this.pass =pass;
	}
	public void set3(long Mob)
	{
		this.Mob =Mob;
	}
	public String get1()
	{
		return Mname;
	}
	public String get2()
	{
		return pass;
	}
	public long get3()
	{
		return Mob;
	}
}