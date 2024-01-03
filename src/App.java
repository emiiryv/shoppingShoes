import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Merhaba! 2. El Ayakkabı alış-satış uygulamamıza hoşgeldiniz!");

        String userName = getValidStringInput("Lütfen bir kullanıcı adı giriniz : ");
        int userBalance = getValidIntInput("Lütfen bakiyenizi giriniz: ");

        User user = new User(userName, userBalance);

        System.out.println("Hoşgeldiniz alışverişe başlayabilirsiniz.");
        user.printUserInfo();
        System.out.println();

        Page page;

        do {
            System.out.println("-----Sayfalar-----");
            System.out.println("1 - Alışveriş Sayfası ");
            System.out.println("2 - Satış Sayfası");
            System.out.println("3 - Favorileriniz");
            System.out.println("4 - Sepetiniz");
            System.out.println("5 - Satın alınan ürünler");
            System.out.print("Lütfen gitmek istediğiniz bölümü seçiniz : ");
            int selectPage = input.nextInt();

            switch (selectPage) {
                case 1:
                    page = new ShoppingPage(user, userName);
                    break;
                case 2:
                    page = new SellingPage(user, userName);
                    break;
                case 3:
                    page = new FavoritesPage(user, userName);
                    break;
                case 4:
                    page = new ShoppingBagPage(user, userName);
                    break;
                case 5:
                    page = new BoughtShoesPage(user, userName);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir sayfa giriniz.");
                    page = null;
            }

        } while (page == null || page.onPage());

        System.out.println("Uygulamadan çıkış yapıldı");
    }
//getValidStringInput ve getValidIntInput metodları, aynı isme sahip fakat farklı parametre listelerine sahip iki metot içeriyor. Bu, Java'da overloading'in bir örneğidir.
    private String getValidStringInput(String promptMessage) {
        String userInput;
        do {
            System.out.print(promptMessage);
            userInput = input.nextLine();
            if (userInput.isEmpty()) {
                System.out.println("Boş giriş yapılamaz. Lütfen tekrar deneyin.");
            }
        } while (userInput.isEmpty());
        return userInput;
    }

    private int getValidIntInput(String promptMessage) {
        int userInput = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print(promptMessage);
                userInput = input.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Geçerli bir değer giriniz.");
                input.nextLine(); // Buffer temizleme
            }
        } while (!validInput);
        return userInput;
    }
}
