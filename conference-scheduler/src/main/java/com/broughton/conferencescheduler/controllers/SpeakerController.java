package com.broughton.conferencescheduler.controllers;

import com.broughton.conferencescheduler.models.Speaker;
import com.broughton.conferencescheduler.repositories.SpeakerRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRespository speakerRespository;

    @GetMapping
    public List<Speaker> list(){
        return speakerRespository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRespository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRespository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //TODO: check for children before deleting
        speakerRespository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        //TODO: Add validation that all attributes are present
        Speaker existingSpeaker = speakerRespository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRespository.saveAndFlush(existingSpeaker);
    }


}
