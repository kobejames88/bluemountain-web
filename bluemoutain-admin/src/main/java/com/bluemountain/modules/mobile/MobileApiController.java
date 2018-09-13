package com.bluemountain.modules.mobile;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.sys.entity.MobileEntity;
import com.bluemountain.modules.sys.service.MobileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-04-23 13:57:13
 */
@RestController
@RequestMapping("/mobile")
public class MobileApiController {
    @Autowired
    private MobileService mobileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:mobile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mobileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:mobile:info")
    public R info(@PathVariable("id") Long id){
        MobileEntity mobile = mobileService.selectById(id);
         return R.ok().put("mobile", mobile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
  /*  @RequiresPermissions("sys:mobile:save")*/
    public R save(@RequestBody MobileEntity mobile){
    	  ValidatorUtils.validateEntity(mobile);
    	mobileService.insert(mobile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:mobile:update")
    public R update(@RequestBody MobileEntity mobile){
        ValidatorUtils.validateEntity(mobile);
        mobileService.updateAllColumnById(mobile);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:mobile:delete")
    public R delete(@RequestBody Long[] ids){
        mobileService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
