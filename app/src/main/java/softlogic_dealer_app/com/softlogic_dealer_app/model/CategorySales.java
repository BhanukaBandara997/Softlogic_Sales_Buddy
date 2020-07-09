package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class CategorySales {

    private int categoryColor;
    private String categoryName;
    private int salesAmount;

    public CategorySales() {
    }

    public CategorySales(int categoryColor, String categoryName, int salesAmount) {
        this.categoryColor = categoryColor;
        this.categoryName = categoryName;
        this.salesAmount = salesAmount;
    }

    public int getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(int categoryColor) {
        this.categoryColor = categoryColor;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }
}
