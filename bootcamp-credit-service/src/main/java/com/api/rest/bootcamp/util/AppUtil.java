package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Credit;
import com.api.rest.bootcamp.dto.CreditDto;
import org.springframework.beans.BeanUtils;

public class AppUtil {
    public static CreditDto entityToDto(Credit credit) {
        CreditDto creditDto = new CreditDto();
        BeanUtils.copyProperties(credit, creditDto);
        return creditDto;
    }

    public static Credit dtoToEntities(CreditDto creditDto) {
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditDto, credit);
        return credit;
    }
}
