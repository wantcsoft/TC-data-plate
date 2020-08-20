package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@TableName("BSC_AuditState")
@ToString
public class AuditStateDao {

    @TableId(value = "AuditStateID", type = IdType.AUTO)
    private Integer auditStateId;
    @TableField(value = "AuditStateName")
    private String auditStateName;

}
