package pl.kurs.schooldiary.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import pl.kurs.schooldiary.interfaces.Identificationable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "grades")
public class Grade implements Serializable, Identificationable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grade")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GradeLevel gradeLevel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String schoolSubject;

    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Grade() {
    }

    public Grade(GradeLevel gradeLevel, LocalDate date, Student student, String schoolSubject, String description, Teacher teacher) {
        this.gradeLevel = gradeLevel;
        this.date = date;
        this.student = student;
        this.schoolSubject = schoolSubject;
        this.description = description;
        this.teacher = teacher;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(String schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
