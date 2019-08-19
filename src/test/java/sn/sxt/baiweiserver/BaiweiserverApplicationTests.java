package sn.sxt.baiweiserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.sxt.baiweiserver.bean.Menu;
import sn.sxt.baiweiserver.mapper.MenuMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaiweiserverApplicationTests {
    @Autowired
    MenuMapper menuMapper;

    @Test
    public void contextLoads() {
        Menu menu=
                menuMapper.selectByPrimaryKey(1);

    }

}
