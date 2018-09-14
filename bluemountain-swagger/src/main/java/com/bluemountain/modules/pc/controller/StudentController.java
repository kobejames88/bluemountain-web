package com.bluemountain.modules.pc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.common.validator.ValidatorUtils;
import com.bluemountain.modules.pc.entity.StudentEntity;
import com.bluemountain.modules.pc.entity.model.StudentModel;
import com.bluemountain.modules.pc.entity.vo.StudentVO;
import com.bluemountain.modules.pc.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("student")
@Api(tags="接口")
public class StudentController {
    @Autowired
    private StudentService studentService;
 
	 /**
     * 列表
     */
    @RequestMapping("/page")
    @ApiOperation("分页查询")
    public R page(@RequestParam Map<String, Object> params, StudentModel studentModel){
 
        EntityWrapper<StudentEntity> ew = new EntityWrapper< StudentEntity>();
        StudentEntity student = new  StudentEntity( studentModel);
     	ew.allEq(MPUtil.allEQMapPre( student, "student"));
    	PageUtils page = studentService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询")
    public R list(StudentModel studentModel){
		ValidatorUtils.validateEntity(studentModel);
        EntityWrapper< StudentEntity> ew = new EntityWrapper< StudentEntity>();
		StudentEntity student = new  StudentEntity( studentModel);
     	ew.allEq(MPUtil.allEQMapPre( student, "student")); 
		List<StudentVO>  studentVOList =  studentService.selectListVO(ew);
		return R.ok("查询成功").put("data", studentVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询")
    public R Model(StudentModel studentModel){
		ValidatorUtils.validateEntity(studentModel);
        EntityWrapper< StudentEntity> ew = new EntityWrapper< StudentEntity>();
		StudentEntity student = new  StudentEntity( studentModel);
		ew.allEq(MPUtil.allEQMapPre( student, "student")); 
		StudentVO  studentVO =  studentService.selectVO(ew);
		return R.ok("查询成功").put("data",  studentVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{studentId}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("studentId") Long studentId){
        StudentEntity student = studentService.selectById(studentId);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody StudentEntity student){
    	ValidatorUtils.validateEntity(student);
        studentService.insert(student);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(StudentEntity student){
    	ValidatorUtils.validateEntity(student);
        studentService.insert(student);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody StudentEntity student){
        ValidatorUtils.validateEntity(student);
        studentService.updateAllColumnById(student);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(StudentEntity student){
        ValidatorUtils.validateEntity(student);
        studentService.updateAllColumnById(student);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Long[] studentIds){
        studentService.deleteBatchIds(Arrays.asList(studentIds));
        return R.ok();
    }

}
