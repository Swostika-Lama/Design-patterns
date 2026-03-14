package ChainOfResponsibility_Customer_FeedBack_Handler;

public abstract class FeedbackHandler {
    protected FeedbackHandler next;
    public void setNext(FeedbackHandler next){
        this.next = next;
    }

    public abstract void handle(Message message);
}
