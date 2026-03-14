package ChainOfResponsibility_Customer_FeedBack_Handler;

public class SuggestionHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getMessageType() == MessageType.SUGGESTION) {
            System.out.println("SuggestionHandler: Logging suggestion for product development.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}

