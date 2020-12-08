package com.darkboss.resources;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Ang Li
 * @date 2020/12/8 上午 10:03
 */
@Data
@EqualsAndHashCode()
@ToString(callSuper = true)
public class ForwardBaseBO implements Serializable {
    private Integer cusNumber;
    private Date valuationDate;
    private ForwardData data;
}
