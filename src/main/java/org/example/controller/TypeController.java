package org.example.controller;


import org.apache.ibatis.annotations.Param;
import org.example.pojo.vo.PortalVo;
import org.example.service.HeadlineService;
import org.example.service.TypeService;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("portal")
@CrossOrigin
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;

//    portal/findAllTypes
    @GetMapping("findAllTypes")
    public Result findAllTypes() {
        Result result =  typeService.findAllTypes();
        return  result;
    }

    @PostMapping("findNewsPage")
    public Result findNewPage(@RequestBody PortalVo portalVo) {
        Result result = headlineService.findNewPage(portalVo);
        return result;

    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(@Param("hid") Integer hid) {

        Result result = headlineService.showHeadlineDetail(hid);
        return result;
    }



}
