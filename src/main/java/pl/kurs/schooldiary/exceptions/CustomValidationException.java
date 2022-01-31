package pl.kurs.schooldiary.exceptions;

import java.util.List;

public class CustomValidationException extends Exception{

    private List<String> messages;

    public CustomValidationException(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
