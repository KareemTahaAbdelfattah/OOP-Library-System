/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

public abstract class libraryItem {

    // Fields ----------------------------------------------------------------------------------------------------------
    private String id;
    private String title;
    private boolean borrowed;
    static private int totalItemsCreated = 0;
    static private int nextNumber = 0;

    // Constructor -----------------------------------------------------------------------------------------------------
    public libraryItem(String title){
        if(!title.isEmpty()){
            this.title = title;
            nextNumber += 1;
            this.id = "ITEM-" + nextNumber;
            totalItemsCreated += 1;
        }else{
            throw new IllegalArgumentException("The title must not be empty");
        }
    }

    // Getters & Setters -----------------------------------------------------------------------------------------------
    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if(title.isEmpty()) System.out.println("The string must not be empty (the operation is rejected)");
        else this.title = title;
    }

    public boolean isBorrowed() {
        return this.borrowed;
    }

    public static int getTotalItemsCreated() {
        return totalItemsCreated;
    }

    private static void setTotalItemsCreated(int totalItemsCreated) {
        libraryItem.totalItemsCreated = totalItemsCreated;
    }

    public String getId() {
        return id;
    }

    // Concrete methods (shared by all items) --------------------------------------------------------------------------
    public void markBorrowed() {
        this.borrowed = true;
    }

    public void markReturned() {
        this.borrowed = false;
    }

    public void displayInfo() {
        System.out.println(getId() + " | " + getTitle()
                + " | " + getType()
                + " | loan: " + getLoanPeriodDays() + " days"
                + " | " + (isBorrowed() ? "OUT" : "available"));
    }

    // Abstract methods (each subclass must provide its own) -----------------------------------------------------------
    public abstract int getLoanPeriodDays();  // how many days this item can be borrowed
    public abstract String getType();         // "Book", "Magazine", or "DVD"
}