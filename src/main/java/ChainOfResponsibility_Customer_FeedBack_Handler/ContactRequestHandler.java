package ChainOfResponsibility_Customer_FeedBack_Handler;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getMessageType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request to support team.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}
