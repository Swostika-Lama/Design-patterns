package prototype_BookRecommendationSystem;


public class Book implements Cloneable{
    private String author;
    private String title;
    private int publicationYear;

    public Book(String author, String title, int publicationYear){
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
    }
    @Override
    public Book clone(){
        try{
            return(Book) super.clone(); // immutable fields
        }catch (CloneNotSupportedException e ){
            throw new AssertionError("Cloned Failed !!", e);
        }
    }
    @Override
    public String toString(){
        return title + " by " + author + " published in " + publicationYear;
    }


}
