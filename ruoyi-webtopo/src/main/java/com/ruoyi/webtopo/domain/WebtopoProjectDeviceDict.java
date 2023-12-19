package com.ruoyi.webtopo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class WebtopoProjectDeviceDict {
    private static final long serialVersionUID = 1L;

    private String label;

    private String value;


    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }


    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("label", getLabel())
                .append("value", getValue())
                .toString();
    }
}
