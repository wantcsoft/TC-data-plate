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
@TableName("BSC_ResultType")
public class ResultTypeDao {

    @TableId(value = "ResultTypeID", type = IdType.AUTO)
    private Integer resultTypeId;

    @TableField(value = "ResultTypeName")
    private String resultTypeName;

}
