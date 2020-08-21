package com.tcsoft.setting.viewmodel;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author WMY
 */
@Data
@ToString
public class TestItemGroupItemViewModel {

    private Integer testItemGroupId;
    private Integer testItemId;

}
