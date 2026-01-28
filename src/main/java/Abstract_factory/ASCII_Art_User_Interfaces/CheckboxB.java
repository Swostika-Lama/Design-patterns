package Abstract_factory.ASCII_Art_User_Interfaces;

class CheckboxB extends Checkbox {
    public CheckboxB(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("(✔) B-Checkbox: " + text);
    }
}
