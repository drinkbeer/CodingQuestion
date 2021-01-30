/*


What is charserver constructed? User, Chat Conversation, Message, Request
Different User? VIP, normal user
Different Room? Group Chat, Private Chat
Different Message? message


*/
public enum UserStatus{
    Online, Offline, Busy, Idle
}

public enum RequestStatus{
    Recept, Reject, Pending
}

public class User{
    private int id;
    private String nickName;
    private UserStatus status;

    private List<Conversation> chats = new ArrayList<Conversation>();
    private List<Request> requests = new ArrayList<Request>();
    private List<Message> messages = new ArrayList<Message>();

    public int getId(){return id;}
    public String getNickName(){return nickName;}
    public void setNickName(String str){this.nickName = str;}
    private void setBusy(){this.status = UserStatus.Busy;}
    private void setOnline(){this.status = UserStatus.Online;}
    private void setOffline(){this.status = UserStatus.Offline;}
    private void setIdle(){this.status = UserStatus.Idle;}

    public void addChats(Conversation conv){chats.add(conv);}   //add to curr chat list
    public void removeChats(Conversation conv){...}

    public void addRequest(Request req){requests.add(req);}     //add new request to request list
    public void removeRequest(Request req){...}
    public void sendRequest(){...}  //send the request list, and set list empty

    public void addMessage(Message msg){...}
    public void removeMessage(Message msg){...}
    public void sendMessage(Message msg){...}
}

public abstract class Conversation{
    private int id;

    protected List<User> users;
    protected List<Message> messages = new ArrayList<Message>();

    public int getId(){return id;}
    public Message createMessage(){
        String str;
        return new Message(str);
    }
    public void sendMessage(){...}
}

public class GroupChat extends Conversation{
    
    public GroupChat(){...}
    private void addUser(User user){users.add(user);}
    private void removeUser(User user){...}
}

public class PrivateChat extends Conversation{
    public PrivateChat(User u1, User u2){...}       //it's created with two users. We cannot add user in private chat
    private boolean dismissPrivateChat(){...}       //dismiss curr chat
}

public class Message{
    private int id;
    private String content;
    private Date date;

    public Message(){...}

    public int getId(){return id;}
    public Date getDate(){return date;}

    public void setMessage(String str){this.content = str;}
    public String getMessage(){return content;}

}

public class Request{
    private int id; //request id
    private User fromUser;  // as only has two users in a request, one is fromUser, another is toUser
    private User toUser;
    private RequestStatus status;
    private Date date;

    public Request(){...}
    public int getId(){return id;}
    public void setStatus(RequestStatus status){...}
    public void getStatus(){...}
    public Date getDate(){...}
    
    public void setFromUser(User user){...}
    public void setToUser(User user){...}
}

