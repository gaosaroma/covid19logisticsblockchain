package tjsse20.covid19logisticsblockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.UserService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.MD5Util;

import java.util.ConcurrentModificationException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public StandardResult getUser(@PathVariable int id){
        return new StandardResult(ConstantDefinition.REQUEST_OK, userService.getUser(id));
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public StandardResult login(@RequestBody User user){
        StandardResult result = new StandardResult(ConstantDefinition.REQUEST_OK, null);
        String inputPasswd = user.getPasswd();
        user = userService.getUserByTel(user.getTelephone(), user.getType());
        if (user == null){
            result.setCode(ConstantDefinition.USER_NOT_EXIST);
        }
        else if (userService.verifyPasswd(inputPasswd, user.getPasswd())){
            if (user.getStatus() != ConstantDefinition.USER_STATUS_AVAILABLE){
                result.setCode(user.getStatus());
            }else{
                result.addObject(user);
            }
        }
        else {
            result.setCode(ConstantDefinition.WRONG_PASSWD);
        }
        return result;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public StandardResult register(@RequestBody User user){
        StandardResult result = new StandardResult(ConstantDefinition.REQUEST_OK, null);
        user.setPasswd(MD5Util.md5(user.getPasswd(), ""));
        result.setCode(userService.register(user));
        if (result.getCode() == ConstantDefinition.REQUEST_OK){
            result.addObject(user);
        }
        return result;
    }

    @RequestMapping("/update")
    @ResponseBody
    public StandardResult update(@RequestBody User user){
        return new StandardResult(ConstantDefinition.REQUEST_OK, userService.update(user));
    }
}
