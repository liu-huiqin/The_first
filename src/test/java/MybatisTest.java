import com.ssm.dao.IUserDao;
import com.ssm.domain.User;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.lang.*;
import java.util.List;
import java.io.BufferedInputStream;
/**
 * Created by jfy on 2020/7/13 0013.
 */
public class MybatisTest {

    public static void main(String args[]){
        System.out.println("测试开始了:");
        try{
//            String resource = "SqlMapConfig.xml";
//            InputStream inputStream = Resources.getResourceAsStream(resource);
            //读取配置文件
           InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建sqlsessionFactory工厂
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //使用工厂生产出sqlsession对象
            SqlSession session=factory.openSession();
            //使用sqlsession创建Dao接口的代理对象
            IUserDao userDao=session.getMapper(IUserDao.class);
            //使用代理对象执行方法
            List<User> users=userDao.findAll();
            for(User user:users){
                System.out.println(user);
            }
            //释放资源
            session.close();
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
