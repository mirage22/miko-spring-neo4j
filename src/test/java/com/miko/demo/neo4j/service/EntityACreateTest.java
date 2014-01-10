package com.miko.demo.neo4j.service;

import com.miko.demo.neo4j.model.EntityA;
import com.miko.demo.neo4j.model.EntityB;
import com.miko.demo.neo4j.model.EntityC;
import com.miko.demo.neo4j.model.EntityD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;

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
public class EntityACreateTest {

    @Autowired
    EntityAService entityAService;

    @Autowired
    EntityBService entityBService;

    @Autowired
    EntityCService entityCService;

    @Autowired
    EntityDService entityDService;

    private Logger logger = LoggerFactory.getLogger(EntityACreateTest.class);

    @Test
    public void createEntityATest(){


        int maxNumEntityA1 = 3;
        int maxNumEntityA2 = 7;
        int entityA1num= 1;

        EntityD entityD1 = new EntityD("entityD",33L);
        entityD1.setDescription("descriptionD1");

        EntityA entityA1 = new EntityA("mirage" + entityA1num,22L);
        entityA1.setDescription("description1");
        entityD1.setParentD(entityA1);

        for(int i = 0; i < maxNumEntityA1; i++){
            EntityB entityB = new EntityB("miko"+i, 1L+i);
            entityA1.addEntityB(entityB);
        }

        logger.debug("createEntityATest = " + entityA1);

        EntityA entityA2 = new EntityA("mirage",22L);
        for(int i = maxNumEntityA1; i<maxNumEntityA2; i++){
            EntityB entityB = new EntityB("miko"+i, 2L+i);
            entityA2.addEntityB(entityB);
        }
        entityA2.setParentA(entityA1);
        entityA2.setDescription("description2");

        EntityC entityC1 = new EntityC("entityC", new BigDecimal(22.0));
        entityC1.setDescription("entityC description");
        entityC1.setEntityA(entityA1);
        entityC1.setEntityD(entityD1);


        entityAService.save(entityA1);
        entityAService.save(entityA2);
        entityDService.save(entityD1);
        entityCService.save(entityC1);

        Assert.notNull(entityA1.getId());
        Assert.notNull(entityA2.getId());
        Assert.notNull(entityD1.getId());
        Assert.notNull(entityC1.getId());
    }
}
