package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author WMY
 */
@Data
@TableName("BSC_PrepLinkErrorCode")
public class PrepLinkErrorCodeDao {

    @TableField(value = "HospitalID")
    private Integer hospitalId;

    @TableId(value = "ErrorID", type = IdType.AUTO)
    private Integer errorId;

    @TableField(value = "ErrorCode")
    private String errorCode;

}
