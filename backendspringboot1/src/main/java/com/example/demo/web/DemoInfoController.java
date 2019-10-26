package com.example.demo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.result.VueExpenseInfoVo;
import com.example.demo.result.VueLoginInfoVo;
import com.smartkaya.bean.Paramater;
import com.smartkaya.core.ParseKayaModel_XPATH;
import com.smartkaya.dao.KayaSQLExecute;
import com.smartkaya.workflows.WorkFlowListener;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@Controller
public class DemoInfoController {

	/**
	 * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
	 * 给VueLoginInfoVo对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
	 * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
	 */
	@CrossOrigin
	@RequestMapping(value = "/api/test2", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {

		///// 使用Kaya添加Combo表-->
//		ParseKayaModel_XPATH.getInstance();
//		String jsonParamater2 = "{Paramater:{'id':'id-0065-00000009','crud':'POST','mappings':[{'keys':{'ComboId':'1','ItemId':'1'},'propertys':{'ComboName':'M1','ItemName':'I1'}}]}}";
//		JSONObject obj2 = JSONObject.fromObject(jsonParamater2);
//		JSONObject jsonObject2 = obj2.getJSONObject("Paramater");
//
//		Paramater paramater2 = (Paramater) JSONObject.toBean(jsonObject2, Paramater.class);
//
//		KayaSQLExecute dao2 = new KayaSQLExecute();
//		dao2.insert(paramater2);
		///// 使用Kaya添加Combo表END<--

		///// 使用Kaya添加三个员工id-->
//		ParseKayaModel_XPATH.getInstance();
//		String jsonParamater = "{Paramater:{'id':'id-0065-00000003','crud':'POST','mapping':{'propertys':{'EmployeeId':'10000001','EmployeeName':'Tom','Password':'123'}}}}";
//		JSONObject obj = JSONObject.fromObject(jsonParamater);
//		JSONObject jsonObject = obj.getJSONObject("Paramater");
//		Paramater paramater = (Paramater) JSONObject.toBean(jsonObject, Paramater.class);
//		KayaSQLExecute dao = new KayaSQLExecute();
//		dao.insert(paramater);

		String jsonParamater = "{Paramater:{" + "'id' : 'id-0065-00000003', " + "'crud':'POST'," + "'mapping':{"
				+ "'propertys':{'EmployeeId':'10000001','EmployeeName':'Tom','Password':'123'}" + "}" + "}}";

		JSONObject obj = JSONObject.fromObject(jsonParamater);
		JSONObject jsonObject = obj.getJSONObject("Paramater");

		Paramater paramater = (Paramater) JSONObject.toBean(jsonObject, Paramater.class);

		KayaSQLExecute dao = new KayaSQLExecute();
		dao.insert(paramater);

		System.out.println("inserted");
		///// 使用Kaya添加三个员工idEND<--

		String jsonParamater2 = "{Paramater:{" + "'id' : 'id-0065-00000003', " + "'text':''," + "'crud':'POST'" + "}}";
		System.out.println(jsonParamater2);
		JSONObject obj2 = JSONObject.fromObject(jsonParamater2);
		JSONObject jsonObject2 = obj2.getJSONObject("Paramater");

		Paramater paramater2 = (Paramater) JSONObject.toBean(jsonObject2, Paramater.class);

		KayaSQLExecute dao2 = new KayaSQLExecute();
		dao2.selectByFullText(paramater2);
		System.out.println(dao2.selectByFullText(paramater2));

		////////////////////////// Connect H2 DB End
//    	System.out.println("equals?="+Objects.equals(name1, loginInfoVo.getUsername()));

		if (bindingResult.hasErrors()) {
			String message = String.format("SpringBoot返回信息：登陆失败，详细信息[%s]。",
					bindingResult.getFieldError().getDefaultMessage());
			return ResultFactory.buildFailResult(message);
		}

		if (!Objects.equals("10000001", loginInfoVo.getUsername()) || !Objects.equals("", loginInfoVo.getPassword())) {
			String message = String.format("SpringBoot返回信息：登陆失败，详细信息[用户名、密码信息不正确]。");
			return ResultFactory.buildFailResult(message);
		}
		return ResultFactory.buildSuccessResult("SpringBoot返回信息：登陆成功。");
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/insert3", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result insert3(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
		/////使用Kaya添加三个员工id-->
		System.out.println("/api/insert3");

		String jsonParamater = "{Paramater:{'id':'id-0065-00000003','crud':'POST','mapping':{'propertys':{'EmployeeId':'10000001','EmployeeName':'Tom','ApprovalLevel':'1','Password':'1','GroupId':'0','DepartmentId':'0'}}}}";
		JSONObject obj = JSONObject.fromObject(jsonParamater);
		JSONObject jsonObject = obj.getJSONObject("Paramater");
		Paramater paramater = (Paramater) JSONObject.toBean(jsonObject, Paramater.class);
		KayaSQLExecute dao = new KayaSQLExecute();
		dao.insert(paramater);
		System.out.println("inserted0");
		
		String jsonParamater1 = "{Paramater:{'id':'id-0065-00000003','crud':'POST','mapping':{'propertys':{'EmployeeId':'20000002','EmployeeName':'Jack','ApprovalLevel':'2','Password':'2','GroupId':'0','DepartmentId':'0'}}}}";
		JSONObject obj1 = JSONObject.fromObject(jsonParamater1);
		JSONObject jsonObject1 = obj1.getJSONObject("Paramater");
		Paramater paramater1 = (Paramater) JSONObject.toBean(jsonObject1, Paramater.class);
		System.out.println(paramater1.getClass());
		KayaSQLExecute dao1 = new KayaSQLExecute();
		dao1.insert(paramater1);
		System.out.println("inserted1");
		
		String jsonParamater2 = "{Paramater:{'id':'id-0065-00000003','crud':'POST','mapping':{'propertys':{'EmployeeId':'30000001','EmployeeName':'Mark','ApprovalLevel':'3','Password':'3','GroupId':'0','DepartmentId':'0'}}}}";
		JSONObject obj2 = JSONObject.fromObject(jsonParamater2);
		JSONObject jsonObject2 = obj2.getJSONObject("Paramater");
		Paramater paramater2 = (Paramater) JSONObject.toBean(jsonObject2, Paramater.class);
		KayaSQLExecute dao2 = new KayaSQLExecute();
		dao2.insert(paramater2);
		System.out.println("inserted2");
		/////<--使用Kaya添加三个员工id END

		return ResultFactory.buildSuccessResult("SpringBoot返回信息：插入成功。");
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/insertcombo", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result insertcombo(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
		/////使用Kaya添加Combo表内容-->
		System.out.println("/api/insertcombo");
		
		//ExpenseType
		Paramater paramaterc1 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'ExpenseType','ComboName':'Expense Type','ItemId':'0','ItemName':'Internal'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc1 = new KayaSQLExecute();
		daoc1.insert(paramaterc1);
		
		Paramater paramaterc2 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'ExpenseType','ComboName':'Expense Type','ItemId':'1','ItemName':'External'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc2 = new KayaSQLExecute();
		daoc2.insert(paramaterc2);
		
		//RequestType
		Paramater paramaterc3 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'RequestType','ComboName':'RequestType','ItemId':'0','ItemName':'Expense Request'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc3 = new KayaSQLExecute();
		daoc3.insert(paramaterc3);
		
		Paramater paramaterc4 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'RequestType','ComboName':'RequestType','ItemId':'1','ItemName':'Travel Request'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc4 = new KayaSQLExecute();
		daoc4.insert(paramaterc4);
		
		//Currency
		Paramater paramaterc5 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'Currency','ComboName':'Currency','ItemId':'0','ItemName':'JPY'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc5 = new KayaSQLExecute();
		daoc5.insert(paramaterc5);
		
		Paramater paramaterc6 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'Currency','ComboName':'Currency','ItemId':'1','ItemName':'CNY'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc6 = new KayaSQLExecute();
		daoc6.insert(paramaterc6);
		
		Paramater paramaterc7 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'Currency','ComboName':'Currency','ItemId':'2','ItemName':'USD'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc7 = new KayaSQLExecute();
		daoc7.insert(paramaterc7);
		
		//ApprovalLevel
		Paramater paramaterc8 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'ApprovalLevel','ComboName':'ApprovalLevel','ItemId':'1','ItemName':'Requester'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc8 = new KayaSQLExecute();
		daoc8.insert(paramaterc8);
		
		Paramater paramaterc9 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'ApprovalLevel','ComboName':'ApprovalLevel','ItemId':'2','ItemName':'Receptionist'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc9 = new KayaSQLExecute();
		daoc9.insert(paramaterc9);
		
		Paramater paramaterc10 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'ApprovalLevel','ComboName':'ApprovalLevel','ItemId':'3','ItemName':'Authorizer'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc10 = new KayaSQLExecute();
		daoc10.insert(paramaterc10);
		
		//GroupId
		Paramater paramaterc11 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'GroupId','ComboName':'GroupId','ItemId':'0','ItemName':'GroupId0'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc11 = new KayaSQLExecute();
		daoc11.insert(paramaterc11);
		
		//DepartmentId
		Paramater paramaterc12 = (Paramater) JSONObject.toBean(JSONObject.fromObject("{Paramater:{'id':'id-0065-00000009','crud':'POST','mapping':{'propertys':{'ComboId':'DepartmentId','ComboName':'DepartmentId','ItemId':'0','ItemName':'DepartmentId0'}}}}").getJSONObject("Paramater"), Paramater.class);
		KayaSQLExecute daoc12 = new KayaSQLExecute();
		daoc12.insert(paramaterc12);
		
		System.out.println("insertedc");
		/////<--使用Kaya添加Combo表内容 END

		return ResultFactory.buildSuccessResult("SpringBoot返回信息：插入成功。");
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/login1", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result login1(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
		System.out.println("/api/login1");
		
		String employeeIdFromFrontend = loginInfoVo.getUsername();
		String employeeIdFromFrontendWithCaret = "^"+employeeIdFromFrontend+"^";
		System.out.println("employeeIdFromFrontendWithCaret"+employeeIdFromFrontendWithCaret);
		String orientationkey = "orientationkey";
		String Password = "Password";
		Map mapForCurrentId = null;


		/////使用Kaya检索员工id-->
		String jsonParamater2 = "{Paramater:{" + "'id' : 'id-0065-00000003', " + "'text':''," + "'crud':'POST'" + "}}";
		System.out.println(jsonParamater2);
		JSONObject obj2 = JSONObject.fromObject(jsonParamater2);
		JSONObject jsonObject2 = obj2.getJSONObject("Paramater");

		Paramater paramater2 = (Paramater) JSONObject.toBean(jsonObject2, Paramater.class);

		KayaSQLExecute dao2 = new KayaSQLExecute();
		System.out.println("------");
		dao2.selectByFullText(paramater2);
		System.out.println("------");
		System.out.println(dao2.selectByFullText(paramater2).getClass());
		
		List listFromKaya = dao2.selectByFullText(paramater2);
		for(int i=0;i<listFromKaya.size();i++){
		    System.out.println(listFromKaya.get(i));
		    Map mapFromList =  (Map) listFromKaya.get(i);
		    System.out.println(mapFromList.get(orientationkey));
		    if (mapFromList.get(orientationkey).equals(employeeIdFromFrontendWithCaret)) {
		    	System.out.println("==");
		    	mapForCurrentId = mapFromList;
		    }	    
		}
		/////使用Kaya检索员工id End<--
		
		//////判断密码对错-->
		if (bindingResult.hasErrors()) {
			String message = String.format("SpringBoot返回信息：登陆失败，详细信息[%s]。",
					bindingResult.getFieldError().getDefaultMessage());
			return ResultFactory.buildFailResult(message);
		}

		if ( mapForCurrentId == null || !mapForCurrentId.get(Password).equals(loginInfoVo.getPassword())) {
			if (mapForCurrentId == null) {
				System.out.println("mapForCurrentId == null");
			}else {
				System.out.println(mapForCurrentId.get(Password));
				System.out.println(loginInfoVo.getPassword());
			}
			String message = String.format("SpringBoot返回信息：登陆失败，详细信息[用户名、密码信息不正确]。");
			return ResultFactory.buildFailResult(message);
		}
		System.out.println("SpringBoot返回信息：登陆成功。");
		JSONObject jsonForCurrentId=JSONObject.fromObject(mapForCurrentId); 
		return ResultFactory.buildSuccessResult((Object)jsonForCurrentId);
		//////判断密码对错 End<--
	}
	
	@CrossOrigin
	@RequestMapping(value = "/api/expense2", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Result expense2(@Valid @RequestBody VueExpenseInfoVo expenseInfoVo, BindingResult bindingResult) {
		System.out.println("/api/expense2");
		
	    String username = expenseInfoVo.getUsername();
	    String password = expenseInfoVo.getPassword();
	    String requestNo = expenseInfoVo.getRequestNo();
//	    String requestType = expenseInfoVo.getRequestType();
	    String expenseType = expenseInfoVo.getExpenseType();
	    String requesterId = expenseInfoVo.getRequesterId();
	    String requestDate = expenseInfoVo.getRequestDate();
	    String fromDate = expenseInfoVo.getFromDate();
	    String endDate = expenseInfoVo.getEndDate();
	    String currency = expenseInfoVo.getCurrency();
	    String account = expenseInfoVo.getAccount();
	    String attachReceipt = expenseInfoVo.getAttachReceipt();
	    
	    

	    System.out.println(username);
	    System.out.println(password);
	    System.out.println(requestNo);
//	    System.out.println(requestType);
	    System.out.println(expenseType);
	    System.out.println(requesterId);
	    System.out.println(requestDate);
	    System.out.println(fromDate);
	    System.out.println(endDate);
	    System.out.println(currency);
	    System.out.println(account);
	    System.out.println(attachReceipt);
	    
	    String properties = "'RequestNo':'" + requestNo + "','ExpenseType':'" + expenseType + "','RequesterId':'" + requesterId + "','RequestDate':'" + requestDate + "','FromDate':'" + fromDate + "','EndDate':'" + endDate + "','Currency':'" + currency + "','Account':'" + account + "','AttachReceipt':'" + attachReceipt + "'";
	    System.out.println(properties);
	    
	    // 添加监听：表中有型数据插入的时候调用本流程。
        // 报销申请流程
        WorkFlowListener wfListener = new WorkFlowListener("id-0065-00000005"); // workflow id
        // 申请ActionID
        wfListener.setActionId("id-0066-0000000a");// ，按钮的id
        
        KayaSQLExecute dao = new KayaSQLExecute();
        dao.setWorkFlowListener(wfListener);
        
        String jsonParamater= "{Paramater:{"
                + "'id' : 'id-0065-0000000a', "
                + "'crud':'insert',"
                + "'mapping':{"
                + "'propertys':{"+ properties +"}"
                + "}"
                + "}}";

        JSONObject obj = JSONObject.fromObject(jsonParamater);
        JSONObject jsonObject = obj.getJSONObject("Paramater");
        Paramater paramater=(Paramater)JSONObject.toBean(jsonObject, Paramater.class);

        dao.insert(paramater);


		return ResultFactory.buildSuccessResult("expense2");
		//////判断密码对错 End<--
	}
}
