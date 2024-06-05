package com.sparta.newspeed.dto;

import lombok.Getter;

@Getter
public class ErrorDto {
    String errormsg;
    String errorcode;

    public ErrorDto(String errormsg, String errorcode) {
        this.errormsg = errormsg;
        this.errorcode = errorcode;
    }

}