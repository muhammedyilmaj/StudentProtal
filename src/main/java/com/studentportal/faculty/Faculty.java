package com.studentportal.faculty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.department.Department;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "faculty")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "faculty_id")
    private Long id;
    @NotNull
    @Column(name = "faculty_name")
    private String facultyName;
    @ToString.Exclude
    @OneToMany(mappedBy = "faculty")
    List<Department> department;

}
