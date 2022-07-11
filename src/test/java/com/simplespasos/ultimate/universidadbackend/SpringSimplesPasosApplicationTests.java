package com.simplespasos.ultimate.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringSimplesPasosApplicationTests {

    Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("Suma valor A y valor B")
    void sumaDeValores() {
        //given
        int valorA = 4;
        int valorB = 6;

        //when
        int expectativa = calculadora.sumar(valorA, valorB);

        //then
        int resultadoEsperado = 10;

        assertThat(expectativa).isEqualTo(resultadoEsperado);
    }

    @Test
    @Disabled("Test deprecado")
    void testDesactivado(){

    }

    class Calculadora{
        int sumar(int valor_a, int valor_B){
            return valor_a + valor_B;
        }
    }

}
