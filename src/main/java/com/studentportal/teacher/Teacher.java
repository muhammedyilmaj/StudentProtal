package com.studentportal.teacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.studentportal.lesson.Lesson;
import com.studentportal.student.Student;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teacher")
@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;
    @ManyToMany(mappedBy = "teachers")
    private List<Student> students;

    @ManyToMany(mappedBy = "teachers")
    private List<Lesson> lessons= new ArrayList<>();

    @Column(name = "teacher_name")
    @NotNull
    private String teacherName;

}
