/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

public class book extends libraryItem{

    // Fields ----------------------------------------------------------------------------------------------------------
    public String author;
    public int pages;

    // Constructor -----------------------------------------------------------------------------------------------------
    public book(String title, String author, int pages){
        super(title);
        this.author = author;
        this.pages = pages;
    }

    // Abstract Methods ------------------------------------------------------------------------------------------------
    @Override
    public int getLoanPeriodDays(){
        return 21;
    }

    @Override
    public String getType(){
        return "Book";
    }
}
