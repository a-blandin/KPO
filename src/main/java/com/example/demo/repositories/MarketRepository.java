package com.example.demo.repositories;

import com.example.demo.db.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends CrudRepository<Market, Long> {
}
