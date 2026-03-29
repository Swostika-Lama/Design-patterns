package Builder_Computer;

public class Main {
    public static void main(String[] args) {

        // Build a Gaming Computer
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(gamingBuilder);
        Computer gamingPC = director1.constructComputer();
        System.out.println("------ Gaming Computer -----");
        System.out.println(gamingPC);

        // Build an Office Computer
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(officeBuilder);
        Computer officePC = director2.constructComputer();
        System.out.println("---- Office Computer -----");
        System.out.println(officePC);
    }
}

