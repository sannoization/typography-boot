package com.boot.typography.conversion;

import com.boot.typography.dto.GoodsDto;
import com.boot.typography.model.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsDtoToEntityConverter implements Converter<GoodsDto, Goods> {

    @Override
    public Goods convert(GoodsDto source) {
        return Goods.builder()
                .id(source.getId())
                .name(source.getName())
                .cost(source.getCost())
                .amount(source.getAmount())
                .material(source.getMaterial())
                .options(source.getOptions())
                .build();
    }
}
