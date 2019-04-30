package com.vic.sb03.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author 罗利华
 * date: 2019/4/29 18:54
 */
public class MyFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("sample")) {
            return FilterReply.ACCEPT; //允许输入串
        } else {
            return FilterReply.DENY; //不允许输出
        }
    }

}
