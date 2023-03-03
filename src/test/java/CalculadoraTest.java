import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.mockito.exceptions.misusing.NullInsteadOfMockException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {


    @TestFactory
    Stream<DynamicTest> dynamicTestFromStreamInJava8() {
        Calculadora calculadora = new Calculadora();

        List<Integer> entrada = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> result = IntStream.range(0, 1000).map(n -> n * 2).boxed().collect(Collectors.toList());

        return entrada.stream()
                .map(numero -> DynamicTest.dynamicTest("Multiplicando: " + numero,
                        () -> {
                            assertEquals(calculadora.multiplica(numero, 2), result.get(numero));

                            }));

    }

}