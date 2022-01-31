package pl.kurs.schooldiary.service;

import org.springframework.stereotype.Service;
import pl.kurs.schooldiary.model.Grade;
import pl.kurs.schooldiary.repository.GradeRepository;


@Service
public class GradeManagementService extends GenericManagementService<Grade, GradeRepository> {

    public GradeManagementService(GradeRepository repository) {
        super(repository);
    }
}
