package com.springpoc.app.repository;

import com.springpoc.app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    List<Payment> findAllByUserId(int userId);
}
