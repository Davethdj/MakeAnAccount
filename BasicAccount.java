import java.util.Scanner;
import java.io.File;
class BasicAccount {
    private String email;
    private String username;
    private String password;
    private int pin;

    public String getUsername(){
        return this.username;
    }
    public BasicAccount(String email, String username, String password, int pin) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.pin = pin;
    }
    public boolean pinIsWrong(int pin) {
        return pin != this.pin;
    }

    private void changePassword(Scanner user) {
        System.out.print("Please Verify This Is Your Account By Entering Your PIN: ");
        int pin = Integer.parseInt(user.nextLine());
        while(pinIsWrong(pin)){
            System.out.print("The PIN That You Entered Does Not Match The PIN On The Account. Try Again.\n");
            pin = Integer.parseInt(user.nextLine());
        }
        System.out.print("Please enter your new password:");
        this.password = user.nextLine();
        System.out.print("You Password Has Been Changed!");
    }

    private void changeEmail(Scanner user) {
        System.out.print("Please Verify This Is Your Account By Entering Your PIN:");
        int pin = Integer.parseInt(user.nextLine());
        while(pinIsWrong(pin)){
            System.out.print("The PIN That You Entered Does Not Match The PIN On The Account. Try Again.\n");
            pin = Integer.parseInt(user.nextLine());
        }
        System.out.print("Please enter your new email:");
        this.email = user.nextLine();
        System.out.print("You Email Has Been Changed!");
    }

    private void changeUsername(Scanner user) {
        System.out.print("Please Verify This Is Your Account By Entering Your PIN: ");
        int pin = Integer.parseInt(user.nextLine());
        while(pinIsWrong(pin)){
            System.out.print("The PIN That You Entered Does Not Match The PIN On The Account. Try Again.\n");
            pin = Integer.parseInt(user.nextLine());
        }
        System.out.print("Please enter your new username:");
        this.username = user.nextLine();
        System.out.print("You Username Has Been Changed!");
    }

    public static void main(String[] args) throws Exception{
        //Please remember to change the file location if you want to try and use this :)
        Members memberList = new Members();
        File members = new File("FILE LOCATION//Info.txt");
        Scanner getData = new Scanner(members);
            String email = getData.nextLine();
        while(!email.equals("stop")){
            String username = getData.nextLine();
            String password = getData.nextLine();
            int pin = Integer.parseInt(getData.nextLine());
            memberList.addMember(new BasicAccount(email,username,password,pin));
            email = getData.nextLine();
        }
        getData.close();
        Scanner user = new Scanner(System.in);
        System.out.println("Hello!\n" + "Press 1 if you would like to create an account.\n" + "Press 2 if you would like to change account info.");
        int choice1 = Integer.parseInt(user.nextLine());
        basicDialogRun(choice1, user, memberList);
        user.close();
    }

    private static void basicDialogRun(int choice1, Scanner user, Members memberList) {
        if (choice1 == 1) {
            System.out.print("Enter an email:");
            String email = user.nextLine();
            System.out.print("Enter a username:");
            String username = user.nextLine();
            System.out.print("Enter a password:");
            String password = user.nextLine();
            System.out.print("Enter a PIN--NOTE YOU CANNOT CHANGE YOUR PIN--:");
            int pin = Integer.parseInt(user.nextLine());
            new BasicAccount(email,username,password,pin);
            System.out.print("You have successfully made an account! Thank you!");
        } else {
            System.out.println("Press 1 to change your email.\nPress 2 to change your username.\nPress 3 to change your password.");
            int choice2 = Integer.parseInt(user.nextLine());
            System.out.print(changingAccountValue(choice2, user, memberList ));
        }
    }
    private static String changingAccountValue(int choice2, Scanner user, Members memberList){
        System.out.print("What is the username of the account you want to change:");
        String username = user.nextLine();
        int locationOfMemberInList = getLocationOfMemberInList(username, memberList);
        if(locationOfMemberInList == -1){
            return "The Username You Have Entered Is Not Part Of Our System.";
        }
        else if(choice2 == 1){
            memberList.getMembers().get(locationOfMemberInList).changeEmail(user);
            return "";
        }
        else if(choice2 == 2){
            memberList.getMembers().get(locationOfMemberInList).changeUsername(user);
            return "";
        }
        else{
            memberList.getMembers().get(locationOfMemberInList).changePassword(user);
            return "";
        }
    }
    private static int getLocationOfMemberInList(String username, Members memberList){
        int locationOfMember = -1;
        for(int i = 0; i<memberList.getMembers().size(); i++ ){
            if(username.equals(memberList.getMembers().get(i).getUsername())){
                locationOfMember = i;
            }
        }
        return locationOfMember;
    }
}
