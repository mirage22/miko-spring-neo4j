package com.miko.demo.neo4j.service;

import com.miko.demo.neo4j.model.EntityA;
import com.miko.demo.neo4j.model.EntityB;
import com.miko.demo.neo4j.model.QEntityA;
import com.miko.demo.neo4j.repository.EntityARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

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
 * Date: 1/7/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/app-config.xml")
public class EntityADeleteTest {

    @Autowired
    EntityAService entityAService;

    @Autowired
    EntityBService entityBService;

    private static final QEntityA qEntityA = QEntityA.entityA;

    private Logger logger = LoggerFactory.getLogger(EntityACreateTest.class);

    @Test
    public void deleteEntityATest(){

        EntityA entityA = entityAService.findByDescription("description2");
        logger.debug("DELETE EntityA = " + entityA);
        for(EntityB entityB: entityA.getEntityBSet()){
            logger.debug("DELETE entityB = " + entityB.getId());
            entityBService.delete(entityB);
        }
        Assert.notNull(entityA);

        entityAService.delete(entityA);

    }
}
