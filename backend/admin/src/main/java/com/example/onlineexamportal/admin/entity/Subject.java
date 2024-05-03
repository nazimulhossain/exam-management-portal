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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subjectName;
    private String subjectCode;
    private String subjectDescription;

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name="course_subject",
            joinColumns=@JoinColumn(name="subject_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    private List<Course> courses;

    @OneToOne(mappedBy = "subject",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Exam exam;

    public void addCourse(Course course){
        if(courses==null){
            courses = new ArrayList<>();
        }

        courses.add(course);
    }
    
}
