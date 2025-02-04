 /**
  *   >> Al-Reacha .~
  *   << BY : Asem Al-Mekhlafi >>
  */

package reechalibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Coder Asem Al-Mekhlafi .
 * @author PC
 */
public class TempData {
    
    /**
     * data of the user that is logein .
     */
    public static Users.Data thisUser;
    
    
    /**
     * path of file that contains book objects .
     */
    public static final String path = "C:/Users/PC/Desktop/books.txt";
    
    /**
     * all data sections .
     */
    public static Sections.Section mainSection = getData();
    
    public static Sections.Section getData(){
        return getData(path);
    }
    
    /**
     * import data books object from file by serialization .
     * 
     * @param path file of data path .
     * @return books .
     */
    public static Sections.Section getData(String path) {
        Sections.Section data = new Sections().new Section("Main Section");
        try {
            try (FileInputStream f = new FileInputStream(path); 
                    ObjectInputStream o = new ObjectInputStream(f)) {
                data = (Sections.Section) o.readObject();
                o.close();
                f.close();
            }
        } catch (Exception ex) {
            System.out.println("file not found or there is an error .");
        }
        return data;
    }
    
    public static boolean saveData(Sections.Section allSections){
        return saveData(allSections, path);
    }

    /**
     * save data books as objects in file .
     * 
     * @param allSections all sections data .
     * @param path path of file .
     * @return true if seccessed, false if failed .
     */
    public static boolean saveData(Sections.Section allSections,String path) {
        try {
            File f = new File(path);
            if (!f.isAbsolute()) {
                f.createNewFile();
            }
            f = null;
            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(path));
            ob.writeObject(allSections);
            ob.flush();
            ob.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    
    
}
