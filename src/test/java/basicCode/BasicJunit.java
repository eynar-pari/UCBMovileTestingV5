package basicCode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit {
    @BeforeEach
    public void init(){
        System.out.println("setup");
    }
    @AfterEach
    public void clean(){
        System.out.println("clean");
    }

    @Test
    public void thisIsATest(){
        System.out.println("ese es mi test 1");
    }

    @Test
    public void thisIsATest2(){
        System.out.println("ese es mi test 2");
    }
}
