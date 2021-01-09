package com.wf.bootapp.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.CreditCardStatement;


@Repository
public interface CreditCardStatementRepository extends JpaRepository<CreditCardStatement,Long>{

}
