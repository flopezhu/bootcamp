package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.documents.BankFee;
import com.api.rest.bootcamp.dto.BankFeeDto;
import com.api.rest.bootcamp.dto.BankFeeResponse;
import org.springframework.beans.BeanUtils;

public final class AppUtils {
    /**
     * @param bankFee
     * @return convert entities to dto.
     */
    public static BankFeeDto entityToDto(final BankFee bankFee) {
        BankFeeDto bankFeeDto = new BankFeeDto();
        BeanUtils.copyProperties(bankFee, bankFeeDto);
        return bankFeeDto;
    }

    /**
     * @param bankFeeDto
     * @return convert dto to entities.
     */
    public static BankFee dtoToEntities(final BankFeeDto bankFeeDto) {
        BankFee bankFee = new BankFee();
        BeanUtils.copyProperties(bankFeeDto, bankFee);
        return bankFee;
    }

    /**
     * @param bankFee
     * @return
     */
    public static BankFeeResponse entitiesToResponseBankFee(
            final BankFee bankFee) {
        BankFeeResponse bankFeeResponse = new BankFeeResponse();
        BeanUtils.copyProperties(bankFee, bankFeeResponse);
        return bankFeeResponse;
    }

    /**
     * constructor for default empty.
     */
    private AppUtils() { }
}
