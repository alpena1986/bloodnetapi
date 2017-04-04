package com.bloodnet.api.model;

public class TblUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.user_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.profile_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String profileId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.password
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.pw_deadline
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String pwDeadline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.login_failed_cnt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private Integer loginFailedCnt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.use_start_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String useStartDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.use_end_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String useEndDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.mail1
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String mail1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.question_type
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String questionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.answer
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String answer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.login_status
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private Boolean loginStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.mail_to_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private Boolean mailToFlg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.lock_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private Boolean lockFlg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.delflg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private Boolean delflg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.create_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String createApp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.create_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.create_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String createDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.update_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String updateApp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.update_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_user.update_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    private String updateDt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.user_id
     *
     * @return the value of tbl_user.user_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.user_id
     *
     * @param userId the value for tbl_user.user_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.profile_id
     *
     * @return the value of tbl_user.profile_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getProfileId() {
        return profileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.profile_id
     *
     * @param profileId the value for tbl_user.profile_id
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setProfileId(String profileId) {
        this.profileId = profileId == null ? null : profileId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.password
     *
     * @return the value of tbl_user.password
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.password
     *
     * @param password the value for tbl_user.password
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.pw_deadline
     *
     * @return the value of tbl_user.pw_deadline
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getPwDeadline() {
        return pwDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.pw_deadline
     *
     * @param pwDeadline the value for tbl_user.pw_deadline
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setPwDeadline(String pwDeadline) {
        this.pwDeadline = pwDeadline == null ? null : pwDeadline.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.login_failed_cnt
     *
     * @return the value of tbl_user.login_failed_cnt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public Integer getLoginFailedCnt() {
        return loginFailedCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.login_failed_cnt
     *
     * @param loginFailedCnt the value for tbl_user.login_failed_cnt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setLoginFailedCnt(Integer loginFailedCnt) {
        this.loginFailedCnt = loginFailedCnt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.use_start_dt
     *
     * @return the value of tbl_user.use_start_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUseStartDt() {
        return useStartDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.use_start_dt
     *
     * @param useStartDt the value for tbl_user.use_start_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUseStartDt(String useStartDt) {
        this.useStartDt = useStartDt == null ? null : useStartDt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.use_end_dt
     *
     * @return the value of tbl_user.use_end_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUseEndDt() {
        return useEndDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.use_end_dt
     *
     * @param useEndDt the value for tbl_user.use_end_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUseEndDt(String useEndDt) {
        this.useEndDt = useEndDt == null ? null : useEndDt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.mail1
     *
     * @return the value of tbl_user.mail1
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getMail1() {
        return mail1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.mail1
     *
     * @param mail1 the value for tbl_user.mail1
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setMail1(String mail1) {
        this.mail1 = mail1 == null ? null : mail1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.question_type
     *
     * @return the value of tbl_user.question_type
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.question_type
     *
     * @param questionType the value for tbl_user.question_type
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.answer
     *
     * @return the value of tbl_user.answer
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.answer
     *
     * @param answer the value for tbl_user.answer
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.login_status
     *
     * @return the value of tbl_user.login_status
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public Boolean getLoginStatus() {
        return loginStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.login_status
     *
     * @param loginStatus the value for tbl_user.login_status
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.mail_to_flg
     *
     * @return the value of tbl_user.mail_to_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public Boolean getMailToFlg() {
        return mailToFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.mail_to_flg
     *
     * @param mailToFlg the value for tbl_user.mail_to_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setMailToFlg(Boolean mailToFlg) {
        this.mailToFlg = mailToFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.lock_flg
     *
     * @return the value of tbl_user.lock_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public Boolean getLockFlg() {
        return lockFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.lock_flg
     *
     * @param lockFlg the value for tbl_user.lock_flg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setLockFlg(Boolean lockFlg) {
        this.lockFlg = lockFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.delflg
     *
     * @return the value of tbl_user.delflg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public Boolean getDelflg() {
        return delflg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.delflg
     *
     * @param delflg the value for tbl_user.delflg
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setDelflg(Boolean delflg) {
        this.delflg = delflg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.create_app
     *
     * @return the value of tbl_user.create_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getCreateApp() {
        return createApp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.create_app
     *
     * @param createApp the value for tbl_user.create_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setCreateApp(String createApp) {
        this.createApp = createApp == null ? null : createApp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.create_user
     *
     * @return the value of tbl_user.create_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.create_user
     *
     * @param createUser the value for tbl_user.create_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.create_dt
     *
     * @return the value of tbl_user.create_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.create_dt
     *
     * @param createDt the value for tbl_user.create_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setCreateDt(String createDt) {
        this.createDt = createDt == null ? null : createDt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.update_app
     *
     * @return the value of tbl_user.update_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUpdateApp() {
        return updateApp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.update_app
     *
     * @param updateApp the value for tbl_user.update_app
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUpdateApp(String updateApp) {
        this.updateApp = updateApp == null ? null : updateApp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.update_user
     *
     * @return the value of tbl_user.update_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.update_user
     *
     * @param updateUser the value for tbl_user.update_user
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_user.update_dt
     *
     * @return the value of tbl_user.update_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public String getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_user.update_dt
     *
     * @param updateDt the value for tbl_user.update_dt
     *
     * @mbggenerated Tue Apr 04 22:24:13 JST 2017
     */
    public void setUpdateDt(String updateDt) {
        this.updateDt = updateDt == null ? null : updateDt.trim();
    }
}