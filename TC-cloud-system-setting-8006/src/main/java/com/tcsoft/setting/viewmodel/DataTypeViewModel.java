package com.tcsoft.setting.viewmodel;


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
@ToString
public class DataTypeViewModel {

    private Integer dataTypeId;
    private String dataTypeName;
}
