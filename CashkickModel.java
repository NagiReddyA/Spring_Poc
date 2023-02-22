package com.springpoc.app.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CashkickModel {


    private int id;
    private String cashkick_name;
    private String status;
    private Date maturity;
    private long total_received;
    private long total_financed;
    private int user_id;
}
