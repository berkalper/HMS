import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;



import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    Manager manager = new Manager();
    private int sum, sum2, total, total2,bookedForDays;
    private String tempStaffID, tempStaffName, tempStaffPassword, tempStaffDepartment,adminKey,expKey,expWrongKey;
    private Double tempStaffSalary;
    private ArrayList<Customer> customers;
    private Customer customer, customer2;
    private Room[] roomlist = new Room[1];
    private ArrayList<Room> rooms;
    private Room room1, room2, room3;
    private Person person1;
    private ArrayList<Staff> staff;
    private Staff staff1,staff2;

    @BeforeEach
    public void setUp() throws Exception {





        //Used in testGenerateBill
        total = 600;
        total2 = 800;

        //Used in testRoom
        rooms = new ArrayList<Room>();
        room1 = new Room(1, 200);
        room2 = new Room(2, 300);
        room3 = new Room(3, 500);
        rooms.add(0, room1);
        rooms.add(1, room2);
        rooms.add(2, room3);


        //Used in testManager
        manager = new Manager("1", "SerhatUzunbayır", "nightshift");


        //Used in testCustomer
        customers = new ArrayList<Customer>();
        customer = new Customer("109", "Zeynep", "muse",500);
        customer2 = new Customer("110", "Ali", "linkinpark",200);

        customers.add(0, customer);
        customers.add(1, customer2);

        person1 = new Person();

        //Used in testStaff
        staff = new ArrayList<Staff>();
        staff1 = new Staff("10", "EgeSevinc", "1", "IT", 10);
        staff2 = new Staff("50","Memo","0","Kitchen",60);
        staff.add(0, staff1);
        staff.add(1,staff2);


        tempStaffID = "10";
        tempStaffName = "Ahmet";
        tempStaffPassword = "111";
        tempStaffDepartment = "Cleaning";
        tempStaffSalary = 213.4;


        //Used in testCountEmptyRooms
        roomlist[0] = new Room(1, 200);
        roomlist[0].setRoomNumber(1);
        roomlist[0].setBookedforDays(10);

        //Used in getAdminKey
        adminKey= "SE318HMS2";
        expKey = Manager.getAdminKey();
        expWrongKey = "askh";

        //Used in testSetGetBookedForDays
        bookedForDays = 10;



    }

    void tearDown() {

    }

    @Test
    public void testGetAdminKey(){
        assertEquals(expKey,adminKey);
        assertNotEquals(expWrongKey,adminKey);
    }



    @Test
    public void testSetGetBookedForDays(){
        room1.setBookedforDays(bookedForDays);

        assertEquals(bookedForDays,room1.getBookedforDays());
        assertNotEquals(bookedForDays-1,room1.getBookedforDays());

    }

    @Test
    public void testSetGetDailyPay(){

        room1.setDailyPay(200);

        assertEquals(200,room1.getDailyPay());
        assertNotEquals(100,room1.getDailyPay());


    }

    @Test
    public void testSetGetType(){

        room1.setType(1);

        assertEquals(1,room1.getType());
        assertNotEquals(2,room1.getType());
    }

    @Test
    public void testSetGetRoomNumber(){

        room1.setRoomNumber(1);

        assertEquals(1,room1.getRoomNumber());
        assertNotEquals(2,room1.getRoomNumber());
    }

    @Test
    public void testSetGetID(){

        person1.setID("1");

        assertEquals("1",person1.getID());
        assertNotEquals("2",person1.getID());

    }

    @Test
    public void testSetGetName(){

        person1.setName("Ege");

        assertEquals("Ege",person1.getName());
        assertNotEquals("Elif",person1.getName());

    }

    @Test
    public void testSetGetPassword(){

        person1.setPassword("123");

        assertEquals("123",person1.getPassword());
        assertNotEquals("321",person1.getPassword());

    }

    @Test
    public void testSetGetDepartment(){

        staff1.setDepartment("Kitchen");

        assertEquals("Kitchen",staff1.getDepartment());
        assertNotEquals("Laundry",staff1.getDepartment());

    }

    @Test
    public void testSetGetSalary(){

        staff1.setSalary(100);

        assertEquals(100,staff1.getSalary());
        assertNotEquals(200,staff1.getSalary());

    }

    @Test
    public void testSetGetStaffMoney(){

        staff1.setMoney(100);

        assertEquals(100,staff1.getMoney());
        assertNotEquals(200,staff1.getMoney());

    }

    @Test
    public void testSetGetBank(){

        manager.setBank(100);

        assertEquals(100,manager.getBank());
        assertNotEquals(200,manager.getBank());

    }

    @Test
    public void testSetGetCustomerMoney(){

        customer.setMoney(100);

        assertEquals(100,customer.getMoney());
        assertNotEquals(200,customer.getMoney());

    }

    @Test
    public void testSetGetMoneyOnHold(){

        customer.setMoneyOnHold(100);

        assertEquals(100,customer.getMoneyOnHold());
        assertNotEquals(200,customer.getMoneyOnHold());

    }

    @Test
    public void testSetGetRoom(){

        customer.setRoom(room1);

        assertEquals(room1,customer.getRoom());
        assertNotEquals(room2,customer.getRoom());

    }


    @Test
    public void testRoom() {

        assertEquals(1, rooms.get(0).getType());
        assertEquals(200, rooms.get(0).getDailyPay());

        assertEquals(2, rooms.get(1).getType());
        assertEquals(300, rooms.get(1).getDailyPay());

        assertNotEquals(490, rooms.get(2).getType());
        assertNotEquals(0, rooms.get(2).getDailyPay());

    }

    @Test
    public void testCustomer() {

        assertEquals("109", customers.get(0).getID());
        assertEquals("Zeynep", customers.get(0).getName());
        assertEquals("muse", customers.get(0).getPassword());
        assertEquals(500, customers.get(0).getMoney());


        assertNotEquals("111", customers.get(1).getID());
        assertNotEquals("Mehmet", customers.get(1).getName());
        assertNotEquals("ironmaiden", customers.get(1).getPassword());
        assertNotEquals(100, customers.get(1).getMoney());


    }

    @Test
    public void testGenerateBill() {

        sum = Main.generateBill(300, 2);
        sum2 = Main.generateBill(200, 3);

        assertEquals(sum, total);
        assertNotEquals(sum2, total2);

    }


    @Test
    public void testManager() {

        assertEquals("1", manager.ID);
        assertEquals("SerhatUzunbayır", manager.name);
        assertEquals("nightshift", manager.password);


        assertNotEquals("2", manager.ID);
        assertNotEquals("SerhatUzunbayırx", manager.name);
        assertNotEquals("nightshiftx", manager.password);

    }

    @Test
    public void testStaff() {

        assertEquals("10", staff1.ID);
        assertEquals("EgeSevinc", staff1.name);
        assertEquals("1", staff1.password);
        assertEquals("IT", staff1.department);
        assertEquals(10, staff1.salary);

        assertNotEquals("11", staff1.ID);
        assertNotEquals("DemetSudeKan", staff1.name);
        assertNotEquals("2", staff1.password);
        assertNotEquals("Kitchen", staff1.department);
        assertNotEquals(20, staff1.salary);

    }

    @Test
    public void testCountEmptyRooms() {

        assertEquals(1, roomlist[0].getType());
        assertEquals(200, roomlist[0].getDailyPay());
        assertEquals(10, roomlist[0].getBookedforDays());
        assertEquals(1, roomlist[0].getRoomNumber());

        assertNotEquals(2, roomlist[0].getType());
        assertNotEquals(300, roomlist[0].getDailyPay());
        assertNotEquals(20, roomlist[0].getBookedforDays());
        assertNotEquals(2, roomlist[0].getRoomNumber());


    }


    @Test
    public void testAddNewStaff() {


        Staff tempStaff = new Staff(tempStaffID, tempStaffName, tempStaffPassword, tempStaffDepartment, tempStaffSalary);
        staff.add(1, tempStaff);

        assertEquals("10", tempStaff.getID());
        assertEquals("Ahmet", tempStaff.getName());
        assertEquals("111", tempStaff.getPassword());
        assertEquals("Cleaning", tempStaff.getDepartment());
        assertEquals(213.4, tempStaff.getSalary());

        assertNotEquals("1", staff.get(1).getID());
        assertNotEquals("sgadfg", staff.get(1).getName());
        assertNotEquals("sdfsagfdsg", staff.get(1).getPassword());
        assertNotEquals("sdsagdfg", staff.get(1).getDepartment());
        assertNotEquals(134, staff.get(1).getSalary());

    }

    @Test
    public void testStaffExpense(){

        assertEquals(70,Main.staffExpense(staff));
        assertNotEquals(20,Main.staffExpense(staff));

    }

    @Test
    public void testQuitJob(){

        Main.quitJob(staff,staff1);

        assertEquals(staff2,staff.get(0));
        assertNotEquals(staff1,staff.get(0));
    }


    @Test
    public void testCustomerMoneyGain(){
        customer.setMoneyOnHold(100);
        customer2.setMoneyOnHold(200);


        assertEquals(300,Main.customerMoneyGain(customers));
        assertNotEquals(100,Main.customerMoneyGain(customers));

    }

    @Test
    public void testHoldMoney(){

        Main.holdMoney(customer,100);

        assertEquals(100,customer.getMoneyOnHold());
        assertNotEquals(200,customer.getMoneyOnHold());


    }


    @Test
    public void testRemoveStaff(){


        manager.removeStaff(staff,staff1.getID());

        assertEquals(staff.get(0),staff2);
        assertNotEquals(staff.get(0),staff1);


    }

    @Test
    public void testCounter(){
        Staff.counter = 0 ;

        staff1 = new Staff("10", "EgeSevinc", "1", "IT", 10);
        staff2 = new Staff("50","Memo","0","Kitchen",60);

        assertEquals(2,Staff.counter);
        assertNotEquals(1,Staff.counter);

    }

    @Test
    public void testRoomTypeSet(){
        customer.setRoom(roomlist[0]);

        assertEquals(1,roomlist[0].getType());
        assertNotEquals(2,roomlist[0].getType());

    }

    @Test
    public void testGlobalVariables(){

        Main.roomCounter = 0;
        Main.emptyRoomCounter = 0;

        assertEquals(0,Main.roomCounter);
        assertNotEquals(1,Main.roomCounter);

        assertEquals(0,Main.emptyRoomCounter);
        assertNotEquals(1,Main.emptyRoomCounter);

    }

}

