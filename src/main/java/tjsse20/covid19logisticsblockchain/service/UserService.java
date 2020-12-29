package tjsse20.covid19logisticsblockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.mapper.UserMapper;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.MD5Util;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User update(User user){
        userMapper.update(user);
        return user;
    }

    public User getUser(Integer id){
        return userMapper.select(id);
    }

    public int register(User user){
        User existUser = userMapper.selectByTel(user.getTelephone());
        if (existUser != null){
            return ConstantDefinition.USER_EXIST;
        }
        switch (user.getType()){
            case 1:
                user.setStatus(ConstantDefinition.USER_STATUS_AVAILABLE);
                userMapper.register(user);
                break;
            case 2:
            case 3:
            case 4:
                user.setStatus(ConstantDefinition.USER_STATUS_UNDER_AUDIT);
                userMapper.register(user);
                break;
            default:
                break;
        }
        return ConstantDefinition.REQUEST_OK;
    }

    public User getUserByTel(String telephone, int type) {
        User user = userMapper.selectByTel(telephone);
        if (user != null && user.getType() == type) {
            return user;
        }
        return null;
    }

    public boolean verifyPasswd(String passwd, String md5){
        return MD5Util.verify(passwd, "", md5);
    }

}
