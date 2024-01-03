public class Shoes {
    private int id;
    private String type;
    private String name;
    private int size;
    private int price;

    public Shoes(int id, String type, String name, int size, int price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public static Shoes[] shoes(){
        Shoes[] shoeList = new Shoes[100];
        shoeList[0] = new Shoes(1,"Sneaker","Nike Dunk Low",43,3000);
        return shoeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setShoeType(String shoeType) {
        this.type = type;
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