package com.boot.typography.service;


import com.boot.typography.dto.GoodsDto;
import com.boot.typography.model.Goods;
import com.boot.typography.repository.GoodsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;
    private final DtoConversionService conversionService;

    public List<GoodsDto> getAllGoods() {
        List<Goods> goods = goodsRepository.findAll();
        return conversionService.convert(goods, GoodsDto.class);
    }

    public GoodsDto createGoods(GoodsDto goodsDto) {
        Goods entity = conversionService.convert(goodsDto, Goods.class);
        Goods result = goodsRepository.saveAndFlush(entity);
        return conversionService.convert(result, GoodsDto.class);
    }

    public GoodsDto updateGoods(GoodsDto goodsDto) {
        Goods entity = conversionService.convert(goodsDto, Goods.class);
        Goods result = goodsRepository.saveAndFlush(entity);
        return conversionService.convert(result, GoodsDto.class);
    }

    public GoodsDto getGoods(Integer id) {
        Goods result = goodsRepository.findById(id).orElseThrow();
        return conversionService.convert(result, GoodsDto.class);

    }

    public void deleteGoodsById(Integer id) {
        goodsRepository.deleteById(id);
    }

    public void deleteAllGoods(List<Integer> ids) {
        goodsRepository.deleteAllById(ids);

    }


}
