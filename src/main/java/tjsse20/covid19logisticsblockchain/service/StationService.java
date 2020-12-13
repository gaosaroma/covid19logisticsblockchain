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

    public List<TransferStation> getAllStations(){
        return stationMapper.getAll();
    }
}
