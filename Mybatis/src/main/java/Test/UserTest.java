package  Test;
import Utils.MybatisUtil;
import com.mybatis.pojo.QueryVo;
import com.mybatis.pojo.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.rmi.CORBA.Util;
import java.io.Reader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserTest {


    @Test
    public void userFindByTest() {
        String resources = "MybatisConfig.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        // 基本数据类型
        User user = session.selectOne("findById",1);
        System.out.println("基本数据类型");
        System.out.println(user.getUname()+"\t"+user.getUage());
        // 包装器类型
        User user2 = session.selectOne("findById2",2);
        System.out.println("包装器类型");
        System.out.println(user2.getUname()+"\t"+user2.getUage());
        // String 类型
        System.out.println("String 类型");
        List<User> list = session.selectList("findByName","zs");
        for (User obj : list){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
        // pojo类型
        User user1 = new User();
        user1.setUage(30);
        User pojo = session.selectOne("findByPojo", user1);
        System.out.println("pojo类型");
        System.out.println(pojo.getUid()+"    "+pojo.getUname()+"    "+pojo.getUage()+"    ");


        session.close();
}

    @Test
    public void  pojoCollection(){
        QueryVo queryVo = new QueryVo();
        queryVo.setParm1(10);
        queryVo.setParm2(1);
        MybatisUtil utils = new MybatisUtil();
        SqlSession sqlSession = utils.getSqlSession();
        String name = sqlSession.selectOne("pojoCollection",queryVo);
        System.out.println("pojo类型");
        System.out.println(name);
        sqlSession.close();
    }

    @Test
    public void returnInt(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = new User();
        user.setUname("yjj");
        int yjjage = sqlSession.selectOne("returnInt", user);
        System.out.println("杨佳佳的年龄是："+yjjage);
        sqlSession.close();
    }

    @Test
    public void returnCollectionList(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = new User();
        user.setUname("yjj");
        List<User> list= sqlSession.selectList("returnCollectionList", user);
        System.out.println("姓名是杨佳佳的有：");
        for (User obj : list){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
        sqlSession.close();
    }

    @Test
    public void returnCollectionList2(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = new User();
        user.setUname("yjj");
        List<Map<String,Object>> list= sqlSession.selectList("returnCollectionList2", user);
        System.out.println("姓名是杨佳佳的有：");
        for (Map map : list){
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void returnCollectionMap(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = new User();
        user.setUname("yjj");
        user.setUage(100);
        Map<String,Object> map= sqlSession.selectOne("returnCollectionMap",user);
        System.out.println("姓名是杨佳佳并且年龄是100的是：");
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void userTest() {
        String resources = "MybatisConfig.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlMapper.openSession();
        // 显现复现
        User user = session.selectOne("findByIdTest",1);
        System.out.println("基本数据类型");
        System.out.println(user.getUid()+"  "+user.getUname()+"  "+user.getUage());

    }

    @Test
    public void ifLable() {
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = new User();
        user.setUname("y");
        user.setUage(20);
        // 显现复现
        int count = sqlSession.selectOne("ifLable",user);
        System.out.println("姓名是以y开头并且年龄大于20岁的人数有："+count);

    }

    @Test
    public void sqlPeace2() {
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        // 显现复现
        List<User> lists = sqlSession.selectList("sqlPeace2");
        for (User obj : lists){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
    }

    @Test
    public void foreach() {
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        ArrayList<Integer> uids = new ArrayList<Integer>();
        uids.add(1);uids.add(3);uids.add(5);uids.add(7);
        // 显现复现
        QueryVo queryVo = new QueryVo();
        queryVo.setUids(uids);
        List<User> lists = sqlSession.selectList("foreach",queryVo);
        for (User obj : lists){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
    }

    @Test
    public void foreach2() {
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        ArrayList<Integer> uids = new ArrayList<Integer>();
        uids.add(1);uids.add(3);uids.add(5);uids.add(7);
        List<User> lists = sqlSession.selectList("foreach2", uids );
        for (User obj : lists){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
    }

    @Test
    public void foreach3() {
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        Integer uids[] = new Integer[]{0,1,2,5,6};
        List<User> lists = sqlSession.selectList("foreach3", uids );
        for (User obj : lists){
            System.out.println(obj.getUid()+"    "+obj.getUname()+"    "+obj.getUage()+"    ");
        }
    }

    @Test
    public void  selectByName(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = sqlSession.selectOne("selectByName", "yjj40");
        System.out.println(user);
        sqlSession.close();
        MybatisUtil mybatisUtil1 = new MybatisUtil();
        SqlSession sqlSession1 = mybatisUtil1.getSqlSession();
        User user1 = sqlSession1.selectOne("selectByName", "yjj40");
        System.out.println(user1);
        sqlSession1.close();
    }

    @Test
    public void  selectByName2(){
        MybatisUtil mybatisUtil = new MybatisUtil();
        SqlSession sqlSession = mybatisUtil.getSqlSession();
        User user = sqlSession.selectOne("selectByName", "yjj40");
        System.out.println(user);

        User user1 = sqlSession.selectOne("selectByName", "yjj40");
        System.out.println(user1);
        sqlSession.close();
    }
}

