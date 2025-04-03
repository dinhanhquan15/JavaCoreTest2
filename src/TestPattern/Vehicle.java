package TestPattern;

public class Vehicle {
    private String ticketId;
    private String licensePlate;
    private String vehicleName;
    private String ownerName;
    private String address;
    private int time;

    public Vehicle(String ticketId, String licensePlate, String vehicleName, String ownreName, String address, int time) throws InvalidParkingException {
        this.ticketId = ticketId;
        this.licensePlate = licensePlate;
        this.vehicleName = vehicleName;
        this.ownerName = ownreName;
        this.address = address;
        if (time <= 0) {
            throw new InvalidParkingException("Số giờ gửi xe phải lớn hơn 0!");
        }
        this.time = time;
    }

    public String getTicketId() { return ticketId; }
    public String getVehicleName() { return vehicleName; }
    public String getLicensePlate() { return licensePlate; }
    public String getOwnreName() { return ownerName; }
    public String getAddress() { return address; }
    public int getTime() { return time; }

    // Tính tiền gửi xe
    public double calculateFee(){
        int hours = getTime();
        if (hours <= 4) {
            return 60000; // 60k nếu dưới hoặc bằng 4 tiếng
        } else if (hours <= 24) {
            return 60000 + (hours - 4) * 10000; // 60k + 10k mỗi giờ sau 4 tiếng
        } else {
            return 200000; // Đồng giá 200k nếu quá 24 tiếng
        }
    }
    @Override
    public String toString() {
        return "Vé gửi xe:" +
                " \t Mã vé gửi xe: " + ticketId +
                " \t Biển số xe: " + licensePlate +
                " \t Loại xe: " + vehicleName +
                " \t Chủ xe: " + ownerName +
                " \t Địa chỉ: " + address +
                " \t Thời gian gửi xe: " + time +
                " \t Giá gửi xe: " + calculateFee() + " VNĐ";
    }
}
