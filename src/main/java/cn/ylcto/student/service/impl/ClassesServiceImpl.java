package cn.ylcto.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ylcto.student.dao.IClassesDao;
import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;

@Service
public class ClassesServiceImpl implements IClassesService{

	@Resource
	private IClassesDao classesDao;
	
	public boolean insert(Classes classes) throws Exception {
		
	if(classesDao.findByCname(classes.getCname())==null){
		return this.classesDao.doCreate(classes);
	}
		return false;
	}

	public List<Classes> list() throws Exception {
		
		return this.classesDao.findAll();
	}

	
	
}
