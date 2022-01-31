package pl.kurs.schooldiary.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.kurs.schooldiary.model.GradeLevel;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class GradeDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private GradeLevel gradeLevel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull
    private StudentDto student;

    private String schoolSubject;

    private String description;

    @NotNull
    private TeacherDto teacher;

    public GradeDto() {
    }

    public GradeDto(Long id, GradeLevel gradeLevel, LocalDate date, StudentDto student, String schoolSubject, String description, TeacherDto teacher) {
        this.id = id;
        this.gradeLevel = gradeLevel;
        this.date = date;
        this.student = student;
        this.schoolSubject = schoolSubject;
        this.description = description;
        this.teacher = teacher;
    }

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

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
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

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }
}
