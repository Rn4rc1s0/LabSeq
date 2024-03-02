package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LabSeqServiceTest {

    private LabSeqService service;

    @BeforeEach
    void setUp() {
        service = new LabSeqService();
    }

    @Test
    void testInitialValues() {
        assertEquals(0, service.calculateLabSeq(0), "Initial value at index 0 should be 0");
        assertEquals(1, service.calculateLabSeq(1), "Initial value at index 1 should be 1");
        assertEquals(0, service.calculateLabSeq(2), "Initial value at index 2 should be 0");
        assertEquals(1, service.calculateLabSeq(3), "Initial value at index 3 should be 1");
    }

    @Test
    void testCachingMechanism() {
        int initialValue = service.calculateLabSeq(10);
        int cachedValue = service.calculateLabSeq(10);
        assertEquals(initialValue, cachedValue, "Caching mechanism does not work as expected.");
    }

    @Test
    void testSequenceCalculation() {
        assertEquals(1, service.calculateLabSeq(4), "The sequence value at index 4 should be 1");
        assertEquals(2, service.calculateLabSeq(8), "The sequence value at index 8 should be 2.");
    }

    @Test
    void testLargeValue() {
        assertDoesNotThrow(() -> service.calculateLabSeq(100), "Method should handle large input values without throwing exceptions");
    }

    @Test
    public void testNegativeIndexHandling() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateLabSeq(-1), "Method should throw IllegalArgumentException for negative indexes.");
    }

    @Test
    public void testLargeValueHandling() {
        assertDoesNotThrow(() -> service.calculateLabSeq(1000), "Method should handle large values without throwing exceptions.");
    }
}
