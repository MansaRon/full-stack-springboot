package com.thendo.jwt.fullstackspringboot.repository;

import com.thendo.jwt.fullstackspringboot.entities.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {}
