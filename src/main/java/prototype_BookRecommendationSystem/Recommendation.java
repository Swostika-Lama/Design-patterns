package prototype_BookRecommendationSystem;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private TargetAudience targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }
    public void setTargetAudience(TargetAudience targetAudience){
       this.targetAudience = targetAudience;
    }
    public TargetAudience getTargetAudience() {
        return targetAudience;
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.targetAudience = this.targetAudience.clone(); //deep clone of targetAudience

            cloned.books = new ArrayList<>();//deep clone of books list
            for (Book book : this.books) {
                cloned.books.add(book.clone()); //deep clone of each book
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning Failed !!", e);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Audience: " + targetAudience + "\nBooks:\n");
        for (int i = 0; i < books.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(books.get(i)).append("\n");
        }
        return sb.toString();
    }

}
