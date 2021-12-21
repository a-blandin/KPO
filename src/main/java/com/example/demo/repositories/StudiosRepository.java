package com.example.demo.repositories;

import com.example.demo.db.Studios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudiosRepository extends CrudRepository <Studios, Long> {
}
