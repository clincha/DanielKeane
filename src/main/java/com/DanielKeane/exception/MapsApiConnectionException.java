package com.DanielKeane.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MapsApiConnectionException extends RuntimeException {
  public MapsApiConnectionException() {
    super();
  }

  public MapsApiConnectionException(String message, Throwable cause) {
    super(message, cause);
  }

  public MapsApiConnectionException(String message) {
    super(message);
  }

  public MapsApiConnectionException(Throwable cause) {
    super(cause);
  }
}
