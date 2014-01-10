package com.miko.demo.neo4j.model;

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

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 12/26/13
 */

@NodeEntity
public class EntityA extends AbstractNeoEntity {

    @Indexed
    private String name;

    private Long value;

    @Indexed
    private String description;

    private EntityA parentA;

    @RelatedTo(type = "ENTITYB")
    private Set<EntityB> entityBSet = new HashSet<EntityB>();




    public EntityA() {
    }

    public EntityA(String name, Long value) {

        Assert.notNull(value);
        Assert.hasText(name);

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntityA getParentA() {
        return parentA;
    }

    public void setParentA(EntityA parentA) {
        this.parentA = parentA;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Set<EntityB> getEntityBSet() {
        return Collections.unmodifiableSet(entityBSet);
    }

    public void setEntityBSet(Set<EntityB> entityBSet) {
        this.entityBSet = entityBSet;
    }

    public void addEntityB(EntityB entityB){
        Assert.notNull(entityB);
        this.entityBSet.add(entityB);
    }

    @Override
    public String toString() {
        return "EntityA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
