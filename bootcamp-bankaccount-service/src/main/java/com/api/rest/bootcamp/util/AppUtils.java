package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.BankAccount;
import com.api.rest.bootcamp.dto.BankAccountDto;
import org.springframework.beans.BeanUtils;
public final class AppUtils {
    /**
     * @param bankAccount
     * @return convert entities to dto.
     */
    public static BankAccountDto entityToDto(final BankAccount bankAccount) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        BeanUtils.copyProperties(bankAccount, bankAccountDto);
        return bankAccountDto;
    }

    /**
     * @param bankAccountDto
     * @return convert dto to entities.
     */
    public static BankAccount dtoToEntities(final BankAccountDto
                                                    bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDto, bankAccount);
        return bankAccount;
    }

    /**
     * constructor empty.
     */
    private AppUtils() { }
}
