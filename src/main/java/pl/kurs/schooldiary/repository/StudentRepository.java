package pl.kurs.schooldiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
