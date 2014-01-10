package com.miko.demo.neo4j.model;

import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;
import org.springframework.data.neo4j.fieldaccess.PrefixedDynamicProperties;
import org.springframework.data.neo4j.support.index.IndexType;
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
 * Date: 1/1/14
 */

@NodeEntity
public class EntityC extends AbstractNeoEntity {

    @Indexed
    private String name;

    @Indexed(indexType = IndexType.FULLTEXT, indexName = "entityc_search")
    private String description;

    @Indexed
    private EntityA entityA;

    @Indexed
    private EntityD entityD;


    @GraphProperty(propertyType = double.class)
    private BigDecimal value;

    private DynamicProperties attributes = new PrefixedDynamicProperties("attributes");

    public EntityC() {
    }

    public EntityC(String name, BigDecimal value) {

        Assert.hasText(name, "Name can not be empty");
        Assert.isTrue(BigDecimal.ZERO.compareTo(value) < 0, "Value must be greater than zero!");

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EntityA getEntityA() {
        return entityA;
    }

    public void setEntityA(EntityA entityA) {
        this.entityA = entityA;
    }

    public EntityD getEntityD() {
        return entityD;
    }

    public void setEntityD(EntityD entityD) {
        this.entityD = entityD;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setAttribute(String key, String value) {
        this.attributes.setProperty(key, value);
    }

    public DynamicProperties getAttributes() {
        return attributes;
    }

    public void setAttributes(DynamicProperties attributes) {
        this.attributes = attributes;
    }
}
