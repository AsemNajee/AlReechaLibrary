/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.io.Serializable;

/**
 * class contains users data .
 * @Coder Asem Al-Mekhlafi .
 * 
 * this class is contains data of users as array,
 * its can add, search for user .
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 3L; // for machein to do serializetion .
    
    /**
     *  default data to control dashboard as admin .
     */
    public static Data[] data = {set("asem", "123", 20210, true), set("azzam", "101", 10101011, false)};

    /**
     * count of users in array .
     */
    public static int count = data.length;

    /**
     * add new user to the array .
     *
     * @param d data of user .
     * @return true if user added, false if user already signed before .
     */
    public static boolean addUser(Data d) {
        if (search(d.getCardID()) != -1) {
            return false;
        }
        data = addItems(d);
        return true;
    }

    /**
     * search about user .
     *
     * @param cardID card id to search for it .
     * @return the index if found, -1 if not found .
     */
    public static int search(long cardID) {
        for (int i = 0; i < count; i++) {
            if (cardID == Users.data[i].getCardID()) {
                return i;
            }
        }
        return -1;
    }

    // add item to the array and resize array +1 .
    private static Data[] addItems(Data d) {
        Data[] temp = new Data[++count];
        for (int i = 0; i < (data == null ? 0 : data.length); i++) {
            temp[i] = data[i];
        }
        temp[count - 1] = new Data(d);
        return temp;
    }

    /**
     * set user info and change it to {@code Data} type .
     *
     * @param name name .
     * @param passowred passowred .
     * @param cardID college card ID .
     * @param isAdmin is Admin to control dashboard .
     * @return new user data from class Data .
     */
    public static Data set(String name, String passowred, long cardID, boolean isAdmin) {
        return new Data(name, passowred, cardID, isAdmin);
    }

    public static Data set(String name, String passowred, long cardID, byte age, String college, byte level, boolean isAdmin) {
        return new Data(name, passowred, cardID, age, college, level, isAdmin);
    }

    /**
     * this class is contains data of user 
     */
    public static class Data implements Serializable {

        private static final long serialVersionUID = 1L; // for machein to do serializetion .

        private String name;
        private byte age;
        private String college;
        private byte level;
        private long cardID;
        private String passowred;
        private boolean isAdmin;

        public Data(String name, String passowred, long cardID, boolean isAdmin) {
            this.name = name;
            this.passowred = passowred;
            this.cardID = cardID;
            this.isAdmin = isAdmin;
        }

        public Data(String name, String passowred, long cardID, byte age, String college, byte level, boolean isAdmin) {
            this.name = name;
            this.age = age;
            this.college = college;
            this.level = level;
            this.cardID = cardID;
            this.passowred = passowred;
            this.isAdmin = isAdmin;
        }

        public Data(Data d) {
            this.name = d.name;
            this.age = d.age;
            this.college = d.college;
            this.level = d.level;
            this.cardID = d.cardID;
            this.passowred = d.passowred;
            this.isAdmin = d.isAdmin;
        }

        public byte getAge() {
            return age;
        }

        public String getCollege() {
            return college;
        }

        public byte getLevel() {
            return level;
        }

        public long getCardID() {
            return cardID;
        }

        public String getName() {
            return name;
        }

        /**
         * check the passowred to log in .
         *
         * @param pas the pass to check .
         * @return true if equals with passowred, false if not equals .
         */
        public boolean isPassowred(String pas) {
            return passowred.equals(pas);
        }

        /**
         * check if this user is admin .
         * 
         * @return {@code true} if is admin,
         *         {@code false} if is not admin .
         */
        public boolean isAdmin() {
            return isAdmin;
        }

    }

}
