package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.documents.Assurance;
import com.api.rest.bootcamp.dto.AssuranceDto;
import com.api.rest.bootcamp.dto.AssuranceResponse;
import org.springframework.beans.BeanUtils;

public final class AppUtils {
    /**
     * @param bankFee
     * @return convert entities to dto.
     */
    public static AssuranceDto entityToDto(final Assurance bankFee) {
        AssuranceDto bankFeeDto = new AssuranceDto();
        BeanUtils.copyProperties(bankFee, bankFeeDto);
        return bankFeeDto;
    }

    /**
     * @param bankFeeDto
     * @return convert dto to entities.
     */
    public static Assurance dtoToEntities(final AssuranceDto bankFeeDto) {
        Assurance bankFee = new Assurance();
        BeanUtils.copyProperties(bankFeeDto, bankFee);
        return bankFee;
    }

    /**
     * @param bankFee
     * @return
     */
    public static AssuranceResponse entitiesToResponseBankFee(
            final Assurance bankFee) {
        AssuranceResponse bankFeeResponse = new AssuranceResponse();
        BeanUtils.copyProperties(bankFee, bankFeeResponse);
        return bankFeeResponse;
    }

    /**
     * constructor for default empty.
     */
    private AppUtils() { }
}
