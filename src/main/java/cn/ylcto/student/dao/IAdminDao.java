package cn.ylcto.student.dao;

import java.sql.SQLException;

import cn.ylcto.student.vo.Admin;

public interface IAdminDao extends IDAO<String, Admin>{


	
	/**
	 * @param vo 包含要执行查询的字段：（email password）
	 * @return  成功返回最后一次登录日期
	 * @throws SQLException
	 */
	public Admin findLLogin(Admin vo)throws SQLException;
}

