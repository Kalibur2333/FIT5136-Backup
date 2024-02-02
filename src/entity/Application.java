package entity;

public class Application {

//address,tenant2@student.monash.edu,Winnie,Wang,041948937,0
    private String address;
    private String email;
    private String tenantFirstName;//string First name,
    private String tenantLastName;// string last name,
    private String contactDetails;// string contact details (email and phone) and
    private String bankSaving;// int saving (optional)in their bank account

    public Application(String address,String email ,String tenantFirstName, String tenantLastName, String contactDetails, String bankSaving) {
        this.address = address;
        this.email = email;
        this.tenantFirstName = tenantFirstName;
        this.tenantLastName = tenantLastName;
        this.contactDetails = contactDetails;
        this.bankSaving = bankSaving;
    }

    public Application() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenantFirstName() {
        return tenantFirstName;
    }

    public void setTenantFirstName(String tenantFirstName) {
        this.tenantFirstName = tenantFirstName;
    }

    public String getTenantLastName() {
        return tenantLastName;
    }

    public void setTenantLastName(String tenantLastName) {
        this.tenantLastName = tenantLastName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getBankSaving() {
        return bankSaving;
    }

    public void setBankSaving(String bankSaving) {
        this.bankSaving = bankSaving;
    }
}

