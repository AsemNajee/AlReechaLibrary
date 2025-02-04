/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.util.Scanner;
import static reechalibrary.ReechaLibrary.clean;
import static reechalibrary.TempData.thisUser;

/**
 * @Coder Asem Al-Mekhlafi
 * @author PC
 */
public class Home {

    private static Scanner in = new Scanner(System.in);
    private static Sections.Section temp = TempData.mainSection;
    private static String secName = "Main";

    public static void main(String[] args) {
        home: do {
            if (thisUser == null) {
                new Login();
            }

            loop:
            do {
                System.out.println("\n");
                System.out.println("|| wellcom again in Reecha Library ||");
                System.out.println("1. home");
                System.out.println("2. change account");
                if (thisUser.isAdmin()) {
                    System.out.println("3. dashboard");
                }
                System.out.println("-".repeat(20));
                System.out.println("0. exit");
                System.out.print("Enter your choise: ");
                byte choose = in.nextByte();
                switch (choose) {
                    case 0: {
                        System.out.println("<< Nice to help you >>");
                        Animation.loading(2200, "Canceling");
                        clean();
                        break home;
                    }
                    case 1: {
                        innerLoop:
                        do {
                            System.out.println("|| Central Library 202 ||");
                            System.out.println("select an option ");
                            System.out.println("1. serf sections");
                            System.out.println("2. get all books");
                            System.out.println("-".repeat(20));
                            System.out.println("0. exit and out");
                            System.out.print("Enter your choise: ");
                            int choise = in.nextInt();
                            in.nextLine();//eat speace

                            System.out.println();
                            switch (choise) {
                                case 0 -> {
                                    System.out.println("<< Nice to help you >>");
                                    Animation.loading(2200, "Canceling");
                                    clean();
                                    break innerLoop;
                                }
                                case 1 -> {
                                    printSections(temp);
                                }
                                case 2 -> {
                                    printBooks(temp);
                                }
                                default ->
                                    System.out.println("Invaled choose.");
                            }
                        } while (true);
                    }
                    break;
                    case 2: {
                        Animation.loading(1000, "exit account");
                        thisUser = null;
                        Animation.loading(1000, "exit page");
                        break loop;
                    }
                    case 3:
                        if (thisUser.isAdmin()) {
                            new Dashboard();
                            break;
                        }
                    default:
                        System.out.println("Invaled choose.");

                }
            } while (true);
        } while (true);
    }

    private static boolean isFolder(Sections.Section section) {
        return section.getSections() != null;
    }

    private static void printSections(Sections.Section section) {
        if (isFolder(section)) {
            System.out.println("|| Sections >");
            for (int i = 0; i < section.getSections().length; i++) {
                System.out.println((i + 1) + ". " + section.getSections().getSection(i));
            }
            System.out.print("Choose section: ");
            int sec = in.nextInt() - 1;
            temp = (sec >= 0 && sec < temp.getSections().length) ? temp.getSections().getSection(sec) : temp;
            secName = temp.getName();
        } else {
            System.out.println("No Sections here .");
        }
    }

    private static void printBooks(Sections.Section section) {
        System.out.println("|| Books > ");
        System.out.println(section.getBooks());
        System.out.println("-".repeat(20));
    }

    private static int menu() {
        System.out.println("""
                           1. get all sections
                           2. get all books
                           --------------------
                           0. exit
                           
                           Enter your choose:""");
        return in.nextInt() - 1;
    }
}
