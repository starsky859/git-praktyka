package pl.kurs.schooldiary.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.schooldiary.dto.GradeDto;
import pl.kurs.schooldiary.dto.TeacherDto;
import pl.kurs.schooldiary.exceptions.CustomValidationException;
import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;
import pl.kurs.schooldiary.model.Grade;
import pl.kurs.schooldiary.model.Student;
import pl.kurs.schooldiary.model.Teacher;
import pl.kurs.schooldiary.service.GradeManagementService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeManagementService gradeManagementService;
    private final ModelMapper mapper;
    private final Validator validator;

    public GradeController(GradeManagementService gradeManagementService, ModelMapper mapper, Validator validator) {
        this.gradeManagementService = gradeManagementService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @PostMapping()
    public ResponseEntity<GradeDto> addGrade(@RequestBody GradeDto gradeDto) throws WrongIdException, NoEntityException, CustomValidationException {

        Set<ConstraintViolation<GradeDto>> violation = validator.validate(gradeDto);
        if (!violation.isEmpty())
            throw new CustomValidationException(
                    violation.stream()
                            .map(x -> x.getPropertyPath().toString() + ' ' + x.getMessage() + "; invalid value: " + x.getInvalidValue())
                            .collect(Collectors.toList())
            );
        //path: message

        Grade addGrade = gradeManagementService.add(mapper.map(gradeDto, Grade.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(addGrade, GradeDto.class));

    }

    @GetMapping
    public ResponseEntity<List<GradeDto>> getGrades() {
        List<Grade> gradeList = new ArrayList<>(gradeManagementService.showAll());
        return ResponseEntity.ok(
                gradeList.stream()
                        .map(x -> mapper.map(x, GradeDto.class))
                        .collect(Collectors.toList())
        );

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GradeDto> getSpecificGrades(@PathVariable(name = "id") long id) throws NoEntityException {
        Grade grade = gradeManagementService.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.map(grade, GradeDto.class));

    }

}
