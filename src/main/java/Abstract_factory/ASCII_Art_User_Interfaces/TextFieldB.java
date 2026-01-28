package Abstract_factory.ASCII_Art_User_Interfaces;

class TextFieldB extends TextField {
    public TextFieldB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("<B-TextField> {" + text + "}");
    }
}

