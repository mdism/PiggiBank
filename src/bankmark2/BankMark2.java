/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmark2;

import javax.swing.JOptionPane;

/**
 *
 * @author mdism
 */
public class BankMark2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String Amount;
        do{
            Amount = JOptionPane.showInputDialog("Enter The Amount With (+) sign to Add & (-) To withdrow, & Enter (Q/q) to Exit ","Input");
            if(Amount != ""){
            switch(Amount){
                case "Q":
                    break;
                case "q":
                    break;
                case "last":
                    BankClass.ShowTransection(0);
                    break;
                case "new":
                    BankClass.ShowTransection(1);
                    break;
                case "all":
                    BankClass.ShowTransection(2);
                    break;
                case "Cnt":
                    BankClass.ShowTransection(3);
                    break;
                    default:
                        try {
                            BankClass.NewTrancistion(Integer.parseInt(Amount));
                        } catch (Exception e) {
                            System.out.println("Input Error");
                            JOptionPane.showMessageDialog(null, "Input Error", "Error",JOptionPane.ERROR_MESSAGE);
                        }
                        break;
            }
            }
        }while(!"q".equals(Amount) && !"Q".equals(Amount) );
        System.out.println("Exit Program!!");
    }
    
}
