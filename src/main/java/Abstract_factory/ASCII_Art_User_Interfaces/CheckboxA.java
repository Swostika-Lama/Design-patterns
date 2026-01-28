package Abstract_factory.ASCII_Art_User_Interfaces;

class CheckboxA extends Checkbox {
    public CheckboxA(String text) { super(text); }

    @Override
    public void display() {
        System.out.println("[X] A-Checkbox: " + text);
    }
}

