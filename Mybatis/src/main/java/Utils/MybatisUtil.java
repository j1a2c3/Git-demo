package Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    public SqlSession getSqlSession(){
        String resources = "MybatisConfig.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
        }catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlsession = sqlMapper.openSession();
        return  sqlsession;
    }
}
