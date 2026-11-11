package prak12;

public class App {
    public static void main(String[] args) {
        User budi = new User("Budi");
        User andi = new User("Andi");
        User cici = new User("Cici");

        budi.addContact(andi);
        budi.addContact(cici);

        budi.sendMessage(andi, "Halo Andi!");
    }
}