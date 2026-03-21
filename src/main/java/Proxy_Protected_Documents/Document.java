package Proxy_Protected_Documents;


public interface Document {
    String getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;

}
