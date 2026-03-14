package ChainOfResponsibility_Customer_FeedBack_Handler;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    public void handle(Message message) {
        if (message.getMessageType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Analyzing general feedback and preparing response.");
        } else if (next != null) {
            next.handle(message);
        }
    }
}

