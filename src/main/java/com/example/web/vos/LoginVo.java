package com.example.web.vos;

import com.example.web.entities.BusinessEntity;
import com.example.web.entities.UserEntity;

public class LoginVo extends UserEntity {
    private String result;
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
