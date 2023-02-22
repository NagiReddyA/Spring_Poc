package com.springpoc.app.repository;

import com.springpoc.app.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

    List<Contract> findAllByUserId(int userId);
}
