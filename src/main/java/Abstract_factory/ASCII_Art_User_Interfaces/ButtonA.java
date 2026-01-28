package Abstract_factory.ASCII_Art_User_Interfaces;

class ButtonA extends Button {
    public ButtonA(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("+----------------------+");
        System.out.println("|  [A Button] " + text);
        System.out.println("+----------------------+");
    }
}



