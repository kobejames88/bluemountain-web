package com.bluemoutain.service;


import com.bluemoutain.dao.CommonDao;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.entity.EntitySupport;
import com.bluemoutain.exception.DataAccessException;
import com.bluemoutain.utils.StringUtils;
import com.bluemoutain.web.support.Pagination;
import com.bluemoutain.web.support.XJJParameter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class XjjServiceSupport<E extends EntitySupport> implements XjjService<E> {
	
	@Autowired
	private CommonDao commonDao;
	
	public XjjServiceSupport(){	}

	public abstract XjjDAO<E> getDao();

	public Long save(E obj) {
		getDao().save(obj);
		Long id = obj.getId();
		return id;
	}
	
	public void update(E obj) {
		getDao().update(obj);
	}

	public E getById(Long id) {
		return (E)getDao().getById(id);
	}

	
	public void delete(Long id) {
		getDao().delete(id);
	}
	
	public void delete(E obj) {
		if(null!=obj && null!=obj.getId())
		{
			delete(obj.getId());
		}
	}
	
	public void deleteByProperty(String property,Object val)
	{
		property = StringUtils.toUnderScoreCase(property);
		getDao().deleteByColumn(property,val);
	}
	
	
	public int getCount(XJJParameter query) {
		return getDao().getCount(query.getQueryMap());
	}
	
	public List<E> findAll() {
		return getDao().findAll();
	}

	public List<E> findList(XJJParameter query) {
		
		System.out.println("===query.getQueryMap()=="+query.getQueryMap());
		return getDao().findList(query.getQueryMap());
	}
	
	public List<E> findListLimit(XJJParameter query,int offset,int limit) {
		//return getDao().findListLimit(null==query?null:query.getQueryMap(),offset,limit);
		
		return getDao().findPage(null==query?null:query.getQueryMap(),offset,limit);
	}

	public Pagination findPage(XJJParameter query, Pagination page) {
		int totalRecord = getDao().getCount(query.getQueryMap());
		page.setTotalRecord(totalRecord);
			
		int limit  = page.getPageSize();
		int currentPage = page.getCurrentPage();
		int offset = (currentPage-1)*limit;
		page.setItems(getDao().findPage(query.getQueryMap(),offset,limit));
		return page;
	}
	
	public E getByParam(XJJParameter param) throws DataAccessException
	{
		
		System.out.println("getByParam===");
		System.out.println("getByParam= dao=="+getDao());
		List<E> list = getDao().findList(param.getQueryMap());
		
		if(null==list || list.size()==0)
		{
			return null;
		}
		
		if(list.size()>1)
		{
			throw new DataAccessException("得到一行数据，数据库却返回多条数据");
		}
		
		return list.get(0);
		
	}
	
	public List<E> findListByProperty(String property,Object val)
	{
		property = StringUtils.toUnderScoreCase(property);
		return getDao().findListByColumn(property,val);
	}
	
	public List<E> findListByPropertyLimit(String property,Object val,int offset,int limit)
	{
		property = StringUtils.toUnderScoreCase(property);
		return getDao().findListByColumnLimit(property,val,offset,limit);
	}
	
	public List<E> findListByColumnValues(String property, Object[] propValArr)
	{
		property = StringUtils.toUnderScoreCase(property);
		return getDao().findListByColumnValues(property,propValArr);
	}
	public List<E> findListByColumnValuesLimit(String property,Object[] propValArr,int offset,int limit)
	{
		property = StringUtils.toUnderScoreCase(property);
		return getDao().findListByColumnValuesLimit(property,propValArr,offset,limit);
	}
	public boolean checkUniqueVal(String tableName,String columnName,String columnVal,Long id)
	{
		int flag = commonDao.checkUniqueVal(tableName,columnName,columnVal,id);
		
		if(flag>0)
		{
			return false;
		}
		return true;
	}
	
}