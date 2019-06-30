package com.itheima.controller;

import com.itheima.domain.Customer;
import com.itheima.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Mr_Zhao
 * @Description:
 * @Date: Create in  2019/6/17 10:51
 */
@Controller
@RequestMapping("/cust")
public class CustController {

    @Autowired
    private CustService custService;
    @RequestMapping("/list")
    public String list(Customer customer,Model model) {
        List<Customer> list = custService.findAll(customer);
        model.addAttribute("customers",list);
        return "center";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Integer save(Customer customer) {

        return custService.save(customer);
    }

    @RequestMapping("/del")
    public String delete(Integer cid) {
        custService.delete(cid);
        return "redirect:/cust/list";
    }
}
