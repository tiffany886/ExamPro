package com.exampro.controller.user;

import com.exampro.constants.ApiResponse;
import com.exampro.mapper.UserMapper;
import com.exampro.model.User;
import com.exampro.utils.jwt.JwtTokenUtil;
import com.exampro.utils.passwd.PassHandler;
import com.exampro.utils.passwd.PassInfo;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/modifyUserInfo")
@Api(tags = "修改用户信息相关接口")
public class UserInfoController {

    /**
     * 注入 UserMapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 注入 JwtTokenUtil
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 注入passHandler
     */
    @Autowired
    private PassHandler passHandler;

    @PostMapping("/modifyUsername")
    @ApiOperation("修改用户名")
    public ResponseEntity<?> modifyUsername(@RequestHeader("Authorization") String token,@RequestParam("username") String username) {
        ApiResponse<Boolean> response = new ApiResponse<>();

        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getId());

        try {
            // 更新用户名
            Integer affectedRows = userMapper.updateUsernameByUserId(username,userId);
            if(affectedRows != 1){
                return ResponseEntity.ok("修改用户名失败");
            }
            HashMap data = new HashMap();
            data.put("username",username);
            return ResponseEntity.ok(response.success("修改用户名成功！！", data));
        } catch (Exception e) {
            // 如果在插入用户时出现异常，捕获异常并返回带有适当错误消息的错误响应
            return ResponseEntity.ok(response.failure("修改用户名失败！" + e.getMessage(), false));
        }

    }

    @PostMapping("/checkPassword")
    @ApiOperation("检测原始密码是否正确")
    public ResponseEntity<?> checkPassword(@RequestHeader("Authorization") String token,@RequestParam("password") String password) {
        ApiResponse<Boolean> response = new ApiResponse<>();

        // 解析token获取旧密码
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getId());
        User userInfo = userMapper.findByUserID(userId);

        if(!passHandler.checkPass(password,"exampro^0^",userInfo.getPassword())){
            return ResponseEntity.ok(response.success("原始密码输入错误！！", false));
        }

        return ResponseEntity.ok(response.success("原始密码输入正确！！", true));
    }

    @PostMapping("/modifyPassword")
    @ApiOperation("修改用户密码")
    public ResponseEntity<?> modifyPassword(@RequestHeader("Authorization") String token,@RequestParam("password") String password) {
        ApiResponse<Boolean> response = new ApiResponse<>();

        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userId = Integer.valueOf(claims.getId());

        try {
            // 加密密码
            PassInfo info = passHandler.buildPassword(password);
            // 更新用户密码
            Integer affectedRows = userMapper.updateUserPwdByUserId(info.getPassword(),userId);
            if(affectedRows != 1){
                return ResponseEntity.ok("修改密码失败");
            }
            return ResponseEntity.ok(response.success("更新密码成功",true));
        } catch (Exception e) {
            // 如果在插入用户时出现异常，捕获异常并返回带有适当错误消息的错误响应
            return ResponseEntity.ok(response.failure("更新密码失败！" + e.getMessage(), false));
        }
    }
}

