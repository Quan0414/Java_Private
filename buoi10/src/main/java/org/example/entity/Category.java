package org.example.entity;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (columnDefinition = "varchar(255)", nullable = false)
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
