package com.zhurilo.pitter.convertor;

import com.zhurilo.pitter.dto.PittDto;
import com.zhurilo.pitter.entity.Pitt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PittConvertor {

    public PittDto ToPittDto(Pitt pitt){
        return PittDto.builder().pitt(pitt.getPitt()).likesQuantity(pitt.getLikesQuantity()).build();
    }
}
