package prototype_BookRecommendationSystem;

public class TargetAudience implements Cloneable{
    private String name;
    private String description;
    private int minAge;
    private int maxAge;

    public TargetAudience(String name, String description, int minAge, int maxAge) {
        this.name = name;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    @Override
    public TargetAudience clone() {
        try {
            return (TargetAudience) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning Failed !!", e);
        }
    }
    @Override
    public String toString() {
        return "TargetAudience{" + "name=" + name + ", description=" + description + ", minAge=" + minAge + ", maxAge=" + maxAge + '}';
    }
}
