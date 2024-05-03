package com.example.onlineexamportal.admin.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name="course_batch",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="batch_id"))
    private List<Batch> batches;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Semester> semesters;


    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name="course_subject",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="subject_id"))
    private List<Subject> subjects;

    public void addBatches(Batch newBatch){
        if(batches==null){
            batches = new ArrayList<>();
        }
        batches.add(newBatch);
    }

    public void addSemester(Semester semester){
        if(semesters==null){
            semesters = new ArrayList<>();
        }
        semesters.add(semester);
    }

    public void addSubject(Subject subject){
        if(subjects==null){
            subjects = new ArrayList<>();
        }
        subjects.add(subject);
    }
}
