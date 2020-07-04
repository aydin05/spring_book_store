package com.developia.bookstore.model;

import lombok.Data;

@Data
public class Response {

    public Response(boolean isSuccess, String message){
        this.isSucces = isSuccess;
        this.message = message;
    }

    private boolean isSucces;
    private String message;
}
