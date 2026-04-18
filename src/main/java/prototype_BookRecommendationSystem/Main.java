package prototype_BookRecommendationSystem;

public class Main {
    public static void main(String[] args) {
        //create a target audience and a recommendation
        TargetAudience youngAdults = new TargetAudience("Young Adults", "Books suitable for readers aged 18-25", 18, 25);
        Recommendation recommendation1 = new Recommendation(youngAdults);

        // Add books to recommendation1 youngAdults
        recommendation1.addBook(new Book("Suzanne Collins", "The Hunger Games", 2008));
        recommendation1.addBook(new Book("John Green", "The Fault in Our Stars", 2012));

        // Clone the recommendation
        Recommendation recommendation2 = recommendation1.clone();

        // Modify the target audience of the cloned recommendation
        TargetAudience children = new TargetAudience("Children", "Books suitable for readers aged 5-12", 5, 12);
        recommendation2.setTargetAudience(children);

        // Remove young-adult books from the children's list (optional)
         recommendation2.removeBook(0);// Remove "The Fault in Our Stars"
         recommendation2.removeBook(0);// Remove "The Hunger Games"

        // Add books for children
        recommendation2.addBook(new Book("Roald Dahl", "Charlie and the Chocolate Factory", 1964));
        recommendation2.addBook(new Book("E.B. White", "Charlotte's Web", 1952));

        // Display both recommendations
        System.out.println("=== Young Adult Recommendation ===");
        System.out.println(recommendation1);

        System.out.println("=== Children Recommendation (Cloned & Modified) ===");
        System.out.println(recommendation2);

    }
}
