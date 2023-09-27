package Test;

import Utils.MybatisUtil;
import com.mybatis.pojo.Consumer;
import com.mybatis.pojo.ConsumerOrder;
import com.mybatis.pojo.Order;
import com.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrderTest {
    SqlSession sqlSession=null;

    @Before
    public void getSqlsession(){
        MybatisUtil mybatisUtil = new MybatisUtil();
         sqlSession = mybatisUtil.getSqlSession();
    }

    @Test
    public void ConsumerOrder(){
        List<ConsumerOrder> list = sqlSession.selectList("ConsumerOrder1");
        for (ConsumerOrder obj : list){
            System.out.println(obj.toString());
        }
    }

    @Test
    public void ConsumerOrder2(){
        List<Order> list = sqlSession.selectList("ConsumerOrder2");
        for (Order obj : list){
            System.out.println(obj.toString());
        }
    }

    @Test
    public void ConsumerOrder3(){
        List<Consumer> list = sqlSession.selectList("ConsumerOrder3");
        for (Consumer obj : list){
            System.out.println(obj.toString());
        }
    }

    @After
    public void closeSqlsession(){
        sqlSession.close();
    }
}
