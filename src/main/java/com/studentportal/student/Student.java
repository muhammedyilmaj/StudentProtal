package com.studentportal.student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.department.Department;
import com.studentportal.guardian.Guardian;
import com.studentportal.teacher.Teacher;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Guardian parents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmnet_id")
    private Department department;
    @ManyToMany
    @JoinTable(
        name = "student_teacher",
        joinColumns = {@JoinColumn(name = "student_id")},
        inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )    private List<Teacher> teachers;

    @Column(name = "grade")
    private String grade;
}
