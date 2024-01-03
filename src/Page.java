import java.util.Scanner;

public abstract class Page {
    private User user;
    private String userName;
    public static Scanner input = new Scanner(System.in);


    public abstract boolean onPage();

    public Page(User user, String userName) {
        this.user = user;
        this.userName = userName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
