package Decorator_Customizable_Printer;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer wrappedPrinter) {
        super(wrappedPrinter);
    }

    private String encrypt(String message) {
        StringBuilder encrypt = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypt.append((char)(c + 3)); // simple Caesar shift
        }
        return encrypt.toString();
    }

    @Override
    public void print(String message) {
        String encrypted = encrypt(message);
        super.print(encrypted);
    }
}
