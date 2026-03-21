package Visitor_File_System_Handling;

public class Main {
    public static void main(String[] args) {
        //Build file system
        Directory root = new Directory("root");
        Directory images = new Directory("images");
        Directory docs = new Directory("docs");

        File f1 = new File("1.png", 9);
        File f2 = new File("2.jpg", 16);
        File f3 = new File("3.png", 17);
        File f4 = new File("test.pdf", 24);

        images.add(f1);
        images.add(f2);
        docs.add(f3);
        docs.add(f4);

        root.add(images);
        root.add(docs);

        // Visitor 1: Size Calculator
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        // Visitor 2: Search for .jpg files
        SearchVisitor searchVisitor = new SearchVisitor(".png");
        root.accept(searchVisitor);

        System.out.println("Search results for '.jpg':");
        for (File f : searchVisitor.getMatch()) {
            System.out.println(" - " + f.getName());
        }
    }

}
