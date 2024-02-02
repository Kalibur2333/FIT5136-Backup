package entity;

public class Tenant {
    private String tenantEmail;
    private String tenantPassword;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String sex;
    private int employmentStatus;
    private int weeklyIncome;

    public Tenant(String tenantEmail, String tenantPassword, String firstName, String lastName, int phoneNumber, String sex, int employmentStatus, int weeklyIncome) {
        this.tenantEmail = tenantEmail;
        this.tenantPassword = tenantPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.employmentStatus = employmentStatus;
        this.weeklyIncome = weeklyIncome;
    }


    // all tenant get methods.

    public String getTenantEmail() {
        return tenantEmail;
    }

    public String getTenantPassword() {
        return tenantPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public int getEmploymentStatus() {
        return employmentStatus;
    }

    public int getWeeklyIncome() {
        return weeklyIncome;
    }

    // all tenant set methods.
    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public void setTenantPassword(String tenantPassword) {
        this.tenantPassword = tenantPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmploymentStatus(int employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setWeeklyIncome(int weeklyIncome) {
        this.weeklyIncome = weeklyIncome;
    }
}
