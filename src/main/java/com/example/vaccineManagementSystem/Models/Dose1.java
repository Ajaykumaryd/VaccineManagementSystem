package com.example.vaccineManagementSystem.Models;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="dose")
public class Dose1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key

    @Column(unique=true)
    private String doseId; //Unique

    @CreationTimestamp
    private Date creationDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
