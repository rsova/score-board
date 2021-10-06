package com.test.synch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Unexpected Parameter")
public class ScoreBoardBadParameterException extends RuntimeException {
}
