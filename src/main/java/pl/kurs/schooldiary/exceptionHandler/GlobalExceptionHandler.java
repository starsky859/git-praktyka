package pl.kurs.schooldiary.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kurs.schooldiary.exceptionHandler.ExceptionResponse;
import pl.kurs.schooldiary.exceptions.CustomValidationException;
import pl.kurs.schooldiary.exceptions.NoEntityException;
import pl.kurs.schooldiary.exceptions.WrongIdException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoEntityException.class, WrongIdException.class})
    public ResponseEntity<ExceptionResponse> handleCustomException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(Arrays.asList(ex.getMessage()), "BAD_REQUEST", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomValidationException.class})
    public ResponseEntity<ExceptionResponse> handleCustomValidationException(CustomValidationException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessages(), "BAD_REQUEST", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> messages = ex.getFieldErrors()
                .stream()
                .map(fe -> "Field: " + fe.getField() + "; rejected value: " + fe.getRejectedValue() + "; message: "
                        + fe.getDefaultMessage())
                .collect(Collectors.toList());
        ExceptionResponse response = new ExceptionResponse(messages, "BAD_REQUEST", LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
            ExceptionResponse response = new ExceptionResponse(Arrays.asList(ex.getMessage()), "BAD_REQUEST", LocalDateTime.now());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
