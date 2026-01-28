package Abstract_factory.ASCII_Art_User_Interfaces;

class ButtonB extends Button {
    public ButtonB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("==== BUTTON B ====");
        System.out.println(">> " + text);
        System.out.println("==================");
    }
}


