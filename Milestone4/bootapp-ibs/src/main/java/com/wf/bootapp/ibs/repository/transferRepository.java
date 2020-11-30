package com.wf.bootapp.ibs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.bootapp.ibs.entity.Transferfunds;

@Repository
public interface transferRepository extends JpaRepository<Transferfunds, Long> {
	List<Transferfunds> findByCustomerId(Long customerId);

}
