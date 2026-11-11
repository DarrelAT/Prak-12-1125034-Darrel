package prak12;

public class App {
    public static void main(String[] args) {
        ChatRoom general = new ChatRoom("General");

        User budi = new User("Budi");
        User andi = new User("Andi");
        User cici = new User("Cici");

        general.registerUser(budi);
        general.registerUser(andi);
        general.registerUser(cici);

        budi.send("Halo semuanya!");

        budi.sendPrivate("Cici", "Rahasia ya, jangan bilang siapa-siapa!");
    }
}