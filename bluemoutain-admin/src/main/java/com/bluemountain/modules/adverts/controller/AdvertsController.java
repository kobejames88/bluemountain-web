package com.bluemountain.modules.adverts.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.adverts.entity.AdvertsDetailEntity;
import com.bluemountain.modules.adverts.entity.AdvertsEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsView;
import com.bluemountain.modules.adverts.service.AdvertsDetailService;
import com.bluemountain.modules.adverts.service.AdvertsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 广告位表
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:18
 */
@RestController
@RequestMapping("adverts/adverts")
public class AdvertsController {
    @Autowired
    private AdvertsService advertsService;

    @Autowired
    private AdvertsDetailService advertsDetailService;
    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("adverts:adverts:list")
    public R page(@RequestParam Map<String, Object> params, AdvertsEntity adverts){
 
        EntityWrapper< AdvertsEntity> ew = new EntityWrapper< AdvertsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( adverts, "adverts"));
    	PageUtils page = advertsService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("adverts:adverts:list")
    public R list( AdvertsEntity adverts){
       	EntityWrapper<  AdvertsEntity> ew = new EntityWrapper<  AdvertsEntity>();
      	ew.allEq(MPUtil.allEQMapPre( adverts, "adverts")); 
        return R.ok().put("data",  advertsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("adverts:adverts:info")
    public R query(AdvertsEntity adverts){
        EntityWrapper< AdvertsEntity> ew = new EntityWrapper< AdvertsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( adverts, "adverts")); 
		AdvertsView advertsView =  advertsService.selectView(ew);
		return R.ok("查询广告位表成功").put("data",  advertsView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{advertsId}")
    @RequiresPermissions("adverts:adverts:info")
    public R info(@PathVariable("advertsId") Long advertsId){
        AdvertsEntity adverts = advertsService.selectById(advertsId);

        return R.ok().put("adverts", adverts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adverts:adverts:save")
    public R save(@RequestBody AdvertsEntity adverts){
    	ValidatorUtils.validateEntity(adverts);
        advertsService.insert(adverts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adverts:adverts:update")
    public R update(@RequestBody AdvertsEntity adverts){
        ValidatorUtils.validateEntity(adverts);
        advertsService.updateAllColumnById(adverts);//全部更新
        AdvertsDetailEntity advertsDetailEntity = new AdvertsDetailEntity();
        EntityWrapper< AdvertsDetailEntity> ew = new EntityWrapper< AdvertsDetailEntity>();
        advertsDetailEntity.setName(adverts.getName());
        ew.eq("adverts_id", adverts.getAdvertsId());
        advertsDetailService.update(advertsDetailEntity, ew);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adverts:adverts:delete")
    public R delete(@RequestBody Long[] advertsIds){
        advertsService.deleteBatchIds(Arrays.asList(advertsIds));

        return R.ok();
    }

}
