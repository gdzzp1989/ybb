package ybb;

import java.util.List;

public class STVMajorType {
    private int id;
    List<STVMajor> major;
    private String cgName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<STVMajor> getMajor() {
        return major;
    }

    public void setMajor(List<STVMajor> major) {
        this.major = major;
    }

    public String getCgName() {
        return cgName;
    }

    public void setCgName(String cgName) {
        this.cgName = cgName;
    }
}
