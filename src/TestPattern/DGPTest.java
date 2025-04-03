package TestPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DGPTest {
    public static void main(String[] args) {
        ParkingLot pKL = ParkingLot.getInstance();
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ GỬI XE ===");
            System.out.println("1. Thêm xe mới");
            System.out.println("2. Hiển thị danh sách xe");
            System.out.println("3. Tìm xe có phí cao nhất");
            System.out.println("4. Lấy xe theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-4): ");

            try {
                choice = Integer.parseInt(bR.readLine());
            } catch (Exception e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên!");
                choice = -1;
                continue;
            }
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Nhập tên xe: ");
                        String vehicleName = bR.readLine();
                        System.out.print("Nhập biển số xe: ");
                        String licensePlate = bR.readLine();
                        System.out.print("Nhập tên chủ xe: ");
                        String ownerName = bR.readLine();
                        System.out.print("Nhập địa chỉ: ");
                        String address = bR.readLine();
                        System.out.print("Nhập số giờ gửi xe: ");
                        int time = Integer.parseInt(bR.readLine());

                        pKL.addVehicle(vehicleName, licensePlate, ownerName, address, time);
                    } catch (InvalidParkingException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Lỗi không xác định: " + e.getMessage());
                    }
                    break;

                case 2:
                    pKL.displayVehicles();
                    break;

                case 3:
                    pKL.findHighestFeeVehicle();
                    break;

                case 4:
                    try {
                        System.out.print("Nhập mã gửi xe cần lấy: ");
                        String ticketId = bR.readLine();
                        pKL.removeVehicle(ticketId);
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}