package tjsse20.covid19logisticsblockchain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.StationService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    StationService stationService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public StandardResult getUser(@PathVariable int id){
        return new StandardResult(ConstantDefinition.REQUEST_OK, stationService.getById(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public StandardResult allStation(){
        List<TransferStation> stations = stationService.getAllStations();
        return new StandardResult(ConstantDefinition.REQUEST_OK, stations);
    }

    @RequestMapping("/create")
    @ResponseBody
    public StandardResult createStation(@RequestBody TransferStation station){
        return new StandardResult(ConstantDefinition.REQUEST_OK, stationService.createStation(station));
    }

    @RequestMapping("/getByType")
    @ResponseBody
    public StandardResult getByType(@RequestBody TransferStation station){
        return new StandardResult(ConstantDefinition.REQUEST_OK, stationService.getStationByType(station.getTransportationType()));
    }

    @RequestMapping("/update")
    @ResponseBody
    public StandardResult update(@RequestBody TransferStation station){
        return new StandardResult(ConstantDefinition.REQUEST_OK, stationService.update(station));
    }


}
