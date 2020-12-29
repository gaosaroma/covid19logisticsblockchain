package tjsse20.covid19logisticsblockchain.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.LogisticsService;
import tjsse20.covid19logisticsblockchain.service.StationService;
import tjsse20.covid19logisticsblockchain.service.UserService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.HTTPUtil;
import tjsse20.covid19logisticsblockchain.util.MD5Util;

import java.util.ConcurrentModificationException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public StandardResult getUser(@PathVariable int id){
        User user = userService.getUser(id);
        TransferStation station = stationService.getById(user.getStationId());
        JSONObject o = (JSONObject) JSONObject.toJSON(user);
        o.put("station", JSONObject.toJSON(station));
        StandardResult result = new StandardResult(ConstantDefinition.REQUEST_OK, null);
        result.addObject(o);
        return result;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public StandardResult login(@RequestBody User user){
        StandardResult result = new StandardResult(ConstantDefinition.REQUEST_OK, null);
        String inputPasswd = user.getPasswd();
        user = userService.getUserByTel(user.getTelephone(), user.getType());
        if (user == null) {
            result.setCode(ConstantDefinition.USER_NOT_EXIST);
        }
        else if (userService.verifyPasswd(inputPasswd, user.getPasswd())){
            if (user.getStatus() != ConstantDefinition.USER_STATUS_AVAILABLE){
                result.setCode(user.getStatus());
            }else{
                TransferStation station = stationService.getById(user.getStationId());
                JSONObject o = (JSONObject) JSONObject.toJSON(user);
                o.put("station", JSONObject.toJSON(station));
                result.addObject(o);
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
        String jscode = user.getJscode();
        String openid = HTTPUtil.request(jscode);
        user.setOpenid(openid);
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
