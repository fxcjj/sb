package com.vic.sb36;

import com.vic.sb36.doc.TryunReport;
import com.vic.sb36.doc.Item;
import com.vic.sb36.repository.ItemRepository;
import com.vic.sb36.repository.TryunReportRepository;
import com.vic.sb36.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb36ApplicationTests {

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TryunReportRepository tryunReportRepository;

    @Test
    public void createIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        esTemplate.createIndex(Item.class);

        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        esTemplate.putMapping(Item.class);
    }

    @Test
    public void index() {
        Item item = new Item(1L, "小米手机7", "手机", "小米", 3499.00, "http://image.baidu.com/13123.jpg");
        itemRepository.save(item);
    }


    @Test
    public void testbatchInsert() {
        Calendar calendar = Calendar.getInstance();

        List<TryunReport> data = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            calendar.set(2019, 13 - 1, 1 + i);
            data.add(new TryunReport(i  + "", DateUtil.getDateString(calendar.getTime()), "DELIVRD"));
        }

        tryunReportRepository.saveAll(data);
    }

    @Test
    public void testQuery() {
        Page<TryunReport> page = tryunReportRepository.findAll(PageRequest.of(1, 5));
//
        for(TryunReport item : page){
            System.out.println(item);
        }
    }








}
