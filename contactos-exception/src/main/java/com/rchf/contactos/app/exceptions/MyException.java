package com.rchf.contactos.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyException  extends Exception {

    /*
    No estamos usando esta clase pero en caso de querrer
    generar una exception propia puede ser de esta manera
    */
    public MyException(String message) {
        super(message);
    }
}
