package com.dkm.base;


import com.dkm.game.data.myenum.GameEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseReq {

    private  String status;

    private String createTime ;

    private String createBy;

    private String updateTime;

    private String updateBy;
}
