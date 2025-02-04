/**
 *   >> Al-Reacha .~
 *   << BY : Asem Al-Mekhlafi >>
 */
package reechalibrary;

import java.io.Serializable;

/**
 * @Coder Asem Al-Mekhlafi
 * @author PC class contains sections of books .
 */
public class Sections implements Serializable {
    
    private static final long serialVersionUID = 1L; // for machein to do serializetion .
    private Section[] section;
    public int length;
    
    
    
    
    /**
     * add new section to the array .
     * @param name name of book .
     */
    public void add(String name) {
        reSize();
        int index = length - 1;
        section[index].setName(name);
    }

    /**
     * check the index and return the section in the array by index.
     * @param index is index which will get from the array .
     * @return the value from the array at index if is in bound , or null if index is out of bound .
     */
    public Section getSection(int index) {
        if (index < 0 || index >= length || section == null) {
            return null;
        }
        return section[index];
    }

    private void reSize() {
        if (section == null || section.length >= length) {
            section = addItems();
        }
    }

    private Section[] addItems() {
        Section[] temp = new Section[++length];
        for (int i = 0; i < (section == null ? 0 : section.length); i++) {
            temp[i] = section[i];
        }
        temp[length - 1] = new Section();
        return temp;
    }
    
    /**
     * delete section with its contents .
     * @param index , the index of section that will delete .
     */
    public void delete(int index){
        Section[] temp = new Section[--length];
        for (int i = 0,j = 0; i < temp.length; i++) {
            if(i == index)
                continue;
            temp[j++] = section[i];
        }
        section = temp;
    }

    /**
     * search about book in the array .
     * @param thingToSearch is book to search about it in the array
     * @return -1 if book is not exists , or index of book if is exists . 
     */
    public int searchFirst(String thingToSearch) {
        if (thingToSearch.equals("") || thingToSearch == null || section == null) {
            return -1;
        }
        for (int i = 0; i < section.length; i++) {
            if (section[i].getName().equals(thingToSearch)) {
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
        if(section == null){
            return "no sections ..!";
        }
        int i = 0;
        for (Section se : section) {
            txt += ++i + "- " + se.getName() + "[" + ((se.getSections() != null) ? se.getSections().length : 0 ) + "] "+ split;
        }
        return txt;
    }
    
    
    
    
    
    /**
     * this class contains sections data .
     */
    public class Section implements Serializable {

        private static final long serialVersionUID = 4L; // for machein to do serializetion .
        private String name;
        private String discription;
        private Book book;
        private Sections sections;

        public String getName() {
            return name;
        }

        public String getDiscription() {
            return discription;
        }

        public Sections getSections() {
            return sections;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDiscription(String discription) {
            this.discription = discription;
        }

        public void setBook(Book book) {
            this.book = book;
        }

        public void setSections(Sections sections) {
            this.sections = sections;
        }

        public Book getBooks(){
            return this.book;
        }
        
        public Section(){
            
        }
        public Section(String name) {
            this.name = name;
        }
        
        @Override
        public String toString(){
            return this.name + ", > {books["+ ((this.book == null) ? 0 : this.book.length) + "], sections["+ ((this.getSections() == null) ? 0 : this.getSections().length) + "]}";
        }
    }
}
