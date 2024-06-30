package org.example.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.Headline;
import org.example.pojo.vo.PortalVo;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author ASUS
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-06-29 21:45:00
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;

    @Autowired
    private JwtHelper jwtHelper;


    @Override
    public Result findNewPage(PortalVo portalVo) {

        IPage<Map> page = new Page<>(portalVo.getPageNum(), portalVo.getPageSize());
        headlineMapper.selectMyPage(page, portalVo);

        List<Map> records = page.getRecords();
        Map data = new HashMap();
        data.put("pageData", records);
        data.put("pageNum", page.getCurrent());
        data.put("pageSize", page.getSize());
        data.put("totalPage", page.getPages());
        data.put("totalSize", page.getTotal());

        Map pageInfo = new HashMap();
        pageInfo.put("pageInfo", data);

        return Result.ok(pageInfo);

    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map headline = headlineMapper.selectDetailMap(hid);
        Map data = new HashMap();
        data.put("headline", headline);

        // 阅读量加一
        Headline headline1 = new Headline();
        headline1.setHid(hid);
        headline1.setVersion((Integer) headline.get("version"));
        headline1.setPageViews((Integer) headline.get("pageViews") + 1);
        headlineMapper.updateById(headline1);

        return Result.ok(data);
    }

    @Override
    public Result publish(Headline headline, String token) {

//        判断是否登录的功能在拦截器中进行实现

        int id = jwtHelper.getUserId(token).intValue();
        headline.setPublisher(id);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());
        headline.setPageViews(0);
        headlineMapper.insert(headline);
        return Result.ok(null);


    }

    @Override
    public Result findHeadlineByHid(Integer hid) {
        Headline headline = headlineMapper.selectById(hid);
        Map data = new HashMap();
        data.put("headline", headline);
        return  Result.ok(data);
    }

    @Override
    public Result myUpdate(Headline headline) {
        Integer version = headlineMapper.selectById(headline.getHid()).getVersion();
        headline.setUpdateTime(new Date());
        headline.setVersion(version);
        headlineMapper.updateById(headline);
        return Result.ok(null);
    }

    @Override
    public Result removeByHid(Integer hid) {
        headlineMapper.deleteById(hid);

        return Result.ok(null);
    }
}




