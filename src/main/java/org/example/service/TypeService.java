package org.example.service;

import org.example.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author ASUS
* @description 针对表【news_type】的数据库操作Service
* @createDate 2024-06-29 21:45:00
*/
public interface TypeService extends IService<Type> {

    Result findAllTypes();
}
