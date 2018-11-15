package net.jeong.pro;

import java.io.Serializable;

public class DeptVo implements Serializable {
    private int deptNo;
    private String deptName;
    private String location;
    public int getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "DeptVo [deptNo=" + deptNo + ", deptName=" + deptName + ", location=" + location + "]";
    }
    
    

}
