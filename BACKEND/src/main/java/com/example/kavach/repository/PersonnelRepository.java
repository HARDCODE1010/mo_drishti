package com.example.kavach.repository;


import com.example.kavach.model.Personnel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonnelRepository extends MongoRepository<Personnel,String> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<Personnel> findByName(String name);
    List<Personnel> findByPosition(String position);

}
