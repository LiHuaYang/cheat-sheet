package com.ariclee.mapper;

import com.ariclee.dto.NviRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 投保记录 Mapper
 *
 * @author chenqk
 * @version 1.0  2019/1/16
 */
@Mapper
@Component
public interface NviRecordMapper {

    /**
     * 插入投保记录
     *
     * @param record 下单记录
     * @return 插入条数
     */
    int insert(NviRecord record);

    /**
     * 根据保融流水号查出投保记录
     *
     * @param orderNo 保融流水号
     * @return 投保记录
     */
    NviRecord queryRecord(@Param("orderNo") String orderNo);

    /**
     * 根据投保单号查询投保记录
     *
     * @param proposalNo 投保单号
     * @return 投保记录
     */
    NviRecord queryByProposalNo(@Param("proposalNo") String proposalNo);

    /**
     * 根据保融流水号更新投保记录状态
     *
     * @param orderNo 保融流水号
     * @param state 交易状态
     * @return 更新条数
     */
    int updateState(@Param("orderNo") String orderNo, @Param("state") String state);

    /**
     * 根据保融流水号更新投保单号和交易状态
     * @param orderNo 保融流水号
     * @param proposalNo 投保单号
     * @param state 交易状态
     * @return 更新条数
     */
    int updateProposalNoAndState(@Param("orderNo") String orderNo, @Param("proposalNo") String proposalNo, @Param("state") String state);

    /**
     * 根据投保单号更新第三方流水号和交易状态
     * 如果订单状态已经是 22，则不更新状态
     *
     * @param proposalNo 投保单号
     * @param bankTradeNo 第三方流水号
     * @param state 交易状态
     * @return 更新条数
     */
    int updateTradeNoAndStatePre(@Param("proposalNo") String proposalNo, @Param("bankTradeNo") String bankTradeNo, @Param("state") String state);

    int updatePolicyInfoAndState(@Param("proposalNo") String proposalNo, @Param("policyNo") String policyNo, @Param("policyUrl") String policyUrl, @Param("state") String state);

    int updateEInvoiceUrl(@Param("proposalNo") String proposalNo, @Param("eInvoiceUrl") String eInvoiceUrl);

}
