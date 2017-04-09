package com.bloodnet.api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.bloodnet.api.mappers.TblProfileMapper;
import com.bloodnet.api.model.TblProfile;
import com.bloodnet.api.services.com.BaseService;
import com.bloodnet.api.services.com.CommonService;
import com.bloodnet.lib.Profile;


@Service
public class ProfileAPIService extends BaseService {
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TblProfileMapper tblProfileMapper;
	
	public void createProfile(Profile profile) throws DataAccessException{
		TblProfile tblProfile = new TblProfile();
		tblProfile.setProfileId(UUID.randomUUID().toString());
		tblProfile.setSex(profile.getSex());
		tblProfile.setFamilyName(profile.getFamilyName());
		tblProfile.setFirstName(profile.getFirstName());
		tblProfile.setBirthdate(profile.getBirthdate());
		tblProfile.setIdNumber(profile.getIdNumber());
		tblProfile.setDelflg(false);
		
		tblProfileMapper.insert(tblProfile);
	}
}
