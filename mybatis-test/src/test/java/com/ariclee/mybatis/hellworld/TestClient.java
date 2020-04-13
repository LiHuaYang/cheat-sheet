package com.ariclee.mybatis.hellworld;

import com.ariclee.mybatis.org.*;
import com.ariclee.mybatis.org.mapper.OrgInfoMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
public class TestClient {


    /**
     * 1、创建 mybatis 配置文件
     * 2、得到配置文件流
     * 3、创建会话工厂，配置文件流
     * 4、通过工厂得到 SqlSession
     * 5、通过 SqlSession 操作数据库
     * 6、释放资源
     *
     * test1：使用 namespace+方法id 定位 mapper 文件中的查询方法
     * test2：将 mapper 接口与 mapper xml 文件动态绑定（对 namespace 和 mapper 里面的方法有约定）
     * test3：静态数据源切换
     */

    @Test
    public void test1() throws Exception {
        String resource = "simple-mybatis-config.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne 结果 是与映射文件中所匹配的 resultType 类型的对象
        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(2).build();
        OrgInfoPo po = sqlSession.selectOne("com.ariclee.mybatis.org.mapper.OrgInfoMapper.getBy", orgInfoReq);

        System.out.println(po);
        sqlSession.close();
    }

    @Test
    public void test2() throws Exception {
        String resource = "simple-mybatis-config.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(2).build();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        OrgInfoPo po = mapper.getBy(orgInfoReq);
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test3() throws Exception {
        String resource = "simple-mybatis-config-db-provider.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(1).build();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        OrgInfoPo po = mapper.getBy(orgInfoReq);
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test4() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        QueryOrgInfoReq orgInfoReq = QueryOrgInfoReq.builder().id(1).build();
        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        OrgInfoPo po = mapper.getBy(orgInfoReq);
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test5() throws Exception {
        String resource = "simple-mybatis-config-db-provider.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // ！增删改默认不提交数据！
        // ！但是方法执行还是会返回成功！
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
//        boolean flag = mapper.insert1(new OrgInfoPo(3, "002", "测试插入2", new Date()));
//        System.out.println(flag);
//        int res = mapper.insert2(new OrgInfoPo(4, "003", "测试插入3", new Date()));
//        System.out.println(res);

        // 受影响行数，而不是更新成功行数
//        boolean flag = mapper.update1(new OrgInfoPo(3, "002", "测试更新2", new Date()));
//        System.out.println(flag);
//        int res = mapper.update2(new OrgInfoPo(4, "003", "测试更新3", new Date()));
//        System.out.println(res);

//        OrgInfoPo po = new OrgInfoPo("003", "测试插入，返回主键", new Date());
//        boolean flag = mapper.insert3(po);
//        System.out.println(po);
//        OrgInfoPo po = new OrgInfoPo("006", "测试插入，返回主键", new Date());
//        boolean flag = mapper.insert4(po);
//        System.out.println(po);

        /* 测试 Oracle 在 Null 情况下报错 */
        OrgInfoPo po = new OrgInfoPo("006", null, null);
        boolean flag = mapper.insert4(po);
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test6() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        // SELECT * FROM org_info_test where 1=1 and id=2 and org_code=?
        OrgInfoPo po = mapper.getBy3(2, "浙江");
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test7() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        Map<String, Object> map = mapper.getBy4(2);
        System.out.println(map);

        sqlSession.close();
    }

    @Test
    public void test8() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        Map<String, OrgInfoPo> map = mapper.getBy5("%00%");
        System.out.println(map);

        sqlSession.close();
    }

    @Test
    public void test9() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        // 一对一
//        OrgInfoPoWithMchInfo po = mapper.getBy6(1);
//        System.out.println(po);
        // 延时查询
//        OrgWithMchInfoPo po = mapper.getBy6_1(1);
//        System.out.println(po.getId());
//        System.out.println("------------------------------------");
//        System.out.println(po.getMch());

        // 一对多
        OrgWithMchInfoPo2 po = mapper.getBy7(2);
        System.out.println(po);

        sqlSession.close();
    }

    @Test
    public void test10() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
        OrgWithMchInfoPo po1 = mapper.getBy8(1);
        System.out.println(po1);

        OrgWithMchInfoPo po2 = mapper.getBy8(2);
        System.out.println(po2);

        sqlSession.close();
    }

    @Test
    public void test11() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);
//        QueryOrgInfoReq req1 = QueryOrgInfoReq.builder().id(1).orgCodeLike("").build();
//        List<OrgWithMchInfoPo> po1 = mapper.getBy9(req1);
//        System.out.println(po1);

//        QueryOrgInfoReq req2 = QueryOrgInfoReq.builder().id(1).orgCodeLike("").build();
//        List<OrgWithMchInfoPo> po2 = mapper.getBy10(req2);
//        System.out.println(po2);

//        QueryOrgInfoReq req3 = QueryOrgInfoReq.builder().id(1).orgCodeLike("1").build();
//        List<OrgWithMchInfoPo> po3 = mapper.getBy11(req3);
//        System.out.println(po3);

//        QueryOrgInfoReq req4 = QueryOrgInfoReq.builder()
//                .id(1).orgCodeLike("%1%").build();
//        List<OrgWithMchInfoPo> po4 = mapper.getBy12(req4);
//        System.out.println(po4);

//        boolean flag = mapper.update3(new OrgInfoPo(9, "9999", "set 标签", new Date()));
//        System.out.println(flag);

//        int res = mapper.batchDelete1(new ArrayList<>(Arrays.asList(11, 12, 13)));
//        System.out.println(res);

//        List<OrgInfoPo> pos1 = Lists.newArrayList(new OrgInfoPo("006", "for1", new Date()), new OrgInfoPo("007", "for2", new Date()));
//        int res = mapper.batchAdd1(pos1);
//        System.out.println(res);

//        List<OrgInfoPo> pos1 = Lists.newArrayList(new OrgInfoPo("006", "for1", new Date()), new OrgInfoPo("007", "for2", new Date()));
//        int res = mapper.batchAdd2(pos1);
//        System.out.println(res);

//        QueryOrgInfoReq req3 = QueryOrgInfoReq.builder().id(1).orgCodeLike("").build();
//        List<OrgWithMchInfoPo> po2 = mapper.getBy13(req3);
//        System.out.println(po2);

        QueryOrgInfoReq req4 = QueryOrgInfoReq.builder().orgCodeLike("1").build();
        List<OrgWithMchInfoPo> po2 = mapper.getBy14(req4);
        System.out.println(po2);

        sqlSession.close();
    }

    @Test
    public void test12() throws Exception {
        String resource = "simple-mybatis-config-mapper.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

        // 一级缓存
        QueryOrgInfoReq req = QueryOrgInfoReq.builder().orgCodeLike("1").build();
        List<OrgWithMchInfoPo> res1 = mapper.getBy15(req);
        System.out.println(res1);

        sqlSession.close();
        sqlSession.clearCache();

//        int delRes = mapper.batchDelete1(new ArrayList<>(Arrays.asList(11, 12, 13)));
//        System.out.println(delRes);

//        List<OrgWithMchInfoPo> res2 = mapper.getBy15(req);
//        System.out.println(res2);

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        OrgInfoMapper mapper2 = sqlSession2.getMapper(OrgInfoMapper.class);
        List<OrgWithMchInfoPo> res2 = mapper2.getBy15(req);
        System.out.println(res2);
    }

    @Test
    public void test13() throws Exception {
        String resource = "mybatis-config-with-page.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrgInfoMapper mapper = sqlSession.getMapper(OrgInfoMapper.class);

//        Page<Object> page = PageHelper.startPage(1, 3);
//        List<OrgWithMchInfoPo> res1 = mapper.getBy16();
//
//        PageInfo<OrgWithMchInfoPo> pageInfo = new PageInfo<>(res1);
//        res1.forEach(System.out::println);
//
//        System.out.println("总页数：" + pageInfo.getPages());
//        System.out.println("总条数：" + pageInfo.getTotal());
//
//        System.out.println("总页数：" + page.getPages());
//        System.out.println("总条数：" + page.getTotal());

//        Page<Object> page = PageHelper.startPage(1, 8);
//        List<OrgWithMchInfoPo> res1 = mapper.getBy16();
//        res1.forEach(System.out::println);

        int res = mapper.insertWithEnum(new OrgInfoPo("0009", "枚举处理器测试1", new Date(), SceneEnum.INSURANCE));

        List<OrgWithMchInfoPo> res1 = mapper.getBy16();
        res1.forEach(System.out::println);

        sqlSession.close();
    }
}
