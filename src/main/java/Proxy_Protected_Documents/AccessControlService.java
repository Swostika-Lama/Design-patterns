package Proxy_Protected_Documents;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance = new AccessControlService();
    private Set<String> allowedPairs = new HashSet<>();

    private AccessControlService(){

    }
    public static AccessControlService getInstance(){
        return instance;
    }
    public void allowAccess(String username, String documentId){
        allowedPairs.add(username + " = " + documentId);
    }
    public boolean isAllowed(String username, String documentId){
        return allowedPairs.contains(username + " = " + documentId);
    }
}
