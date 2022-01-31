package pl.kurs.schooldiary.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long id;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Grade> grades = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


//    @Email
//    private String email;
//    @Size(min = 5000, max = 200_000)
//    private Double salary;
//    @NotEmpty
//    private List<@NotBlank String> nickNames;


    public Student() {
    }

    public Student(String firstName, String lastName, String pesel, LocalDate birthDate) {
        super(firstName, lastName, pesel, birthDate);
    }

    public Student(String firstName, String lastName, String pesel, LocalDate birthDate, Teacher teacher) {
        super(firstName, lastName, pesel, birthDate);
        this.teacher = teacher;
    }

    public Student(String firstName, String lastName, String pesel, LocalDate birthDate, Set<Grade> grades, Teacher teacher) {
        super(firstName, lastName, pesel, birthDate);
        this.grades = grades;
        this.teacher = teacher;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
