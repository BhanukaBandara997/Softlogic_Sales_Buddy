package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class Category {
    private String categoryName;
    private int thumbnail;

    public Category() {
    }

    public Category(String categoryName, int thumbnail) {
        this.categoryName = categoryName;
        this.thumbnail = thumbnail;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
