package prak12;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatRoom> chatRooms = new ArrayList<>(); // Support multiple rooms

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addChatRoom(ChatRoom room) {
        if (!chatRooms.contains(room)) {
            chatRooms.add(room);
        }
    }

    public void removeChatRoom(ChatRoom room) {
        chatRooms.remove(room);
    }

    public void send(String message) {
        if (!chatRooms.isEmpty()) {
            chatRooms.get(0).sendBroadcast(this, message);
        } else {
            System.out.println(name + " belum bergabung ke chat room manapun.");
        }
    }

    public void sendToRoom(ChatRoom room, String message) {
        if (chatRooms.contains(room)) {
            room.sendBroadcast(this, message);
        } else {
            System.out.println(name + " tidak terdaftar di room tersebut.");
        }
    }

    public void sendPrivate(String recipientName, String message) {
        if (!chatRooms.isEmpty()) {
            chatRooms.get(0).sendPrivateMessage(this, recipientName, message);
        } else {
            System.out.println(name + " belum bergabung ke chat room.");
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + this.name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }
}