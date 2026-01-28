package Organization_Structure;


interface Organization {
    void add(Organization organization);
    void remove(Organization organization);
    double getSalary();
    String toXML(int indent);
}
