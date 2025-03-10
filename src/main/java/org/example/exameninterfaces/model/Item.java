package org.example.exameninterfaces.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items") @Data
public class Item {
    @Id
    private String id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rate;
    private int count;
}
