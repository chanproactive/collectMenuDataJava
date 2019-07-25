package com.collectMenuDataJava.collectMenuDataJava.Menu;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuRepository extends MongoRepository<MenuList, String> {
    List<MenuList> findByName(String name);

}