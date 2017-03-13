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
public class NeuralNet {
    private List<Integer> NumberOfNeuronsOnLayerList;
    private List<List<Neuron>> NeuronLayersList;
    private int nubmerOfInputs;
    
    private void setLists() {
        this.NumberOfNeuronsOnLayerList = new LinkedList<>();
        this.NeuronLayersList = new LinkedList<>();
    }
    
    private void setNumberOfNeuronsForEachLayer() {
        this.NumberOfNeuronsOnLayerList.add(this.nubmerOfInputs);
        this.NumberOfNeuronsOnLayerList.add(40);
        this.NumberOfNeuronsOnLayerList.add(30);
        this.NumberOfNeuronsOnLayerList.add(10);
    }
    
    public void setNumberOfNeuronsForEachLayer(List<Integer> SizeOfLayersList) {        
        this.NumberOfNeuronsOnLayerList = SizeOfLayersList;
    }
    
    private List<Double> RandomList(int lenght) {
        List<Double> RandomList = new LinkedList<>();
        Random rand = new Random();
        
        for(int i = 0; i < lenght; i++) {
            RandomList.add(rand.nextDouble());
        }
        return RandomList;
    }
    
    private void addLayer(int layerSize, int neuronSize) { // random 
        List<Neuron> TempNeuronList = new LinkedList<>();
        
        for(int i = 0; i < layerSize; i++) {
            TempNeuronList.add(new Neuron(RandomList(neuronSize)));
        }
        
        NeuronLayersList.add(TempNeuronList);
    }
        
    public void setNetwork() {
        this.addLayer(this.NumberOfNeuronsOnLayerList.get(0),1);
        
        for(int i = 1; i < this.NeuronLayersList.size(); i++) {
            this.addLayer(this.NumberOfNeuronsOnLayerList.get(i),this.NumberOfNeuronsOnLayerList.get(i - 1));
        }
        
    }
    
    public void setNetwork(List<List<Neuron>> LayersList) {
        if(LayersList.isEmpty()) {
            throw new IllegalArgumentException("Some layer was empty");
        } else {
            this.NeuronLayersList = LayersList;
        }
        
    }
    
    public void setWeights(int whichLayer, List<List<Double>> Weights) { 
        List<Neuron> TempNeuronList = new LinkedList<>();
        
        this.NeuronLayersList.get(whichLayer).stream().forEach((Neuron neuron) -> {
            TempNeuronList.add(new Neuron(neuron));
        });
        
    }
    
    
    
    public void setWeights(List<Double> Weights) { 
        
    }
    
    public void setInputsOfNetwork() {
        
    }
    
    public void setInputsOfNetwork(List<Double> InputNetworkData) {
        
    }
    
    public NeuralNet() {
        this.setLists();
        this.setNumberOfNeuronsForEachLayer();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
