import java.util.ArrayList;
import java.util.List;

public class ShoppingBag {
    private static List<ShoppingBag> shoppingBagList = new ArrayList<>();


    private int id;
    private String shoeType;
    private String name;
    private int size;
    private int price;

    public ShoppingBag(int id, String shoeType, String name, int size, int price) {
        this.id = id;
        this.shoeType = shoeType;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public static List<ShoppingBag> getShoppingBagList() {
        return shoppingBagList;
    }

    public static void addToShoppingBag(FavoriteShoes favShoe) {
        ShoppingBag shoppingBagItem = new ShoppingBag(favShoe.getId(), favShoe.getType(),
                favShoe.getName(), favShoe.getSize(), favShoe.getPrice());
        shoppingBagList.add(shoppingBagItem);

        // Satın alındığında BoughtShoes listesine de ekleyin
        BoughtShoes.addToBoughtShoes(shoppingBagItem);
    }

    public static void printShoppingBag() {
        System.out.println("Sepetinizdeki Ürünler:");

        for (ShoppingBag shoppingBagItem : shoppingBagList) {
            System.out.println("ID: " + shoppingBagItem.getId() + " - " + shoppingBagItem.getName() + " - " +
                    shoppingBagItem.getSize() + " Numara - Fiyat: " + shoppingBagItem.getPrice() + " TL");
        }
    }

    public static void setShoppingBagList(List<ShoppingBag> shoppingBagList) {
        ShoppingBag.shoppingBagList = shoppingBagList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoeType() {
        return shoeType;
    }

    public void setShoeType(String shoeType) {
        this.shoeType = shoeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
