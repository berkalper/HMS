public class Customer extends Person implements Menu {

    // These attributes are for money operations and room
    private double Money;
    private double moneyOnHold;
    private Room room;

    // setters/getters/constructors
    public static int custCOUNTER=0;

    public Customer(String ID, String name, String password, double money) {
        super(ID, name, password);
        Money = money;
        custCOUNTER++;
    }

    public Customer() {
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public double getMoneyOnHold() {
        return moneyOnHold;
    }

    public void setMoneyOnHold(double moneyOnHold) {
        this.moneyOnHold = moneyOnHold;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void menu() {
        System.out.println("Please enter choice:\n0 to book rooms\n1 to extend booking\n2 to cancel booking");
        System.out.println("Or type -1 to exit program");
    }
}
