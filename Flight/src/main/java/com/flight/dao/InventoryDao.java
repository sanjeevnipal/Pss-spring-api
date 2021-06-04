package com.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entity.Inventory;

public interface InventoryDao extends JpaRepository<Inventory, Integer> {

}
