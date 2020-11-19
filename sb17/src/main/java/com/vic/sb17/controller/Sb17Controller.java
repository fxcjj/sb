package com.vic.sb17.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗利华
 * date: 2020/11/19 14:13
 */
@Slf4j
@RestController
@RequestMapping("sb17")
public class Sb17Controller {

    @GetMapping("test1")
    public String test1() {
      log.error("error");
      log.warn("warn");
      log.info("info");
      log.debug("debug");
      log.trace("trace");
      return "ok";
    }

}
