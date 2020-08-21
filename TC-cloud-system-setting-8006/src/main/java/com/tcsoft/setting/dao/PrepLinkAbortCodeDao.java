package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，PropLink代码
 * @author WMY
 */
@Data
@ToString
@TableName("BSC_PrepLinkAbortCode")
public class PrepLinkAbortCodeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "AbortID", type = IdType.AUTO)
    private Integer abortId;

    @TableField(value = "AboutCode")
    private String abortCode;

}
