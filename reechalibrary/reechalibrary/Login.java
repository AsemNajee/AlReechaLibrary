/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.util.Scanner;

/**
 * @Coder Asem Al-Mekhlafi
 * @author Asem Al-Mekhlafi
 */
public class Login {

    private Scanner in = new Scanner(System.in);

    public Login() {
        boolean done = false;
        do {
            System.out.println("\n|| Reecha Library ||");
            System.out.println("1. create new account");
            System.out.println("2. log in");
            System.out.print("Enter your choise: ");
            byte choose = in.nextByte();
            in.nextLine(); // eat space
            switch (choose) {
                case 1: {
                    System.out.println("|| Enter your info >");
                    System.out.print("Name: ");
                    String name = in.nextLine();
                    System.out.print("Age: ");
                    byte age = in.nextByte();
                    in.nextLine();// eat space
                    System.out.print("college: ");
                    String college = in.nextLine();
                    System.out.print("level: ");
                    byte level = in.nextByte();
                    System.out.print("university card ID: ");
                    long cardID = in.nextLong();
                    in.nextLine();   // eat space
                    System.out.print("passowred: ");
                    String passowred = in.nextLine();
                    boolean isNotExists = Users.addUser(Users.set(name, passowred, cardID, age, college, level, false));
                    if (isNotExists) {
                        TempData.thisUser = new Users.Data(Users.data[Users.search(cardID)]);
                        System.out.println("your account has added, \nyou are login now");
                        done = true;
                    } else {
                        System.out.println("this account is already in .");
                    }
                }
                break;
                case 2: {
                    System.out.println("|| Enter your account info >");
                    System.out.print("university card ID: ");
                    long cardID = in.nextLong(); in.nextLine(); // eat space
                    int index;
                    if ((index = Users.search(cardID)) != -1) {
                        System.out.print("Enter passowred: ");
                        String passowred = in.nextLine();
                        if (Users.data[index].isPassowred(passowred)) {
                            System.out.println("loge in seccessed .");
                            TempData.thisUser = new Users.Data(Users.data[index]);
                            done = true;
                        } else {
                            System.out.println("passowred not matches .");
                        }

                    } else {
                        System.out.println("user not found .");
                    }
                }
                break;
                default:
                    System.out.println("Invaled choose .");
            }
        } while (!done);
    }
}
