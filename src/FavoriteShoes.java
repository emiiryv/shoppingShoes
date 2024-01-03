import java.util.List;
import java.util.ArrayList;

public class FavoriteShoes extends Shoes {
    public FavoriteShoes(int id, String shoeType, String name, int size, int price) {
        super(id, shoeType, name, size, price);
    }

    private static List<FavoriteShoes> favoriteShoesList = new ArrayList<>();

    public static List<FavoriteShoes> getFavoriteShoesList() {
        return favoriteShoesList;
    }

    public static void addToFavorites(FavoriteShoes shoeToAdd) {
        favoriteShoesList.add(shoeToAdd);
        System.out.println("Ürün favorilere eklendi.");
    }
}
