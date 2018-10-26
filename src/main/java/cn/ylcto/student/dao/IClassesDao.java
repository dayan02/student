package cn.ylcto.student.dao;

import cn.ylcto.student.vo.Classes;

public interface IClassesDao extends IDAO<Integer, Classes> {

	
	public Classes findByCname(String cname);
	
}
