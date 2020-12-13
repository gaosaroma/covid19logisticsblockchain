package tjsse20.covid19logisticsblockchain.resultparams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.util.List;

public class StandardResult {
    private int code;
    private JSONArray resultObjects;

    public JSONArray getResultObjects() {
        return resultObjects;
    }

    public void setResultObjects(JSONArray resultObjects) {
        this.resultObjects = resultObjects;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void addObject(Object o){
        this.resultObjects.add(JSONObject.toJSON(o));
    }

    public StandardResult(){
        this.code = ConstantDefinition.REQUEST_OK;
        this.resultObjects = new JSONArray();
    }

    public StandardResult(int code, Object result) {
        this.code = code;
        if (result == null){
            this.resultObjects = new JSONArray();
        }
        else if (result instanceof List) {
            this.resultObjects = JSONArray.parseArray(JSON.toJSONString(result));
        } else {
            JSONObject object = (JSONObject) JSONObject.toJSON(result);
            this.resultObjects = new JSONArray();
            this.resultObjects.add(object);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
