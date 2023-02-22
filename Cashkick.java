package com.springpoc.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;


@Entity
@Table(name="cashkick")
@NamedQuery(name = "Cashkick.findAll",query = "select c from Cashkick c")
public class Cashkick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "cashkick_name")
    private String cashkick_name;
    @Column(name = "status")
    private String status;
    @Column(name = "maturity")
    private Date maturity;
    @Column(name = "total_received")
    private long total_received;
    @Column(name = "total_financed")
    private long total_financed;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(name="cashkick_contract",joinColumns = @JoinColumn(name = "cashkick_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "contract_id",referencedColumnName = "id"))
    private List<Contract> contracts=new ArrayList<>();

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Cashkick() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCashkick_name() {
        return cashkick_name;
    }

    public void setCashkick_name(String cashkick_name) {
        this.cashkick_name = cashkick_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMaturity() {
        return maturity;
    }

    public void setMaturity(Date maturity) {
        this.maturity = maturity;
    }

    public long getTotal_received() {
        return total_received;
    }

    public void setTotal_received(long total_received) {
        this.total_received = total_received;
    }

    public long getTotal_financed() {
        return total_financed;
    }

    public void setTotal_financed(long total_financed) {
        this.total_financed = total_financed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cashkick(int id, String cashkick_name, String status, Date maturity, long total_received, long total_financed, User user, List<Contract> contracts) {
        this.id = id;
        this.cashkick_name = cashkick_name;
        this.status = status;
        this.maturity = maturity;
        this.total_received = total_received;
        this.total_financed = total_financed;
        this.user = user;
        this.contracts = contracts;
    }
}
