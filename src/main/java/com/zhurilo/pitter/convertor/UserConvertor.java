package com.zhurilo.pitter.convertor;

import com.zhurilo.pitter.dto.UserDto;
import com.zhurilo.pitter.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConvertor {

    public UserDto toUserDto(User user){
        return UserDto.builder().id(user.getId()).name(user.getName()).build();
    }

}
