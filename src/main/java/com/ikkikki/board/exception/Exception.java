package com.ikkikki.board.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Exception extends  RuntimeException {
  public Exception(String message) {
    super(message);
  }
  public Exception(String message, Throwable cause) {}
}
