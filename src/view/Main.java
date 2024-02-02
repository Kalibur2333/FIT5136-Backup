package view;

import boundary.Controller;
import boundary.Login;
import entity.Application;
import entity.Property;
import entity.Tenant;
import entity.WishList;

import java.util.ArrayList;
import java.util.Scanner;


/* class for display all menu in system */
public class Main {
    static Login login = new Login();
    static Scanner scanner = new Scanner(System.in);

    static Tenant currentTenant;

    public static void main(String[] args)
    {


        Main main = new Main();

        currentTenant = displayLogin();
        String userEmail = currentTenant.getTenantEmail();
//        displayMainMenu();
        main.selectMainMenu(userEmail);
    }

    public static Tenant displayLogin(){
        //String currentTenantEmail =
        return login.getLoginInput();
    }

    public void displayMainMenu(){

        System.out.println("--------------------------");
        System.out.println("Monash Rental Space System");
        System.out.println("--------------------------");
        System.out.println("---------Main Menu--------");
        System.out.println("--------------------------");
        System.out.println("---Enter 1 - 5 or quit-----");
        System.out.println("1: Search by Address");
        System.out.println("2: Search by Filter");
        System.out.println("3: My Application");
        System.out.println("4: My Wishlist");
        System.out.println("Q: Quit System");
        System.out.println("--------------------------");
        System.out.print("Please input your choice: ");

    }

    public boolean selectValidation(String input) {
        boolean isValidInput = input.matches("[1-5Qq]");
        return isValidInput;
    }
    public void selectMainMenu(String userEmail) {
        boolean quit = false;
        Main main = new Main();
        while (!quit) {
            Controller controller = new Controller();

            String mainMenuInput = scanner.nextLine();
            while (!main.selectValidation(mainMenuInput)) {
                displayMainMenu();
//                System.out.println("--------------------------");
//                System.out.println("Enter 1 - 5 or quit");
//                System.out.println("1: Search by Address");
//                System.out.println("2: Search by Filter");
//                System.out.println("3: My Application");
//                System.out.println("4: My Wishlist");
//                System.out.println("Q: Quit System");
//                System.out.println("--------------------------");
                mainMenuInput = scanner.nextLine();
            }
            while (main.selectValidation(mainMenuInput)) {
                if (mainMenuInput.equals("1")){ //by address
                    ArrayList<Property> filterdProperty = main.SearchAddress();
                    Property selectedProperty = main.selectProperty(filterdProperty);
                    if (selectedProperty == null){
                        System.out.println("Sorry, no properties were found, please try again.");
                    }

                    if (main.chooseAddWishlist(selectedProperty)){
                        controller.addWishlist(userEmail, selectedProperty);
                    }
                    System.out.println("Do you want to apply for it? (Y/N)");
                    String apply = "";
                    apply = scanner.next();
                    while (!apply.equalsIgnoreCase("Y") && !apply.equalsIgnoreCase("N")) {
                        System.out.println("Invalid input. Please enter Y or N.");
                        apply = scanner.nextLine();
                    }
                    if (apply.equalsIgnoreCase("Y")){
                        String userSaving = main.applyForProperty();
                        if(!controller.addNewApplication(userEmail, selectedProperty, userSaving))//not duplicated
                            System.out.println("Please try again! ");
                    } else {
                        System.out.println("Thank you for your interest!");
                    }
                    break;
                } else if (mainMenuInput.equals("2")){//search by filter
                    ArrayList<Property> filterdProperty = main.SearchProperty();
                    Property selectedProperty = main.selectProperty(filterdProperty);
                    //String userEmail = Tenant.getLoginTenant();
                    if ((main.chooseAddWishlist(selectedProperty)) ){
                        controller.addWishlist(userEmail, selectedProperty);
                    }
                    System.out.println("Do you want to apply for it? (Y/N)");
                    String apply = "";
                    apply = scanner.next();
                    while (!apply.equalsIgnoreCase("Y") && !apply.equalsIgnoreCase("N")) {
                        System.out.println("Invalid input. Please enter Y or N.");
                        apply = scanner.nextLine();
                    }

                    // begin apply
                    if (apply.equalsIgnoreCase("Y")){
                        String userSaving = main.applyForProperty();

//                         public Boolean addNewApplication(String currentEmail, Property selectedProperty, String bankSaving)
                        controller.addNewApplication(userEmail, selectedProperty, userSaving);
                    } else {// N
                        System.out.println("Thank you for your interest!");
                    }
                    break;
                    //------------------------------------------------------------------------------
                } else if (mainMenuInput.equals("3")){
                    ArrayList<Application> applicationShow = controller.searchApplicationsByEmail(userEmail);
                    System.out.println();
                    System.out.println("Press enter back to main menu");
                    propertiesShow(applicationShow);
                    break;
                    //------------------------------------------------------------------------------
                } else if (mainMenuInput.equals("4")){
                    //ArrayList<WishList> peachWishlists
                    ArrayList<WishList> wishListShow = controller.searchWishlistsByEmail(userEmail);
                    wishListShow(wishListShow);

                    System.out.println("Press enter back to main menu");

                    break;
                } else if (mainMenuInput.equalsIgnoreCase("Q")){
                    quit = true;
                    break;
                }
            }
        }
    }


    public void onePropertyToString(Property currentProperty){
        if (currentProperty != null) {
            System.out.println("_____________________________________");
            System.out.println("suburb: " + currentProperty.getSuburb());
            System.out.println("price: " + currentProperty.getPricePerWeek());
            System.out.println("Furnished: " + currentProperty.getFurnished());
            System.out.println("Type: " + currentProperty.getType());
            System.out.println("_____________________________________");
        }
    }

    public void propertiesShow(ArrayList<Application> applications){
        Application application = new Application();
        if (applications.size() == 0)
            System.out.println("Sorry, no properties were found, please try again.");
        else {
            for (Application eachProperty: applications ){
                System.out.println("_____________________________________");
                System.out.println("Address: " + eachProperty.getAddress());
                System.out.println("_____________________________________");
            }
        }
    }

    public void wishListShow(ArrayList<WishList> wishLists){
        Application application = new Application();
        if (wishLists.size() == 0)
            System.out.println("Sorry, no properties were found, please try again.");
        else {
            for (WishList eachProperty: wishLists ){
                System.out.println("_____________________________________");
                System.out.println("Address: " + eachProperty.getPropertyAddress());
                System.out.println("_____________________________________");
            }
        }
    }

    public void propertiesToString(ArrayList<Property> filterProperties){

        if (filterProperties.size() == 0)
            System.out.println("Sorry, no properties were found, please try again.");
        else {
            for (Property eachProperty: filterProperties ){
                System.out.println("_____________________________________");
                System.out.println("Address: " + eachProperty.getAddress());
                System.out.println("suburb: " + eachProperty.getSuburb());
                System.out.println("price: " + eachProperty.getPricePerWeek());
                System.out.println("Furnished: " + eachProperty.getFurnished());
                System.out.println("Type: " + eachProperty.getType());
                System.out.println("_____________________________________");
            }
        }
    }


    /*
    *   for wishlist
    * */
    public void displayCurrentTenant(Tenant loginTenant){
            System.out.println("email: " + loginTenant.getTenantEmail());
            System.out.println("lastname: " + loginTenant.getLastName());
    }




    // feature 2

    public ArrayList<Property> SearchProperty()
    {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        ArrayList<Property> searchProperty = controller.getAllProperties();
        ArrayList<Property> filterdProperty = new ArrayList<>();
        System.out.println("Do you want to set a price range? (Y/N)");
        String answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter minimum price: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            int minPrice = scanner.nextInt();
            System.out.println("Enter maximum price: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
            int maxPrice = scanner.nextInt();
            filterdProperty = controller.searchPropertyByPriceRange(minPrice, maxPrice, searchProperty);
        } else filterdProperty = searchProperty;
//        scanner.nextLine();
        System.out.println("Do you want to filter by suburb? (Y/N)");
        answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Enter suburb: ");
            String suburb = scanner.nextLine();
            filterdProperty = controller.searchPropertyBySuburb(suburb, filterdProperty);
        }
        //scanner.nextLine();/////////////////////////////////
        System.out.println("Do you want to filter by furnished or not? (Y/N)");
        System.out.println("Y: Furnished    N: Unfurnished");
        answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("Y")) {
            boolean hasFurnished = true;
            filterdProperty = controller.searchPropertyByFurnished(hasFurnished, filterdProperty);
        } else
            filterdProperty = controller.searchPropertyByFurnished(false, filterdProperty);
//        scanner.nextLine();/////////////////////
        System.out.println("Do you want to filter by type? (Y?N)");
        answer = scanner.nextLine();
        while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
            System.out.println("Invalid input. Please enter Y or N.");
            answer = scanner.nextLine();
        }
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Enter type: ");
            String type = scanner.nextLine();
            filterdProperty = controller.searchPropertyByType(type, filterdProperty);
        }
//        scanner.nextLine();
        System.out.println("Filter Outcome as above:");
        propertiesToString(filterdProperty);
        return filterdProperty;
    }

    public ArrayList<Property> SearchAddress()
    {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        ArrayList<Property> searchProperty = controller.getAllProperties();
        ArrayList<Property> filterdProperty = new ArrayList<>();
        System.out.println("Enter the Address: ");
        String address = scanner.nextLine();
        filterdProperty = controller.searchPropertyByAddress(address, searchProperty);
        propertiesToString(filterdProperty);
        return filterdProperty;
    }

    public Property selectProperty(ArrayList<Property> filterdProperty) {
        Scanner scanner = new Scanner(System.in);
        if(filterdProperty.size() == 0) {
            System.out.println("Sorry, no properties were found");
        } else {
            for (int i = 0; i < filterdProperty.size(); i ++) {
                System.out.println((i+1) + ":" + filterdProperty.get(i).getAddress());
            }
            System.out.println("Please select a property by entering the number");
            String selection = scanner.nextLine();
            int selectionInt = 0;
            try
            {
                selectionInt = Integer.parseInt(selection);
            } catch (NumberFormatException e){
                System.out.println("Invalid Enter");
            }
            if (selectionInt > filterdProperty.size() || selectionInt < 1) {
                System.out.println("Invalid selection, retry");
                selectProperty(filterdProperty);
            } else {
                Property selectedProperty = filterdProperty.get(selectionInt - 1);
                System.out.println("You have selected the following property:");
                System.out.println("Address: " + selectedProperty.getAddress());
                System.out.println("Suburb: " + selectedProperty.getSuburb());
                System.out.println("Price: " + selectedProperty.getPricePerWeek());
                System.out.println("Furnished: " + selectedProperty.getFurnished());
                System.out.println("Type: " + selectedProperty.getType());
                System.out.println("Bedrooms: " + selectedProperty.getNoOfBedrooms()+"Car Spaces: "+selectedProperty.getNoOfCarSpaces());
                System.out.println("Publish Date: " + selectedProperty.getPublishDate());
                return selectedProperty;
            }
        }
        return null;
    }


    public boolean chooseAddWishlist(Property selectedProperty) {
        boolean answer = false;
        if (selectedProperty != null) {

            System.out.println("Do you want to add to wishlist? (Y/N)");
            String input = scanner.nextLine();
            while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Invalid input. Please enter Y or N.");
                input = scanner.nextLine();
            }
            if (input.equalsIgnoreCase("Y")) {
                answer = true;
            }

        }
        return answer;
    }

    public String applyForProperty() {
        scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Please enter your saving: ");
        String saving = scanner.nextLine();


        System.out.println("Your application has been submitted !");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Saving: " + saving);
        System.out.println("Press Enter to main menu");
        return saving;
    }
}
