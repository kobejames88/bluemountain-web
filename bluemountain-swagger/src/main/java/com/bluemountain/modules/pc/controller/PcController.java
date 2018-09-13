package modules.pc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import modules.pc.entity.PcEntity;
import modules.pc.entity.model.PcModel;
import modules.pc.entity.vo.PcVO;
import modules.pc.service.PcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
@RestController
@RequestMapping("pc")
@Api(tags="接口")
public class PcController {
    @Autowired
    private PcService pcService;
 
	 /**
     * 列表
     */
    @RequestMapping("/page")
    @ApiOperation("分页查询")
    public R page(@RequestParam Map<String, Object> params, PcModel pcModel){
 
        EntityWrapper< PcEntity> ew = new EntityWrapper<PcEntity>();
        PcEntity pc = new  PcEntity( pcModel);
     	ew.allEq(MPUtil.allEQMapPre( pc, "pc"));
    	PageUtils page = pcService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询")
    public R list(PcModel pcModel){
		ValidatorUtils.validateEntity(pcModel);
        EntityWrapper< PcEntity> ew = new EntityWrapper< PcEntity>();
		PcEntity pc = new  PcEntity( pcModel);
     	ew.allEq(MPUtil.allEQMapPre( pc, "pc")); 
		List<PcVO>  pcVOList =  pcService.selectListVO(ew);
		return R.ok("查询成功").put("data", pcVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询")
    public R Model(PcModel pcModel){
		ValidatorUtils.validateEntity(pcModel);
        EntityWrapper< PcEntity> ew = new EntityWrapper< PcEntity>();
		PcEntity pc = new  PcEntity( pcModel);
		ew.allEq(MPUtil.allEQMapPre( pc, "pc")); 
		PcVO pcVO =  pcService.selectVO(ew);
		return R.ok("查询成功").put("data",  pcVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{pcId}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("pcId") Long pcId){
        PcEntity pc = pcService.selectById(pcId);

        return R.ok().put("pc", pc);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody PcEntity pc){
    	ValidatorUtils.validateEntity(pc);
        pcService.insert(pc);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(PcEntity pc){
    	ValidatorUtils.validateEntity(pc);
        pcService.insert(pc);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody PcEntity pc){
        ValidatorUtils.validateEntity(pc);
        pcService.updateAllColumnById(pc);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(PcEntity pc){
        ValidatorUtils.validateEntity(pc);
        pcService.updateAllColumnById(pc);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Long[] pcIds){
        pcService.deleteBatchIds(Arrays.asList(pcIds));
        return R.ok();
    }

}
