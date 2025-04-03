package TestSanPham;

public class PerishableProduct extends Product {
    private String expiryDate;

    public PerishableProduct(String productId, String name , int quantity, double price, String expiryDate) {
        super(productId, name, quantity, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }


    public String toString() {
        return super.toString() + " Ngày hết hạn: " + expiryDate;
    }
}