package com.app.service.mapper;

import com.app.service.dto.response.BalanceResponseDto;
import com.stripe.model.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    BalanceResponseDto map(Balance stripeBalance);

    List<BalanceResponseDto.Available> mapAvailable(List<Balance.Available> availableList);

    BalanceResponseDto.Available mapSingleAvailable(Balance.Available available);
}