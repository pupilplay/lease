import com.study.lease.common.result.Result;
import com.study.lease.model.entity.ApartmentFacility;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

/**
 * ClassName: testLombok
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author pupil
 * @Create 2025/4/26 21:12
 * @Version 1.0
 */
public class MyTest {
    @Test
    public void test1() throws Exception {
//        ApartmentFacility apartmentFacility=new ApartmentFacility();
        try {
            Constructor<ApartmentFacility> declaredConstructor = ApartmentFacility.class.getDeclaredConstructor(Long.class, Long.class);
            declaredConstructor.setAccessible(true);
            ApartmentFacility apartmentFacility = declaredConstructor.newInstance(1L, 2L);
            System.out.println(apartmentFacility.getId());
        } finally {
            System.out.println("failed");
        }
    }
    @Test
    public void test2(){
        com.study.lease.common.result.Result res = Result.ok();
        System.out.println(res);

    }
}
