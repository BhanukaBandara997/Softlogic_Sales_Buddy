package softlogic_dealer_app.com.softlogic_dealer_app.model;

public class Account {

    private String salesPersonName;
    private String salesPersonEmailAddress;
    private String salesPersonAffiliateCompany;
    private String appVersionNumber;
    private String appVersion;
    private int salesPersonThumbnail;

    public Account() {
    }

    public Account(String salesPersonName, String salesPersonEmailAddress, String salesPersonAffiliateCompany, String appVersionNumber, String appVersion, int salesPersonThumbnail) {
        this.salesPersonName = salesPersonName;
        this.salesPersonEmailAddress = salesPersonEmailAddress;
        this.salesPersonAffiliateCompany = salesPersonAffiliateCompany;
        this.appVersionNumber = appVersionNumber;
        this.appVersion = appVersion;
        this.salesPersonThumbnail = salesPersonThumbnail;
    }

    public String getSalesPersonName() {
        return salesPersonName;
    }

    public void setSalesPersonName(String salesPersonName) {
        this.salesPersonName = salesPersonName;
    }

    public String getSalesPersonEmailAddress() {
        return salesPersonEmailAddress;
    }

    public void setSalesPersonEmailAddress(String salesPersonEmailAddress) {
        this.salesPersonEmailAddress = salesPersonEmailAddress;
    }

    public String getSalesPersonAffiliateCompany() {
        return salesPersonAffiliateCompany;
    }

    public void setSalesPersonAffiliateCompany(String salesPersonAffiliateCompany) {
        this.salesPersonAffiliateCompany = salesPersonAffiliateCompany;
    }

    public String getAppVersionNumber() {
        return appVersionNumber;
    }

    public void setAppVersionNumber(String appVersionNumber) {
        this.appVersionNumber = appVersionNumber;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public int getSalesPersonThumbnail() {
        return salesPersonThumbnail;
    }

    public void setSalesPersonThumbnail(int salesPersonThumbnail) {
        this.salesPersonThumbnail = salesPersonThumbnail;
    }

}
