package hms2;

public class Person {
    // Parent class of all human objects(customer,staff,manager)
    // Protected so we can use them in child classes.
    protected String ID;
    protected String name;
    protected String password;

    // setters/getters/constructors
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }

    public Person(String ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }
}
