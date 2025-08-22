package calısmaTestlerim;

import org.junit.jupiter.api.RepeatedTest;

public class repeadTest {
    @RepeatedTest(5)
    public void test() {
        System.out.println("3 defa test");
    }
}
// bazı testleri tekrar tekrar çalıştırmak istersem bu anatosyanları
// kullanabilirim