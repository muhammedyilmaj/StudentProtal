package com.studentportal.department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.faculty.Faculty;
import com.studentportal.lesson.Lesson;
import com.studentportal.student.Student;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="department")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Department{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="department_id")
    private Long id;
    @NotNull
    @Column(name="department_name")
    private  String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Student> students;
    @Column(name = "department_type")
    private String departmentType;
    @Column(name = "lessons")
    @OneToMany(mappedBy ="department")
    private List<Lesson> lessons;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

}
