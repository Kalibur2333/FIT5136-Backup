package boundary;

import entity.Application;
import entity.Property;
import entity.Tenant;
import entity.WishList;

import java.util.ArrayList;
import java.util.Objects;


public class Controller {

    private Tenant loginTenant;

    public Controller(){
        //Tenant loginTenant = null;
    }


    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        get all tenants arraylist form txt
    */


    /*
    -----------------------------------------------feature 1 Login-----------------------------------------------------
    */
    public ArrayList<Tenant> getAllTenants(){

       FileIOControl fileIO = new FileIOControl();

        ArrayList<String> tenantsList = fileIO.readFile("tenantsList.txt");

        // store all users
        ArrayList<Tenant> tenants = new ArrayList<>();

        for (String eachLine: tenantsList){
            String[] eachStringArray = eachLine.split(",");
            //0,1,2,3,4
            // tenant2@student.monash.edu,Monash1234,Winnie,Wang,041948937,female,2,200
            //String name = eachStringArray[0];
            //System.out.println(eachStringArray[0]);

            Tenant aTenant = new Tenant(
                    eachStringArray[0],//tenantEmail
                    eachStringArray[1], //tenantPassword
                    eachStringArray[2],//firstName
                    eachStringArray[3],//lastName
                    Integer.parseInt(eachStringArray[4]),//phoneNumber
                    eachStringArray[5],//sex
                    Integer.parseInt(eachStringArray[6]),//employmentStatus
                    Integer.parseInt(eachStringArray[7]));//weeklyIncome

            tenants.add(aTenant);//get all tenants
        }
        return tenants;
    }



    /*
        get all properties arraylist form txt
    */
    public ArrayList<Property> getAllProperties(){

        FileIOControl fileIO = new FileIOControl();

        // String array store all property
        ArrayList<String> properties = fileIO.readFile("propertiesList.txt");

        // use for store all users
        ArrayList<Property> allPropertiesList = new ArrayList<>();

        for (String eachLine: properties){
            String[] eachStringArray = eachLine.split(",");// each string line

        //address,suburb,house,pricePerWeek,false,noOfBedrooms,noOfCarSpaces,state,publishDate,
            // contact,agent,preferredRentCost,preferredSuburb,description,
            // inspectionDateAndTime,rentalStatus

            Property aProperty = new Property(
                    eachStringArray[0],//String address;
                    eachStringArray[1], // String suburb;
                    eachStringArray[2],// String type;
                    Integer.parseInt(eachStringArray[3]),//int pricePerWeek;
                    Boolean.parseBoolean(eachStringArray[4]),// boolean furnished;
                    Integer.parseInt(eachStringArray[5]),// int noOfBedrooms;
                    Integer.parseInt(eachStringArray[6]),// int noOfCarSpaces;
                    eachStringArray[7],// String state;
                    eachStringArray[8],// String publishDate;
                    eachStringArray[9],// String contact;
                    eachStringArray[10],// String agent;
                    Integer.parseInt(eachStringArray[11]),// int preferredRentCost;
                    eachStringArray[12],// String preferredSuburb;
                    eachStringArray[13],// String description;
                    eachStringArray[14],// String inspectionDateAndTime;
                    eachStringArray[15]//String rentalStatus;
            );

            allPropertiesList.add(aProperty);//get all tenants  -->ArrayList<Property>
        }
        return allPropertiesList;
    }


    /*
    get current login Tenant tenant(just one tenant)
    also can use as get one Tenant
*/
    public Tenant getLoginTenant(String inputEmail) {
        ArrayList<Tenant> allTenants = getAllTenants();

        for (Tenant currentTenant : allTenants) {
            if (currentTenant.getTenantEmail().equals(inputEmail)) {


                this.loginTenant = new Tenant(currentTenant.getTenantEmail(),
                        currentTenant.getTenantPassword(),
                        currentTenant.getFirstName(), currentTenant.getLastName(),
                        currentTenant.getPhoneNumber(), currentTenant.getSex(),
                        currentTenant.getEmploymentStatus(), currentTenant.getWeeklyIncome());
            }
        }
        return this.loginTenant;
    }

    /*
     *   check input Email exist in store email
     * */
    public boolean checkEmailPassword(String inputEmail,String inputPassword){
        ArrayList<Tenant> allTenants = getAllTenants();
        for (Tenant currentTenant : allTenants)
        {
            if (currentTenant.getTenantEmail().equals(inputEmail))//email pass
                if (currentTenant.getTenantPassword().equals(inputPassword))
                    return true;// inputEmail passed
        }
        return false;
    }


    /*
    -----------------------------------------------feature 2 sort property by filter--------------------------------
    */
    /*!!!! need add valid function to judge the lowPrice < highPrice */
    public ArrayList<Property> searchPropertyByPriceRange(int lowPrice,int highPrice,ArrayList<Property> searchedPropertiesList){

        ArrayList<Property> filteredPropertiesList = new ArrayList<>();
        for (Property eachProperty: searchedPropertiesList){
            if (eachProperty.getPricePerWeek() >= lowPrice ){
                if (eachProperty.getPricePerWeek() <= highPrice)
                    filteredPropertiesList.add(eachProperty);}
        }
        return filteredPropertiesList;// ArrayList<Property>
    }


    // print all suburb --> choose ---> searchPropertyBySuburb

    /* need to concern , if function has look-ahead search  */
    public ArrayList<Property> searchPropertyBySuburb(String suburb, ArrayList<Property> searchedPropertiesList){
        ArrayList<Property> newPropertiesList = new ArrayList<>();
        for (Property eachProperty: searchedPropertiesList){
            if (eachProperty.getSuburb().equalsIgnoreCase(suburb))
                newPropertiesList.add(eachProperty);
        }
        return newPropertiesList;
    }


    // whether Furnished
    public ArrayList<Property> searchPropertyByFurnished(Boolean FurnishedType,ArrayList<Property> searchedPropertiesList){
        ArrayList<Property> newPropertiesList = new ArrayList<>();
        for (Property eachProperty: searchedPropertiesList){
            if (eachProperty.getFurnished() == FurnishedType)
                newPropertiesList.add(eachProperty);
        }
        return newPropertiesList;
    }


    // Type（house,unit,apartment...）
    // searchPropertyByType()
    public ArrayList<Property> searchPropertyByType(String PropertyType,ArrayList<Property> searchedPropertiesList){
        ArrayList<Property> newPropertiesList = new ArrayList<>();
        for (Property eachProperty: searchedPropertiesList){
            if (eachProperty.getType().equalsIgnoreCase(PropertyType))
                newPropertiesList.add(eachProperty);
        }
        return newPropertiesList;
    }

    public ArrayList<Property> searchPropertyByAddress(String address, ArrayList<Property> searchedPropertiesList)
    {
        ArrayList<Property> newPropertiesList = new ArrayList<>();
        for (Property eachProperty: searchedPropertiesList){
            if (eachProperty.getAddress().equalsIgnoreCase(address))
                newPropertiesList.add(eachProperty);
        }
        return newPropertiesList;
    }

    /*
    -----------------------------------------------feature 3 apply property------------------------------------------
    */


    public ArrayList<Application> getAllApplications(){
        FileIOControl fileIO = new FileIOControl();

        // String array store all property
        ArrayList<String> applications = fileIO.readFile("application.txt");

        ArrayList<Application> allApplications = new ArrayList<>();
        for (String eachLine: applications){

            String[] eachStringArray = eachLine.split(",");

//            address,tenant2@student.monash.edu,Winnie,Wang,041948937,0
            Application oneApplication = new Application(eachStringArray[0],//address;
                    eachStringArray[1],//email
                    eachStringArray[2],//First name,
                    eachStringArray[3],//last name,
                    eachStringArray[4],// contactDetails;
                    eachStringArray[5]);// bankSaving;
            allApplications.add(oneApplication);
        }
        return allApplications;
    }


    /*
    *  need get input for int bankSaving
    *  also need to consider user want to reset the application info detail
    * */
    public Boolean addNewApplication(String currentEmail, Property selectedProperty, String bankSaving){


        ArrayList<String> allApplicationAddress = new ArrayList<>();
        ArrayList<Application> allApplications = getAllApplications();// check  txt data

        for (Application eachLine: allApplications){

            if (Objects.equals(eachLine.getEmail(), currentEmail))//current email
                allApplicationAddress.add(eachLine.getAddress()); // get exist application's properties address
        }

        boolean checkDuplicated = false;
        for (String emailEachAddress: allApplicationAddress) {//check the property has duplicate application
            //  haven't application before
            if (Objects.equals(emailEachAddress, selectedProperty.getAddress())) {//property has been applied
                checkDuplicated = true;
                System.out.println("The current property has been applied ! ");
                System.out.println("Application has not save. ");
            }}

//                address,tenant2@student.monash.edu,Winnie,Wang,041948937,0
        if (!checkDuplicated){
                Tenant currentTenant = getLoginTenant(currentEmail);
                String line = selectedProperty.getAddress()+ "," +
                        currentEmail + "," +
                        currentTenant.getLastName()+ "," +
                        currentTenant.getFirstName()+ "," +
                        currentTenant.getPhoneNumber()+ "," + bankSaving+ "\n";
                FileIOControl fileIO = new FileIOControl();
                fileIO.writeFile("application.txt", line);
        }
        return checkDuplicated; // true: duplicate
    }

    public ArrayList<Application> searchApplicationsByEmail(String email){
        ArrayList<Application> allApplications = getAllApplications();// check  txt data
        ArrayList<Application> peachApplications = new ArrayList<>();
        for (Application currentApplication: allApplications){
            if (Objects.equals(currentApplication.getEmail(), email)){
                peachApplications.add(currentApplication);
            }
        }
        return peachApplications;

    }

    /*
    -----------------------------------------------feature 4 Wishlist--------------------------------------------------
    */
    public ArrayList<WishList> getAllWishlists(){
        FileIOControl fileIO = new FileIOControl();

        // String array store all property
        ArrayList<String> Wishlists = fileIO.readFile("wishList.txt");

        ArrayList<WishList> allWishlists = new ArrayList<>();
        for (String eachLine: Wishlists){

            String[] eachStringArray = eachLine.split(",");

            WishList oneWishlist = new WishList(eachStringArray[0],eachStringArray[1]);
            allWishlists.add(oneWishlist);
        }
        return allWishlists;
    }



    /* need check Property selectedProperty not null!! */
    public void addWishlist(String currentEmail,Property selectedProperty){
        ArrayList<String> allWishlistAddress = new ArrayList<>();
        ArrayList<WishList> allWishlists =  getAllWishlists();// check  txt data
        for (WishList eachLine: allWishlists){


            if (Objects.equals(eachLine.getTenantEmail(), currentEmail))//current email
                allWishlistAddress.add(eachLine.getPropertyAddress()); // get exist wishlist's properties address

        }
        for (String eachAddress: allWishlistAddress) {//check the property has duplicate application
            // unique or haven't used wishlist before
            if (!Objects.equals(selectedProperty.getAddress(), eachAddress) || (allWishlists.size() == 0))
            {
                String line = currentEmail + "," + selectedProperty.getAddress();
                FileIOControl fileIO = new FileIOControl();
                fileIO.writeFile("wishList.txt", line);
            } else {
                System.out.println("The current property has been in the Wishlist! ");
            }
        }

    }



    public ArrayList<WishList> searchWishlistsByEmail(String email){
        ArrayList<WishList> allWishlists = getAllWishlists();// check  txt data
        ArrayList<WishList> peachWishlists = new ArrayList<>();
        for (WishList currentWishlist: allWishlists){
            if (Objects.equals(currentWishlist.getTenantEmail(), email)){
                peachWishlists.add(currentWishlist);
            }
        }
        return peachWishlists;

    }
 //--------------------------------------------------- feature 4-----Wishlist-----------------------------------------
//
//    boolean checkDuplicated = false;
//        for (String eachAddress: allApplicationAddress){
//        if (Objects.equals(selectedProperty.getAddress(), eachAddress)){
//            checkDuplicated = true;
//            System.out.println("The current property has been applied ! ");
//        }
//    }
//        if (checkDuplicated == false){
//        Tenant currentTenant = getLoginTenant(currentEmail);
//        String line = selectedProperty.getAddress()+ "," +
//                currentEmail + "," +
//                currentTenant.getLastName()+ "," +
//                currentTenant.getFirstName()+ "," +
//                currentTenant.getPhoneNumber()+ "," + bankSaving;
//        FileIOControl fileIO = new FileIOControl();
//        fileIO.writeFile("application.txt", line);
//    }








}
