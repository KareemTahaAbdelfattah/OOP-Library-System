/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

public class magazine extends libraryItem{

    // Fields ----------------------------------------------------------------------------------------------------------
    public int issueNumber;

    // Constructor -----------------------------------------------------------------------------------------------------
    public magazine(String title, int issueNumber){
        super(title);
        this.issueNumber = issueNumber;
    }

    // Abstract Methods ------------------------------------------------------------------------------------------------
    @Override
    public int getLoanPeriodDays(){
        return 7;
    }

    @Override
    public String getType(){
        return "Magazine";
    }
}
