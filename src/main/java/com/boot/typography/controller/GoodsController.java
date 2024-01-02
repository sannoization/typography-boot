package com.boot.typography.controller;

import com.boot.typography.dto.GoodsDto;
import com.boot.typography.service.GoodsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping
    public List<GoodsDto> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @GetMapping(path = "/{id}")
    public GoodsDto getGoodsById(@PathVariable Integer id) {
        return goodsService.getGoods(id);
    }

    @PostMapping
    public GoodsDto createGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.createGoods(goodsDto);
    }

    @PutMapping
    public GoodsDto updateGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.updateGoods(goodsDto);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable Integer id) {
        goodsService.deleteGoodsById(id);
    }
}
