package com.vic.sb08.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 罗利华
 * date: 2019/9/18 11:23
 */
public class SimpleVo {

    Long creditWayId;
    String creditWayName;
    Long thirdId;
    String thirdName;
    Integer status;

    public SimpleVo(Long creditWayId, String creditWayName, Long thirdId, String thirdName, Integer status) {
        this.creditWayId = creditWayId;
        this.creditWayName = creditWayName;
        this.thirdId = thirdId;
        this.thirdName = thirdName;
        this.status = status;
    }
}
