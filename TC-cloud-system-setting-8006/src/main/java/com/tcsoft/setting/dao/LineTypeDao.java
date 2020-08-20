package com.tcsoft.setting.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 基础配置信息，流水线类型
 * @author WMY
 */
@Data
@TableName("BSC_LineType")
@ToString
public class LineTypeDao {

    @TableId(value = "LineTypeId", type = IdType.AUTO)
    private Integer lineTypeId;
    @TableField(value = "LineTypeCode")
    private String lineTypeCode;
    @TableField(value = "LineTypeName")
    private String lineTypeName;
    @TableField(value = "Comment")
    private String comment;

}
