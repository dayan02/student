package cn.ylcto.student.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.ylcto.student.dao.IStudentDao;
import cn.ylcto.student.vo.Student;

@Repository
public class IStudentDaoImpl extends SqlSessionDaoSupport implements IStudentDao{

	@Autowired
	 public IStudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		
	}
	
	public boolean doCreate(Student vo) throws SQLException {
		
		return super.getSqlSession().insert("StudentNs.doCreate",vo)>0;
	}

	public boolean doUpdate(Student vo) throws SQLException {

		return super.getSqlSession().update("StudentNs.doUpdate", vo)>0;
	}

	public boolean doRemove(Set<?> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Student findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAllBySplit(String column, String keyWord,
			Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAllCount(String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student> findAllBySplit(Integer currentPage, Integer lineSize)
			throws SQLException {
	 Map<String,Object> map = new HashMap<>();
	 map.put("start", (currentPage-1)*lineSize);
	 map.put("lineSize", lineSize);
		return super.getSqlSession().selectList("StudentNs.findBySpilt", map);
	}

	public Integer getAllCount() throws SQLException {
		return super.getSqlSession().selectOne("StudentNs.getAllCount");
	}

}
