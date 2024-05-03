package com.example.onlineexamportal.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String semesterName;

    @ManyToMany
    @JoinTable(name="batch_semester",
            joinColumns=@JoinColumn(name="semester_id"),
            inverseJoinColumns=@JoinColumn(name="batch_id"))
    @JsonBackReference(value = "batch-semester")
    private List<Batch> batches;

    @OneToMany( cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "semester_id")
    private List<Subject> subjects;

    public void addBatch(Batch newBatch){
        if(batches==null){
            batches = new ArrayList<>();
        }
        batches.add(newBatch);
    }

    public void addSubject(Subject newSubject){
        if(subjects==null){
            subjects= new ArrayList<>();
        }
        subjects.add(newSubject);
    }
}
