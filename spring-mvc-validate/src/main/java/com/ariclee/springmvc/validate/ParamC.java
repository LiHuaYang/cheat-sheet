package com.ariclee.springmvc.validate;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lihy
 * @version 1.0  2019/10/31
 */
@Data
public class ParamC {
    @NotBlank
    String name;

}
