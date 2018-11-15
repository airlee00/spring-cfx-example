package net.jeong.pro;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface DeptProcess {

    public List<DeptVo> processDept();
}
