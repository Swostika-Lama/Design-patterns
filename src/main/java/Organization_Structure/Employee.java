package Organization_Structure;

class Employee implements Organization{
    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void add(Organization organization){

    }

    @Override
    public void remove(Organization organization) {

    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toXML(int indent) {
        String pad = " ".repeat(indent); return pad + "<employee name=\"" + name + "\" salary=\"" + salary + "\" />\n";
    }
}
