package jason.app.jobfair.web.controller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import jason.app.jobfair.common.entity.Person;
import jason.app.jobfair.common.repository.PersonRepository;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/servlet-context.xml")
@WebAppConfiguration
public class PersonControllerTest {
 
    private MockMvc mockMvc;
 
    @Autowired
    private PersonRepository personRepo;
    
    @Autowired
    private WebApplicationContext context;
 
    //Add WebApplicationContext field here

    //The setUp() method is omitted.
    @Before  
    public void setup() { 
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    } 
 
    @Test
    public void findAll_ShouldAddTodoEntriesToModelAndRenderTodoListView() throws Exception {
        Person first = new Person();
        first.setId(1L);
        first.setFirstName("Lorem ipsum");
        first.setLastName("Foo");

 
        Person second = new Person();
        second.setId(2L);
        second.setFirstName("Lorem ipsum");
        second.setLastName("Bar");
                
 
        when(personRepo.findAll()).thenReturn(Arrays.asList(first, second));
 
        mockMvc.perform(get("/person/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"))
                .andExpect(model().attribute("people", hasSize(2)))
                .andExpect(model().attribute("people", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("firstName", is("Lorem ipsum")),
                                hasProperty("lastName", is("Foo"))
                        )
                )))
                .andExpect(model().attribute("people", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("firstName", is("Lorem ipsum")),
                                hasProperty("lastName", is("Bar"))
                        )
                )));
 
        verify(personRepo, times(1)).findAll();
        verifyNoMoreInteractions(personRepo);
    }
}
