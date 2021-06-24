import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Person implements Menu {

    // Bank is the total money of the hotel
    private double Bank;
    Scanner input = new Scanner(System.in);

    public double getBank() {
        return Bank;
    }

    public void setBank(double bank) {
        Bank = bank;
    }

    // setters/getters/constructors
    public Manager() {

    }

    public Manager(String ID, String name, String password) {
        super(ID, name, password);

    }
    //Key for managerLogin
    public static String getAdminKey(){
        return "SE318HMS2";
    }

    @Override
    public void menu() {
        System.out.println("Please enter choice:\n0 to add new staff\n1 to remove staff \n2 to see all staff info\n" +
                "3 to see all room info \n4 to see available rooms\n5 to see how long a specific room is booked for\n6 to pay staff their salary\n" +
                "7 to transfer money from held accounts to bank (approve reservation)\n8 to see amount of money in the bank\n9 to see useful graphs and charts");
        System.out.println("Or type -1 to exit program");
    }

    // Creating staff object and adding it to staff arraylist
    // Also showing all staff in the end to see that we actually added it.
    public void addNewStaff(ArrayList<Staff> staff){

        System.out.println("ID of new staff");
        String tempStaffID = input.next();
        System.out.println("Name of new staff");
        String tempStaffName = input.next();
        System.out.println("Password of new staff");
        String tempStaffPassword = input.next();
        System.out.println("Department of new staff");
        String tempStaffDepartment = input.next();
        System.out.println("Salary of new staff");
        double tempStaffSalary = input.nextDouble();
        Staff tempStaff = new Staff(tempStaffID,tempStaffName,tempStaffPassword,tempStaffDepartment,tempStaffSalary);
        staff.add(tempStaff);
        for(int i =0;i<staff.size();i++){
            System.out.println(staff.get(i).Info());
        }

    }
    // Showing all staff information
    public void staffInfo(ArrayList<Staff> staff){
        for(int i =0;i<staff.size();i++){
            System.out.println(staff.get(i).Info());
        }
    }

    // Remove a current staff
    public void removeStaff(ArrayList<Staff> staff,String ID) {
        for (int i=0;i<staff.size();i++){
            if (staff.get(i).getID().equals(ID)){
                staff.remove(i);
            }

        }
        Staff.counter--;
    }

}


