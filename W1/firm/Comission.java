//********************************************************************
// Comission.java Author: Meta Arda Nabila
//
// 
//********************************************************************
package firm;

public class Comission extends Hourly {
    double sales;       //total sales the employee has made
    double com_rate;    //comission rate for the employee
    
    public Comission(String eName, String eAddress, String ePhone,
    String socSecNumber, double rate, double comission_rate){
        super(eName, eAddress, ePhone, socSecNumber, rate);
        com_rate = comission_rate;
    }
    
    public void addSales (double totalSales) {
        sales += totalSales;
    }
}
