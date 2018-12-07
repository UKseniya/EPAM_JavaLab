import java.util.*;

public class Employee {
    private int id;
    private int parentId;
    private String name;
    private List<Employee> reports = new ArrayList<>();
    static int space = 0;

    public Employee(int id, int parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getReports() {
        return reports;
    }

    public void setReports(List<Employee> reports) {
        this.reports = reports;
    }

    public void printReports() {
        if(this.getReports().size() != 0){
            space++;
            for (Employee report : reports){
                for(int i = 0; i < space; i++){
                    System.out.print("    ");
                }
                System.out.println(report);
                if(report.getReports().size() != 0){
                    report.printReports();
                }
            }
            space--;
        }
    }

    public void printLeaders(Map<Integer, Employee> employees){
        if(this.getParentId() != 0){
            space++;
            Employee leader = employees.get(parentId);
            for(int i = 0; i < space; i++){
                System.out.print("    ");
            }
            System.out.println(leader);
            if(leader.getParentId() != 0){
                leader.printLeaders(employees);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                parentId == employee.parentId &&
                Objects.equals(name, employee.name) &&
                Objects.equals(reports, employee.reports);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, parentId, name, reports);
    }

    @Override
    public String toString() {
        return name;
    }
}
