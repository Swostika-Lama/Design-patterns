package Proxy_Protected_Documents;


public class DocumentProxy implements Document{
    private RealDocument realDocument;
    private AccessControlService access = AccessControlService.getInstance();

    public DocumentProxy(RealDocument realDocument){
        this.realDocument =realDocument;
    }
    @Override
    public String getId(){
        return realDocument.getId();
    }

    @Override
    public String getCreationDate(){
        return realDocument.getCreationDate();
    }
    @Override
    public String getContent(User user) throws AccessDeniedException {
        if(access.isAllowed(user.getUsername(),realDocument.getId())){
            return realDocument.getContent(user);
        }
        throw new AccessDeniedException("User" + user.getUsername() + " is not allowed to access his document " + realDocument.getId());

    }

}
