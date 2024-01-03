public class User {
    private String userName;
    private int userBalance;

    public User(String userName,int userBalance){
        this.userName = userName;
        this.userBalance=userBalance;
    }
    public void deductBalance(double amount) {
        if (amount > userBalance) {
            System.out.println("Yetersiz bakiye. Satın alma işlemi gerçekleştirilemedi.");
        } else {
            userBalance -= amount;
            System.out.println("Satın alma işlemi başarıyla gerçekleştirildi. Kalan bakiyeniz: " + userBalance);
        }
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }


    public void printUserInfo(){
        System.out.println("Kullanıcı:\t"+this.userName+
                " |\tBakiyeniz:\t"+this.userBalance);
    }


}