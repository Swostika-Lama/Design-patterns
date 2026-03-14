package ChainOfResponsibility_Customer_FeedBack_Handler;

public class Message {
    private MessageType messageType;
    private String messageContent;
    private String senderEmail;

    public Message(MessageType messageType, String messageContent, String senderEmail){
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType(){
        return messageType;
    }
    public String getMessageContent(){
        return messageContent;
    }
    public String getSenderEmail(){
        return senderEmail;
    }
}
