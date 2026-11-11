package prak12;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void sendBroadcast(User sender, String message) {
        System.out.println("[ChatRoom " + roomName + "] (Broadcast dari " + sender.getName() + "): " + message);
        for (User member : members) {
            if (!member.equals(sender)) {
                member.receiveMessage(sender, message);
            }
        }
    }

     public void sendPrivateMessage(User sender, String recipientName, String message) {
        System.out.println("[ChatRoom " + roomName + "] (Private " + sender.getName() + " > " + recipientName + "): " + message);
        for (User member : members) {
            if (member.getName().equalsIgnoreCase(recipientName)) {
                member.receiveMessage(sender, message);
                return;
            }
        }
        System.out.println("Penerima " + recipientName + " tidak ditemukan.");
    }

}