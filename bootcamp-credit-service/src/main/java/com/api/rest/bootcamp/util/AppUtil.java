package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.Credit;
import com.api.rest.bootcamp.dto.CreditDto;
import org.springframework.beans.BeanUtils;

public final class AppUtil {
    /**
     * @param credit
     * @return convert entities to dto.
     */
    public static CreditDto entityToDto(final Credit credit) {
        CreditDto creditDto = new CreditDto();
        BeanUtils.copyProperties(credit, creditDto);
        return creditDto;
    }

    /**
     * @param creditDto
     * @return convert dto to entities.
     */
    public static Credit dtoToEntities(final CreditDto creditDto) {
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditDto, credit);
        return credit;
    }

    /**
     * constructor empty.
     */
    private AppUtil() { }
}
