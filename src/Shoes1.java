import java.util.Scanner;

public class Shoes1 extends Shoes {
    private Scanner input = new Scanner(System.in);
    private int numOfShoes = 0;
    private static final int MAX_SHOES = 100;
    private Shoes1[] addShoeList = new Shoes1[MAX_SHOES];

    public Shoes1(int id, String type, String name, int size, int price) {
        super(id, type, name, size, price);
    }


    public void addShoe() {
        Scanner input = new Scanner(System.in);
        while (numOfShoes < MAX_SHOES) {
            System.out.println("-----------------------");
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

            addShoeList[numOfShoes] = new Shoes1(id, type, name, size, price);
            numOfShoes++;

            System.out.println("-- Eklenen Ayakkabılar --");
            printShoes(); // Eklenen ayakkabıları bastırma işlemi

            System.out.println("Başka ayakkabı eklemek istiyor musunuz? (Evet=1 / Hayır=2):");
            int choice = input.nextInt();
            if (choice != 1) {
                break;
            }
        }
    }

    public Shoes1[] getShoeList() {
        return addShoeList;
    }

    public void printShoes() {
        System.out.println("Eklenen Ayakkabılar:");
        for (int i = 0; i < numOfShoes; i++) {
            System.out.println("-----------------------");
            System.out.println("Ayakkabı ID: " + addShoeList[i].getId());
            System.out.println("Ayakkabı Türü: " + addShoeList[i].getType());
            System.out.println("Ayakkabı İsmi: " + addShoeList[i].getName());
            System.out.println("Ayakkabı Bedeni: " + addShoeList[i].getSize());
            System.out.println("Ayakkabı Fiyatı: " + addShoeList[i].getPrice());
        }
    }
}