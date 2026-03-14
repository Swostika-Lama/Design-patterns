package ChainOfResponsibility_Customer_FeedBack_Handler;

public class CompensationHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getMessageType() == MessageType.COMPENSATION) {
            System.out.println("CompensationHandler: Reviewing compensation claim...");
            System.out.println("Decision: Claim approved or rejected.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}
