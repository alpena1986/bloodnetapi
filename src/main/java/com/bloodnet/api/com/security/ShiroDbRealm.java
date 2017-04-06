package com.bloodnet.api.com.security;

import javax.management.relation.Role;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.bloodnet.api.model.TblUser;
import com.bloodnet.api.services.UserService;

@Scope("prototype")
@Component
public class ShiroDbRealm extends JdbcRealm {

	@Autowired
	private UserService userService = null;

	public void setUserService(final UserService userService){
	    this.userService = userService;
	}

	public UserService getUserService(){
	    return userService;
	}

	/**
	 * 認証処理
	 * @param token 認証トークン
	 * @return AuthenticationInfo
	 * @throws AuthenticationException Apache Shiroからの例外
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {

	    //トークンからユーザ名を取得する
	    final UsernamePasswordToken upToken = (UsernamePasswordToken) token;
	    final String userName = upToken.getUsername();
	    final String password = String.valueOf(upToken.getPassword());

	    //DBからユーザ情報を取得する。
	    TblUser user = userService.getUser(userName);

	    Sha256CredentialsMatcher credentialsMatcher = new Sha256CredentialsMatcher();
	    super.setCredentialsMatcher(credentialsMatcher);
	    credentialsMatcher.setHashIterations(1);

	    //パスワードが改ざんされていないかをチェック
	    final Sha256Hash credentials = Sha256Hash.fromBase64String(user.getPassword());
	    credentials.setSalt(ByteSource.Util.bytes(Base64.decode(user.getSalt())));

	    final SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, credentials, getName());
	    info.setCredentialsSalt(credentials.getSalt());

	    return info;
	}

}