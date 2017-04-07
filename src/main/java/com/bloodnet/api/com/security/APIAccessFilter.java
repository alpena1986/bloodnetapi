package com.bloodnet.api.com.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bloodnet.api.model.TblAcid;
import com.bloodnet.api.services.AcidService;

/**
 * MySQL認証用に作成した独自フィルタです。
 */
@Scope("prototype")
@Component
public class APIAccessFilter extends AccessControlFilter {

	@Autowired
	public AcidService acidService;
	
	public APIAccessFilter() {
		super();
	}

	/**
	 * アクセス許可時の処理 カスタマイズ用の認証処理です。
	 * 
	 * @param req
	 *            リクエスト情報
	 * @param rsp
	 *            レスポンス情報
	 * @param obj
	 *            付加情報
	 * @throws Exception
	 *             例外
	 * @return boolean true:アクセス許可
	 */
	@Override
	protected boolean isAccessAllowed(final ServletRequest req, final ServletResponse rsp, final Object obj) throws Exception {

		ShiroHttpServletRequest request = (ShiroHttpServletRequest)req;
		String acid = request.getHeader("acid");
		TblAcid tblAcid = acidService.getAcid(acid);

		try {
			if (tblAcid == null) {
				throw new AuthenticationException();
			}
			return true;
		} catch (AuthenticationException e) {
			return false;
		}
	}

	/**
	 * アクセス拒否時の処理
	 * 
	 * @param req
	 *            リクエスト情報
	 * @param rsp
	 *            レスポンス情報
	 * @throws Exception
	 *             例外
	 * @return boolean false:アクセス許拒否
	 */
	@Override
	protected boolean onAccessDenied(final ServletRequest req,
			final ServletResponse rsp) throws Exception {
		// Apache-shiroを介した別の認証フィルターで失敗した場合に、飛ばされます。
		// 1個しか指定していないので、今回はここには飛んできませんので、実装しません。
		return false;
	}

}