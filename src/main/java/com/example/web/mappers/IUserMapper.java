package com.example.web.mappers;

import com.example.web.entities.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserMapper { //인터페이스 이용해서 DB와 연결
    int insertUser(UserEntity userEntity);

    UserEntity selectUser(UserEntity userEntity);

    UserEntity selectPw(@Param(value = "email") String email,
                        @Param(value = "phoneNumber") String phoneNumber);

    UserEntity selectId(@Param(value = "password") String password,
                        @Param(value = "phoneNumber") String phoneNumber);
}
