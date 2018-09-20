package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import dto.AbsenceInfo;
import dto.SalaryShow;
import dto.TransferInfo;
import entity.Absence;
import entity.Department;
import entity.Employee;
import javafx.util.converter.TimeStringConverter;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.AbsenceService;
import service.AccountRelated;
import service.MoneyRelatedService;
import util.DepId;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class MisController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AbsenceService absenceService;

    @Autowired
    private AccountRelated accountRelated;

    @Autowired
    private MoneyRelatedService moneyRelatedService;

    private DepId depId=new DepId();

    @RequestMapping(value = "/login")
    public String main(){
        return "login";
    }

    /**
     * 登录各个部门主页
     * @param username
     * @param password
     * @param way
     * @param model
     * @return
     * 完成
     */
    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String login(@RequestParam("username") int username,@RequestParam("password") String password,@RequestParam("way") int way,Model model){

        System.out.println("username="+username+"  password="+password+"   way="+way);

        if(way==0){
            Employee employee=accountRelated.loginEmployee(username,password);
            if(employee==null){
                model.addAttribute("result",0);
                return "login";
            }
            List<SalaryShow> salaryShows=moneyRelatedService.findSalaryOrderByDate(employee.getEid(),20);
            model.addAttribute("sas",salaryShows);
            model.addAttribute("eid",employee.getEid());
            return "main_yuanGong";
        }
        if(way==1){
            Department department=accountRelated.loginDepartment(username,password);
            if(department==null){
                model.addAttribute("result",0);
                return "login";
            }
            if(department.getName().equals("管理员")) {
                List<Department> departments = accountRelated.findDepartment(0, 20);
                model.addAttribute("deps",departments);
                return "main_manager";
            }
            if(department.getName().equals("行政部")){
                 List<AbsenceInfo> absences = absenceService.selectAbsenceRecords(0,50);
                model.addAttribute("abs",absences);
                return "main_xingZhengBu";
            }
            if(department.getName().equals("人事部")) {
                List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
                model.addAttribute("Infos",transferInfos);
                return "main_renShiBu";
            }
            if(department.getName().equals("财务部")){
                List<SalaryShow> salaryShowList=moneyRelatedService.findSalaryOrderByDate(0,50);
                model.addAttribute("salaryList",salaryShowList);
                return "main_caiWuBu";
            }
        }
        return "login";
    }


    /**
     * 人事部：添加员工信息
     * DONE
     */
    @RequestMapping(value = "/addemp1",method = RequestMethod.GET)
    public String addemp(){
        return "renShiBu4";
    }

    @RequestMapping(value = "/addemp",method = RequestMethod.POST)
    public String addemployee(@RequestParam("ename") String ename,
                              @RequestParam("password") String password,@RequestParam("dpnum")int dpnum,Model model){
        int did=depId.getDepId(dpnum);
        System.out.println("ename="+ename+",password"+password+"dpnum:"+dpnum+"     did="+did);
        float salary=5000;
        accountRelated.register(ename,password,salary,did);
        List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
        model.addAttribute("Infos",transferInfos);
        return "main_renShiBu";
    }


    /**
     * 人事部：添加员工调度信息
     * @return
     */
    @RequestMapping(value = "/renshibu",method = RequestMethod.GET)
    public String renshibu(){return "renShiBu"; }

    @RequestMapping(value = "/addtransfer",method = RequestMethod.POST)
    public String addtransfer(@RequestParam("eid") int eid, @RequestParam("way")int way,
                              @RequestParam(value = "odep",required = false)Integer odep,
                              @RequestParam(value = "ndep",required = false) Integer ndep,
                              Model model){
        System.out.println("eid="+eid+"             way="+way+"               odep"+odep+"               ndep"+ndep);

        int oldDep=depId.getDepId(odep);
        int newDep=depId.getDepId(ndep);
        //根据调动方式way传递新旧部门号给数据层
        if(way==0){
            //调动：新旧部门采用传入参数
            accountRelated.addTransferRecord(eid,oldDep,newDep);
        }
        if(way==1){
            //辞退：旧部门采用传入参数，新部门为-1
            accountRelated.addTransferRecord(eid,oldDep,-1);
        }
        if(way==2){
            //退休：旧部门采用传入参数，新部门为0
            accountRelated.addTransferRecord(eid,oldDep,0);
        }
        if(way==3){
            //新员工：旧部门采用-1，新部门为传入参数
            accountRelated.addTransferRecord(eid,-1,newDep);
        }
        List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
        model.addAttribute("Infos",transferInfos);
        return "main_renShiBu";

    }

    /**
     * 修改员工调度信息
     * @param tid
     * @param eid
     * @param model
     * @return
     * DONE
     */
    @RequestMapping(value = "/edittransfer/{tid}/{eid}",method = RequestMethod.GET)
    public String edittransfer(@PathVariable("tid") int tid,@PathVariable("eid")int eid, Model model){
        model.addAttribute("tid",tid);
        model.addAttribute("eid",eid);
        return "renShiBu2";
    }

    @RequestMapping(value = "/{tid}/confirmtransfer",method = RequestMethod.GET)
    public String confrimtransfer(@PathVariable("tid")int tid, @RequestParam("eid") int eid, @RequestParam("way")int way,
                                  @RequestParam(value = "odep",required = false)Integer odep,
                                  @RequestParam(value = "ndep",required = false) Integer ndep,
                                  Model model){

        System.out.println("eid="+eid+"             way="+way+"               odep"+odep+"               ndep"+ndep);

        int oldDep=depId.getDepId(odep);
        int newDep=depId.getDepId(ndep);
        if(way==0){
            //调动：新旧部门采用传入参数
        }
        if(way==1){
            //辞退：旧部门采用传入参数，新部门为-1
            newDep=-1;
        }
        if(way==2){
            //退休：旧部门采用传入参数，新部门为0
            newDep=0;
        }
        if(way==3){
            //新员工：旧部门采用-1，新部门为传入参数
            oldDep=-1;
        }
        int result=accountRelated.updateTransfer(tid,eid,oldDep,newDep);
        model.addAttribute("result",result);
        List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
        model.addAttribute("Infos",transferInfos);
        return "main_renShiBu";
    }


    /**
     * 人事部删除调度信息
     * @param tid
     * @param model
     * @return
     * DONE
     */
    @RequestMapping(value = "/deletetransfer/{tid}",method = RequestMethod.GET)
    public String deletetransfer(@PathVariable("tid") int tid, Model model){
        accountRelated.deleteTransferRecordById(tid);
        List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
        model.addAttribute("Infos",transferInfos);
        return "main_renShiBu";
    }






    /**
     * 行政部：添加缺勤记录
     * 完成
     */

    @RequestMapping(value = "/refaddabs",method = RequestMethod.GET)
    public String refaddabsenc(){
        return "xingZhengBu";
    }

    @RequestMapping(value = "/addabs",method = RequestMethod.POST)
    public String addabsence(int eid,int days,int atype,String start ,
                             String reason, Model model){
        int result=addabsencerecord(eid,days,atype,start,reason);
        List<AbsenceInfo> absences = absenceService.selectAbsenceRecords(0, 50);
        model.addAttribute("abs", absences);
        model.addAttribute("result",result);
        return "main_xingZhengBu";
    }

    public int addabsencerecord(int eid,int days,int atype,String start ,
                                String reason){
        try {
            SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
            Date date = new Date(format.parse(start).getTime());//String转date的方法
            String newstart=start+" 00:00:00";
            Timestamp startTime=Timestamp.valueOf(newstart);//String转timestamp的方法
            System.out.println("date="+date+"   newstart="+newstart+"    startTime="+startTime);
            //请假
            if(atype==1)
                absenceService.addAbsenceRecordAskForLeave(eid,startTime,days,reason);
            //迟到
            if(atype==2)
                absenceService.addAbsenceRecordLate(eid,startTime,days,reason);
            //旷工
            if(atype==3)
                absenceService.addAbsenceRecordAbsenteeism(eid,startTime,days,reason);
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    /**
     * 行政部：修改单条缺勤记录
     * @param aid
     * @return
     * DONE
     */
    @RequestMapping(value = "/editabs/{aid}",method = RequestMethod.GET)
    public String editabsencerecorde(@PathVariable("aid") int aid,Model model){
        AbsenceInfo absenceInfo = absenceService.findAbsenceInfoByAid(aid);
        model.addAttribute("abs", absenceInfo);
        return "xingZhengBu2";
    }

    @RequestMapping(value = "/confirmeditabs/{aid}",method=RequestMethod.POST)
    public String confirmeditabs(@PathVariable("aid")int aid,int eid,int days,int atype,String start ,
                                 String reason,Model model){
        absenceService.deleteAbsenceByAid(aid);
        int result=addabsencerecord(eid,days,atype,start,reason);
        List<AbsenceInfo> absences = absenceService.selectAbsenceRecords(0, 50);
        model.addAttribute("abs", absences);
        model.addAttribute("result",result);
        return "main_xingZhengBu";
    }

    /**
     * 行政部：删除单条缺勤记录
     * @param aid
     * @param model
     * @return
     * 完成
     */
    @RequestMapping(value="/delabs/{aid}",method = RequestMethod.GET)
    public String deleteabsencerecord(@PathVariable("aid") int aid,Model model){
        //TODO:根据eid删除单条缺勤记录，不应该是eid，而是aid DONE
        System.out.println("aid="+aid);
        absenceService.deleteAbsenceByAid(aid);
        List<AbsenceInfo> absences = absenceService.selectAbsenceRecords(0,50);
        model.addAttribute("abs",absences);
        return "main_xingZhengBu";
    }



    @RequestMapping(value = "/editsala/{sid}",method = RequestMethod.GET)
    public String editsalary(@PathVariable("sid") int sid,Model model){
        return null;
    }


    /**
     * 管理员：修改部门密码
     * @param did
     * @param model
     * @return
     * 完成
     */
    @RequestMapping(value = "/changedpassword/{did}",method = RequestMethod.GET)
    public String changepassword(@PathVariable("did") int did,Model model){
       Department department = accountRelated.findDepartmentByDid(did);
       model.addAttribute("dep", department);
       return "manager";
    }


    @RequestMapping(value = "/confirmdpassword",method = RequestMethod.POST)
    public String confirmdpassword(@RequestParam("dname") String dname,@RequestParam("did") int did,
                                   @RequestParam("oldpass") String opass,@RequestParam("newpass")String npass,Model model){
        System.out.println("dname="+dname+"    did="+did+"   opass="+opass+"    npass="+npass);
        int result=accountRelated.updateDepartment(did,dname,npass);
        model.addAttribute("result",result);
        List<Department> departments = accountRelated.findDepartment(0, 20);
        model.addAttribute("deps",departments);
        return "main_manager";
    }





    @RequestMapping(value = "/changeepassword/{eid}",method = RequestMethod.GET)
    public String changeepassword(@PathVariable("eid") int eid,Model model){
        Employee employee=accountRelated.findEmployeeByEid(eid);
        model.addAttribute("emp",employee);
        return "yuanGong1";
    }


    @RequestMapping(value = "/confirmepassword",method = RequestMethod.POST)
    public String confrimpassword(@RequestParam("eid") int eid,@RequestParam("ename")String name,
                                  @RequestParam("opass")String opass,@RequestParam("npass")String npass,Model model){
        int result=accountRelated.updateEmployeePassword(eid,name,opass,npass);
        model.addAttribute("result",result);
        List<SalaryShow> salaryShows=moneyRelatedService.findSalaryOrderByDate(eid,20);
        model.addAttribute("sas",salaryShows);
        model.addAttribute("eid",eid);
        return "main_yuanGong";
    }


    @RequestMapping(value = "/dataException")
    public String dataException(){
        return "/error/dataException";
    }


}
