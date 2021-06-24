public class Staff extends Person implements Menu {
    // our variables now with added money operations;
    String department;
    double salary;
    private double Money;
    public static int counter=0;

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public Staff() {
    }
    // setters/getters/constructors
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Staff(String ID, String name, String password, String department, double salary) {
        super(ID, name, password);
        this.department = department;
        this.salary = salary;
        counter++;
    }
    // The method that manager will call to see info for staff objects.
    public String  Info(){
        String completeInfo="";
        completeInfo +="ID: "+getID()+"\n";
        completeInfo +="Name: "+getName()+"\n";
        completeInfo +="Department: "+getDepartment()+"\n";
        completeInfo +="Salary: "+getSalary()+"\n";
        return  completeInfo;
    }

    @Override
    public void menu() {
        System.out.println("Please enter choice:\n0 to display your own information \n1 to receive a work notification \n2 to accept overwork\n3 to quit your job");
        System.out.println("Or type -1 to exit program");
    }
}
