public class Inventory {
    private Product[] products;
    private int size;
    private static final int MAX_SIZE = 50;
    public Inventory() {
        products = new Product[MAX_SIZE];
        size = 0;
    }
    public void Them(Product product) throws InvalidProductException {
        if(product.getQuantity() < 0){
            throw new InvalidProductException("Số Lượng không thể âm!");
        }
        if(product.getPrice() < 0){
            throw new InvalidProductException("Giá không thể âm!");
        }
        for(int i = 0; i < size; i++){
            if(products[i].getProductId().equals(product.getProductId())){
                throw new InvalidProductException("Mã sản phẩm: " + product.getProductId() + " Đã tồn tại! ");
            }
        }
        if(size == MAX_SIZE){
            System.out.println(" Kho hàng đã đầy! ");
            return;
        }
        products[size] = product;
        size++;
        System.out.println("Đã thêm sản phẩm: " + product.getName());
    }
    public void HienThiDanhSach(){
        if(size == 0){
            System.out.println("Kho hàng trống! ");
        } else {
            System.out.println("Danh sách sản phẩm: " );
            for(int i = 0; i < size; i++){
                System.out.println(products[i].toString());
            }
        }
    }
    public void HighValueProduct(){
        if(size == 0){
            System.out.println(" Kho hàng trống! ");
            return;
        }
        Product maxValueProduct = products[0];
        for(int i = 1; i < size; i++){
            if(products[i].getTotalValue() > maxValueProduct.getTotalValue()){
                maxValueProduct = products[i];
            }
        }
        System.out.println("Sản phẩm có giá trị cao nhất: " + maxValueProduct.toString() + ", Total Value: " + maxValueProduct.getTotalValue());
    }
    public void Xoa(String productId){
        for (int i = 0; i < size; i++) {
            if(products[i].getProductId().equals(productId)){
                for(int j = 0; j < size - 1; j++){
                    products[j] = products[j+1];
                }
                products[size - 1] = null;
                size--;
                System.out.println("Đã xóa sản phẩm với mã: " + productId);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với mã: " + productId);
    }
}