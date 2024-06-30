package org.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.example.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.vo.PortalVo;

import java.util.Map;

/**
* @author ASUS
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-06-29 21:45:00
* @Entity org.example.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {

    IPage<Map> selectMyPage(IPage page, @Param("portalVo")PortalVo portalVo);

    Map selectDetailMap(Integer hid);
}




