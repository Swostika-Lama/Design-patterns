package Visitor_File_System_Handling;

import java.util.ArrayList;
import java.util.List;


public class SearchVisitor implements FileSystemVisitor{
    private String namePattern;
    private List<File> match = new ArrayList<>();

    public SearchVisitor(String namePattern){
        this.namePattern = namePattern;
    }

    @Override
    public void visit(File file){
        if (file.getName().contains(namePattern)){
            match.add(file);
        }
    }
    @Override
    public void visit(Directory directory){

    }
    public List<File> getMatch(){
        return match;
    }
}
