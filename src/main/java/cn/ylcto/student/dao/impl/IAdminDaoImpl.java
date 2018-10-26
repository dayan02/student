package cn.ylcto.student.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ylcto.student.dao.IAdminDao;
import cn.ylcto.student.vo.Admin;


@Repository
public class IAdminDaoImpl extends SqlSessionDaoSupport implements IAdminDao{

	@Autowired
	public IAdminDaoImpl(SqlSessionFactory sqlSessionFactory) {
		 super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	public Admin findLLogin(Admin vo) throws SQLException {
		return super.getSqlSession().selectOne("AdminNS.findLogin", vo);
		

	}
	
	public boolean doUpdate(Admin vo) throws SQLException {
		//如果>0则实现更新操作
		return super.getSqlSession().update("AdminNS.doUpdateLastDate",vo) > 0;
	}
	
	public boolean doCreate(Admin vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Admin findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> findAllBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
