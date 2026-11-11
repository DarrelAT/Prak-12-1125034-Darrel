package prak12;

public class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void send(String message) {
        if (chatRoom != null) {
            chatRoom.sendBroadcast(this, message);
        } else {
            System.out.println(name + " belum bergabung ke chat room manapun.");
        }
    }

    public void sendPrivate(String recipientName, String message) {
        if (chatRoom != null) {
            chatRoom.sendPrivateMessage(this, recipientName, message);
        } else {
            System.out.println(name + " belum bergabung ke chat room.");
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + this.name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }
}