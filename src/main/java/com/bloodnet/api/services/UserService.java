package com.bloodnet.api.services;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodnet.api.mappers.TblUserMapper;
import com.bloodnet.api.model.TblUser;
import com.bloodnet.api.model.TblUserExample;
import com.bloodnet.api.services.com.BaseService;
import com.bloodnet.api.services.com.CommonService;
import com.bloodnet.lib.User;


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
	
	public void createUser(User user){
		TblUser tblUser = new TblUser();
		tblUser.setUserId(user.getId());
		tblUser.setPassword(user.getPassword());
		tblUser.setProfileId(user.getProfileId());
		tblUser.setSecondaryEmail(user.getSecondaryEmail());
		tblUser.setLastPasswordChangeYmd(new LocalDate().toString("yyyyMMdd"));
		tblUser.setAccountStatus("0");
		tblUser.setLoginFailedCnt(0);
		tblUser.setLockFlg(false);
		tblUser.setDelflg(false);
		
		tblUserMapper.insert(tblUser);
	}
}
