/** ==============================================**
 ** @Author: Kareem Taha Abd El-Fattah Mohammed
 ** @Category: OOP Project
 ** @brief: Library Lending System
/** ==============================================**/
package oopProject;

public class dvd extends libraryItem{

    // Fields ----------------------------------------------------------------------------------------------------------
    public int runtimeMinutes;

    // Constructor -----------------------------------------------------------------------------------------------------
    public dvd(String title, int runtimeMinutes){
        super(title);
        if(runtimeMinutes > 0) this.runtimeMinutes = runtimeMinutes;
        else throw new IllegalArgumentException("runtimeMinutes must be greater that 0");
    }

    // Abstract Methods ------------------------------------------------------------------------------------------------
    @Override
    public int getLoanPeriodDays(){
        return 3;
    }

    @Override
    public String getType(){
        return "DVD";
    }
}
