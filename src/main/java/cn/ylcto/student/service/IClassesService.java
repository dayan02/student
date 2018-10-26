package cn.ylcto.student.service;

import java.util.List;

import cn.ylcto.student.vo.Classes;

public interface IClassesService {

	
	/**
	 * 实现数据增加
	 * @param classes
	 * @return 成功返回true，失败返回false
	 * @throws Exception
	 */
	public boolean insert(Classes classes) throws Exception;
	
	/**实现数据的全部列出
	 * @return
	 * @throws Exception
	 */
	public List<Classes> list() throws Exception;
	
}
