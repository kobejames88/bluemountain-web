package modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import com.bluemountain.common.utils.PageUtils;
import modules.pc.entity.StudentEntity;
import modules.pc.entity.view.StudentView;
import modules.pc.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StudentVO> selectListVO(Wrapper<StudentEntity> wrapper);
   	
   	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	List<StudentView> selectListView(Wrapper<StudentEntity> wrapper);
   	
   	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper);
}

