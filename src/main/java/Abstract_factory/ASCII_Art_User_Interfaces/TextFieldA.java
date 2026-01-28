package Abstract_factory.ASCII_Art_User_Interfaces;

class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }
    @Override public void display() {
        System.out.println("[A TextField] >> " + text);
    }
}
