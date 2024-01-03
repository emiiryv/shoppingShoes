public class ShoppingPage extends Page{
    private String pageName = "Alışveriş Sayfası";
    public ShoppingPage(User user, String userName) {
        super(user, userName);
    }



    @Override
    public boolean onPage() {
        System.out.println("Alışveriş bölümüne hoşgeldiniz " + this.getUserName());
        printInfo();
        System.out.println("Şu an satışta olan ürünleri görüntülemek ister misiniz? (Evet için 'e') ");
        String showProducts = input.next().toLowerCase();

        if (showProducts.equals("e")) {
            Shoes[] shoeList = Shoes.shoes();
            System.out.println("Satışta Olan Ürünler:");

            for (Shoes shoe : shoeList) {
                if (shoe != null) {
                    System.out.println("ID: " + shoe.getId() + " - " + shoe.getName() + " - " + shoe.getSize() + " Numara - Fiyat: " + shoe.getPrice() + " TL");
                }
            }
            System.out.println("Bu ürünlerden favorilere eklemek istediğiniz var mı? (Evet için 'e')");
            String addFav = input.next().toLowerCase();
            // ShoppingPage içinde
            if (addFav.equals("e")) {
                System.out.print("Favorilere eklemek istediğiniz ürünün ID'sini giriniz : ");
                int giveID = input.nextInt();

                FavoriteShoes favShoeToAdd = findShoeById(giveID, shoeList);
                if (favShoeToAdd != null) {
                    FavoriteShoes.addToFavorites(favShoeToAdd);
                } else {
                    System.out.println("Belirtilen ID ile bir ürün bulunamadı.");
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
    private FavoriteShoes findShoeById(int id, Shoes[] shoeList) {
        for (Shoes shoe : shoeList) {
            if (shoe != null && shoe.getId() == id) {
                return new FavoriteShoes(shoe.getId(), shoe.getType(), shoe.getName(), shoe.getSize(), shoe.getPrice());
            }
        }
        return null;
    }



    public void printInfo(){
        System.out.println("Bu sayfa içerisinde satışta olan ürünleri inceleyebilirsiniz.");
    }


}
