package com.indraneela.spring_boot_tutorial.Entity;

import jakarta.persistence.Entity; // Change this to jakarta
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @NotBlank(message = "Please enter your merchant id")
    @Length(max = 30)
    private String merchantAccount;

    private int amount;
    private Date date;
    private String comments;
    private int catergoryID;
}
