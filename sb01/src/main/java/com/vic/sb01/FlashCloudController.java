package com.vic.sb01;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vic.sb01.vo.RestVo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Victor
 * date: 2019/4/16 16:03
 */
@RestController
@RequestMapping("fc")
public class FlashCloudController {

    @PostMapping("cb/panVerify")
    public void cbPanVerify(@RequestBody JSONObject json) {
        System.out.println("result:" + json);
    }

    @PostMapping("cb/panVerify1")
    public RestVo cbPanVerify1(@RequestBody String json, @RequestParam("mer") String mer) {
        System.out.println("result1:" + json);
        System.out.println("merchantCode:" + mer);
        return RestVo.success();
    }

}
