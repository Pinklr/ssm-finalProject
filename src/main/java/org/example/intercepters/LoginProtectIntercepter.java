package org.example.intercepters;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utils.JwtHelper;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginProtectIntercepter implements HandlerInterceptor {


    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token  = request.getHeader("token");
        if(StringUtils.isEmpty(token) || jwtHelper.isExpiration(token)) {
            Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            response.getWriter().print(json);
//            拦截、
            return false;
        }

        return true;

    }
}
