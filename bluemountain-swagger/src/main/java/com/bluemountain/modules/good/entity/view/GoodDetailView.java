package modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodDetailEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 商品描述表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_detail")
@ApiModel(value = "GoodDetail")
public class GoodDetailView  extends GoodDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodDetailView(){
	}
 
 	public GoodDetailView(GoodDetailEntity goodDetailEntity){
 	try {
			BeanUtils.copyProperties(this, goodDetailEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
