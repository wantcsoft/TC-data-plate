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
@TableName("BSC_ConfirmState")
@ToString
public class ConfirmStateDao {

    @TableId(value = "ConfirmStateID", type = IdType.AUTO)
    private Integer confirmStateId;
    @TableField(value = "ConfirmStateName")
    private String confirmStateName;

}
