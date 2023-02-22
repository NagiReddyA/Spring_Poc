package com.springpoc.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "contract")
@NamedQuery(name = "Contract.findAll",query = "select c from Contract c")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "contract_name")
    private String contract_name;
    @Column(name = "type")
    private String type;
    @Column(name = "per_payment")
    private long per_payment;
    @Column(name = "term_length")
    private String term_length;
    @Column(name = "payment_amount")
    private long payment_amount;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private List<UsedContract> usedContractList;


    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(name="cashkick_contract",joinColumns = @JoinColumn(name = "contract_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cashkick_id",referencedColumnName = "id"))
    private List<Cashkick> cashkicks=new ArrayList<>();

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPer_payment() {
        return per_payment;
    }

    public void setPer_payment(long per_payment) {
        this.per_payment = per_payment;
    }

    public String getTerm_length() {
        return term_length;
    }

    public void setTerm_length(String term_length) {
        this.term_length = term_length;
    }

    public long getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(long payment_amount) {
        this.payment_amount = payment_amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UsedContract> getUsedContractList() {
        return usedContractList;
    }

    public void setUsedContractList(List<UsedContract> usedContractList) {
        this.usedContractList = usedContractList;
    }


    public List<Cashkick> getCashkicks() {
        return cashkicks;
    }

    public void setCashkicks(List<Cashkick> cashkicks) {
        this.cashkicks = cashkicks;
    }

    public Contract(int id, String contract_name, String type, long per_payment, String term_length, long payment_amount, User user, List<UsedContract> usedContractList, List<Cashkick> cashkicks) {
        this.id = id;
        this.contract_name = contract_name;
        this.type = type;
        this.per_payment = per_payment;
        this.term_length = term_length;
        this.payment_amount = payment_amount;
        this.user = user;
        this.usedContractList = usedContractList;
        this.cashkicks = cashkicks;
    }
}
