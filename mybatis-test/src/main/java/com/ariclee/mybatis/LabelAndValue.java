package com.ariclee.mybatis;

import java.io.Serializable;

public interface LabelAndValue extends Serializable {

    String getValue();

    String getLabel();

    LabelAndValue getByVal(String val);
}
