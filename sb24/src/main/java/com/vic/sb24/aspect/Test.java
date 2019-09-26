package com.vic.sb24.aspect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 罗利华
 * date: 2019/9/4 15:34
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>();
        param.put("idcardFrontImagePath", "a");
        param.put("user_id", "dd");
        param.put("relationId", 56789L);
        param.put("relationType", 56);

        System.out.println(param.get("relationId"));
    }
}
