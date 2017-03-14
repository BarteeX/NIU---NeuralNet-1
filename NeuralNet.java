/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Martic
 */
public class NeuralNet {
    
    
    public static void main(String[] args) throws IllegalAccessException {
        NeuralNetwork net = new NeuralNetwork(25, 10);
        
        List<Double> inputDataList = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            inputDataList.add((double)i);
        }
        net.setInputData(inputDataList);
        
        net.makeImpulse();
    }
    
}
