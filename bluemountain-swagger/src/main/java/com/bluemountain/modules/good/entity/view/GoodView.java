package modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-12 14:52:34
 */
@TableName("cn_good")
@ApiModel(value = "Good")
public class GoodView  extends GoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodView(){
	}
 
 	public GoodView(GoodEntity goodEntity){
 	try {
			BeanUtils.copyProperties(this, goodEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
