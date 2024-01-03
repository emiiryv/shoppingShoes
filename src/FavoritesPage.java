import java.util.List;

public class FavoritesPage extends Page {
    private List<FavoriteShoes> favShoeList = FavoriteShoes.getFavoriteShoesList();
    public FavoritesPage(User user, String userName) {
        super(user, userName);
    }

    @Override
    public boolean onPage() {
        System.out.println("Favoriler bölümüne hoşgeldiniz " + getUserName());
        System.out.println("Favorilerinizi görüntülemek ister misiniz? (Evet için 'e') ");
        String showFavs = input.next().toLowerCase();
        if (showFavs.equals("e")) {
            List<FavoriteShoes> favShoeList = FavoriteShoes.getFavoriteShoesList();

            if (favShoeList.isEmpty()) {
                System.out.println("Favori listeniz boş.");
            } else {
                System.out.println("Favori Ürünleriniz:");

                for (FavoriteShoes favShoe : favShoeList) {
                    System.out.println("ID: " + favShoe.getId() + " - " + favShoe.getName() + " - " +
                            favShoe.getSize() + " Numara - Fiyat: " + favShoe.getPrice() + " TL");
                }
                System.out.print("Bu ürünlerden sepetinize eklemek istediğiniz ürün var mı?(Evet için 'e', Hayır için 'h') : ");
                String addBag = input.next().toLowerCase();
                if (addBag.equals("e")) {
                    System.out.print("Favori ürünlerden sepete eklemek istediğiniz ürünün ID'sini giriniz:");
                    int selectedID = input.nextInt();

                    FavoriteShoes selectedFavShoe = findFavoriteShoeByID(selectedID);

                    if (selectedFavShoe != null) {
                        ShoppingBag.addToShoppingBag(selectedFavShoe);
                        System.out.println("Seçilen favori ürün sepete eklendi.");
                    } else {
                        System.out.println("Belirtilen ID ile favori ürün bulunamadı.");
                    }
                }
            }
        }
        boolean exitPage = false;
        do {
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
    private FavoriteShoes findFavoriteShoeByID(int id) {
        for (FavoriteShoes favShoe : favShoeList) {
            if (favShoe.getId() == id) {
                return favShoe;
            }
        }
        return null;
    }
}
