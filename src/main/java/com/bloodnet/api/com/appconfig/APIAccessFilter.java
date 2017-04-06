package com.bloodnet.api.com.appconfig;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * MySQL認証用に作成した独自フィルタです。
 */
@Scope("prototype")
@Component
public class APIAccessFilter extends AccessControlFilter {

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
	protected boolean isAccessAllowed(final ServletRequest req,
			final ServletResponse rsp, final Object obj) throws Exception {

		// ユーザIDとパスワードを使ってログイン実行する。
		String userName = req.getParameter("user_name");

		String password = req.getParameter("password");

		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		final Subject subject = SecurityUtils.getSubject();

		try {

			subject.login(token);

			return true;

			// loginメソッドで認証失敗すると例外が飛んできます
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