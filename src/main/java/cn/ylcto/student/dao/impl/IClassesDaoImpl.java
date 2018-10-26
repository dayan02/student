package cn.ylcto.student.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ylcto.student.dao.IClassesDao;
import cn.ylcto.student.vo.Classes;

@Repository
public class IClassesDaoImpl extends SqlSessionDaoSupport implements IClassesDao{

	@Autowired
	public IClassesDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	public boolean doCreate(Classes vo) throws SQLException {
		
		return super.getSqlSession().insert("ClassesNS.doCreate", vo)>0;
	}

	public Classes findByCname(String cname) {
		
		return super.getSqlSession().selectOne("ClassesNS.findByCname", cname);
	}

	public boolean doUpdate(Classes vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Classes findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Classes> findAll() throws SQLException {
		
		return super.getSqlSession().selectList("ClassesNS.findAll");
	}

	public List<Classes> findAllBySplit(String column, String keyWord,
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
