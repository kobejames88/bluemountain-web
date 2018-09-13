package com.bluemountain.modules.adverts.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.adverts.entity.AdvertsDetailEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsDetailView;
import com.bluemountain.modules.adverts.service.AdvertsDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 广告位详情
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:19
 */
@RestController
@RequestMapping("adverts/advertsdetail")
public class AdvertsDetailController {
    @Autowired
    private AdvertsDetailService advertsDetailService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("adverts:advertsdetail:list")
    public R page(@RequestParam Map<String, Object> params,AdvertsDetailEntity advertsDetail){
 
        EntityWrapper<AdvertsDetailEntity> ew = new EntityWrapper< AdvertsDetailEntity>();
      	ew.allEq(MPUtil.allEQMapPre( advertsDetail, "advertsDetail"));
    	PageUtils page = advertsDetailService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("adverts:advertsdetail:list")
    public R list( AdvertsDetailEntity advertsDetail){
       	EntityWrapper<  AdvertsDetailEntity> ew = new EntityWrapper<  AdvertsDetailEntity>();
      	ew.allEq(MPUtil.allEQMapPre( advertsDetail, "advertsDetail")); 
        return R.ok().put("data",  advertsDetailService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("adverts:advertsdetail:info")
    public R query(AdvertsDetailEntity advertsDetail){
        EntityWrapper< AdvertsDetailEntity> ew = new EntityWrapper< AdvertsDetailEntity>();
 		ew.allEq(MPUtil.allEQMapPre( advertsDetail, "advertsDetail")); 
		AdvertsDetailView advertsDetailView =  advertsDetailService.selectView(ew);
		return R.ok("查询广告位详情成功").put("data",  advertsDetailView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{advertsDetailId}")
    @RequiresPermissions("adverts:advertsdetail:info")
    public R info(@PathVariable("advertsDetailId") Long advertsDetailId){
        AdvertsDetailEntity advertsDetail = advertsDetailService.selectById(advertsDetailId);

        return R.ok().put("advertsDetail", advertsDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adverts:advertsdetail:save")
    public R save(@RequestBody AdvertsDetailEntity advertsDetail){
    	ValidatorUtils.validateEntity(advertsDetail);
        advertsDetailService.insert(advertsDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adverts:advertsdetail:update")
    public R update(@RequestBody AdvertsDetailEntity advertsDetail){
        ValidatorUtils.validateEntity(advertsDetail);
        advertsDetailService.updateAllColumnById(advertsDetail);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adverts:advertsdetail:delete")
    public R delete(@RequestBody Long[] advertsDetailIds){
        advertsDetailService.deleteBatchIds(Arrays.asList(advertsDetailIds));

        return R.ok();
    }

}
