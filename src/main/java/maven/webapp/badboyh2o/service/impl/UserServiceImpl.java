package maven.webapp.badboyh2o.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import maven.webapp.badboyh2o.dao.UserDao;
import maven.webapp.badboyh2o.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public User findUserByName(String name) {
        return this.userDao.findByUsername(name);
    }
}