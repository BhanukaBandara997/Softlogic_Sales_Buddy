package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class Product {
    private String productName;
    private String price;
    private int thumbnail;

    public Product() {
    }

    public Product(String productName, String price, int thumbnail) {
        this.productName = productName;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
