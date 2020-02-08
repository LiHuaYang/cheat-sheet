package com.ariclee.mybatis;

import java.util.Arrays;

/**
 * @author lihy
 * @version 1.0  2020/2/7
 */
public enum SceneEnum implements LabelAndValue {
    INSURANCE("INSURANCE", "保险"),
    OTHER("OTHER", "非保险");

    SceneEnum(String value, String label){
        this.value = value;
        this.label = label;
    }

    private String value;
    private String label;


    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public LabelAndValue getByVal(String val) {
        return value == null ? null : Arrays.stream(SceneEnum.values()).filter(x -> x.value.equals(value)).findAny()
                .orElse(null);
    }
}
