package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.wf.bootapp.ibs.entity.DebitCard;


@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard,Long>{
	
	List<DebitCard> findBycustomerId(Long id);

	DebitCard findBycardNumber(Long cardNumber);

	}
