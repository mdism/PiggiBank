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
public class BankClass {
//    private final int MAX = 10;
    public enum Txn{
        Last,Current,All;
    }
    private static final int MAX = 10;
    private static String Current_Transaction;
    private static String Last_Transaction;
    private static final String [] Transaction_Buff = new String[MAX];
    public static int TrCount=0;
    static int Balance = 0;
    
    static void NewTrancistion(int Amount){
        Last_Transaction = Current_Transaction;
        if (Amount >= 0){
            Balance += Amount;
            System.out.println("Cradit Amount " + Amount + ". The Balence is " + Balance+ ".");
            Current_Transaction = ("Cradit Amount " + Amount + ". The Balence is " + Balance+ ".");
            SaveTransection();
        }
        else{
            if(Balance >= (Amount *(-1))){
                Balance += Amount;
                System.out.println("Debit Amount " + Amount + ". The Balence is " + Balance+ ".");
                Current_Transaction = ("Debit Amount " + Amount + ". The Balence is " + Balance+ ".");
            SaveTransection();
            }
            else{
                System.out.println("Insufient Belence");
                Current_Transaction = ("Transiction Faild. The Balence is " + Balance+ ".");
                JOptionPane.showMessageDialog(null, "Insufient Belence", "Belence", JOptionPane.INFORMATION_MESSAGE);
            SaveTransection();
            }
            
        }
    }
    private static void SaveTransection(){
        if(TrCount >= MAX ){
            int x;
            for (x = 0; x < Transaction_Buff.length-1; x++) 
            {
                Transaction_Buff[x]=Transaction_Buff[x+1];
            }
            Transaction_Buff[x] = "Count:" + (TrCount+1) + " " + Current_Transaction;
        }
        else{
            Transaction_Buff[TrCount] = "Count:" + (TrCount+1) + " " + Current_Transaction;
        }
        TrCount++;
    }
    
    static void ShowTransection(int x){
        switch (x){
            case 0: // Last Transection
                System.out.println("Last Transection : " + Last_Transaction);
                break;
            case 1: // Current Transetion
                System.out.println("Current Transection : " + Current_Transaction);
                break;
            case 2: // Last 10 Transections
                System.out.println("MINI Statment");
                int Num=1;
                for(String a : Transaction_Buff){
                    if(a != null){
                    System.out.println("Sr No: " + Num +" "+ a);
                    Num++;
                    }
                }
                break;
            case 3: // Number of Transection done
                System.out.println("Total Number of Transection: " + TrCount);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}
