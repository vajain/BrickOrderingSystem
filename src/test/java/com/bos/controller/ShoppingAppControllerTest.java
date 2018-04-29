package com.bos.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.shop.controller.ShoppingAppController;
import com.shop.model.Product;
import com.shop.service.ShoppingAppService;


/**
 * Controller class responsible for unit testing of products fetch services
 * 
 * @author Vaishali
 * @version 1.0
 */

public class ShoppingAppControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingAppService shoppingAppService;

    @InjectMocks
    private ShoppingAppController shoppingAppController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(shoppingAppController)
                .build();
    }
	
	/**
	 * Test get products 
	 */
//    @Test
//    public void test_getCatalogue_success() throws Exception {
//        List<Product> products = Arrays.asList(
//                new Product("Arsenal TV","Sports"),
//                new Product("Chelsea TV", "Sports"),
//                new Product("Sky News", "News"),
//		        new Product("Sky Sports News", "News"));
//     
//    	 when(shoppingAppService.getProducts(3)).thenReturn(products);
//        mockMvc.perform(get("/getProducts/3"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$[0].product", is("Arsenal TV")))
//                .andExpect(jsonPath("$[0].category", is("Sports")))
//                .andExpect(jsonPath("$[1].product", is("Chelsea TV")))
//                .andExpect(jsonPath("$[1].category", is("Sports")))
//		        .andExpect(jsonPath("$[2].product", is("Sky News")))
//		        .andExpect(jsonPath("$[2].category", is("News")))
//		        .andExpect(jsonPath("$[3].product", is("Sky Sports News")))
//		        .andExpect(jsonPath("$[3].category", is("News")));
//        verify(shoppingAppService, times(1)).getProducts(3);
//        verifyNoMoreInteractions(shoppingAppService);
//    }
//    
//	/**
//	 * Test if no products for passed location, the sky sports and sky sports news are still returned
//	 */
//    @Test
//    public void test_getCatalogue_no_products_db() throws Exception {
//        List<Product> orders = Arrays.asList(
//                new Product("Arsenal TV","Sports"),
//                new Product("Chelsea TV", "Sports"));
//     
//    	 when(shoppingAppService.getProducts(8)).thenReturn(orders);
//        mockMvc.perform(get("/getProducts/8"))
//                .andExpect(status().isOk())
//               // .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//                .andExpect(jsonPath("$[0].product", is("Sky News")))
//		        .andExpect(jsonPath("$[0].category", is("News")))
//		        .andExpect(jsonPath("$[1].product", is("Sky Sports News")))
//		        .andExpect(jsonPath("$[1].category", is("News")));
//        verify(shoppingAppService, times(1)).getProducts(8);
//        verifyNoMoreInteractions(shoppingAppService);
//    }

}
