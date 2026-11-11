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

        budi.send("Halo semuanya di General!");
        andi.send("Halo juga Budi!");

        general.muteUser(budi, cici);

        cici.send("Eh, aku kok gak bisa ngomong?");

        general.showHistory();
    }
}