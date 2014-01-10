package com.miko.demo.neo4j.service;

import com.miko.demo.neo4j.dto.EntityADTO;
import com.miko.demo.neo4j.model.EntityA;
import com.miko.demo.neo4j.repository.EntityARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/4/14
 */

@Service("entityAService")
@SuppressWarnings("unchecked")
public class EntityAServiceImpl implements EntityAService {

    @Autowired
    EntityARepository entityARepository;

    private Logger logger = LoggerFactory.getLogger(EntityAServiceImpl.class);

    @Override
    public EntityA findOne(Long id) {
        return entityARepository.findOne(id);
    }

    @Override
    public EntityA findByName(String name) {
        return entityARepository.findByName(name);
    }

    @Override
    public List<EntityA> findAll() {
        return (List)entityARepository.findAll();
    }

    @Override
    public List<EntityADTO> findAllDTO() {
        List<EntityADTO> result = new ArrayList<EntityADTO>();

        EndResult<EntityA> entityAList = entityARepository.findAll();

        for(EntityA entityA: entityAList){
            logger.debug("findAllDTO entityA name = " + entityA.getName() + " value = " + entityA.getValue());
            result.add(new EntityADTO(entityA.getName(), entityA.getValue()));
        }

        return result;
    }

    @Override
    public EntityA findByDescription(String description) {
        return entityARepository.findByDescription(description);
    }

    @Override
    public EntityA save(EntityA entityA) {
        logger.debug("SAVE = " + entityA);
        return entityARepository.save(entityA);
    }

    @Override
    public void delete(EntityA entityA) {
        logger.debug("DELETE = " + entityA);
        entityARepository.delete(entityA);
    }
}
