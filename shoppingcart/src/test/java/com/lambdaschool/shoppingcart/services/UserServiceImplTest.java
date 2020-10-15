package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.ShoppingcartApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes =
        ShoppingcartApplication.class)
@AutoConfigureMockMvc
@WithUserDetails(value = "cinnamon")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest
{
    @Autowired
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @org.junit.Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
    }

    @org.junit.Test
    public void findAll()
    {
        assertEquals(3, userService.findAll()
                .size());
    }

    @org.junit.Test
    public void findUserById()
    {
        assertEquals("cinnamon", userService.findUserById(2).getUsername());
    }

    @org.junit.Test
    public void findUserByName()
    {
    }

    @org.junit.Test
    public void delete()
    {
    }

    @org.junit.Test
    public void save()
    {
    }
}