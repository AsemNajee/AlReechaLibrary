/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.util.Scanner;
import static reechalibrary.TempData.getData;
import static reechalibrary.TempData.saveData;
import static reechalibrary.ReechaLibrary.clean;

/**
 * @Coder Asem Al-Mekhlafi
 * @author PC
 */
public class Dashboard {

    private Scanner in = new Scanner(System.in);
    private Sections.Section father = TempData.mainSection;
    private Sections.Section temp = TempData.mainSection;
    private String secName = "Main";

    public Dashboard() {
        loop:
        do {
            Animation.loading(2000);
            System.out.println("\n");
            System.out.println("wellcom in dashboard .");
            System.out.println("Select an option");
            System.out.println("1. Books & sections Settings >");
            System.out.println("|| More Settings ||");
            System.out.println("2. get report");
            System.out.println("3. save data in file");
            System.out.println("4. get data from file");
            System.out.println("-".repeat(20));
            System.out.println("0. exit");
            System.out.print("Enter your choise: ");
            byte choose = in.nextByte();
            in.nextLine(); // eat space .
            switch (choose) {
                case 0: {
                    System.out.println("<< Nice to help you >>");
                    Animation.loading(2200, "Canceling");
                    clean();
                    break loop;
                }
                case 1: {
                    serfSections();
                }break;
                case 2: {
                    System.out.println("|| Report ||");
                }
                break;
                case 3: {
                    if (saveData(TempData.mainSection)) {
                        System.out.println("seved seccessed.");
                    }else{
                        System.out.println("faild.");
                    }
                }
                break;
                case 4: {
                    TempData.mainSection = getData();
                    System.out.println("data imported");
                }
                break;
                default:
                    System.out.println("Invalid choose.");
            }
        } while (true);
    }

    private void serfSections() {
        loop:
        do {
            Animation.loading(2000);
            System.out.println((secName + " >>"));
            int choose = menu();
            in.nextLine();
            switch (choose) {
                case 0: { // reset temps to default .
                    temp = TempData.mainSection;
                    secName = "Main";
                    return;
                }
                case 1: {
                    printSections(temp);
                }
                break;
                case 2: {
                    printBooks(temp);
                }
                break;
                case 3: {
                    System.out.println("|| add new book >");
                    System.out.print("Enter name: ");
                    String name = in.nextLine();
                    System.out.print("Enter auther: ");
                    String auther = in.nextLine();
                    if(temp.getBooks() == null) { temp.setBook(new Book()); }
                    temp.getBooks().add(name, auther);
                    System.out.println("your book has added.");
                }
                break;
                case 4: {
                    if(temp.getBooks() == null) { System.out.println("no books yet"); break;}
                    System.out.println("|| edit book ||");
                    System.out.println(temp.getBooks());
                    System.out.print("Enter the index of book: ");
                    int ind = in.nextInt() - 1;
                    System.out.println("what you will edit");
                    String[] ed = {"name", "auther", "date", "discription", "pages", "image", "stars"};
                    for (int i = 0; i < ed.length; i++) {
                        System.out.println((i + 1) + ". " + ed[i]);
                    }
                    System.out.print("Enter your choise: ");
                    choose = (byte) (in.nextByte() - 1);
                    in.nextLine();// eat space
                    System.out.print("Enter new value: ");
                    if (temp.getBooks().get(ind).edit(in.nextLine(), ed[choose]) != null) {
                        System.out.println("done, value has edited.");
                    } else {
                        System.out.println("some thing went wrong .");
                    }
                }
                break;
                case 5: {
                    if(temp.getBooks() == null) { System.out.println("no books yet"); break;}
                    System.out.println("|| delete book ||");
                    System.out.println(temp.getBooks());
                    System.out.print("Enter the index of book: ");
                    int ind = in.nextInt() -1;
                    temp.getBooks().delete(ind);
                    System.out.println("done, book deleted.");
                }
                break;
                case 6: {
                    System.out.println("Enter Section info >>");
                    System.out.print("name: ");
                    if(temp.getSections() == null) { temp.setSections(new Sections()); }
                    temp.getSections().add(in.nextLine());
                    Animation.loading(2000, "add section");
                    System.out.println("Section added.");
                }
                break;
                case 7: {
                    System.out.print("Enter section new name: ");
                    temp.setName(in.nextLine());
                    System.out.println("Section edited.");
                }
                break;
                case 8: {
                    if (father == temp) {
                        System.out.println("Cannot delete main section .");
                    } else {
                        System.out.println("are you sure,\n delete this section (" + temp.getName() + ")");
                        System.out.println("1. sure, delete.");
                        System.out.println("2. no, don't delete");
                        System.out.print("Enter your decision: ");
                        if (in.next().equals("1")) {
                            father.getSections().delete(father.getSections().searchFirst(temp.getName()));
                            System.out.println("deleted.");
                            return;
                        }
                    }
                }
                break;
                default:
                    System.out.println("Invaled choose.");
            }
        } while (true);
    }
    
    /**
     * check the section sections .
     * @param section section that will be checked .
     * @return true if sections in {@param section} are not empty,
     *         false if sections in {@param section} are empty
     */
    public boolean isFolder(Sections.Section section) {
        return section.getSections() != null;
    }

    /**
     * print all sectons in {@param section} and request the index from the user,
     * to enter the section by index from user .
     * @param section that will be print sections from it .
     */
    public void printSections(Sections.Section section) {
        if (isFolder(section)) {
            System.out.println("|| Sections >");
            for (int i = 0; i < section.getSections().length; i++) {
                System.out.println((i + 1) + ". " + section.getSections().getSection(i));
            }
            System.out.print("Choose section: ");
            int sec = in.nextInt() -1;
            temp = (sec >= 0 && sec < temp.getSections().length) ? temp.getSections().getSection(sec) : temp;
            secName = temp.getName();
        } else {
            System.out.println("No Sections here .");
        }
    }

    /**
     * print all books in the section .
     * @param section that will be print books from it .
     */
    public void printBooks(Sections.Section section) {
        System.out.println("|| Books > ");
        System.out.println(section.getBooks());
        System.out.println("-".repeat(20));
        System.out.print("Enter index of book: ");
        int ind = in.nextInt() -1;
        System.out.println(section.getBooks().get(ind));
        System.out.println("-".repeat(20));
        System.out.print("Enter any thing to back: ");
        in.next();
    }

    /**
     * print this menu after each section info,
     * and recept the choose of user .
     * @return choose of user .
     */
    public int menu() {
        System.out.print("""
                           1. get all sections
                           2. get all books
                           3. add book
                           4. edit book
                           5. del book
                           6. add section
                           7. edit Section name 
                           8. del section
                           --------------------
                           0. exit
                           
                           Enter your choose:""");
        return in.nextInt();
    }

}
