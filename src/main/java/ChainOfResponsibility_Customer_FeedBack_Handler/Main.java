package ChainOfResponsibility_Customer_FeedBack_Handler;

public class Main {
    public static void main(String[] args) {

        // Create handlers
        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactRequestHandler();
        FeedbackHandler suggestion = new SuggestionHandler();
        FeedbackHandler general = new GeneralFeedbackHandler();

        // Build the chain
        compensation.setNext(contact);
        contact.setNext(suggestion);
        suggestion.setNext(general);

        // Create messages
        Message m1 = new Message(MessageType.COMPENSATION, "I want a refund for my order.", "user1@example.com");
        Message m2 = new Message(MessageType.CONTACT_REQUEST, "Please call me regarding my account.", "user2@example.com");
        Message m3 = new Message(MessageType.SUGGESTION, "Add dark mode to the app.", "user3@example.com");
        Message m4 = new Message(MessageType.GENERAL_FEEDBACK, "Great service!", "user4@example.com");

        // Process messages
        compensation.handle(m1);
        compensation.handle(m2);
        compensation.handle(m3);
        compensation.handle(m4);
    }
}

