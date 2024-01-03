import java.util.ArrayList;
import java.util.List;

public class BoughtShoes extends ShoppingBag{
    private static List<BoughtShoes> boughtShoesList = new ArrayList<>();
    public BoughtShoes(int id, String shoeType, String name, int size, int price) {
        super(id, shoeType, name, size, price);
    }
    public static List<BoughtShoes> getBoughtShoesList() {
        return boughtShoesList;
    }
    public static void addToBoughtShoes(ShoppingBag shoppingBag) {
        BoughtShoes boughtShoesItem = new BoughtShoes(shoppingBag.getId(), shoppingBag.getShoeType(),
                shoppingBag.getName(), shoppingBag.getSize(), shoppingBag.getPrice());
        boughtShoesList.add(boughtShoesItem);
    }
}
