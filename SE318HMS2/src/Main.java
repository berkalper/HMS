import java.util.*;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class Main {
    public static void main(String[]args){
        // These are our room variations we have 10 of room1 5 of room2 and 2 of room3.
        // They are kept in an array because we have fixed number of rooms in a hotel.
        // After we create our arrays we initialize our rooms with their type and dailyPay accordingly


        Room[] roomsType1 = new Room[10];
        for(int i=0;i< roomsType1.length;i++){
            roomsType1[i]= new Room(1,200);
            roomsType1[i].setRoomNumber(i+1);
        }

        Room[] roomsType2 = new Room[5];
        for(int i=0;i< roomsType2.length;i++){
            roomsType2[i]=new Room(2,300);
            roomsType2[i].setRoomNumber(i+1);
        }

        Room[] roomsType3 = new Room[2];
        for(int i=0;i< roomsType3.length;i++){
            roomsType3[i]=new Room(3,500);
            roomsType3[i].setRoomNumber(i+1);
        }

        // Arraylist of customers and staff will hold our staff and customer objects.
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Staff> staff  = new ArrayList<Staff>();

        // This flag is for controlling the most outer loop
        // It is implemented so that if we want to make another login after initial login we can just erase flag
        // But currently it is implemented so that you cannot go between different logins.
        // (For example i logged in as customer i cannot go back and log in as staff.
        boolean flag = true;

        Scanner input = new Scanner(System.in);

        // These checks turn true if user enters correct ID and password and after that we can display our menu for that type of user.
        boolean managerCheck = false;
        boolean staffCheck = false;
        boolean customerCheck = false;

        // These are the inner loops for all 3 logins(customer,staff,manager)
        boolean ManagerLoopCheck = true;
        boolean StaffLoopCheck = true;
        boolean CustomerLoopCheck = true;

        // These are example objects in our system we created.
        Manager manager =new Manager ("1","SerhatUzunbayır","nightshift");
        manager.setBank(500);
        // Key is SE318HMS2 for manager its in Manager class getAdminKey method.

        Staff staff1 = new Staff("10","EgeSevinc","1","IT",10);
        Staff staff2 = new Staff("20","DemetSudeKan","1","Recepsionist",20);
        Staff staff3 = new Staff("30","BerkAlper","1","Financial",30);


        Customer customer = new Customer("101","Ada","90",300);
        Customer customer2 = new Customer("102","Efe","91",400);
        Customer customer3 = new Customer("103","Cansu","92",500);
        Customer customer4 = new Customer("104","Okan","93",300);
        Customer customer5 = new Customer("105","Emre","94",100);
        Customer customer6 = new Customer("106","Tuana","95",500);
        Customer customer7 = new Customer("107","Müge","96",350);

        // And we add our objects to their correct arraylists
        // There is only 1 manager (owner) so we don't need an arraylist for it.
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);

        // simulating some customers that paid for their rooms and are waiting for approval by manager (customermoneygain method)
        customer2.setRoom(roomsType1[0]);
        customer2.setMoneyOnHold(200);
        customer2.setRoom(roomsType1[0]);
        customer2.getRoom().setBookedforDays(1);

        customer3.setRoom(roomsType2[1]);
        customer3.setMoney(300);
        customer3.setMoneyOnHold(300);
        customer3.setRoom(roomsType2[0]);
        customer3.getRoom().setBookedforDays(1);

        customer5.setRoom(roomsType3[1]);
        customer5.setMoneyOnHold(500);
        customer5.setRoom(roomsType3[0]);
        customer5.getRoom().setBookedforDays(1);


        staff.add(staff1);
        staff.add(staff2);
        staff.add(staff3);


        // Example manager login > ID:1 , Password:nightshift , Key:SE318HMS2
        // Example staff login > ID:10 , Password:1
        // Example customer login > ID:101, Password:90 OR you can write wrong ID,Password system will understand that you are not registered.
        // Then you can register a customer and login with your ID and Password you choose.

        // outer loop
        while (flag) {
            System.out.println("Please type\n1 for manager login \n2 for staff login \n3 for customer login");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    // Loop for manager login
                    while (ManagerLoopCheck) {
                        System.out.println("Enter ID for manager");
                        String tempID = input.next();
                        System.out.println("Enter password for manager");
                        String tempPassword = input.next();
                        System.out.println("Enter key for manager");
                        String tempKey = input.next();

                        // If correct ID,name,password,key are given we login as manager.
                        if (tempID.equals(manager.getID()) && tempPassword.equals(manager.getPassword()) && tempKey.equals(Manager.getAdminKey())) {
                            System.out.println("Manager login authorised...");
                            ManagerLoopCheck = false;
                            managerCheck = true;
                            // Loop for menu
                            while(true) {
                                if(managerCheck){
                                    manager.menu();
                                    int managerChoice = input.nextInt();
                                    switch (managerChoice){
                                        // Creating staff object and adding it to staff arraylist
                                        // Also showing all staff in the end to see that we actually added it.
                                        case 0:
                                            manager.addNewStaff(staff);
                                            break;
                                        // Remove a current staff
                                        case 1:
                                            System.out.println("Type the ID of the staff that you want to remove");
                                            String tempIDToErase = input.next();
                                            manager.removeStaff(staff,tempIDToErase);
                                            break;
                                        // Showing all staff information
                                        case 2:
                                            manager.staffInfo(staff);
                                            break;
                                        // Display info for all rooms
                                        case 3:
                                            System.out.println("Displaying room info for rooms of type 1");
                                            roomInfo(roomsType1);
                                            System.out.println("Displaying room info for rooms of type 2");
                                            roomInfo(roomsType2);
                                            System.out.println("Displaying room info for rooms of type 3");
                                            roomInfo(roomsType3);

                                            break;
                                        // Counts number of avaiable rooms and shows room numbers which are empty.
                                        case 4:
                                            System.out.println("Number of empty rooms: "+AvailableRooms(roomsType1,roomsType2,roomsType3));
                                            break;
                                        // Display the information of a specific room.
                                        case 5:
                                            System.out.println("Which type of room?1,2 or 3?");
                                            int roomType = input.nextInt();
                                            System.out.println("Which number?");
                                            int roomIndex = input.nextInt();
                                            if(roomType==1){
                                                for(int x =0;x<roomsType1.length;x++){
                                                    if(x==roomIndex-1){
                                                        if(roomsType1[x].getBookedforDays()==0){
                                                            System.out.println("Checking Room Number: "+roomsType1[x].getRoomNumber());
                                                            System.out.println("This room is available(Booked for 0 days)");
                                                        }
                                                        else{
                                                            System.out.println("This room is booked for : "+roomsType1[x].getBookedforDays()+" days");
                                                        }

                                                    }
                                                }
                                            }
                                            if(roomType==2){
                                                for(int x =0;x<roomsType2.length;x++){
                                                    if(x==roomIndex-1){
                                                        if (roomsType2[x].getBookedforDays()==0){
                                                            System.out.println("Checking Room Number: "+roomsType2[x].getRoomNumber());
                                                            System.out.println("This room is available(Booked for 0 days)");
                                                        }
                                                        else{
                                                            System.out.println("This room is booked for : "+roomsType2[x].getBookedforDays()+" days");
                                                        }

                                                    }
                                                }
                                            }
                                            if(roomType==3){
                                                for(int x =0;x<roomsType3.length;x++){
                                                    if(x==roomIndex-1){
                                                        if (roomsType3[x].getBookedforDays()==0){
                                                            System.out.println("Checking Room Number: "+roomsType3[x].getRoomNumber());
                                                            System.out.println("This room is available(Booked for 0 days)");
                                                        }
                                                        else{
                                                            System.out.println("This room is booked for : "+roomsType3[x].getBookedforDays()+" days");
                                                        }

                                                    }
                                                }
                                            }
                                            break;
                                            // Paying salaries of each staff from bank
                                        case 6:
                                            System.out.println("Paying staff");
                                            manager.setBank(manager.getBank() - staffExpense(staff));
                                            for(int i=0;i<staff.size();i++){
                                                staff.get(i).setMoney(staff.get(i).getMoney()+staff.get(i).getSalary());
                                            }
                                            break;
                                            // Transfering money from on hold accounts of customers to bank
                                        case 7:
                                            manager.setBank(manager.getBank() + customerMoneyGain(customers));
                                            break;
                                            // shows money on the bank
                                        case 8:
                                            System.out.println("Checking balance");
                                            System.out.println("The bank has "+manager.getBank());
                                            break;
                                            // shows useful graphs and charts
                                        case 9:
                                            System.out.println("Type 1 to see customer to staff ratio\n2 to see empty rooms to reserved rooms ratio\n3 to see room cost to type ratio");
                                            emptyRoomCounter = CountEmptyRooms(roomsType1,roomsType2,roomsType3);
                                            roomCounter=17-emptyRoomCounter;
                                            int chartChoice = input.nextInt();

                                            // graphs and chart objects
                                            // we show them by hiding others etc.
                                            PieChart_AWT demo = new PieChart_AWT( "Staff/Customer" );
                                            demo.setSize( 560 , 367 );
                                            RefineryUtilities.centerFrameOnScreen( demo );
                                            PieChart_AWT2 demo2 = new PieChart_AWT2( "Reserved/Empty" );
                                            demo2.setSize( 560 , 367 );
                                            RefineryUtilities.centerFrameOnScreen( demo2 );

                                            if (chartChoice==1){

                                                demo2.setVisible(false);
                                                demo.setVisible( true );
                                            }
                                            else if(chartChoice==2){
                                                demo.setVisible(false);
                                                demo2.setVisible( true );
                                                break;
                                            }
                                            else if(chartChoice==3){
                                                demo.setVisible(false);
                                                demo2.setVisible(false);
                                                LineChart_AWT3 chart = new LineChart_AWT3(
                                                        "Cost vs Room Type" ,
                                                        "Cost vs Room Type");

                                                chart.pack( );
                                                RefineryUtilities.centerFrameOnScreen( chart );
                                                chart.setVisible( true );
                                            }
                                            break;
                                        case -1:
                                            System.exit(1);
                                        default:
                                            System.out.println("Please type a correct input from the menu displayed above");
                                    }
                                }
                            }
                        } else continue;

                    }
                    break;
                case 2:
                    // Loop for staff login
                    while (StaffLoopCheck) {
                        int indexStaff=0;
                        System.out.println("Enter correct ID for Staff");
                        String tempID = input.next();
                        System.out.println("Enter correct password for Staff");
                        String tempPassword = input.next();
                        for (int i =0;i<staff.size();i++){
                            if(staff.get(i).getID().equals(tempID)&&staff.get(i).getPassword().equals(tempPassword)){
                                System.out.println("Staff login authorised...");
                                StaffLoopCheck = false;
                                staffCheck = true;
                                indexStaff=i;

                            }

                        }

                        if (staffCheck){
                            // Loop for staff menu
                            while(true) {
                                staff.get(indexStaff).menu();
                                int staffChoice = input.nextInt();

                                switch (staffChoice){
                                    // Staff methods for working in their respective departments
                                    case 0:
                                        System.out.println("Displaying your own information");
                                        System.out.println(staff.get(indexStaff).Info());
                                        break;
                                    case 1:
                                        System.out.println("Work notification");
                                        int rand;
                                        Random random= new Random();
                                        rand= random.nextInt(17);
                                        System.out.println("Room number "+rand+" needs cleaning");
                                        break;
                                    case 2:
                                        System.out.println("OverWork accepted clean your department");
                                        staff.get(indexStaff).setSalary(staff.get(indexStaff).getSalary()+10);
                                        System.out.println("Your new salary this month is : "+staff.get(indexStaff).getSalary());
                                        break;
                                        // staff quits job
                                    case 3:
                                        System.out.println("Are you sure? Type 1 to proceed or anything else to stay");
                                        int choiceToQuit = input.nextInt();
                                        if(choiceToQuit==1){
                                            quitJob(staff,staff.get(indexStaff));
                                            Staff.counter--;
                                            System.exit(1);
                                        }
                                        else continue;
                                        break;

                                    case -1:
                                        System.exit(1);
                                    default:
                                        System.out.println("Please type a correct input from the menu displayed above");

                                }
                            }
                        }
                    }
                    break;
                case 3:
                    // Loop for customer login
                    while (CustomerLoopCheck) {
                        int index = 0;
                        // We check if customer is signed in before or he/she has to register.
                        System.out.println("checking if you are signed in before");
                        System.out.println("enter ID");
                        String tempID = input.next();
                        System.out.println("enter password");
                        String tempPassword = input.next();
                        for (int i = 0; i < customers.size(); i++) {
                            if (customers.get(i).getID().equals(tempID) && customers.get(i).getPassword().equals(tempPassword)) {
                                System.out.println("Customer login authorised...");
                                CustomerLoopCheck = false;
                                customerCheck = true;
                                index = i;
                            }

                        }

                        if (customerCheck) {
                            // Loop for customer menu
                            while(true) {
                                customers.get(index).menu();
                                int customerChoice = input.nextInt();
                                switch (customerChoice) {
                                    // After the customer types in which type of room and how many days to stay
                                    // System will display the bill that he has to pay.
                                    // Customer Money and debt attributes will be implemented in future releases for money operations
                                    // (Customer will actually pay)
                                    case 0:
                                        System.out.println("Enter type of room 1,2, or 3");
                                        int roomType = input.nextInt();
                                        System.out.println("Enter how many days to book");
                                        int daysToBook = input.nextInt();
                                        if (roomType == 1) {
                                            if(customers.get(index).getMoney()>=200*daysToBook) {
                                                for (int j = 0; j < roomsType1.length; j++) {
                                                    if (roomsType1[j].getBookedforDays() == 0) {
                                                        roomsType1[j].setBookedforDays(daysToBook);
                                                        customers.get(index).setRoom(roomsType1[j]);
                                                        System.out.println("Room at number: " + roomsType1[j].getRoomNumber() + " is booked for " + customers.get(index).getRoom().getBookedforDays() + " days");
                                                        System.out.println(generateBill(roomsType1[j].getDailyPay(), roomsType1[j].getBookedforDays()) + " tl");
                                                        holdMoney(customers.get(index), calculateBill(roomsType1[j].getDailyPay(), roomsType1[j].getBookedforDays()));
                                                        System.out.println("Your current money left is "+customers.get(index).getMoney());
                                                        break;
                                                    }
                                                }
                                            }
                                            else System.out.println("You don't have enough money");
                                        }
                                        if (roomType == 2) {
                                            if(customers.get(index).getMoney()>=300*daysToBook) {
                                                for (int j = 0; j < roomsType2.length; j++) {
                                                    if (roomsType2[j].getBookedforDays() == 0) {
                                                        roomsType2[j].setBookedforDays(daysToBook);
                                                        customers.get(index).setRoom(roomsType2[j]);
                                                        System.out.println("Room at number: " + roomsType2[j].getRoomNumber() + " is booked for " + customers.get(index).getRoom().getBookedforDays() + " days");
                                                        System.out.println(generateBill(roomsType2[j].getDailyPay(), roomsType2[j].getBookedforDays()) + " tl");
                                                        holdMoney(customers.get(index), calculateBill(roomsType2[j].getDailyPay(), roomsType2[j].getBookedforDays()));
                                                        System.out.println("Your current money left is "+customers.get(index).getMoney());
                                                        break;
                                                    }
                                                }
                                            }
                                            else System.out.println("You don't have enough money");
                                        }
                                        if (roomType == 3) {
                                            if(customers.get(index).getMoney()>=500*daysToBook) {
                                                for (int j = 0; j < roomsType3.length; j++) {
                                                    if (roomsType3[j].getBookedforDays() == 0) {
                                                        roomsType3[j].setBookedforDays(daysToBook);
                                                        customers.get(index).setRoom(roomsType3[j]);
                                                        System.out.println("Room at number: " + roomsType3[j].getRoomNumber() + " is booked for " + customers.get(index).getRoom().getBookedforDays() + " days");
                                                        System.out.println(generateBill(roomsType3[j].getDailyPay(), roomsType3[j].getBookedforDays()) + " tl");
                                                        holdMoney(customers.get(index), calculateBill(roomsType3[j].getDailyPay(), roomsType3[j].getBookedforDays()));
                                                        System.out.println("Your current money left is "+customers.get(index).getMoney());
                                                        break;
                                                    }
                                                }
                                            }
                                            else System.out.println("You don't have enough money");
                                        }
                                        break;
                                        // Extending booking if already a room is reserved.
                                    case 1:
                                        try{
                                            System.out.println("How many days do you want to extend");
                                            int extention = input.nextInt();
                                            if(customers.get(index).getMoney()>=customers.get(index).getRoom().getDailyPay()*extention){
                                                customers.get(index).getRoom().setBookedforDays(customers.get(index).getRoom().getBookedforDays()+extention);
                                                customers.get(index).setMoney(customers.get(index).getMoney()-customers.get(index).getRoom().getDailyPay()*extention);
                                                customers.get(index).setMoneyOnHold(customers.get(index).getMoneyOnHold()+customers.get(index).getRoom().getDailyPay()*extention);
                                                System.out.println("Extended booking");
                                                System.out.println("your room "+ "is booked for "+customers.get(index).getRoom().getBookedforDays()+" days");
                                                System.out.println("Extra bill generated");
                                                System.out.println(generateBill(customers.get(index).getRoom().getDailyPay(),customers.get(index).getRoom().getBookedforDays()));
                                                System.out.println("Your current money left is "+customers.get(index).getMoney());
                                            }
                                            else{
                                                System.out.println("You don't have enough money");
                                            }

                                        }catch (NullPointerException e){
                                            System.out.println("You don't have a room yet to extend duration, please book a room first.");
                                        }
                                        break;
                                        // cancelling booking if already a room is reserved
                                    case 2:
                                        try{
                                            System.out.println("Are you sure? Please type 1 to cancel your booking.");
                                            int sure = input.nextInt();
                                            if(sure==1){
                                                System.out.println("Canceling your  booking");
                                                customers.get(index).setMoney(customers.get(index).getMoney()+customers.get(index).getMoneyOnHold());
                                                customers.get(index).setMoneyOnHold(0);
                                                customers.get(index).getRoom().setBookedforDays(0);
                                                customers.get(index).setRoom(null);
                                                System.out.println("Your current money left is "+customers.get(index).getMoney());
                                            }
                                        }catch (NullPointerException e){
                                            System.out.println("You don't have a room to cancel booking, please book a room first");
                                        }
                                        break;
                                    case -1:
                                        System.exit(1);
                                        break;
                                    default:
                                        System.out.println("Please type a correct input from the menu displayed above");
                                }
                            }
                        }
                        else{
                            System.out.println("You have not registered before please register");
                            System.out.println("Enter ID");
                            String tempId = input.next();
                            System.out.println("Enter name");
                            String name = input.next();
                            System.out.println("Enter password");
                            String password = input.next();
                            System.out.println("Enter money");
                            Double money = input.nextDouble();
                            Customer c = new Customer(tempId,name,password,money);
                            customers.add(c);
                        }
                    }
            }
            // Outer loop stopping.
            flag = false;
        }
    }
        // this method extracts money from money attribute to holdmoney attribute ( so that customer can cancel until manager takes it)
        // After approval of the money it gets taken by bank from moneyOnHold
    public static void holdMoney(Customer customer,int bill){
        customer.setMoney(customer.getMoney()-bill);
        customer.setMoneyOnHold(bill);
    }
    // calculates total salary of staff as a monthly expense
    public static double staffExpense(ArrayList<Staff> staff){
        double totalExpenseOfStaff =0;
        for(int i=0;i<staff.size();i++){
            totalExpenseOfStaff+= staff.get(i).getSalary();
        }
        return totalExpenseOfStaff;
    }
    // Staff method that destroys the staff object(quits the job)
    public static void quitJob (ArrayList<Staff> staff, Staff s1){
        System.out.println("Quitting job... We are sad to see you gone...");
        staff.remove(s1);
    }
    // And this transfer money from hold to bank
    public static double customerMoneyGain(ArrayList<Customer> customers){
        System.out.println("Transfering money from customers to bank");
        double totalGain=0;
        for (int i=0;i<customers.size();i++){
            totalGain += customers.get(i).getMoneyOnHold();
            customers.get(i).setMoneyOnHold(0);
        }
        return totalGain;
    }
    // global counter variables for pie charts
    public static int roomCounter=0;
    public static int emptyRoomCounter=0;
    // Shows info for all rooms with given array of rooms.
    public static void roomInfo(Room[] rooms){
        for(int i=0;i< rooms.length;i++){
            System.out.println("Room number : "+rooms[i].getRoomNumber()+" is of type "+rooms[i].getType());
            System.out.println("It costs: "+rooms[i].getDailyPay()+" daily");
            System.out.println("is booked for "+rooms[i].getBookedforDays()+" days:");
            System.out.println();
        }

    }
    // Calculates the bill customer will have to pay.
    public static int generateBill(int dailyPay,int daysBooked){
        System.out.println("Your total bill is: ");
        return dailyPay*daysBooked;
    }
    // Same method does not print, only for counting.
    public static int calculateBill(int dailyPay,int daysBooked){
        return dailyPay*daysBooked;
    }
    // Will count total empty rooms
    // And shows their numbers.(Room of type : 1 at number 2 is available)
    public static int AvailableRooms(Room[] rooms1, Room[] rooms2, Room[] rooms3){
        System.out.println("Displaying available rooms:");
        int counter =0;
        for (int i=0;i< rooms1.length;i++){
            if(rooms1[i].getBookedforDays() == 0){
                System.out.println("Room of type : "+rooms1[i].getType()+" at number "+rooms1[i].getRoomNumber()+" is available");
                counter++;
            }
        }
        for (int i=0;i< rooms2.length;i++){
            if(rooms2[i].getBookedforDays() == 0){
                System.out.println("Room of type : "+rooms2[i].getType()+" at number "+rooms2[i].getRoomNumber()+" is available");
                counter++;
            }
        }
        for (int i=0;i< rooms3.length;i++){
            if(rooms3[i].getBookedforDays() == 0){
                System.out.println("Room of type : "+rooms3[i].getType()+" at number "+rooms3[i].getRoomNumber()+" is available");
                counter++;
            }
        }
        return counter;
    }
    // This method only counts the number of empty rooms
    public static int CountEmptyRooms(Room[] rooms1, Room[] rooms2, Room[] rooms3){
        System.out.println("Displaying available rooms:");
        int counter =0;
        for (int i=0;i< rooms1.length;i++){
            if(rooms1[i].getBookedforDays() == 0){
                counter++;
            }
        }
        for (int i=0;i< rooms2.length;i++){
            if(rooms2[i].getBookedforDays() == 0){
                counter++;
            }
        }
        for (int i=0;i< rooms3.length;i++){
            if(rooms3[i].getBookedforDays() == 0){
                counter++;
            }
        }
        return counter;
    }

}