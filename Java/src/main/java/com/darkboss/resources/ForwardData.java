package com.darkboss.resources;

import cn.hutool.json.JSONSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ang Li
 * @date 2020/12/8 上午 10:03
 */
@Data
@EqualsAndHashCode()
public class ForwardData extends JSONSupport implements Serializable {
    private Date dealDate;
    private Date spotDate;


}
