package com.bloodnet.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodnet.api.mappers.TblUserMapper;
import com.bloodnet.api.model.TblUser;
import com.bloodnet.api.model.TblUserExample;
import com.bloodnet.api.services.com.BaseService;
import com.bloodnet.api.services.com.CommonService;


@Service
public class UserService extends BaseService {

	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TblUserMapper tblUserMapper;
	
	public TblUser getUser(String userId){
		TblUserExample example = new TblUserExample();
		TblUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<TblUser> userList = tblUserMapper.selectByExample(example);
		if(userList != null && userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
}
