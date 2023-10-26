package com.exampro.controller.user;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.UserMapper;
import com.exampro.model.User;
import com.exampro.utils.jwt.JwtTokenUtil;
import com.exampro.utils.passwd.PassHandler;
import com.exampro.utils.passwd.PassInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {
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
    /**
     * 查询所有用户
     */
    @GetMapping("/allUser")
    @ApiOperation("查询所有用户")
    public List findAllUsers(){
        return userMapper.findAllUsers();
    }

    /**
     * 查询数据库检查用户是否存在
     * @param username
     * @return
     */
    @PostMapping(value="/checkIfUserExist",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("查询数据库检查用户是否存在")
    public ResponseEntity<ApiRest<Boolean>> checkUserExists(@RequestParam("username") String username){
        // 查询数据库检查用户是否存在
        User user = userMapper.findByUsername(username);
        System.out.println(user);
        ApiResponse<Boolean> response = new ApiResponse<>();
        if (user != null) {
            // 用户存在
            return ResponseEntity.ok(response.success("用户存在", true));
        } else {
            // 用户不存在
            return ResponseEntity.ok(response.failure("用户不存在", false));
        }
    }


    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("登录接口")
    public ResponseEntity<?> login(@RequestParam("username") String username,@RequestParam("password") String password) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 判断用户是否存在
        User user = userMapper.findByUsername(username);
        // 如果用户不存在
        if(user == null){
            return ResponseEntity.ok(response.failure("用户不存在，登录失败！！!", false));
        }
        System.out.println(user.getPassword());
        // 判断用户的密码是否相同
        if(!passHandler.checkPass(password,"exampro^0^",user.getPassword())){
            return ResponseEntity.ok(response.failure("密码不正确！登陆失败！", false));
        }
        // 生成Token并返回给客户端
        String token = jwtTokenUtil.buildToken(user.getUserid(),username,user.getRoleid());
        HashMap data = new HashMap();
        data.put("token",token);
        data.put("username",username);
        data.put("userid",user.getUserid());
        return ResponseEntity.ok(response.success("登录成功！", data));
    }

    @PostMapping(value = "/reguser",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("注册用户")
    public ResponseEntity<?> regUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password,@RequestParam("roleid") String roleid) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 判断用户是否存在
        User user = userMapper.findByUsername(username);
        // 判断用户名是否被占用
        if (user != null) {
            return ResponseEntity.ok(response.failure("用户名已经被占用,请重新输入一个新的用户名!", false));
        }

        try {
            // 加密密码
            PassInfo info = passHandler.buildPassword(password);
            // 创建一个新的User对象，使用提供的用户名、密码和角色
            User newUser = new User(username, info.getPassword(), Integer.parseInt(roleid));
            // 将新用户插入数据库
            userMapper.insertNewUser(newUser);
            newUser = userMapper.findByUsername(username);
            // 生成Token并返回给客户端
            String token = jwtTokenUtil.buildToken(newUser.getUserid(),username,newUser.getRoleid());
            HashMap data = new HashMap();
            data.put("token",token);
            data.put("username",username);
            data.put("userid",newUser.getUserid());
            return ResponseEntity.ok(response.success("注册用户成功！", data));
        } catch (Exception e) {
            // 如果在插入用户时出现异常，捕获异常并返回带有适当错误消息的错误响应
            return ResponseEntity.ok(response.failure("注册用户失败！" + e.getMessage(), false));
        }
    }
}
