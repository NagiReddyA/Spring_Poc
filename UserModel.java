package com.springpoc.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserModel {
    private int id;
    private String user_name;
    private String email;
    private String password;
    private long mobile_number;
    private long credit_limit;
}
