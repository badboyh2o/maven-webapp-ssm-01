package maven.webapp.badboyh2o.dao;

import maven.webapp.badboyh2o.domain.User;

public interface UserDao {
    
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
