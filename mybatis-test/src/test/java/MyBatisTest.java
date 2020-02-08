import com.ariclee.mybatis.OrgInfoPo;
import com.ariclee.mybatis.QueryOrgInfoReq;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
public class MyBatisTest {

    @Test
    public void test() throws Exception {
        // mybatis配置文件
        String resource = "simple-mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(2).build();
        OrgInfoPo po = sqlSession.selectOne("com.ariclee.mybatis.mapper.OrgInfoMapper.getBy", orgInfoReq);

        System.out.println(po);

        // 释放资源
        sqlSession.close();
    }
}