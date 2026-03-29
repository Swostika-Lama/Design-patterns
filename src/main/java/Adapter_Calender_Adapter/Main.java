package Adapter_Calender_Adapter;

public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set an initial date
        date.setDay(2);
        date.setMonth(4);
        date.setYear(1996);

        System.out.println("Initial date: " + date);

        // Advance by 10 days
        date.advanceDays(10);
        System.out.println("After advancing 10 days: " + date);

        // Advance by 40 more days
        date.advanceDays(40);
        System.out.println("After advancing 40 more days: " + date);
    }
}

