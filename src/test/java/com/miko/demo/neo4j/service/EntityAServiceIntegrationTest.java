package com.miko.demo.neo4j.service;

import com.miko.demo.neo4j.config.AbstractIntegrationTest;
import com.miko.demo.neo4j.model.EntityA;
import com.miko.demo.neo4j.model.EntityB;
import com.miko.demo.neo4j.repository.EntityARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

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

@RunWith(SpringJUnit4ClassRunner.class)
public class EntityAServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    EntityAService entityAService;

    private Logger logger = LoggerFactory.getLogger(EntityAServiceIntegrationTest.class);

    @Test
    public void testEntityACreation(){
        EntityA entityA = new EntityA("mirage001",22L);

        entityA = entityAService.save(entityA);
        logger.debug("EntityA Creation = " + entityA);
        assertThat(entityA.getId(), is(notNullValue()));
    }

    @Test
    public void testEntityASearch(){
        EntityA entityA = entityAService.findByDescription("description008");
        logger.debug("EntityA Search = " + entityA);
        for(EntityB eb: entityA.getEntityBSet()){
            logger.debug("EntityA Set EntityB = " + eb);
        }
        assertThat(entityA.getId(), is(notNullValue()));

    }

}
