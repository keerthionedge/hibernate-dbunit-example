package com.hib.dbunit.example.domain;

/**
 * This Class xUser todo ramacke
 *
 * @author <a href="mailto:keerthi.ramachandran@outlook.com">Keerthi Ramachandran</a>
 * @since 2.6. / 25-08-2013
 */
public class xUser {
    private Long userGkey;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getUserGkey() {
        return userGkey;
    }

    public void setUserGkey(Long userGkey) {
        this.userGkey = userGkey;
    }
}
