package Visitor_File_System_Handling;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
