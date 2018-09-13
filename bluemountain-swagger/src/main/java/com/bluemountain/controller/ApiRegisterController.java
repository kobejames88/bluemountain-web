package controller;



import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import form.RegisterForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册接口
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);
      
        return  userService.register(form) ;
    }
    
    @ApiOperation("注册")
    @PostMapping("register2")
    public R test( RegisterForm form){
       	
        ValidatorUtils.validateEntity(form);

        return  userService.register(form) ;

     }
    
    
}
