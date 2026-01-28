package Abstract_factory.ASCII_Art_User_Interfaces;

public class Main {
    public static void main(String[] args) {

        // Choose a style (A or B)
        UIFactory factory = new AFactory();
        // UIFactory factory = new BFactory();

        Button btn = factory.createButton("Click me!");
        TextField tf = factory.createTextField("Enter your name.");
        Checkbox cb = factory.createCheckbox("Confirm All");

        btn.display();
        tf.display();
        cb.display();

        System.out.println("\n--- Updating text dynamically ---\n");

        btn.setText("Updated Button Text");
        tf.setText("Updated Field");
        cb.setText("Updated Checkbox");

        btn.display();
        tf.display();
        cb.display();
    }
}

