package CesarCypher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static CesarCypher.PassTypes.*;

public class CypherTest {

    @Test
    void testWeakCypher1(){
        String newText = CesarCypher.Cypher(WEAK, "AbC");
        assertEquals("BcD", newText);
    }
    @Test
    void testWeakCypher2(){
        String newText = CesarCypher.Cypher(WEAK, "Ana");
        assertEquals("Bob", newText);
    }
    @Test
    void testWeakCypher3(){
        String newText = CesarCypher.Cypher(WEAK, "XyZ");
        assertEquals("YzA", newText);
    }
    @Test
    void testWeakCypher4(){
        String newText = CesarCypher.Cypher(WEAK, "abcdefghijklmnopqrstuvwxyz");
        assertEquals("bcdefghijklmnopqrstuvwxyza", newText);
    }
    @Test
    void testStrongCypher1(){
        String newText = CesarCypher.Cypher(MEDIUM, "AbC");
        assertEquals("EfG", newText);
    }
    @Test
    void testStrongCypher2(){
        String newText = CesarCypher.Cypher(MEDIUM, "Ana");
        assertEquals("Ere", newText);
    }
    @Test
    void testStrongCypher3(){
        String newText = CesarCypher.Cypher(MEDIUM, "XyZ");
        assertEquals("BcD", newText);
    }
    @Test
    void testStrongCypher4(){
        String newText = CesarCypher.Cypher(MEDIUM, "abcdefghijklmnopqrstuvwxyz");
        assertEquals("efghijklmnopqrstuvwxyzabcd", newText);
    }

}
