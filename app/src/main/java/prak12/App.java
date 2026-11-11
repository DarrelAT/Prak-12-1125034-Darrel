package prak12;

public class App {
    public static void main(String[] args) {
        ChatRoom general = new ChatRoom("General");
        ChatRoom sports = new ChatRoom("Sports");

        User budi = new User("Budi"); 
        User andi = new User("Andi");
        User cici = new User("Cici");

        general.registerUser(budi);
        general.registerUser(andi);
        general.registerUser(cici);

        sports.registerUser(budi);
        sports.registerUser(andi);

        budi.sendToRoom(sports, "Halo teman-teman olahraga!");

        general.removeUser(budi, cici);
    }
}