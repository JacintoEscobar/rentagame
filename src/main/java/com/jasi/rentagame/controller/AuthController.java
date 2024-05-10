package com.jasi.rentagame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jasi.rentagame.dto.ApiResponse;
import com.jasi.rentagame.dto.LoginRequestBody;
import com.jasi.rentagame.err.ApiResponseErrorMessage;
import com.jasi.rentagame.service.JwtService;
import com.jasi.rentagame.util.ApiResponseMessage;
import com.jasi.rentagame.util.RequestValidator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/auth", method = RequestMethod.POST)
public class AuthController {
    @Autowired
    RequestValidator requestValidator;

    @Autowired
    private JwtService jwtService;

    @PostMapping(path = "/login", produces = "application/json")
    @Tag(name = "Auth", description = "Authentication and Authorization methods")
    @Operation(summary = "Allow users login", description = "Allow users login with their username and password. The returned object contains a jwt token for authorization")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid LoginRequestBody loginRequestBody, BindingResult validation) {
        if (requestValidator.isInvalidRequest(validation)) {
            return new ResponseEntity<>(new ApiResponse(ApiResponseErrorMessage.BAD_REQUEST, requestValidator.getErrors(validation)), HttpStatus.BAD_REQUEST);
        }
        String token = jwtService.generateToken(loginRequestBody);
        return new ResponseEntity<>(new ApiResponse(ApiResponseMessage.LOGIN_SUCCESS, token), HttpStatus.OK);
    }
}
