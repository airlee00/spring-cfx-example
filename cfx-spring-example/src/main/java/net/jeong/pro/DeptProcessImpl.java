package net.jeong.pro;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "net.jeong.pro.DeptProcess")
public class DeptProcessImpl implements DeptProcess {

    @Override
    public List<DeptVo> processDept(){
        // TODO Auto-generated method stub
        System.out.println("------------호출-----------");
        List<DeptVo> list = new ArrayList<DeptVo>();
        for(int i=0;i<5;i++) {
            DeptVo vo = new DeptVo();
            vo.setDeptName("부서명" + i);
            vo.setDeptNo(i);
            vo.setLocation("지역" + i);
            list.add(vo);
        }
        return list;
    }

    
}
