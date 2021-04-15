package org.neuedu.java20vblog.model;

public class Role {
    private Long id;
    private String rname;
    private String rnameZh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRnameZh() {
        return rnameZh;
    }

    public void setRnameZh(String rnameZh) {
        this.rnameZh = rnameZh;
    }
}
