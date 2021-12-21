package com.example.demo.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Studios {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private  Long id;
    private String  name;
    private String address;
    private String phoneNumber;

}
