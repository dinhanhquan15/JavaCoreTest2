import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;
        do{
            System.out.println("\n=== QUẢN LÝ KHO HÀNG ===");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm giá trị cao nhất");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-4): ");

            try{
                choice = Integer.parseInt(reader.readLine());
            } catch(Exception e){
                System.out.println("Lỗi: lựa chọn phải là số nguyên!");
                choice = -1;
                continue;
            }

            switch(choice){
                case 1:
                try{
                    System.out.print("Nhập mã sản phẩm: ");
                    String productId = reader.readLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = reader.readLine();
                    System.out.print("Nhập số lượng: ");
                    int quantity = Integer.parseInt(reader.readLine());
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(reader.readLine());
                    System.out.print("Có hạn sử dụng? (y/n): ");
                    String isPerishable = reader.readLine();

                        if (isPerishable.equalsIgnoreCase("y")) {
                            System.out.print("Nhập ngày hết hạn (dd/mm/yyyy): ");
                            String expiryDate = reader.readLine();
                            inventory.Them(new PerishableProduct(productId, name, quantity, price, expiryDate));
                        } else {
                            inventory.Them(new Product(productId, name, quantity, price));
                        }
                    } catch (InvalidProductException e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: Số lượng và giá phải là số!");
                    } catch (Exception e) {
                        System.out.println("Lỗi không xác định: " + e.getMessage());
                    }
                    break;
                case 2:
                    inventory.HienThiDanhSach();
                    break;
                case 3:
                    inventory.HighValueProduct();
                    break;
                case 4:
                    try{
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String idToDelete = reader.readLine();
                        inventory.Xoa(idToDelete);
                    } catch (Exception e){
                        System.out.println("lỗi: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}