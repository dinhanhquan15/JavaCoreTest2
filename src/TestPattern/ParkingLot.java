package TestPattern;

public class ParkingLot {
    private static ParkingLot instance;
    private Vehicle[] vehicles;
    private int size;
    private static final int MAX_SIZE = 50;
    private int ticketCounter = 0;

    private ParkingLot() {
        vehicles = new Vehicle[MAX_SIZE];
        size = 0;
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    private String generateTicketId() {
        ticketCounter++;
        return "TICKET" + String.format("%03d", ticketCounter); // Tự động sinh mã
    }

    // Thêm phương tiện
    public void addVehicle(String vehicleName, String licensePlate, String ownerName, String address, int time)
            throws InvalidParkingException {
        if (licensePlate.trim().isEmpty()) {
            throw new InvalidParkingException("Biển số xe không được để trống!");
        }
        for (int i = 0; i < size; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                throw new InvalidParkingException("Biển số xe: " + licensePlate + " đã tồn tại!");
            }
        }
        if (size >= MAX_SIZE) {
            System.out.println("Bãi xe đầy!");
            return;
        }
        String ticketId = generateTicketId();
        vehicles[size] = new Vehicle(ticketId, vehicleName, licensePlate, ownerName, address, time); // Tạo Vehicle mới
        size++;
        System.out.println("Đã thêm xe, mã gửi xe: " + ticketId);
    }

    // Hiển thị danh sách xe
    public void displayVehicles() {
        if (size == 0) {
            System.out.println("Bãi xe trống!");
        } else {
            System.out.println("Danh sách xe trong bãi: " + size);
            for (int i = 0; i < size; i++) {
                System.out.println(vehicles[i].toString());
            }
        }
    }

    // Tìm phương tiện có phí cao nhất
    public void findHighestFeeVehicle() {
        if (size == 0) {
            System.out.println("Bãi xe trống!");
            return;
        }
        Vehicle maxFeeVehicle = vehicles[0];
        for (int i = 1; i < size; i++) {
            if (vehicles[i].calculateFee() > maxFeeVehicle.calculateFee()) {
                maxFeeVehicle = vehicles[i];
            }
        }
        System.out.println("Xe có phí cao nhất: " + maxFeeVehicle.toString());
    }

    // Xóa phương tiện
    public void removeVehicle(String ticketId) {
        for (int i = 0; i < size; i++) {
            if (vehicles[i].getTicketId().equals(ticketId)) {
                System.out.println("Xe đã được lấy: " + vehicles[i].toString());
                for (int j = i; j < size - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Không tìm thấy xe với mã: " + ticketId);
    }
}