package tech.hdurmaz.sms.service;


import tech.hdurmaz.sms.entity.SystemLog;
import tech.hdurmaz.sms.repository.CustomLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomLogService {

    @Autowired
    private CustomLogRepository customLogRepository;

    /**
     * method for saving log to database
     * @param log
     */
    @Transactional
    public void save(SystemLog log){
        customLogRepository.save(log);
    }

    /**
     * for getting all logs exist in database
     * @return
     */
    public List<SystemLog> getAll(){
        return (List<SystemLog>) customLogRepository.findAll();
    }

    /**
     * getting all logs includes word keyword
     * @param word
     * @return
     */
    @Transactional
    public List<SystemLog> search(String word){
        return customLogRepository.search(word);
    }

}
