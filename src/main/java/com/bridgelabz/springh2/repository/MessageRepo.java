package com.bridgelabz.springh2.repository;
//JpaRepository perform to curd operation
import com.bridgelabz.springh2.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {
}
