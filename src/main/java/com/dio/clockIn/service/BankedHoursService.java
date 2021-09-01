package com.dio.clockIn.service;

import com.dio.clockIn.model.BankedHours;
import com.dio.clockIn.repository.BankedHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankedHoursService {

    BankedHoursRepository bankedHoursRepository;

    @Autowired
    public BankedHoursService(BankedHoursRepository bankedHoursRepository){
        this.bankedHoursRepository = bankedHoursRepository;
    }

    public BankedHours saveBankedHours(BankedHours bankedHours){
        return bankedHoursRepository.save(bankedHours);
    }

    public void deleteBankedHours(Long id){
        bankedHoursRepository.deleteById(id);
    }

    public List<BankedHours> listBankedHours(){
        return bankedHoursRepository.findAll();
    }

    public Optional<BankedHours> getBankedHoursById(Long id){
        return bankedHoursRepository.findById(id);
    }

    public BankedHours updateBankedHours(BankedHours bankedHours){
        return bankedHoursRepository.save(bankedHours);
    }
}
