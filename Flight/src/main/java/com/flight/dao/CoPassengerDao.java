package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.flight.entity.CoPassenger;

@Transactional
public interface CoPassengerDao extends JpaRepository<CoPassenger, Integer> {
	
	@Modifying
	@Query(value = "delete from copassengers  where copassenger_id= :copassenger_id",nativeQuery = true)
	public void deleteCopassengersById(int copassenger_id);
//    public void deleteByCopassengerId(int copassengerId);

}
