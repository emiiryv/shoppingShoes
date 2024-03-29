import java.util.ArrayList;
import java.util.List;

public class ShoppingBagPage extends Page {
    public ShoppingBagPage(User user, String userName) {
        super(user, userName);
    }

    @Override
    public boolean onPage() {
        System.out.println("Merhaba sepetinize hoşgeldiniz " + getUserName());
        System.out.println("Buradan sepetinize ekledğiniz ürünleri görüntüleyebilir ve satın alabilirsiniz");
        System.out.print("Sepetinizi görüntülemek ister misiniz? (Evet için 'e') : ");
        String showBag = input.next().toLowerCase();
        if (showBag.equals("e")) {
            ShoppingBag.printShoppingBag();
            if (ShoppingBag.getShoppingBagList().isEmpty()) {
                System.out.println("Sepetiniz boş. Alışverişinizi tamamlamak için önce ürün ekleyin.");
                return true;
            }

            System.out.println("Alışverişinizi tamamlamak istiyor musunuz?(Bakiyeniz :" + getUser().getUserBalance() + ")");
            System.out.println("(Evet için 'e')");
            String finishShop = input.next().toLowerCase();
            if (finishShop.equals("e")) {
                List<ShoppingBag> shoppingBagList = ShoppingBag.getShoppingBagList();
                double totalPrice = 0;

                for (ShoppingBag shoppingBag : shoppingBagList) {
                    totalPrice += shoppingBag.getPrice();
                }

                if (getUser().getUserBalance() < totalPrice) {
                    System.out.println("Yetersiz bakiye! Alışveriş işlemi gerçekleştirilemedi.");
                } else {
                    List<BoughtShoes> boughtShoesList = new ArrayList<>();

                    for (ShoppingBag shoppingBag : shoppingBagList) {
                        boughtShoesList.add(new BoughtShoes(shoppingBag.getId(), shoppingBag.getShoeType(), shoppingBag.getName(),
                                shoppingBag.getSize(), shoppingBag.getPrice()));
                    }

                    System.out.println("Satın Alınan Ürünler:");
                    for (BoughtShoes boughtShoe : boughtShoesList) {
                        System.out.println("ID: " + boughtShoe.getId() + " - " + boughtShoe.getName() + " - " +
                                boughtShoe.getSize() + " Numara - Fiyat: " + boughtShoe.getPrice() + " TL");
                    }

                    getUser().deductBalance(totalPrice);

                    shoppingBagList.clear();
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
    }
