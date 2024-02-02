package entity;

/*
* tenant
* p1,p2,p3
* addDate
*
*             tenantEmail + "_wishlist.txt"
* */
public class WishList {

    private String tenantEmail;
    private String propertyAddress;

    public WishList(String tenantEmail, String propertyAddress) {
        this.tenantEmail = tenantEmail;
        this.propertyAddress = propertyAddress;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }
}