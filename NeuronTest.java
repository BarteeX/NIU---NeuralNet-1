/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.pow;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import neuralnet.Neuron;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Martic
 */
public class NeuronTest {
    
    Neuron neuron; 
    
    public NeuronTest() {
        neuron = new Neuron();
    }
    
    
    @Test
    public void setInputTest() {
        List<Double> TestList = new LinkedList<>();
        TestList.add(1.0);
        TestList.add(0.0);
        TestList.add(1.0);
        neuron.setInputs(TestList);
        
        Assert.assertEquals(TestList, neuron.getInputs());
    }
    
    @Test 
    public void setWeightsTest() {
        List<Double> TestList = new LinkedList<>();
        
        TestList.add(-1.66666);
        TestList.add(0.6324215);
        TestList.add(1.2135125612616236216);
        
        neuron.setWeights(TestList);
        
        Assert.assertEquals(TestList, neuron.getWeights());
    }
    
    @Test 
    public void setBiasTest() {
        neuron.setBias(-1.5);
        Assert.assertEquals(-1.5,(double)neuron.getBias());
    }
    
    @Test
    public void getNumberOfSynapsysTest() {
        List<Double> TestList = new LinkedList<>();
        TestList.add(1.0);
        TestList.add(0.0);
        TestList.add(1.0);
        neuron.setWeights(TestList);
        
        Assert.assertEquals(3, this.neuron.getNumberOfSynapsys());
    }
    
    @Test
    public void calculateSumTest() throws IllegalAccessException {
        List<Double> TestInputs = new LinkedList<>();
        
        TestInputs.add((double)1.0);
        TestInputs.add((double)0.0);
        TestInputs.add((double)1.0);
        
        neuron.setInputs(TestInputs);
        
        List<Double> TestWeights = new LinkedList<>();
        
        TestWeights.add((double)-1.6);
        TestWeights.add((double)0.6);
        TestWeights.add((double)1.4);
        
        neuron.setWeights(TestWeights);
        
        this.neuron.calculateSum();
        
        Double calculatedSum = this.neuron.getSum();
        
        Assert.assertTrue(Math.abs(calculatedSum + 0.2) < Math.pow(10, -8));
    }
    
    @Test
    public void activateFunctionTest() throws IllegalAccessException {
        List<Double> WeightsTestList = new LinkedList<>();
        WeightsTestList.add(1.0);
        WeightsTestList.add(0.0);
        WeightsTestList.add(1.0);
        
        List<Double> InputTestList = new LinkedList<>();
        InputTestList.add(3.0);
        InputTestList.add(-0.123);
        InputTestList.add(-30.3);
        
        Neuron TestNeuron = new Neuron(WeightsTestList, InputTestList, (double)0);
        
        TestNeuron.activateFunction(); 
        
        Double TestNeuronOutput = TestNeuron.getOutput();
        Double ExpectetValueOfActivation = (1/(1+ (double)pow(Math.E, -1.0*TestNeuron.getSum())));
        
        Assert.assertTrue(Math.abs(TestNeuronOutput - ExpectetValueOfActivation) < Math.pow(10, -10));    
        Assert.assertEquals((double)TestNeuronOutput, (double)ExpectetValueOfActivation);
    }
}
