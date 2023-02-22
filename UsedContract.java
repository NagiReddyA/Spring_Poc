package com.springpoc.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;



@Entity
@Table(name = "used_contract")
@NamedQuery(name = "UsedContract.findAll",query = "select uc from UsedContract uc")
public class UsedContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "remaining_amount")
    private long remaining_amount;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public UsedContract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRemaining_amount() {
        return remaining_amount;
    }

    public void setRemaining_amount(long remaining_amount) {
        this.remaining_amount = remaining_amount;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public UsedContract(int id, long remaining_amount, Contract contract) {
        this.id = id;
        this.remaining_amount = remaining_amount;
        this.contract = contract;
    }
}
