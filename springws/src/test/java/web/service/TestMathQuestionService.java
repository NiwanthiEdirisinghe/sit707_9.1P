package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
    public void testTrueAdd() {
        Assert.assertEquals(3.0, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }
    
    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }
    
    @Test
    public void testAddBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }
    
    @Test
    public void testAddNumber1Invalid() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
    }
    
    @Test
    public void testAddNumber2Invalid() {
        Assert.assertNull(MathQuestionService.q1Addition("1", "xyz"));
    }
    
    @Test
    public void testAddBothNumbersInvalid() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "xyz"));
    }

    @Test
    public void testTrueSubtract() {
        Assert.assertEquals(6.0, MathQuestionService.q2Subtraction("10", "4"), 0);
    }

    @Test
    public void testSubtractNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "4"));
    }
    
    @Test
    public void testSubtractNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("10", ""));
    }
    
    @Test
    public void testSubtractBothNumbersEmpty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", ""));
    }
    
    @Test
    public void testSubtractNumber1Invalid() {
        Assert.assertNull(MathQuestionService.q2Subtraction("abc", "4"));
    }
    
    @Test
    public void testSubtractNumber2Invalid() {
        Assert.assertNull(MathQuestionService.q2Subtraction("10", "xyz"));
    }
    
    @Test
    public void testSubtractBothNumbersInvalid() {
        Assert.assertNull(MathQuestionService.q2Subtraction("abc", "xyz"));
    }
}
