package TestSanPham;

public class Product {
    private String name;
    private String productId;
    private int quantity;
    private double price;
    public Product(String productId, String name, int quantity, double price) {
        this.name = name;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getTotalValue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + productId + "\t Tên sản phẩm: " + name + "\t Số lượng:  " + quantity + "\t Giá sản phẩm: " + price + "VNĐ" + "\t Tổng Giá trị sản phẩm: " + getTotalValue();
    }
}
