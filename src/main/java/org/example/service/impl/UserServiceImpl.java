package org.example.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.example.utils.JwtHelper;
import org.example.utils.MD5Util;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author ASUS
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-06-29 21:45:00
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public Result login(User user) {

        //根据账号查询数据库
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User user1 = userMapper.selectOne(lambdaQueryWrapper);

        if(user1 == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        //对比密码
        if(!StringUtils.isEmpty(user.getUserPwd()) &&
                MD5Util.encrypt(user.getUserPwd()).equals(user1.getUserPwd())) {
            //登录成功
            //根据id生成token
            String token = jwtHelper.createToken(Long.valueOf(user1.getUid()));
            Map data = new HashMap();
            data.put("token", token);
            return Result.ok(data);


        }

        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }
}




