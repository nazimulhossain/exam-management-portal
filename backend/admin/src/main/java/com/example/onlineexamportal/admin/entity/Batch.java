package com.example.onlineexamportal.admin.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;
    private String batchCode;
    private String batchName;
    private String batchDescription;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name="course_batch",
            joinColumns=@JoinColumn(name="batch_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    private List<Course> courses;

    @ManyToMany
    @JoinTable(name="batch_semester",
            joinColumns=@JoinColumn(name="batch_id"),
            inverseJoinColumns=@JoinColumn(name="semester_id"))
    @JsonManagedReference(value = "batch-semester")
    private List<Semester> semesters;

    public void addCourse(Course newCourse){
        if(courses==null){
            courses = new ArrayList<>();
        }
        courses.add(newCourse);
    }

    public void addSemester(Semester semester){
        if(semesters==null){
            semesters = new ArrayList<>();
        }
        semesters.add(semester);
    }



}
