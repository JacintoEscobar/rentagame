package com.jasi.rentagame.util;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public final class RequestValidator {
    public final boolean isInvalidRequest(BindingResult validationRequResult) {
        return validationRequResult.hasFieldErrors();
    }

    public final HashMap<String, String> getErrors(BindingResult validationReqResult) {
        HashMap<String, String> errors = new HashMap<>();
        validationReqResult.getFieldErrors().forEach((FieldError fieldError) -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return errors;
    }
}
