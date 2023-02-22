package com.springpoc.app.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "payment")
@NamedQuery(name = "Payment.findAll",query = "select p from Payment p")
public class Payment {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "status")
    private String status;
    @Column(name = "due_date")
    private Date due_date;
    @Column(name = "expected_amount")
    private long expected_amount;
    @Column(name = "outstanding_amount")
    private long outstanding_amount;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public long getExpected_amount() {
        return expected_amount;
    }

    public void setExpected_amount(long expected_amount) {
        this.expected_amount = expected_amount;
    }

    public long getOutstanding_amount() {
        return outstanding_amount;
    }

    public void setOutstanding_amount(long outstanding_amount) {
        this.outstanding_amount = outstanding_amount;
    }

    public Payment(int id, String status, Date due_date, long expected_amount, long outstanding_amount, User user) {
        this.id = id;
        this.status = status;
        this.due_date = due_date;
        this.expected_amount = expected_amount;
        this.outstanding_amount = outstanding_amount;
       // this.cashkick = cashkick;
        this.user = user;
    }
}
