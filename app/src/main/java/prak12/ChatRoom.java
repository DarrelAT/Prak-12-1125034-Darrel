package prak12;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members = new ArrayList<>();
    private List<String> badwords = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void addBadword(String word){
        badwords.add(word.toLowerCase());
    }

    public String filterMessage(String message) {
        String filtered = message;
        for(String word : badwords){
            String replacement = "*".repeat(word.length());
            filtered = filtered.replaceAll("(?i)\\b" + word + "\\b", replacement);
        }
        return filtered;
    }

    public void sendBroadcast(User sender, String message) {
        String filteredMessage = filterMessage(message);

        System.out.println("[ChatRoom " + roomName + "] (Broadcast dari " + sender.getName() + "): " + filteredMessage);
        for (User member : members) {
            if (!member.equals(sender)) {
                member.receiveMessage(sender, filteredMessage);
            }
        }
    }

    public void sendPrivateMessage(User sender, String recipientName, String message) {
        String filteredMessage = filterMessage(message);

        System.out.println("[ChatRoom " + roomName + "] (Private " + sender.getName() + " > " + recipientName + "): " + filteredMessage);
        for (User member : members) {
            if (member.getName().equalsIgnoreCase(recipientName)) {
                member.receiveMessage(sender, filteredMessage);
                return;
            }
        }
        System.out.println("Penerima " + recipientName + " tidak ditemukan.");
    }
}