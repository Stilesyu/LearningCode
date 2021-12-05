///**
// * @author 虞晓晨
// * @version 1.0
// * @since 2018/11/9
// * @Modifytime: 2018/11/9
// *
// **/
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.servlet.view.InternalResourceView;
//import springlearning.spitter.HomeController;
//import springlearning.spitter.Spittle;
//import springlearning.spitter.SpittleController;
//import springlearning.spitter.SpittleRepository;
//
//import static org.mockito.Mockito.mock;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class MvcTest {
//
//        @Test
//    public void testHomePage() throws Exception {
//            HomeController homeController = new HomeController();
//            MockMvc mockMvc = standaloneSetup(homeController).build();
//
//            mockMvc.perform(get("/")).andExpect(view().name("home"));
//
//        }
//
//    @Test
//    public void shouldShowRecenSpitles(){
//            /*create 20 Spittle object*/
//        List<Spittle>  expectedSpittles  = createSpittleList(20);
//            /*use mockito simulate a object */
//        SpittleRepository mockSpittleRepository = mock(SpittleRepository.class);
//        /*if expectRepository have 20 object then return a list*/
//        when(mockSpittleRepository.findSpittles(Long.MAX_VALUE,20)).thenReturn(expectedSpittles);
//        /*new a Controller and afferent a mockSpittleRepository object*/
//        SpittleController spittleController = new SpittleController(mockSpittleRepository);
//
//        MockMvc mockMvc = standaloneSetup(spittleController)
//                .setSingleView(new InternalResourceView("/WEB/INF/spitter/spittle.jsp")).build();
//        mockMvc.perform(get("/Spitter")).
//                andExpect(view().name("spittles"))
//                ;
//
//
//    }
//
//
//    /*模拟用户消息*/
//    private List<Spittle> createSpittleList(int count){
//            List<Spittle> list = new ArrayList<>();
//            for (int i=0;i<count;i++){
//                list.add(new Spittle("Spittle:"+i,new Date()));
//            }
//            return list;
//    }
//
//
//
//
//
//}
