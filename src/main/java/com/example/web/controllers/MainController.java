package com.example.web.controllers;

import com.example.web.Services.MainService;
import com.example.web.entities.BusinessEntity;
import com.example.web.vos.LoginVo;
import com.example.web.vos.UserTableVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "main")
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }


    @GetMapping(value="/add")
    public ModelAndView getAdd(ModelAndView modelAndView){
        modelAndView.setViewName("/main/add");
        return modelAndView;
    }
    @PostMapping(value = "/add")
    public ModelAndView postList(ModelAndView modelAndView,
                                 BusinessEntity businessEntity,
                                 HttpServletRequest request,
                                 HttpSession session){
        session = request.getSession();
        LoginVo loginVo = (LoginVo) session.getAttribute("loginVo1");
        businessEntity.setUserId(loginVo.getIndex());
        this.mainService.insertBusiness(businessEntity);
        modelAndView.setViewName("redirect:/main/index");
        return modelAndView;
    }
    @GetMapping(value="index")
    public ModelAndView getIndex(ModelAndView modelAndView,
                                 HttpServletRequest request,
                                 HttpSession session){
        session =request.getSession();
        LoginVo loginVo=(LoginVo) session.getAttribute("loginVo1");
        BusinessEntity[] businessEntities = this.mainService.businesscard(loginVo.getIndex());
        modelAndView.addObject("businessEntities",businessEntities);
        modelAndView.setViewName("/main/index");
        return getPage(1,modelAndView);
    }

    @GetMapping(value = "/delete")
    public ModelAndView getDelete(ModelAndView modelAndView,
                                  int index){
        this.mainService.deleteUser(index);
        modelAndView.setViewName("redirect:/main/index");
        return modelAndView;
    }
    @GetMapping(value = "/updatecard")
    public ModelAndView getUpdate(ModelAndView modelAndView,
                                  int index,
                                  BusinessEntity businessEntity){
        businessEntity=this.mainService.updateCard(index);
        modelAndView.addObject("businessentity",businessEntity);
        modelAndView.setViewName("/main/modify");
        return modelAndView;
    }
    @PostMapping(value="/takeCard")
    public ModelAndView postTake(ModelAndView modelAndView,
                                 BusinessEntity businessEntity){
        this.mainService.takeCard(businessEntity);
        modelAndView.setViewName("redirect:/main/index");
        return modelAndView;
    }
    @GetMapping(value = "find")
    public ModelAndView getFind(ModelAndView modelAndView,
                                String findSelect,
                                String find){
        return getFind(modelAndView, findSelect , find , 1);
    }
    @GetMapping(value = "/find/{page}")
    public ModelAndView getFind(ModelAndView modelAndView,
                                String findSelect,
                                String find,
                                @PathVariable(name = "page")int page){
        UserTableVo userTableVo = this.mainService.showTable(findSelect, find ,page);
        userTableVo.setFindSelect(findSelect);
        userTableVo.setFind(find);
        modelAndView.addObject("businessEntities", userTableVo.getBusinessEntities());
        modelAndView.addObject("id","find");
        modelAndView.setViewName("/main/index");
        return modelAndView;
    }
    @GetMapping(value = "index/{page}")
    public ModelAndView getPage(@PathVariable(name = "page")int page,
                                ModelAndView modelAndView) {
        UserTableVo userTableVo = this.mainService.getUser(page);
        System.out.println(userTableVo.getMaxPage());
        modelAndView.addObject("businessEntities",userTableVo.getBusinessEntities());
        modelAndView.addObject("id","find2");
        modelAndView.setViewName("/main/index");
        return modelAndView;
    }
}
