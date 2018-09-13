package com.bluemountain.service;

import com.bluemountain.dao.SysGeneratorDao;
import com.bluemountain.entity.ColumnEntity;
import com.bluemountain.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
* @author  作者  michaelou
* @date 创建时间：2018年7月9日 上午10:30:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
* 
* 获取oracle数据库信息
*/
 

@Service("oracleDataBaseService")
public class OracleDataBaseService extends DataBaseInfo {
	 
	@Autowired
	private SysGeneratorDao sysGeneratorDao;

	@Value("${spring.datasource.username}")
	private String databaseName;
	

	@Override
	public String queryDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	}

	@Override
	public List<TableEntity> getTableList() {
		List<TableEntity> tables = sysGeneratorDao.queryOracleTableList(null);
		 
		 
		tables.stream().forEach((tableInfo) -> {
			List<ColumnEntity> columns = sysGeneratorDao.selectAllOracleColumns(tableInfo.getTableName());
			tableInfo.setColumns(columns);
		});
		return tables;
	}
	 
}
