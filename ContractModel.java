package com.springpoc.app.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ContractModel {


    @Id
    private int id;
    private String contract_name;
    private String type;
    private long per_payment;
    private String term_length;

    private long payment_amount;
    private int user_id;
}
