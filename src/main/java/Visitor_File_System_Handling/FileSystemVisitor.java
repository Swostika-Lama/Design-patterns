package Visitor_File_System_Handling;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}
