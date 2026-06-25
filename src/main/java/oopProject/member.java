/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

import java.util.ArrayList;
import java.util.List;

public class member {

    // Fields ----------------------------------------------------------------------------------------------------------
    private String memberId;
    private String name;
    private int maxAllowed;
    private List<libraryItem> borrowedItems = new ArrayList<>();
    private static int nextId = 1;

    // Constructor -----------------------------------------------------------------------------------------------------
    public member(String name, int maxAllowed){
        if(!name.isEmpty() && maxAllowed > 0){
            this.memberId = "M" + nextId;
            nextId++;
            this.name = name;
            this.maxAllowed = maxAllowed;
        }else{
            throw new IllegalArgumentException("The name must not be empty, also the maxAllowed should " +
                    "be a positive number");
        }
    }

    // Getters & Setters -----------------------------------------------------------------------------------------------
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(int maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public List<libraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<libraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    // Concrete methods (shared by all items) --------------------------------------------------------------------------
    public int getBorrowedCount(){
        return borrowedItems.size();
    }

    public boolean canBorrowMore(){
        return borrowedItems.size() < maxAllowed ? true : false;
    }

    public void addItemtoMembersList(libraryItem Item){
        borrowedItems.add(Item);
        System.out.println("Added Item to member's list done Successfully");
    }

    public void removeItemfromMembersList(libraryItem Item){
        borrowedItems.remove(Item);
        System.out.println("Removed Item from member's list done Successfully");
    }
}