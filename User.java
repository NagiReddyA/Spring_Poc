package com.springpoc.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;


@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll",query = "select u from User u")
public class User {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile_number")
    private long mobile_number;
    @Column(name = "credit_limit")
    private long credit_limit;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Payment> paymentList;

    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Cashkick> cashkickList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private List<Contract> contractList;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public long getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(long credit_limit) {
        this.credit_limit = credit_limit;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Cashkick> getCashkickList() {
        return cashkickList;
    }

    public void setCashkickList(List<Cashkick> cashkickList) {
        this.cashkickList = cashkickList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public User(int id, String user_name, String email, String password, long mobile_number, long credit_limit, List<Payment> paymentList, List<Cashkick> cashkickList, List<Contract> contractList) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.mobile_number = mobile_number;
        this.credit_limit = credit_limit;
        this.paymentList = paymentList;
        this.cashkickList = cashkickList;
        this.contractList = contractList;
    }
}