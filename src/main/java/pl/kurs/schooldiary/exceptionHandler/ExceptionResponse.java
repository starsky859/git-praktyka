package pl.kurs.schooldiary.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionResponse {

    private List<String> errorMessages;
    private String errorCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd:MM:yyyy HH:mm:ss")
    private LocalDateTime date;

    public ExceptionResponse() {
    }



    public ExceptionResponse(List<String> errorMessages, String errorCode, LocalDateTime date) {
        this.errorMessages = errorMessages;
        this.errorCode = errorCode;
        this.date = date;
    }


    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


}
