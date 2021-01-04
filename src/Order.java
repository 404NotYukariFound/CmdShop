public class Order {
    private User user;
    private Product[] products;
    private int ShangPinShuLiang;
    private int TotalPrice;


    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setShangPinShuLiang(int shangPinShuLiang) {
        ShangPinShuLiang = shangPinShuLiang;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public Product[] getProducts() {
        return products;
    }

    public int getShangPinShuLiang() {
        return ShangPinShuLiang;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }
}
