package prak12;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members = new ArrayList<>();

    public setChatRoom(String roomName) {
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
}