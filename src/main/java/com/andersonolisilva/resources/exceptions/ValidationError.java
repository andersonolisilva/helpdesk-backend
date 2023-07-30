package com.andersonolisilva.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    
    private static final long serialVersionUID = 1L;

    List<FieldMessage> errors = new ArrayList<>();
    
    public ValidationError(){
        super();
    }

    public ValidationError(Long timestaLong, Integer status, String error, String message, String path){
        super(timestaLong, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String filedName, String message) {
        this.errors.add(new FieldMessage(filedName, message));
    }
    
    
}
