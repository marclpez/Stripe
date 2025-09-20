package com.app.service.mapper;

import com.app.service.dto.BalanceDto;
import com.stripe.model.Balance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    BalanceDto map(Balance stripeBalance);

    List<BalanceDto.Available> mapAvailable(List<Balance.Available> availableList);

    BalanceDto.Available mapSingleAvailable(Balance.Available available);
}