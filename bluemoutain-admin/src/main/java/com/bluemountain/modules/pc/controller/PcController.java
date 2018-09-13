package com.bluemountain.modules.pc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.pc.entity.PcEntity;
import com.bluemountain.modules.pc.entity.view.PcView;
import com.bluemountain.modules.pc.service.PcService;
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
 * @date 2018-06-20 15:47:02
 */
@RestController
@RequestMapping("pc/pc")
public class PcController {
    @Autowired
    private PcService pcService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("pc:pc:list")
    public R page(@RequestParam Map<String, Object> params, PcEntity pc){
 
        EntityWrapper< PcEntity> ew = new EntityWrapper< PcEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pc, "pc"));
    	PageUtils page = pcService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pc:pc:list")
    public R list( PcEntity pc){
       	EntityWrapper<  PcEntity> ew = new EntityWrapper<  PcEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pc, "pc")); 
        return R.ok().put("data",  pcService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("pc:pc:info")
    public R query(PcEntity pc){
        EntityWrapper< PcEntity> ew = new EntityWrapper< PcEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pc, "pc")); 
		PcView pcView =  pcService.selectView(ew);
		return R.ok("查询成功").put("data",  pcView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{pcId}")
    @RequiresPermissions("pc:pc:info")
    public R info(@PathVariable("pcId") Long pcId){
        PcEntity pc = pcService.selectById(pcId);

        return R.ok().put("pc", pc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pc:pc:save")
    public R save(@RequestBody PcEntity pc){
    	ValidatorUtils.validateEntity(pc);
        pcService.insert(pc);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pc:pc:update")
    public R update(@RequestBody PcEntity pc){
        ValidatorUtils.validateEntity(pc);
        pcService.updateAllColumnById(pc);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pc:pc:delete")
    public R delete(@RequestBody Long[] pcIds){
        pcService.deleteBatchIds(Arrays.asList(pcIds));

        return R.ok();
    }

}
