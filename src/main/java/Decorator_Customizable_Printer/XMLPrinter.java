package Decorator_Customizable_Printer;

public class XMLPrinter extends PrinterDecorator{

    public XMLPrinter(Printer wrappedPrinter){
        super(wrappedPrinter);
    }

    @Override
    public void print(String message){
        String xmlMessage = "<message>" + message + "</message>";
        super.print(xmlMessage);
    }
}
