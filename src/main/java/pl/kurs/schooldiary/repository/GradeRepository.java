package pl.kurs.schooldiary.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {



}
