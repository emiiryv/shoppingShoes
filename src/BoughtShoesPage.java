import java.util.List;

public class BoughtShoesPage extends Page {
    public BoughtShoesPage(User user, String userName) {
        super(user, userName);
    }

    @Override
    public boolean onPage() {
        System.out.println("Merhaba satın alınanlar bölümüne hoşgeldiniz " + getUserName());
        System.out.print("Satın aldığınız ürünleri görüntülemek ister misiniz? (Evet için 'e') : ");
        String showBought = input.next().toLowerCase();
        if (showBought.equals("e")) {
            List<BoughtShoes> boughtShoesList = getBoughtShoesList();

            if (boughtShoesList.isEmpty()) {
                System.out.println("Satın aldığınız ürün bulunmamaktadır.");
            } else {
                System.out.println("Satın Aldığınız Ürünler:");

                for (BoughtShoes boughtShoe : boughtShoesList) {
                    System.out.println("ID: " + boughtShoe.getId() + " - " + boughtShoe.getName() + " - " +
                            boughtShoe.getSize() + " Numara - Fiyat: " + boughtShoe.getPrice() + " TL");
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

    private List<BoughtShoes> getBoughtShoesList() {
        return BoughtShoes.getBoughtShoesList();
    }
}
