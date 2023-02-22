package com.springpoc.app.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PaymentModel {


    private int id;
    private String status;
    private Date due_date;
    private long expected_amount;
    private long outstanding_amount;
    private int user_id;
}
