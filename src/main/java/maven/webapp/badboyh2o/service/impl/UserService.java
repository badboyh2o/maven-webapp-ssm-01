package maven.webapp.badboyh2o.service.impl;

import maven.webapp.badboyh2o.domain.User;

public interface UserService {
    
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    public User findUserByName(String name);
}
