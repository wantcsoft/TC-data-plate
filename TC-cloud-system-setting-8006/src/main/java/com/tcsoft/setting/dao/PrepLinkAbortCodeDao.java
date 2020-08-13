package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_PrepLinkAbortCode")
public class PrepLinkAbortCodeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "AbortID", type = IdType.AUTO)
    private Integer abortId;

    @TableField(value = "AboutCode")
    private String abortCode;

}
