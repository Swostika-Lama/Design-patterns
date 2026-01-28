package Organization_Structure;

import java.util.ArrayList;
import java.util.List;

public class Department implements Organization{
    private String name;
    private List<Organization> children = new ArrayList<>();

    public Department(String name){
        this.name = name;
    }

    @Override
    public void add(Organization organization) {
        children.add(organization);

    }

    @Override
    public void remove(Organization organization) {
        children.remove(organization);

    }

    @Override
    public double getSalary() {
        return children.stream()
                .mapToDouble(Organization::getSalary)
                .sum();
    }

    @Override
    public String toXML(int indent) {
        String pad = " ".repeat(indent);
        StringBuilder sb = new StringBuilder();
        sb.append(pad).append("<department name=\"").append(name).append("\">\n");
        for (Organization c : children) {
            sb.append(c.toXML(indent + 2));
        }
        sb.append(pad).append("</department>\n");
        return sb.toString();
    }
}
