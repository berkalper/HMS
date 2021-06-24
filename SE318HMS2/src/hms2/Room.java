package hms2;

public class Room {
    // Type means 1>One person room , 2>Two person room , 3>Suite
    // We will try to implement hashing for type and dailyPays so we don't need to initialize them in arrays in future releases.
    int bookedforDays;
    int type;
    int dailyPay;
    int roomNumber;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // setters/getters/constructors
    public Room(int type, int dailyPay) {
        this.type = type;
        this.dailyPay = dailyPay;
    }

    public int getDailyPay() {
        return dailyPay;
    }

    public void setDailyPay(int dailyPay) {
        this.dailyPay = dailyPay;
    }

    public int getBookedforDays() {
        return bookedforDays;
    }

    public void setBookedforDays(int bookedforDays) {
        this.bookedforDays = bookedforDays;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
