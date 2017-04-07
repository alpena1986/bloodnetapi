package com.bloodnet.api.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodnet.api.mappers.TblAcidMapper;
import com.bloodnet.api.model.TblAcid;
import com.bloodnet.api.model.TblAcidExample;
import com.bloodnet.api.services.com.BaseService;
import com.bloodnet.api.services.com.CommonService;


@Service
public class AcidService extends BaseService {

	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TblAcidMapper tblAcidMapper;
	
	public TblAcid getAcid(String acid){
		TblAcidExample example = new TblAcidExample();
		TblAcidExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(acid);
		List<TblAcid> acidList = tblAcidMapper.selectByExample(example);
		if(acidList != null && acidList.size() > 0){
			return acidList.get(0);
		}
		return null;
	}
	
	public String createAcid(String userId){
		String acid = UUID.randomUUID().toString();
		TblAcid tblAcid = new TblAcid();
		tblAcid.setAcid(acid);
		tblAcid.setUserId(userId);
		tblAcidMapper.insert(tblAcid);
		return acid;
	}

}
