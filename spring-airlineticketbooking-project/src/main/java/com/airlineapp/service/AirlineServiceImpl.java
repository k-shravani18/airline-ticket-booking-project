package com.airlineapp.service;

import com.airlineapp.model.Airline;
import com.airlineapp.repository.IAirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */
@Service
public class AirlineServiceImpl implements IAirlineService{
    private IAirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(IAirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline addAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void updateAirline(Airline airline) {
    airlineRepository.save(airline);
    }

    @Override
    public void deleteAirline(int airlineId) {
    airlineRepository.deleteById(airlineId);
    }

    @Override
    public List<Airline> getAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline getByAirlineId(int airlineId) {
        return airlineRepository.findById(airlineId).get();
    }


    @Override
    public List<Airline> getByAirlineHeadquarters(String headquarters) {
        return airlineRepository.findByAirlineHeadquarters(headquarters);
    }
}
