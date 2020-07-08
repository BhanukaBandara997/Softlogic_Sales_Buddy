package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class Product {
    private String productName;
    private String productSummaryDetails;
    private String productSerialNo;
    private String productDescription;
    private String socialMediaLink;
    private String price;
    private int thumbnail;

    public Product() {
    }

    public Product(String productName, String productSummaryDetails, String productSerialNo, String productDescription, String socialMediaLink, String price, int thumbnail) {
        this.productName = productName;
        this.productSummaryDetails = productSummaryDetails;
        this.productSerialNo = productSerialNo;
        this.productDescription = productDescription;
        this.socialMediaLink = socialMediaLink;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getProductSummaryDetails() {
        return productSummaryDetails;
    }

    public void setProductSummaryDetails(String productSummaryDetails) {
        this.productSummaryDetails = productSummaryDetails;
    }


    public String getProductSerialNo() {
        return productSerialNo;
    }

    public void setProductSerialNo(String productSerialNo) {
        this.productSerialNo = productSerialNo;
    }

    public String getSocialMediaLink() {
        return socialMediaLink;
    }

    public void setSocialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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
