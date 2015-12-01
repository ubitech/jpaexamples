/*
 *  Copyright 2015-2016 PaaSword project, http://www.paasword.eu/
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.paasword;

import eu.paasword.dao.UserRepository;
import eu.paasword.model.User;
import java.util.logging.Logger;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Panagiotis Gouvas (pgouvas@ubitech.eu)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ServiceTest {

    private static final Logger logger = Logger.getLogger(ClassName.class.getName());

    public ServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test() {

    }

    @Autowired
    UserRepository urs;

    @Ignore
    @Test
    public void testWiring() {
        logger.info("Test Autowiring ");
        Assert.assertNotNull(urs);
        logger.info("Test testWiring finished successfully");
    }//EOM    

    /*
     *   This method will execute several test-cases. It will be used to get the raw
     *   SQL queries that is autogenerated by Hibernate. Before you run the queries
     *   you should remove all data from your database and you should enable 
     *   spring.jpa.show-sql = true in the application.properties 
     */
    @Test
    public void testDAOs() {
        logger.info("Test DAOs initialized");

        /*
         * CASE-1: Insert a simple user. This is the simplest case
         * In a clean installation of the database there will be no Usertype.
         * We will attempt to create one User object without filling the Usertype
         * Since Usertype is declared as "optional = false" we expect runtime exception
         */
        try {
            User newuser = new User();
            newuser.setName("Panagiotis Gouvas");
            logger.info("CASE-1 execution");
            urs.save(newuser);
        } catch (Exception ex1) {
            logger.info("Exception generated because Usertype was not provided");
        }
        /*
         * Indeed the save statement was interpreted to the following SQL 
         * insert into user (name, usertype) values (?, ?)
         * however the following exception was generated: Column 'usertype' cannot be null
         * since an SQL Error (1048) was generated due to constraint violation
         * Please note that if "optional = false" changes to "optional = true" then the insert query
         * will be executed with the second argument as NULL
         */
        
        
        
        /*
         * CASE-1: Insert a simple user. This is the simplest case
         * In a clean installation of the database there will be no Usertype.
         * We will attempt to create one User object without filling the Usertype
         * Since Usertype is declared as "optional = true" we expect runtime exception
         */
        
        
        
        
        
    }//EoM

}//EoC
