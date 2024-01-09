package com.boot.typography.conversion;

import com.boot.typography.dto.GoodsDto;
import com.boot.typography.model.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsToDtoConverter implements Converter<Goods, GoodsDto> {

    @Override
    public GoodsDto convert(Goods source) {
        return GoodsDto.builder()
                .id(source.getId())
                .name(source.getName())
                .cost(source.getCost())
                .amount(source.getAmount())
                .material(source.getMaterial())
                .options(source.getOptions())
                .build();
    }
}