package com.vic.sb24.controller;

import com.vic.sb24.entity.Goods;
import com.vic.sb24.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 罗利华
 * date: 2020/4/7 17:11
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("updateName")
    public int updateName(@RequestBody Goods goods) {
        int result = goodsService.updateName(goods);
        System.out.println(result == 1 ? "更新成功" : "更新失败");
        return result;
    }

}
