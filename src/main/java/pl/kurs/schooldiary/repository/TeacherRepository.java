package pl.kurs.schooldiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary.model.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {


}
