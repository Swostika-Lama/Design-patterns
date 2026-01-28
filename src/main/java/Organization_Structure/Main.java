package Organization_Structure;

public class Main {
    public static void main(String[] args) {

        // Root of the organization
        Department root = new Department("Head Office");

        // Sub-departments
        Department hr = new Department("HR");
        Department it = new Department("IT");
        Department dev = new Department("Development");

        // Employees
        Employee e1 = new Employee("Amir", 5500);
        Employee e2 = new Employee("Avi", 5000);
        Employee e3 = new Employee("Shyam", 4000);
        Employee e4 = new Employee("Dinesh", 6000);

        // Build structure
        hr.add(e1);
        hr.add(e2);

        dev.add(e3);
        it.add(dev);
        it.add(e4);

        root.add(hr);
        root.add(it);

        // Print total salary
        System.out.println("Total salary of organization: " + root.getSalary());

        // Print XML structure
        System.out.println("\nOrganizational Structure (XML):");
        System.out.println(root.toXML(0));

        //remove
        System.out.println("\n=== REMOVING Avi FROM HR ===");
        hr.remove(e2);  // Remove employee Avi
        System.out.println(root.toXML(0)); System.out.println("Total salary after removal: " + root.getSalary());
    }
}

