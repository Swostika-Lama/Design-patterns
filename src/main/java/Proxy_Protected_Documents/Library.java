package Proxy_Protected_Documents;

import java.util.HashMap;

public class Library {
    private HashMap<String, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String date, String content) {
        RealDocument doc = new RealDocument(id, date, content);
        documents.put(id, doc);
    }

    public void addProtectedDocument(String id, String date, String content) {
        RealDocument realDoc = new RealDocument(id, date, content);
        DocumentProxy proxyDoc = new DocumentProxy(realDoc);
        documents.put(id, proxyDoc);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}

