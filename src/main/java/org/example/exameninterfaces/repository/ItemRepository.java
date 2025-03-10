package org.example.exameninterfaces.repository;

import org.example.exameninterfaces.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
