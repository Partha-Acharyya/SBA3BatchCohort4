package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.Card;
import com.wf.bootapp.ibs.entity.CreditCardEligibility;


@Repository
public interface CardRepository extends JpaRepository<Card,Long>{

	List<Card> findBycustomerId(Long id);

	Card findBycardNumber(Long cardNumber);

}
