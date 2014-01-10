package com.miko.demo.neo4j.controller;


import com.miko.demo.neo4j.dto.EntityADTO;
import com.miko.demo.neo4j.dto.EntityAListResponseDTO;
import com.miko.demo.neo4j.service.EntityAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
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
 * Date: 1/5/14
 */
@Controller
@RequestMapping("/api")
public class JSONController {

    @Autowired
    EntityAService entityAService;

    private Logger logger = LoggerFactory.getLogger(JSONController.class);

    @RequestMapping(value = "/entityAList", method = RequestMethod.GET)
    public @ResponseBody
    List<EntityADTO> getEntityAList(Principal principal, HttpServletRequest request,
                                         HttpServletResponse response){


        List<EntityADTO> result = entityAService.findAllDTO();

        logger.debug("getEntityAList = " + result);

        return result;
    }

    @RequestMapping(value = "/entityAListDTO", method = RequestMethod.GET)
    public @ResponseBody
    EntityAListResponseDTO getEntityAListDTO(Principal principal, HttpServletRequest request,
                                          HttpServletResponse response){



        EntityAListResponseDTO result = new EntityAListResponseDTO();
        result.setName("mirage");
        result.setStatus(true);
        result.setList(entityAService.findAllDTO());

        logger.debug("getEntityAList = " + result);

        return result;
    }

}
