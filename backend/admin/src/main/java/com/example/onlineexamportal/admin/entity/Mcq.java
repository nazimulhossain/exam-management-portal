package com.example.onlineexamportal.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mcq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mcq_id")
    private List<Option> options;
    private String answer;
    private int points;

    public void addOptions(Option newOption){
        if(options==null){
            options = new ArrayList<>();
        }
        options.add(newOption);
    }

}
