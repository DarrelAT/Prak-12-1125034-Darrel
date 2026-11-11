package prak12;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members = new ArrayList<>();
    private List<String> badwords = new ArrayList<>();
    private User admin;
    
    private List<User> mutedUsers = new ArrayList<>();
    private List<String> chatHistory = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public void registerUser(User user) {
        if (members.isEmpty()) {
            admin = user;
        }
        members.add(user);
        user.addChatRoom(this);
    }

    public void removeUser(User operator, User userToRemove) {
        if (operator.equals(admin)) {
            members.remove(userToRemove);
            userToRemove.removeChatRoom(this);
            System.out.println("[Admin " + admin.getName() + "] mengeluarkan " + userToRemove.getName() + " dari room " + roomName);
        } else {
            System.out.println(operator.getName() + " bukan admin dan tidak memiliki hak.");
        }
    }

    public void muteUser(User adminOperator, User userToMute) {
        if (adminOperator.equals(admin)) {
            mutedUsers.add(userToMute);
            System.out.println("[Admin " + admin.getName() + "] telah me-mute " + userToMute.getName());
        }
    }

    public void unmuteUser(User adminOperator, User userToUnmute) {
        if (adminOperator.equals(admin)) {
            mutedUsers.remove(userToUnmute);
            System.out.println("[Admin " + admin.getName() + "] telah membuka mute untuk " + userToUnmute.getName());
        }
    }

    public void showHistory() {
        System.out.println("=== Chat History (" + roomName + ") ===");
        for (String log : chatHistory) {
            System.out.println(log);
        }
        System.out.println("=================================");
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
        if (mutedUsers.contains(sender)) {
            System.out.println("[ChatRoom " + roomName + "] Pesan dari " + sender.getName() + " di-mute dan diabaikan.");
            return;
        }

        String filteredMessage = filterMessage(message);
        
        String logEntry = "[" + roomName + "] " + sender.getName() + ": " + filteredMessage;
        chatHistory.add(logEntry);

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