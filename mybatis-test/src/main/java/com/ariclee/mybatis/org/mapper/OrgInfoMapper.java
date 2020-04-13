package com.ariclee.mybatis.org.mapper;

import com.ariclee.mybatis.mch.MchInfoPO;
import com.ariclee.mybatis.org.OrgInfoPo;
import com.ariclee.mybatis.org.OrgWithMchInfoPo;
import com.ariclee.mybatis.org.OrgWithMchInfoPo2;
import com.ariclee.mybatis.org.QueryOrgInfoReq;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lihy
 * @version 1.0  2020/1/18
 */
public interface OrgInfoMapper {

    OrgInfoPo getBy(QueryOrgInfoReq req);

    OrgInfoPo getBy2(Integer id, String orgCode);

    OrgInfoPo getBy3(@Param("id") Integer id, @Param("orgCode") String orgCode);

    /* ---------------------------------------------------------------------------- */
    // 封装 Map 测试（resultType）
    /* ---------------------------------------------------------------------------- */
    Map<String, Object> getBy4(Integer id);

    @MapKey("id")
    Map<String, OrgInfoPo> getBy5(String orgCode);

    /* ---------------------------------------------------------------------------- */
    // 多表联查测试（resultMap）
    /* ---------------------------------------------------------------------------- */
    OrgWithMchInfoPo getBy6(Integer id);

    OrgWithMchInfoPo getBy6_1(Integer id);

    MchInfoPO getMchInfoByOrgId(Integer id);

    List<MchInfoPO> getMchInfosByOrgId(Integer id);

    // 一对多
    OrgWithMchInfoPo2 getBy7(Integer id);

    /* ---------------------------------------------------------------------------- */
    // discriminator 测试
    /* ---------------------------------------------------------------------------- */
    OrgWithMchInfoPo getBy8(Integer id);

    /* ---------------------------------------------------------------------------- */
    // 动态 SQL 测试
    /* ---------------------------------------------------------------------------- */
    List<OrgWithMchInfoPo> getBy9(QueryOrgInfoReq req);

    // 访问静态变量
    List<OrgWithMchInfoPo> getBy10(QueryOrgInfoReq req);
    // and 问题
    List<OrgWithMchInfoPo> getBy11(QueryOrgInfoReq req);
    // choose
    List<OrgWithMchInfoPo> getBy12(QueryOrgInfoReq req);
    // set
    boolean update3(OrgInfoPo po);

    int batchDelete1(@Param("ids") List<Integer> ids);

    int batchAdd1(@Param("pos") List<OrgInfoPo> pos);

    int batchAdd2(@Param("pos") List<OrgInfoPo> pos);

    // _paramter,_databaseId
    List<OrgWithMchInfoPo> getBy13(QueryOrgInfoReq req);

    // bind
    List<OrgWithMchInfoPo> getBy14(QueryOrgInfoReq req);

    /* ---------------------------------------------------------------------------- */
    // 缓存测试
    /* ---------------------------------------------------------------------------- */
    List<OrgWithMchInfoPo> getBy15(QueryOrgInfoReq req);

    /* ---------------------------------------------------------------------------- */
    // 分页测试
    /* ---------------------------------------------------------------------------- */
    List<OrgWithMchInfoPo> getBy16();

    /* ---------------------------------------------------------------------------- */
    // 自定义类型处理器测试
    /* ---------------------------------------------------------------------------- */
    int insertWithEnum(OrgInfoPo po);

    /* ---------------------------------------------------------------------------- */
    // 返回值测试
    /* ---------------------------------------------------------------------------- */
    boolean insert1(OrgInfoPo po);

    int insert2(OrgInfoPo po);

    boolean update1(OrgInfoPo po);

    int update2(OrgInfoPo po);

    /* ---------------------------------------------------------------------------- */
    // 返回自增主键
    /* ---------------------------------------------------------------------------- */
    /* MYSQL */
    boolean insert3(OrgInfoPo po);
    /* ORACLE */
    boolean insert4(OrgInfoPo po);

    /* ---------------------------------------------------------------------------- */
    // 查询
    /* ---------------------------------------------------------------------------- */
    List<OrgInfoPo> selectList(QueryOrgInfoReq req);

    OrgInfoPo selectSingle(QueryOrgInfoReq req);
}
