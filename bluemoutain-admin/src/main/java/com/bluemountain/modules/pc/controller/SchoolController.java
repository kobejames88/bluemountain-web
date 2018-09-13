package com.bluemountain.modules.pc.controller;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.pc.entity.SchoolEntity;
import com.bluemountain.modules.pc.service.SchoolService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
@RestController
@RequestMapping("pc/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pc:school:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = schoolService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schoolId}")
    @RequiresPermissions("pc:school:info")
    public R info(@PathVariable("schoolId") Long schoolId){
        SchoolEntity school = schoolService.selectById(schoolId);

        return R.ok().put("school", school);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pc:school:save")
    public R save(@RequestBody SchoolEntity school){
    	ValidatorUtils.validateEntity(school);
        schoolService.insert(school);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pc:school:update")
    public R update(@RequestBody SchoolEntity school){
        ValidatorUtils.validateEntity(school);
        schoolService.updateAllColumnById(school);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pc:school:delete")
    public R delete(@RequestBody Long[] schoolIds){
        schoolService.deleteBatchIds(Arrays.asList(schoolIds));

        return R.ok();
    }

}
