package org.neuedu.java20his.systeminfo.model;

import java.io.Serializable;

public class ConstantType implements Serializable {
    private Integer id;

    private String constanttypecode;

    private String constanttypename;

    private Integer delmark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstanttypecode() {
        return constanttypecode;
    }

    public void setConstanttypecode(String constanttypecode) {
        this.constanttypecode = constanttypecode == null ? null : constanttypecode.trim();
    }

    public String getConstanttypename() {
        return constanttypename;
    }

    public void setConstanttypename(String constanttypename) {
        this.constanttypename = constanttypename == null ? null : constanttypename.trim();
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}