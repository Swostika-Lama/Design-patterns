package Facade_API;


public class FxRateDemo {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String baseCurrency = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );

            System.out.println("Base currency from FX API:");
            System.out.println(baseCurrency);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

