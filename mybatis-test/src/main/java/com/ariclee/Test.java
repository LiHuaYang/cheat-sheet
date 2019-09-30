package com.ariclee;

import com.ariclee.dto.NviRecord;
import com.ariclee.mapper.NviRecordMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author lihy
 * @version 1.0  2019/6/8
 */
public class Test {

    public static void main(String[] args) {
        // 定义 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 使用配置文件创建 SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).fatal("创建 SqlSessionFactory失败", ex);
            return;
        }

        // 定义 sqlSession
        SqlSession sqlSession = null;
        try {
            // 用sqlSessionFactory创建sqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 获取Mapper
            NviRecordMapper mapper = sqlSession.getMapper(NviRecordMapper.class);
            // 执行Mapper接口方法.
            NviRecord record = mapper.queryByProposalNo("TEAU20193301Q000E00183");
            // 打印信息
            System.err.println(record.getId());
        } finally {
            // 使用完后要记得关闭sqlSession资源
            if (sqlSession != null)
                sqlSession.close();
        }

    }
}
