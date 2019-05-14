package com.example.springbootdemo.restfuldemo.controller;

import com.example.springbootdemo.restfuldemo.data.UserFormData;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.example.springbootdemo.restfuldemo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * controller测试
 *
 * @author jiancheng
 * @date 2019-5-13
 */

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserControllerTest {
    private static final Logger log = LoggerFactory.getLogger(com.example.springbootdemo.restfuldemo.controller.UserControllerTest.class);
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;

    public UserControllerTest() {
    }

    @Before
    public void setUp() throws Exception {
        log.info("开始");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        log.info("构建完的mockMvn{}", this.mockMvc);
    }

    @After
    public void tearDown() throws Exception {
        log.info("结束");
    }

    @Test
    public void hello() {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            log.error("异常信息{}", e);
        }
    }

    @Test
    public void saveByResultVo() {
        try {
            UserForm userForm = UserFormData.getUserForm();
            int status = 1;
            MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/saveByResultVo");
            mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON);
            mockHttpServletRequestBuilder.content(objectMapper.writeValueAsString(userForm));
            mockHttpServletRequestBuilder.param("status", status + "");

            MvcResult mvcResult = this.getMvcResult(mockHttpServletRequestBuilder);
            MockHttpServletResponse response = mvcResult.getResponse();
            log.info("输出结果{}", response.getContentAsString());
            List<UserEntity> userEntityList = userRepository.findAll();
            log.info("当前从查询到到集合为{}", userEntityList.size());
            assert userEntityList.size() == 0;
        } catch (Exception var5) {
            log.error("异常信息{}", var5);
        }
    }

    @Test
    public void save() {
        try {
            UserForm userForm = UserFormData.getUserForm();
            MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/save");
            mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON);
            mockHttpServletRequestBuilder.content(this.objectMapper.writeValueAsString(userForm));

            MvcResult mvcResult = this.getMvcResult(mockHttpServletRequestBuilder);
            MockHttpServletResponse response = mvcResult.getResponse();
            log.info("输出结果{}", response.getContentAsString());
        } catch (Exception e) {
            log.error("异常信息{}", e);
        }
    }

    @Test
    public void update() {
        try {
            UserForm userForm = UserFormData.getUserForm();
            userForm.setId(1L);
            userForm.setName("list");
            MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.put("/update");
            mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON);
            mockHttpServletRequestBuilder.content(this.objectMapper.writeValueAsString(userForm));
            MvcResult mvcResult = this.getMvcResult(mockHttpServletRequestBuilder);
            MockHttpServletResponse response = mvcResult.getResponse();
            log.info("输出结果{}", response.getContentAsString());
            UserForm resultValue = (UserForm) this.objectMapper.readValue(response.getContentAsString(), UserForm.class);

            assert resultValue.getName().equals(userForm.getName());
        } catch (Exception var6) {
            log.error("异常信息{}", var6);
        }

    }

    @Test
    public void findOneById() {
        try {
            MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/findOneById");
            mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON);
            mockHttpServletRequestBuilder.content("1L");
            MvcResult mvcResult = this.getMvcResult(mockHttpServletRequestBuilder);
            MockHttpServletResponse response = mvcResult.getResponse();
            log.info("输出结果{}", response.getContentAsString());
        } catch (Exception var4) {
            log.error("异常信息{}", var4);
        }

    }

    private MvcResult getMvcResult(MockHttpServletRequestBuilder mockHttpServletRequestBuilder) throws Exception {
        return this.mockMvc.perform(mockHttpServletRequestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
    }

}
