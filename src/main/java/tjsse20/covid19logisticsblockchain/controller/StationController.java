package tjsse20.covid19logisticsblockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.StationService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    StationService stationService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public StandardResult allStation(){
        List<TransferStation> stations = stationService.getAllStations();
        return new StandardResult(ConstantDefinition.REQUEST_OK, stations);
    }

}
