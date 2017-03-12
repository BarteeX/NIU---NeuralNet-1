/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Martic
 */
public class NeuralNet {
    private List<Integer> NumberOfNeuronsOnLayerList;
    private List<List<Neuron>> NeuronLayersList;
    private int nubmerOfInputs;
    
    private void setNumberOfNeuronsForEachLayer() {
        NumberOfNeuronsOnLayerList = new LinkedList<>();
        
        this.NumberOfNeuronsOnLayerList.add(4);
        this.NumberOfNeuronsOnLayerList.add(5);
        this.NumberOfNeuronsOnLayerList.add(2);
    }
    
    public void setNumberOfNeuronsForEachLayer(int first, int second, int third) {
        NumberOfNeuronsOnLayerList = new LinkedList<>();
        
        this.NumberOfNeuronsOnLayerList.add(first);
        this.NumberOfNeuronsOnLayerList.add(second);
        this.NumberOfNeuronsOnLayerList.add(third);
    }
    
    private List<Double> RandomList(int lenght) {
        List<Double> RandomList = new LinkedList<>();
        Random rand = new Random();
        for(int i = 0; i < lenght; i++) {
            RandomList.add(rand.nextDouble());
        }
        return RandomList;
    }
    
    private void addLayer(int layerSize) { // random 
        List<Neuron> TempNeuronList = new LinkedList<>();
        
        for(int i = 0; i < layerSize; i++) {
            TempNeuronList.add(new Neuron(RandomList(this.nubmerOfInputs)));
        }
    }
    
    public void setNetwork() {
        this.setNumberOfNeuronsForEachLayer();
        
        boolean first = true;
        
        NumberOfNeuronsOnLayerList.stream().forEach((Integer limit) -> {
            if(!first) {
                for(int i = 0; i < limit; i++) {
                    TempNeuronList.add(new Neuron(RandomList(this.nubmerOfInputs)));
                }
                NeuronLayersList.add(TempNeuronList);
                TempNeuronList.clear();
            }
        });
        
        this.LayerOfNeurons1 = new LinkedList<>();
        for(int i = 0; i < this.numbOfNeuronsAtFirstLayer; i++) {
            this.LayerOfNeurons1.add(new Neuron());
        }
        
        this.LayerOfNeurons2 = new LinkedList<>();
        for(int i = 0; i < this.numbOfNeuronsAtSecondLayer; i++) {
            this.LayerOfNeurons2.add(new Neuron());
        }
        
        this.LayerOfNeurons3 = new LinkedList<>();
        for(int i = 0; i < this.numbOfNeuronsAtThridLayer; i++) {
            this.LayerOfNeurons3.add(new Neuron());
        }
    }
    
    public void setNetwork(List<List<Neuron>> LayersList) {
        if(FirstLayer.isEmpty() || SecondLayer.isEmpty() || ThirdLayer.isEmpty()) {
            throw new IllegalArgumentException("Some layer was empty");
        } else {
            this.setNumberOfNeuronsForEachLayer(FirstLayer.size(), SecondLayer.size(), ThirdLayer.size());

            this.LayerOfNeurons1 = new LinkedList<>();
            this.LayerOfNeurons1 = FirstLayer;

            this.LayerOfNeurons2 = new LinkedList<>();
            this.LayerOfNeurons2 = SecondLayer;

            this.LayerOfNeurons3 = new LinkedList<>();
            this.LayerOfNeurons3 = ThirdLayer;
        }
        
    }
    
    public void setWeights(int whichLayer, List<List<Double>> Weights) { 
        List<Neuron> TempNeuronList = new LinkedList<>();
        
        switch(whichLayer) {
            case 1: 
                LayerOfNeurons1.stream().forEach((Neuron Neuron) -> {
                   
                    TempNeuronList.add(Neuron);
                });
                break;
                
            case 2:
                
                break;
            case 3:
                
                break;
            default:
                throw new IllegalArgumentException("Secected layer doesn't exist");
        }
    }
    
    
    
    public void setWeights(List<Double> Weights) { 
        
    }
    
    public void setInputsOfNetwork() {
        
    }
    
    public void setInputsOfNetwork(List<Double> InputNetworkData) {
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
