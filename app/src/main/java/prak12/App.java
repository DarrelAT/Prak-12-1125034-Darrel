package prak12;

public class App {
    public static void main(String[] args) {
        ChatRoom general = new ChatRoom("General");

        general.addBadword("kasar");
        general.addBadword("jelek");

        User budi = new User("Budi");
        User andi = new User("Andi");

        general.registerUser(budi);
        general.registerUser(andi);

        budi.send("Halo andi");
        budi.send("Jangan berkata kasar ya");

    }
}