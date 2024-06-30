package org.example.controller;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import org.example.service.HeadlineService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("headline")
@CrossOrigin
public class HeadlineController {


    @Autowired
    private HeadlineService headlineService;

//    headline/publish
    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token) {
        Result result = headlineService.publish(headline, token);
        return result;

    }


    /**
     * headline/findHeadlineByHid
     * 头条回显
     */
    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(@Param("hid") Integer hid) {
        Result result = headlineService.findHeadlineByHid(hid);
        return result;
        
    }

//    headline/update
//    修改头条的信息
    @PostMapping("update")
    public Result myUpdate(@RequestBody Headline headline) {
        Result result = headlineService.myUpdate(headline);
        return result;
    }

//    removeByHid

    @PostMapping("removeByHid")
    public  Result removeByHid( Integer hid) {
        Result result = headlineService.removeByHid(hid);
        return  result;
    }

}
