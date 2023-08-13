package com.example.kavach.repository;

import com.example.kavach.model.SiteLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<SiteLocation,String> {

}
