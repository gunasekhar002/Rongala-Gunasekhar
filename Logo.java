package cvproject;
import java.util.*;
public class Logo extends Thread
{
    static void homePage() {
    String[] lines = {
       

"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"            @@@@@@@@   @@@      @@@         @@@@       @@@@@@@@     @@@@@@      "+"\u001b[00;1m",
"\t\t\u001b[41m"+"          @@@      @@   @@@    @@@        @@@@@@      @@@          @@    @@     "+"\u001b[00;1m",
"\t\t\u001b[41m"+"         @@@@            @@@   @@@           @@@     @@@@@@@@@@     @@@@@@      "+"\u001b[00;1m",
"\t\t\u001b[41m"+"          @@@             @@@.@@@            @@@     @@@    @@@@   @@    @@     "+"\u001b[00;1m",
"\t\t\u001b[41m"+"          @@@@    @@@     @@@@@@             @@@      @@@   @@@    @@    @@     "+"\u001b[00;1m",
"\t\t\u001b[41m"+"             @@@@@@       @@@@           @@@@@@@@@     @@@@@@       @@@@@@      "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                         @@@@    @@        @@     @@  @   @@    "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                         @   @  @  @      @@ @@   @@  @  @@     "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                         @@@@@ @@@@@@@   @@   @@ @@   @@@       "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                         @   @@@     @@  @@     @@@   @  @@     "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                         @@@@ @@     @@ @@      @@@   @   @@    "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
"\t\t\u001b[41m"+"                                                                                "+"\u001b[00;1m",
                                                                           
    };

    for (String line : lines) {
        Logo t = new Logo();
        t.start();

        try {
            Thread.sleep(10);
            System.out.println(line);
            
        } catch (InterruptedException e) {
            
        }
    }
}
	public static void main(String[] args) {
	    homePage();
	}
}
