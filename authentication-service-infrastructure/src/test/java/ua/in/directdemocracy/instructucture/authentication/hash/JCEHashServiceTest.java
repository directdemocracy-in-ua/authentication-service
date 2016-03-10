package ua.in.directdemocracy.instructucture.authentication.hash;

import static org.junit.Assert.*;

import java.util.Base64;

import org.junit.Before;
import org.junit.Test;

public class JCEHashServiceTest {

    JCEHashService hashService;
    
    @Before
    public void init() {
        hashService = new JCEHashService();
    }
    
    @Test
    public void hashIsBase64Encoded64Bytes() {
        byte[] bytes = Base64.getDecoder().decode(hashService.fromString("some string"));
        assertNotNull(bytes);
        assertEquals(64, bytes.length);
    }
    
    @Test
    public void hashCodesOfTheSameStringAreEqual() {
        assertEquals(hashService.fromString("string"), hashService.fromString("string"));
    }
    
    @Test
    public void hashCodesOfDifferentStringsDoNotEqual() {
        assertNotEquals(hashService.fromString("string1"), hashService.fromString("string2"));
    }
    
    @Test
    public void hashCodeOfEmptyString() {
        assertEquals("z4PhNX7vuL3xVChQ1m2AB9Yg5AULVxXcg/SpIdNs6c5H0NE8XYXysP+DGNKHfuwvY7kxvUdBeoGlODJ6+SfaPg==",
                hashService.fromString(""));
    }
    
    @Test
    public void hashCodeOfSomeString() {
        assertEquals("J1fLPK/DmvRRq7Jpe+ebSrYdY9dNhbBBhinejCaBG1KfPzeA0BUAY/9Vor7udMTsECoqJzGh8ffxDUc60Ypqhw==",
                hashService.fromString("string"));
    }

    
    public static void main(String[] args) {
        JCEHashService hashService = new JCEHashService();
        System.out.printf("hash('string') = %s\n", hashService.fromString("string"));
        System.out.printf("hash('string1') = %s\n", hashService.fromString("string1"));
        System.out.printf("hash('string2') = %s\n", hashService.fromString("string2"));
        System.out.printf("hash('') = %s\n", hashService.fromString(""));
    }
}
