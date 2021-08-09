package com.vic.sb47.controller;

import com.vic.sb47.entity.Seckill;
import com.vic.sb47.entity.SeckillOrder;
import com.vic.sb47.service.SeckillOrderService;
import com.vic.sb47.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @GetMapping("kill")
    public String findById(@RequestParam("phone") String phone, @RequestParam("seckillId") Long seckillId) {
        // 校验参数
        if(!StringUtils.hasText(phone)) {
            return "手机号不能为空！";
        }
        if(seckillId == null || seckillId == 0L) {
            return "秒杀商品ID不能为空";
        }

        // 用户频率限制 todo


        // 修改库存 这里要优化为：提前生成token，用户拿到token才可操作数据库
        // 方式1
//        int row = seckillService.deInventoryByLock(seckillId);

        // 方式2
        Seckill seckill = seckillService.findBySeckillId(seckillId);
        int row = seckillService.deInventoryByOptimisticLock(seckillId, seckill.getVersion());
        if(row == 0) {
            System.out.println("秒杀失败！phone: " + phone + ", seckillId: " + seckillId);
            return "秒杀结束，请看看其它商品！";
        }

        // 生成秒杀订单 这里可以使用MQ异步处理订单
        SeckillOrder order = new SeckillOrder();
        order.setUserPhone(phone);
        order.setSeckillId(seckillId);
        order.setStatus(1);
        seckillOrderService.insertOrder(order);
        System.out.println("秒杀成功！phone: " + phone + ", seckillId: " + seckillId);
        return "恭喜，秒杀成功！";
    }

}
