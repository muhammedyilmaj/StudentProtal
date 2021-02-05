package com.studentportal.guardian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.student.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "guardian")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guardian_id")
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "students")
    @OneToMany(mappedBy = "guardian")
    private List<Student> students;

}
