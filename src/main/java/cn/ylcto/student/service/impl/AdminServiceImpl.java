package cn.ylcto.student.service.impl;

import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.ylcto.student.dao.IAdminDao;
import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;

@Service
public class AdminServiceImpl implements IAdminService {

	@Resource
	private IAdminDao adminDao;
	
	public Admin login(Admin vo) throws Exception {
		
		Admin admin = this.adminDao.findLLogin(vo);
		if(admin!=null){//登录成功
			vo.setLastdate(new Date());
			this.adminDao.doUpdate(vo);
		}
		return admin;
	}

}
