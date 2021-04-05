package tjsse20.covid19logisticsblockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;
import tjsse20.covid19logisticsblockchain.mapper.StationMapper;

import java.util.List;

@Service
public class StationService {
    @Autowired
    StationMapper stationMapper;

    public TransferStation getById(Integer id){
        return stationMapper.select(id);
    }

    public TransferStation update(TransferStation station){
        stationMapper.update(station);
        return station;
    }

    public List<TransferStation> getAllStations(){
        return stationMapper.getAll();
    }

    public TransferStation createStation(TransferStation station){
        stationMapper.insert(station);
        return station;
    }

    public List<TransferStation> getStationByType(String type){
        return stationMapper.selectByType(type);
    }

    public TransferStation getStationByWorker(int workerId){
        return stationMapper.selectByWorker(workerId);
    }
}
