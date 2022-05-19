package com.api.rest.bootcamp.util;

import com.api.rest.bootcamp.document.BankAccount;
import com.api.rest.bootcamp.dto.BankAccountDto;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static BankAccountDto entityToDto(BankAccount bankAccount) {
        BankAccountDto bankAccountDto = new BankAccountDto();
        BeanUtils.copyProperties(bankAccount, bankAccountDto);
        return bankAccountDto;
    }

    public static BankAccount dtoToEntities(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountDto, bankAccount);
        return bankAccount;
    }
}
