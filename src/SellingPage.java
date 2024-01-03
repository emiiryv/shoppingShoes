import java.util.ArrayList;
import java.util.Scanner;

public class SellingPage extends Page {
    private ArrayList<Shoes1> shoeList = new ArrayList<>();

    public SellingPage(User user, String userName) {
        super(user, userName);
    }

    @Override
    public boolean onPage() {
        System.out.println("Satış sayfasına hoşgeldiniz.");

        boolean exitPage = false;
        do {
            Shoes1 newShoe = createShoesPage(); // Yeni ayakkabı oluşturuluyor
            addToGlobalShoeList(newShoe); // Oluşturulan ayakkabı global listeye ekleniyor

            System.out.println("-- Eklenen Ayakkabılar --");
            printGlobalShoes(); // Global ayakkabı listesini gösterme işlemi

            System.out.print("Başka bir sayfaya geçmek istiyor musunuz? (Evet için 'e', Hayır için 'h') : ");
            String answer = input.next().toLowerCase();

            if (answer.equals("h")) {
                return false;
            } else if (answer.equals("e")) {
                exitPage = true;
            } else {
                System.out.println("Geçerli bir yanıt giriniz.");
            }
        } while (!exitPage);

        return true;
    }

    private Shoes1 createShoesPage() {
        Scanner input = new Scanner(System.in);

        System.out.println("Eklenecek Ayakkabı ID:");
        int id = input.nextInt();
        input.nextLine(); // Dummy read to consume the newline character
        System.out.println("Eklenecek Ayakkabı Tür:");
        String type = input.nextLine();
        System.out.println("Eklenecek Ayakkabı İsmi:");
        String name = input.nextLine();
        System.out.println("Eklenecek Ayakkabı Bedeni:");
        int size = input.nextInt();
        System.out.println("Eklenecek Ayakkabı Fiyatı:");
        int price = input.nextInt();

        return new Shoes1(id, type, name, size, price);
    }

    private void printGlobalShoes() {
        System.out.println("Eklenen Ayakkabılar:");
        for (Shoes1 shoe : globalShoeList) {
            System.out.println("-----------------------");
            System.out.println("Ayakkabı ID: " + shoe.getId());
            System.out.println("Ayakkabı Türü: " + shoe.getType());
            System.out.println("Ayakkabı İsmi: " + shoe.getName());
            System.out.println("Ayakkabı Bedeni: " + shoe.getSize());
            System.out.println("Ayakkabı Fiyatı: " + shoe.getPrice());
        }
    }

    private static ArrayList<Shoes1> globalShoeList = new ArrayList<>();

    private static void addToGlobalShoeList(Shoes1 shoe) {
        globalShoeList.add(shoe);
    }
}