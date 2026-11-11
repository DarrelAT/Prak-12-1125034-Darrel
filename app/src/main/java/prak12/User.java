package prak12;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> contacts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addContact(User user){
        contacts.add(user);
    }

    public void sendMessage(User receiver, String message) {
        System.out.println("[" + this.name + " -> " + receiver.getName() + "]: " + message);
        receiver.receiveMessage(this, message);
    }

    public void sendGroupMessage(String message){
        System.out.println("[" + this.name + "mengirim pesan grup]: " + message);
        for (User contact : contacts) {
            contact.receiveMessage(this, message);
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + this.name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }
}