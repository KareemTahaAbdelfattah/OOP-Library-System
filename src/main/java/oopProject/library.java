/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

import java.util.*;

public class library {
    // Fields ----------------------------------------------------------------------------------------------------------
    public static Map<String, libraryItem> catalog= new HashMap<>();   // item id → item (lets you look an item up quickly)
    public static Map<String, member> members = new HashMap<>();   //member id → member
    public static Set<String> borrowedIds = new HashSet<>();   // the ids of every item currently out (a Set, so no duplicates)

    // Constructor -----------------------------------------------------------------------------------------------------
    // Getters & Setters -----------------------------------------------------------------------------------------------

    // Concrete methods (shared by all items) --------------------------------------------------------------------------
    public void addItem(libraryItem item){
        catalog.put(item.getId(), item);
        System.out.println("Added Item to the catalog done Successfully");
    }
    public void addMember(member m){
        members.put(m.getMemberId(), m);
        System.out.println("Added Member done Successfully");
    }
    public void borrowItem(String memberId, String itemId) throws libraryException {
        if(memberId.isEmpty()){
            throw new libraryException("memberId can't be empty, please provide it again");
        }else if(itemId.isEmpty()){
            throw new libraryException("itemId can't be empty, please provide it again");
        }else{
            if(!members.containsKey(memberId)){
                throw new libraryException("memberId isn't exist is the database, please provide correct one again");
            }else if(!catalog.containsKey(itemId)){
                throw new libraryException("itemId isn't exist is the database, please provide correct one again");
            }else if(!members.get(memberId).canBorrowMore()){
                throw new libraryException("This member can't borrow more books");
            }else if(borrowedIds.contains(itemId)){
                throw new libraryException("This Item is already out and was borrowed by another member");
            }else{
                catalog.get(itemId).markBorrowed();
                members.get(memberId).addItemtoMembersList(catalog.get(itemId));
                borrowedIds.add(itemId);
                System.out.println("Done Borrowed successfully");
            }
        }
    }
    public void returnItem(String memberId, String itemId) throws libraryException{
        if(memberId.isEmpty()){
            throw new libraryException("memberId can't be empty, please provide it again");
        }else if(itemId.isEmpty()){
            throw new libraryException("itemId can't be empty, please provide it again");
        }else{
            if(!members.containsKey(memberId)){
                System.out.println("Member ID isn't exist in the database");
            }else if(members.get(memberId).getBorrowedItems().contains(catalog.get(itemId))){
                catalog.get(itemId).markReturned();
                members.get(memberId).removeItemfromMembersList(catalog.get(itemId));
                borrowedIds.remove(itemId);
                System.out.println("Returned Done Successfully");
            }else{
                System.out.println("ITEM isn't in the member borrow list");
            }
        }
    }
    public static void listCatalog(){
        for(String k: catalog.keySet()){
            catalog.get(k).displayInfo();
        }
    }
    public static void printReport(){
        System.out.println("---------- REPORT ---------------");
        System.out.println("Total Items is          : " + catalog.size());
        System.out.println("Currently Items out is  : " + borrowedIds.size());
        System.out.println("The Set of Borrowed Ids : " + borrowedIds);
        int bookItem = 0, magazineItem = 0, dvdItem = 0;
        for (libraryItem i : catalog.values()) {
            if (i.getType() == "Book"){
                bookItem++;
            }else if(i.getType() == "Magazine"){
                magazineItem++;
            }else if(i.getType() == "DVD"){
                dvdItem++;
            }else{
                // Nothing
            }
        }
        System.out.println("Items by type           : " +
                "{Book = " + bookItem + ", Magazine = " + magazineItem + ", DVD = " + dvdItem + "}");
        System.out.println("Total Items created is  : " + libraryItem.getTotalItemsCreated());
        System.out.println("---------------------------------");
    }
    // Abstract methods (each subclass must provide its own) -----------------------------------------------------------
}