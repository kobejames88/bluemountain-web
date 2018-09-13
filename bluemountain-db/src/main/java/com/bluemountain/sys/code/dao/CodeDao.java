package com.bluemountain.sys.code.dao;


import com.bluemountain.sys.code.entity.ColumnInfo;
import com.bluemountain.sys.code.entity.TableInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeDao  {
	public List<String> findTableList();
	public String getDataBaseName();
	public TableInfo getTableInfoByName(@Param("tableName") String tableName, @Param("dbName") String dbName);
	public List<ColumnInfo> findColumnsByTable(@Param("tableName") String tableName, @Param("dbName") String dbName);
}
