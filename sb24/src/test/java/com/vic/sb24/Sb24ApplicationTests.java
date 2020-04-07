package com.vic.sb24;

import com.vic.sb24.entity.Goods;
import com.vic.sb24.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb24ApplicationTests {

    @Autowired
    GoodsService goodsService;

    @Test
    public void testInsert() {
        Goods g = new Goods();
        g.setName("飞机");
        g.setStatus(1);
        goodsService.insert(g);
    }

    @Test
    public void testOptimistic() {

        Long goodsId = 1L;
        Goods goods1 = goodsService.findById(goodsId);
        Goods goods2 = goodsService.findById(goodsId);

        goods1.setName("坦克");
        int updateResult1 = goodsService.updateName(goods1);
        System.out.println("修改商品信息1" + (updateResult1 == 1 ? "成功" : "失败"));

        goods2.setName("巧克力");
        int updateResult2 = goodsService.updateName(goods2);
        System.out.println("修改商品信息2" + (updateResult2 == 1 ? "成功" : "失败"));

        // 失败后重试
        if(updateResult2 == 0) {
            int maxRetryTime = 3;
            int time = 0;
            do {
                time++;
                System.out.println("重试 " + time + " 次执行");
                try {
                    Goods dbGoods = goodsService.findById(goods2.getId());
                    goods2.setVersion(dbGoods.getVersion());
                    updateResult2 = goodsService.updateName(goods2);
                    System.out.println("修改商品信息2" + (updateResult2 == 1 ? "成功" : "失败"));
                } catch (Exception e) {
                    try {
                        //暂停
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            } while (updateResult2 == 0 && time < maxRetryTime);
        }


    }

}
