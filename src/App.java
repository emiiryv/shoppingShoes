import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Alışveriş sitesine hoşgeldiniz");
        System.out.println("Lütfen bir kullanıcı adı giriniz.");
        String userName = input.nextLine();
    }

}
