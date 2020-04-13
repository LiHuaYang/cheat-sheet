package com.ariclee.mybatis.org;

import java.io.Serializable;

public interface LabelAndValue extends Serializable {

    String getValue();

    String getLabel();

    LabelAndValue getByVal(String val);
}
