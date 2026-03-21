package Proxy_Protected_Documents;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService access = AccessControlService.getInstance();

        // Users
        User eric = new User("Eric");
        User ronav = new User("Ronav");

        // Add documents
        library.addUnprotectedDocument("doc1", "01-02-2026", "This is public document.");
        library.addProtectedDocument("doc2", "03-03-2026", "This is protected document.");

        // Allow eric to access doc2
        access.allowAccess("eric", "doc2");

        // Test access
        try {
            System.out.println("Eric reads doc1: " +
                    library.getDocument("doc1").getContent(eric));

            System.out.println("Eric reads doc2: " +
                    library.getDocument("doc2").getContent(eric));

            System.out.println("Ronav reads doc2: " +
                    library.getDocument("doc2").getContent(ronav));

        } catch (AccessDeniedException e) {
            System.out.println("ACCESS DENIED: " + e.getMessage());
        }
    }
}

