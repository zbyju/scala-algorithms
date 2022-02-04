package `data-structure`.math.complex

import org.junit.Test
import org.junit.Assert.*

class ComplexTest {
    @Test def constructor = {
        assertEquals(1, Complex(1, 0).re, 0.01)
        assertEquals(0, Complex(1, 0).im, 0.01)
        assertEquals(1, Complex(1, 1).re, 0.01)
        assertEquals(1, Complex(1, 1).im, 0.01)
    }

    @Test def unaryMinus = {
        assertEquals(-1, -Complex(1, 0).re, 0.01)
        assertEquals(0, -Complex(1, 0).im, 0.01)
        assertEquals(-1, -Complex(1, 1).re, 0.01)
        assertEquals(-1, -Complex(1, 1).im, 0.01)
    }

    @Test def abs2 = {
        assertEquals(1, Complex(1, 0).abs2, 0.01)
        assertEquals(25, Complex(3, 4).abs2, 0.01)
    }

    @Test def abs = {
        assertEquals(1, Complex(1, 0).abs, 0.01)
        assertEquals(5, Complex(3, 4).abs, 0.01)
    }
    
    @Test def inverse = {
        assertEquals(Complex(0.5, -0.5), Complex(1, 1).inverse)
        assertEquals(Complex(1, 1), Complex(0.5, -0.5).inverse)
    }

    @Test def plus = {
        assertEquals(Complex(6, 4), Complex(1, 3) + Complex(5, 1))
        assertEquals(Complex(1, 3), Complex(1, 3) + Complex(0, 0))
        assertEquals(Complex(1, 3), Complex(0, 0) + Complex(1, 3))
        assertEquals(Complex(0, 0), Complex(0, 0) + Complex(0, 0))
    }

    @Test def minus = {
        assertEquals(Complex(-4, 2), Complex(1, 3) - Complex(5, 1))
        assertEquals(Complex(1, 3), Complex(1, 3) - Complex(0, 0))
        assertEquals(Complex(-1, -3), Complex(0, 0) - Complex(1, 3))
        assertEquals(Complex(0, 0), Complex(0, 0) - Complex(0, 0))
    }

    @Test def multiply = {
        assertEquals(Complex(2, 16), Complex(1, 3) * Complex(5, 1))
    }
}
