package cn.ylcto.student.service;

import java.util.List;
import java.util.Map;

import cn.ylcto.student.vo.Student;

public interface IStudentService {

	/**
	 * 实现学生数据增加操作
	 * @param vo
	 * @return
	 */
	public boolean insert(Student vo) throws Exception;
	
	
	 /**
     * 实现数据分页查询操作
     * @param currentPage 表示当前页
     * @param lineSize 表示每页显示记录数
     * @return
     * @throws Exception
     */
	public Map<String,Object> listSpilt(int currentPage,int lineSize)  throws Exception;
	
	
	/**
	 * @param vo传入需要验证的数据
	 * @return返回布尔值，成功true，失败false
	 * @throws Exception
	 */
	public boolean update(Student vo)throws Exception ;
	
	
	/**实现数据批量删除操作
	 * @param ids 表示要执行删除的操作的集合数据
	 * @return
	 * @throws Exception
	 */
	public boolean delete(List<String> ids) throws Exception;
	
	
	
}
