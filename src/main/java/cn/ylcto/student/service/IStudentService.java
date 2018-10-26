package cn.ylcto.student.service;

import java.util.Map;

import cn.ylcto.student.vo.Student;

public interface IStudentService {

	/**
	 * 实现学生数据增加操作
	 * @param vo
	 * @return
	 */
	public boolean insert(Student vo) throws Exception;
	
	public Map<String,Object> listSpilt(int currentPage,int lineSize)  throws Exception;
	
}
