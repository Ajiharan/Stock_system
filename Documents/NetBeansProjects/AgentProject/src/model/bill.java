/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Haran
 */
public class bill {
    private String bill_no;
    private String customer_name;
    private String paid_amount;
    private String Total_amount;
    private  static bill b1;

    public  static bill getB1() {
        return b1;
    }

    public   void setB1(bill b1) {
        this.b1 = b1;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }

    public String getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(String Total_amount) {
        this.Total_amount = Total_amount;
    }
    
    
    
}
