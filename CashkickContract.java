//package com.springpoc.app.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name="cashkick_contract")
//@NamedQuery(name = "CashkickContract.findAll",query = "select c from CashkickContract c")
//public class CashkickContract {
//
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "cashkick_id")
//    private Cashkick cashkick;
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "contract_id")
//    private int contract_id;
//
//    public CashkickContract() {
//    }
//
//
//    public Cashkick getCashkick() {
//        return cashkick;
//    }
//
//    public void setCashkick(Cashkick cashkick) {
//        this.cashkick = cashkick;
//    }
//
//    public int getContract_id() {
//        return contract_id;
//    }
//
//    public void setContract_id(int contract_id) {
//        this.contract_id = contract_id;
//    }
//
//    public CashkickContract(Cashkick cashkick, int contract_id) {
//        this.cashkick = cashkick;
//        this.contract_id = contract_id;
//    }
//}
