/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Martic
 */
public class NeuralNetwork {
    private List<Neuron> inputLayersList;
    private List<Neuron> hiddenLayer1; 
    private List<Neuron> hiddenLayer2; 
    private List<Neuron> hiddenLayer3; 
    private List<Neuron> outputLayerList;
    
    private List<Double> outputDataInputLayerList;
    private List<Double> outputDataHiddenLayer1List;
    private List<Double> outputDataHiddenLayer2List;
    private List<Double> outputDataHiddenLayer3List;
    private List<Double> outputDataOutputLayerList;
    
    private int numberOfInputs;
    private int numberOfOutputs;
    
    private List<Integer> hiddenSizesList;
    private List<Double> inputDataList;
    private List<Double> outputDataList;
    
    private List<Double> randomList(int lenght) {
        List<Double> RandomList = new LinkedList<>();
        Random rand = new Random();
        
        for(int i = 0; i < lenght; i++) {
            RandomList.add(rand.nextDouble());
        }
        return RandomList;
    }
    
    private List<Neuron> Layer(int neuronSize, int numberOfNeurons) {
        List<Neuron> toReturn = new LinkedList<>();
        
        for(int i = 0; i < numberOfNeurons; i++) {
            toReturn.add(new Neuron(this.randomList(neuronSize)));
        }
        
        return toReturn;
    }
    
    private void setInputLayer() {
        List<Double> oneElement = new LinkedList<>();
        oneElement.add(1d);
        
        for(int i = 0; i < this.numberOfInputs; i++) {
            this.inputLayersList.add(new Neuron(oneElement));
        }
    }
    
    private void setHiddenLayers() {        
        this.hiddenLayer1 = (Layer(this.numberOfInputs, this.hiddenSizesList.get(0)));
        this.hiddenLayer2 = (Layer(this.hiddenSizesList.get(0), this.hiddenSizesList.get(1)));
        this.hiddenLayer3 = (Layer(this.hiddenSizesList.get(1), this.hiddenSizesList.get(2)));
    }
    
    private void setOutputLayer() {
        this.outputLayerList = Layer(this.hiddenSizesList.get(2), this.numberOfOutputs);
    }
    
    private List<Neuron> setWeightsOnLayer(List<Neuron> toChangeList, List<List<Double>> weightsList) {
        Neuron tempNeuron;
        List<Neuron> tempNeuronList = toChangeList;
        for(int i = 0; i < tempNeuronList.size(); i++) {
            tempNeuron = tempNeuronList.get(i);
            tempNeuron.setWeights(weightsList.get(i));
            tempNeuronList.set(i, tempNeuron);
        }
        return toChangeList;
    }
    
    public void setWeights(int whichLayer, List<List<Double>> weightsList) {
        switch (whichLayer) {            
            case 2:
                // 2 - means number of layer
                this.hiddenLayer1 = setWeightsOnLayer(this.hiddenLayer1, weightsList);
                break;
            
            case 3:
                this.hiddenLayer2 = setWeightsOnLayer(this.hiddenLayer2, weightsList);
                break;
            
            case 4:
                this.hiddenLayer3 = setWeightsOnLayer(this.hiddenLayer3, weightsList);
                break;
            
            case 5:
                this.outputLayerList = setWeightsOnLayer(this.outputLayerList, weightsList);
                break;
                
            case 1:
                // 1 - means first layer
                throw new IllegalArgumentException("Can't change weghts of 1. layer");
            
            default:
                throw new IllegalArgumentException("Layer" + whichLayer + "doesn't exist");
        }
    }
    
   public void setInputData(List<Double> inputDataList) {
       this.inputDataList = new LinkedList<>(inputDataList);
   }
   
   public List<Double> getInputData() {
       return this.inputDataList;
   }
   
   
   public void makeImpulse() throws IllegalAccessException {
       Neuron tempNeuron;
       
       for(int i = 0; i < this.numberOfInputs; i++) {
           List<Double> oneElemntList = new LinkedList<>();
           oneElemntList.add(this.inputDataList.get(i));
           
           tempNeuron = this.inputLayersList.get(i);
           tempNeuron.setInputs(oneElemntList);
           tempNeuron.calculateSum();
           tempNeuron.activateFunction();
           this.inputLayersList.set(i, tempNeuron);
       }
       
       
       
   }
    
    public NeuralNetwork(int numberOfInputs, int numberOfOutputs) {
        this.hiddenSizesList = new LinkedList<>();        
        this.hiddenSizesList.add(80);
        this.hiddenSizesList.add(70);
        this.hiddenSizesList.add(60);
        
        this.inputLayersList = new LinkedList<>();
        this.hiddenLayer1 = new LinkedList<>();
        this.hiddenLayer2 = new LinkedList<>();
        this.hiddenLayer3 = new LinkedList<>();
        this.outputLayerList = new LinkedList<>();
        
        this.numberOfInputs = numberOfInputs;
        this.numberOfOutputs = numberOfOutputs;
        
        this.inputDataList = new LinkedList<>();
        this.outputDataList = new LinkedList<>();
        
        this.outputDataInputLayerList = new LinkedList<>();
        this.outputDataHiddenLayer1List = new LinkedList<>();
        this.outputDataHiddenLayer2List = new LinkedList<>();
        this.outputDataHiddenLayer3List = new LinkedList<>();
        this.outputDataOutputLayerList = new LinkedList<>();
        
        setInputLayer();
        setHiddenLayers();
        setOutputLayer();
    }
}
