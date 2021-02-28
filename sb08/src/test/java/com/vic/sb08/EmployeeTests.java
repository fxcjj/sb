package com.vic.sb08;

import com.alibaba.fastjson.JSON;
import com.vic.sb08.bo.DeptEmployeeLinkBo;
import com.vic.sb08.bo.PageBo;
import com.vic.sb08.entity.User;
import com.vic.sb08.repository.DeptEmployeeLinkRepository;
import com.vic.sb08.repository.UserRepository;
import com.vic.sb08.vo.EmployeeVo;
import com.vic.sb08.vo.SimpleUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTests {

    @Autowired
    DeptEmployeeLinkRepository deptEmployeeLinkRepository;

    @Test
    public void testPage() {
        PageBo<DeptEmployeeLinkBo> pageBo = new PageBo();
        pageBo.init();

        DeptEmployeeLinkBo linkBo = new DeptEmployeeLinkBo();
        linkBo.setDeptCode("A");
        pageBo.setParam(linkBo);


        Page<EmployeeVo> page = deptEmployeeLinkRepository.findEmployeeVoPage(PageRequest.of(pageBo.getPage() - 1, pageBo.getSize(), Sort.by(Sort.Direction.ASC, "id")), pageBo.getParam().getDeptCode());
        System.out.println(JSON.toJSONString(page.getContent()));
        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());

    }


}
