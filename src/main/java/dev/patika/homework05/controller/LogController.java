package dev.patika.homework05.controller;


import dev.patika.homework05.entity.SystemLog;
import dev.patika.homework05.service.CustomLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final CustomLogService customLogService;

    /**
     *
     * @return all logs from database
     */
    @GetMapping("/logs")
    public ResponseEntity<SystemLog> getAllLogs(){
        return new ResponseEntity(customLogService.getAll(), HttpStatus.OK) ;
    }

    /**
     *
     * @param keyword
     * @return logs which includes keyword
     */
    @GetMapping("/logs/search/{keyword}")
    public ResponseEntity<SystemLog> searchInLogs(@PathVariable String keyword){
        return new ResponseEntity(customLogService.search(keyword),HttpStatus.OK);
    }



}
