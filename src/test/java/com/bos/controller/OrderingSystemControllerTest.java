package com.bos.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bos.Util.TestUtil;
import com.bos.model.OrderDetail;
import com.bos.service.OrderingSystemService;

/**
 * Controller class responsible for unit testing creating and fetching brick orders APIs
 * 
 * @author Vaishali
 * @version 1.0
 */

public class OrderingSystemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private OrderingSystemService orderService;

    @InjectMocks
    private OrderingSystemController orderController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(orderController)
                .build();
    }
	
	/**
	 * Test get all orders method success
	 */
    @Test
    public void test_getOrders_success() throws Exception {
        List<OrderDetail> orders = Arrays.asList(
                new OrderDetail(1, 5),
                new OrderDetail(2, 8));
        when(orderService.getOrders()).thenReturn(orders);
        mockMvc.perform(get("/getOrders"))
                .andExpect(status().isOk())
                //.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].orderId", is(1)))
                .andExpect(jsonPath("$[0].numberOfBricks", is(5)))
                .andExpect(jsonPath("$[1].orderId", is(2)))
                .andExpect(jsonPath("$[1].numberOfBricks", is(8)));
        verify(orderService, times(1)).getOrders();
        verifyNoMoreInteractions(orderService);
    }
    
	/**
	 * Test get order detail by order id success
	 */
    @Test
    public void test_getOrderByOrderId_success() throws Exception {
        OrderDetail orderDetail = new OrderDetail(1, 8);
        when(orderService.getOrder(1)).thenReturn(orderDetail);
        mockMvc.perform(get("/getOrder/{orderId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.orderId", is(1)))
                .andExpect(jsonPath("$.numberOfBricks", is(8)));
        verify(orderService, times(1)).getOrder(1);
        verifyNoMoreInteractions(orderService);
    }
    
	/**
	 * Test get order detail by order id HTTP 404 when order detail not found
	 */
    @Test
    public void test_get_by_id_fail_404_not_found() throws Exception {
        when(orderService.getOrder(10)).thenReturn(null);
        mockMvc.perform(get("/getOrder/{orderId}", 10))
                .andExpect(status().isNotFound());
        verify(orderService, times(1)).getOrder(10);
        verifyNoMoreInteractions(orderService);
    }
    
    /**
	 * Test create order success success
	 */
    @Test
    public void test_createOrder_success() throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setNumberOfBricks(9);
        mockMvc.perform(
                post("/createOrder")
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(orderDetail)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/users/")));
        verify(orderService, times(1)).createOrder(9);
        verifyNoMoreInteractions(orderService);
    }

}
