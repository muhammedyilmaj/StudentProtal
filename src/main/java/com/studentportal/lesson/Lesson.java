package com.studentportal.lesson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.department.Department;
import com.studentportal.student.Student;
import com.studentportal.teacher.Teacher;
import lombok.Data;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "Lesson")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Lesson {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "lesson_id")
    private Long id;

    @Column(name="lesson_name")
    @NotNull
    private String lessonName;
    @Transient
    private List<String> lessonClass;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
        name = "lesson_teacher",
        joinColumns = {@JoinColumn(name = "lesson_id")},
        inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private List<Teacher> teachers;

    @ManyToMany
    @JoinTable(
        name = "student_lesson",
        joinColumns = {@JoinColumn(name = "lesson_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )    private List<Student> students;

}
