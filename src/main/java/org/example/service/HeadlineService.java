package org.example.service;

import org.example.mapper.HeadlineMapper;
import org.example.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.vo.PortalVo;
import org.example.utils.Result;

/**
* @author ASUS
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-06-29 21:45:00
*/
public interface HeadlineService extends IService<Headline> {


    Result findNewPage(PortalVo portalVo);

    Result showHeadlineDetail(Integer hid);
}
