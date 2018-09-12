package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import dto.AbsenceInfo;
import dto.SalaryShow;
import dto.TransferInfo;
import entity.Absence;
import entity.Department;
import entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AbsenceService;
import service.AccountRelated;
import service.MoneyRelatedService;
import util.DepId;

import java.sql.Timestamp;
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
     */
    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String login(@Param("username") int username,@Param("password") String password,@Param("way") int way,Model model){

        System.out.printf("username="+username+"  password="+password+"   way="+way);

        if(way==0){
            Employee employee=accountRelated.loginEmployee(username,password);
            List<SalaryShow> salaryShows=moneyRelatedService.findSalaryOrderByDate(employee.getEid(),20);
            model.addAttribute("sas",salaryShows);
            model.addAttribute("eid",employee.getEid());
            return "main_yuanGong";
        }
        if(way==1){
            Department department=accountRelated.loginDepartment(username,password);
            if(department.getName().equals("管理员")) {
                List<Department> departments = accountRelated.findDepartment(0, 20);
                model.addAttribute("deps",departments);
                return "main_manager";
            }
            if(department.getName().equals("行政部")){
                List<AbsenceInfo> absenceInfos=absenceService.selectAbsenceRecords(0,50);
                model.addAttribute("abs",absenceInfos);
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
     * 新增员工信息
     */
    @RequestMapping(value = "/addemp1",method = RequestMethod.GET)
    public String addemp(){
        return "renShiBu4";
    }

    @RequestMapping(value = "/addemp",method = RequestMethod.POST)
    public String addemployee(@Param("ename") String ename,
                              @Param("password") String password,@Param("dpnum")int dpnum,Model model){

        System.out.println("ename="+ename+",password"+password+"dpnum:"+dpnum);

        int did=depId.getDepId(dpnum);
        float salary=5000;
        accountRelated.register(ename,password,salary,did);
        List<TransferInfo> transferInfos=accountRelated.findTransferInfoOrderByDate(0,50);
        model.addAttribute("Infos",transferInfos);
        return "main_renShiBu";
    }


    /**
     * 添加员工调度信息
     * @return
     */
    @RequestMapping(value = "/renshibu",method = RequestMethod.GET)
    public String renshibu(){return "renShiBu"; }

    @RequestMapping(value = "/addtransfer",method = RequestMethod.POST)
    public String addtransfer(@Param("eid") int eid,@Param("way")int way,
                              @Param("odep")int odep,@Param("ndep") int ndep){
        System.out.println("eid="+eid+"way="+way+"odep"+odep+"ndep"+ndep);

        //根据调动方式way传递新旧部门号给数据层
        if(way==0){
            //调动：新旧部门采用传入参数
        }
        if(way==1){
            //辞退：旧部门采用传入参数，新部门为-1
        }
        if(way==2){
            //退休：旧部门采用传入参数，新部门为0
        }
        if(way==3){
            //新员工：旧部门采用-1，新部门为传入参数
        }
        return null;

    }




    @RequestMapping(value = "/changepassword/{eid}",method = RequestMethod.GET)
    public String changgepassword(@PathVariable("eid") int eid,Model model){
        Employee employee= accountRelated.findEmployeeByEid(eid);
        model.addAttribute("emp",employee);
        return "yuanGong1";
    }


    @RequestMapping(value = "/confirmpassword",method = RequestMethod.POST)
    public String confrimpassword(@Param("eid") int eid,@Param("ename")String name,
                                  @Param("opass")String opass,@Param("npass")String npass,Model model){
        int result=accountRelated.updateEmployeePassword(eid,name,opass,npass);
        model.addAttribute("result",result);
        return "main_yuanGong";
    }


    /**
     * 添加缺勤记录
     * @param cid
     * @param startTime
     * @param days
     * @param atype
     * @param reason
     * @param model
     * @return
     */
    @RequestMapping(value = "/addabs",method = RequestMethod.POST)
    public String addabsence(@Param("cnumber")int cid, @Param("startDate") Timestamp startTime,
                             @Param("days")int days, @Param("atype") int atype, @Param("reason")String reason, Model model){
        //请假
        if(atype==1)
            absenceService.addAbsenceRecordAskForLeave(cid,startTime,days,reason);
        //迟到
        if(atype==2)
            absenceService.addAbsenceRecordLate(cid,startTime,days,reason);
        //旷工
        if(atype==3)
            absenceService.addAbsenceRecordAbsenteeism(cid,startTime,days,reason);
        List<AbsenceInfo> absences=absenceService.selectAbsenceRecords(0,50);
        model.addAttribute("abs",absences);
        return "main_xingZhengBu";
    }

    @RequestMapping(value = "/editsala/{sid}",method = RequestMethod.GET)
    public String editsalary(@PathVariable("sid") int sid,Model model){
        return null;
    }

}
