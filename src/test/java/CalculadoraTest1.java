import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest1 {
    @TestFactory
    Stream<DynamicTest> dynamicTestFromStreamInJava8() {
        Calculadora calculadora = new Calculadora();

        List<Integer> entrada = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> result = IntStream.range(0, 1000).map(n -> n - 1).boxed().collect(Collectors.toList());

        return entrada.stream()
                .map(numero -> DynamicTest.dynamicTest("Restando: " + numero,
                        () -> {
                            assertEquals(calculadora.resta(numero, 1), result.get(numero));

                        }));

    }

}