/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.io.Serializable;

/**
 * @Coder Asem Al-Mekhlafi
 * @author PC
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L; // for machein to do serializetion .
    private info[] book;
    public int length;
    

    /**
     * add new book to the array .
     * @param name name of book .
     * @param auther the writer .
     */
    public void add(String name, String auther) {
        reSize();
        int index = length - 1;
        book[index].setName(name);
        book[index].setAuther(auther);
    }

    /**
     * check the index and return the value in the array .
     * @param index is index which will get from the array .
     * @return the value from the array at index if is in bound , or null if index is out of bound .
     */
    public info get(int index) {
        if (index < 0 || index >= length || book == null) {
            return null;
        }
        return book[index];
    }

    private void reSize() {
        if (book == null || book.length >= length) {
            book = addItems();
        }
    }

    private info[] addItems() {
        info[] temp = new info[++length];
        for (int i = 0; i < (book == null ? 0 : book.length); i++) {
            temp[i] = book[i];
        }
        temp[length - 1] = new info();
        return temp;
    }
    
    /**
     * delete book from the list by index . 
     * @param index index of book that will delete .
     */
    public void delete(int index){
        info[] temp = new info[--length];
        for (int i = 0,j = 0; i < temp.length; i++) {
            if(i == index)
                continue;
            temp[j++] = book[i];
        }
        book = temp;
    }

    /**
     * search about book in the array .
     * @param thingToSearch is book to search about it in the array
     * @return -1 if book is not exists , or index of book if is exists . 
     */
    public int searchFirst(String thingToSearch) {
        if (thingToSearch.equals("") || book == null) {
            return -1;
        }
        for (int i = 0; i < book.length; i++) {
            if (book[i].getName().equals(thingToSearch)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * get all elements in the array as list .
     * @return the list as name : auther [$price]
     */
    @Override
    public String toString() {
        return toString("\n");
    }
    public String toString(String split) {
        String txt = "";
        if(book == null){
            return "no books yet";
        }
        int i = 0;
        for (info b : book) {
            txt += ++i + "- " + b.getName() + ": " + b.getAuther() + " [$" + b.getPrice() + "]" + split;
        }
        return txt;
    }
    
    
    
    /**
     * this class is contains books info .
     */
    public class info implements Serializable {

        private static final long serialVersionUID = 2L; // for machein to do serializetion .
        private String name;
        private String auther;
        private int price; // not necessary
        private long date;
        private short pages;
        private String image;
        private byte stars;
        private String discription;
        private String[] keyWords;

        public info(String name, String auther, short pages) {
            this.name = name;
            this.auther = auther;
            this.pages = pages;
        }

        public info() {
        }

        public void setDate(long date) {
            this.date = date;
        }

        public void setPages(short pages) {
            this.pages = pages;
        }

        public void setDiscription(String discription) {
            this.discription = discription;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setStars(byte stars) {
            this.stars = stars;
        }
        

        public void setKeyWords(String[] keyWords) {
            this.keyWords = keyWords;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAuther(String auther) {
            this.auther = auther;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getAuther() {
            return auther;
        }

        public int getPrice() {
            return price;
        }

        public long getDate() {
            return date;
        }

        public short getPages() {
            return pages;
        }

        public String getImage() {
            return image == null ? "" : image;
        }

        public byte getStars() {
            return stars;
        }

        public String getDiscription() {
            return discription == null ? "" : discription;
        }

        public String[] getKeyWords() {
            return keyWords;
        }

        /**
         * export all data of book as String .
         * @return data of book ;
         */
        @Override
        public String toString() {
            return "|| " + this.getName() + " ||\n\n"
                    + "Auther: " + this.getAuther() + "\n"
                    + "Price: $" + this.getPrice() + "\n"
                    + "date: "+ this.getDate() + "\n"
                    + "pages: " + this.getPages() + "\n\n"
                    + this.getDiscription();
        }
        
        
        
    /**
     * edit values of book by name of variable . 
     * 
     * @param value new value .
     * @param var name of variable that will be edited .
     * @return old value .
     */
    public Object edit(Object value, String var) {
        Object oldValue = null;
        
        if (var.equals("name")) {
            oldValue = this.getName();
            this.setName((String) value);
            
        } else if (var.equals("auther")) {
            oldValue = getAuther();
            this.setAuther((String) value);
            
        } else if (var.equals("date")) {
            oldValue = getDate();
            setDate((long) value);
        
        } else if (var.equals("pages")) {
            oldValue = getPages();
            setPages((short) value);
        
        } else if (var.equals("image")) {
            oldValue = getImage();
            setImage((String) value);
        
        } else if (var.equals("stars")) {
            oldValue = getStars();
            setStars((byte) value);
        
        } else if (var.equals("discription")) {
            oldValue = getDiscription();
            setDiscription((String) value);
        }
        return oldValue;
    }
    

    }; // end inner class// end inner class

    
}
