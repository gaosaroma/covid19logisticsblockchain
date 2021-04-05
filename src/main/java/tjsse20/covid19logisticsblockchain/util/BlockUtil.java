package tjsse20.covid19logisticsblockchain.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

public class BlockUtil {
    public static int getBlockHeight(String blockId){
        return new Random().nextInt(20);
    }

    public static int getBlockId(){
        return new Random().nextInt(899999999) + 100000000;
    }

    public static JSONObject getRiskInfoFromBlock(JSONObject jsonObject){
        return JSONObject.parseObject(jsonObject.toJSONString());
    }

    public static void main(String[] args){
        System.out.println(getBlockId());
    }
}
