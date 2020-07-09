package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class RankedSalesPerson {

    private String salesPersonName;
    private int salesPersonThumbnail;
    private String affiliateCompany;
    private int soldProductQuantity;
    private int rankNumber;

    public RankedSalesPerson() {

    }

    public RankedSalesPerson(int rankNumber, String salesPersonName, int salesPersonThumbnail, String affiliateCompany, int soldProductQuantity) {
        this.rankNumber = rankNumber;
        this.salesPersonName = salesPersonName;
        this.salesPersonThumbnail = salesPersonThumbnail;
        this.affiliateCompany = affiliateCompany;
        this.soldProductQuantity = soldProductQuantity;
    }

    public int getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public int getSalesPersonThumbnail() {
        return salesPersonThumbnail;
    }

    public void setSalesPersonThumbnail(int salesPersonThumbnail) {
        this.salesPersonThumbnail = salesPersonThumbnail;
    }

    public String getAffiliateCompany() {
        return affiliateCompany;
    }

    public void setAffiliateCompany(String affiliateCompany) {
        this.affiliateCompany = affiliateCompany;
    }

    public int getSoldProductQuantity() {
        return soldProductQuantity;
    }

    public void setSoldProductQuantity(int soldProductQuantity) {
        this.soldProductQuantity = soldProductQuantity;
    }
}
