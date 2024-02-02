package boundary;

import entity.Tenant;

import java.util.Scanner;




//*This class is for login check*/
public class Login {


    private Tenant currentTenant = null;

    public Login(){}


        Controller controller = new Controller();


        public Tenant getLoginInput() {
            boolean loginStatus = false;

            while (!loginStatus) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("--------------------------");
                System.out.println("Monash Rental Space System");
                System.out.println("--------------------------");
                System.out.println("--------Login Page--------");
                System.out.println("Q: quit the system");
                System.out.println("--------------------------");
                System.out.println("Please input your email");
                System.out.println("--------------------------");
                String inputEmail = scanner.nextLine();
                System.out.println("Please input your password");
                String inputPassword = scanner.nextLine();


                // validate
                if (inputEmail.equalsIgnoreCase("Q") || inputPassword.equalsIgnoreCase("Q")){
                    System.out.println("----Thank you for using it. See you next time!-----");
                     break;}

                else if (!controller.checkEmailPassword(inputEmail,inputPassword)) {// email not exist


                    System.out.println("---------------------------------------");
                    System.out.println("Email does not exist or Wrong password, please try again.");

                    // back to input, need while loop in control class
                    }


                else {
                    System.out.println("-------------------------------------");
                    System.out.println("Login succeed, welcome to MRS system!");
                    loginStatus = true;
                    currentTenant = controller.getLoginTenant(inputEmail);
                }

            }

            //  turn to the main menu
            return currentTenant;//return Tenant : can use set()get()

        }



}
