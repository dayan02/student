package cn.ylcto.student.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IStudentDao;
import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Student;

@Service
public class StudentServiceImpl implements IStudentService{

	@Resource
	private IStudentDao studentDao;
	
	public boolean insert(Student vo) throws Exception {
		
		return this.studentDao.doCreate(vo);
	}

	@Override
	public Map<String, Object> listSpilt(int currentPage, int lineSize)
			throws Exception {
		 Map<String,Object> map  = new HashMap<>();
	        map.put("allStudent",this.studentDao.findAllBySplit(currentPage,lineSize));
	        map.put("studentCount",this.studentDao.getAllCount());
	        return map;
	}

	@Override
	public boolean update(Student vo) throws Exception {
		return this.studentDao.doUpdate(vo);
	}

	@Override
	public boolean delete(List<String> ids) throws Exception {
		System.out.println(ids);
		return this.studentDao.doRemoverBatch(ids);
	}

	

}
