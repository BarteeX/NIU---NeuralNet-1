package neuralnet;

import static java.lang.Math.pow;
import java.util.LinkedList;
import java.util.List;

public final class Neuron {
    private List<Double> InputsList;
    private List<Double> WeightsList;
    private Double Bias, Sum, Output, Beta;
    private boolean sumWasCalculated, outputWasCounted;
    
       
    public void calculateSum() throws IllegalAccessException {
        if(this.InputsList.isEmpty() || this.WeightsList.isEmpty()) {
            throw new IllegalAccessException("Input of Weight list was empty");
        } else { 
            this.Sum = (double)this.Bias;
            
            for(int i = 0; i < getNumberOfSynapsys(); ++i) {
                this.Sum += (double)InputsList.get(i) * (double)WeightsList.get(i);  
            }
            
            this.sumWasCalculated = true;
        }
    }
    
    public void activateFunction() throws IllegalAccessException {
        if(this.sumWasCalculated) {
            this.Output = (double)(1/(1+ (double)pow(Math.E, -(double)this.Beta*(double)this.Sum)));
            this.outputWasCounted = true;
        } else {
            this.calculateSum();
            this.activateFunction();
        }
    }
    
    public Double getOutput() throws IllegalAccessException {
        if(this.outputWasCounted) {
           return (double)this.Output; 
        } else {
            this.activateFunction();
            return this.getOutput();
        }
    }
    
    public Double getSum() {
        if(this.sumWasCalculated) {
            return (double)this.Sum;
        } else {
            throw new IllegalAccessError("Sum was not calculated");
        }
    }
    
    public int getNumberOfSynapsys() {
        if(this.WeightsList.isEmpty()) {
            return 0;
        } else {
            return this.WeightsList.size(); // + 1 means Input0
        }
    }
    
    /**
     * 
     * @return value of bias synapse
     */
    public Double getBias() {
        return this.Bias;
    }
    
    /**
     * 
     * @return list of inputs each synapse
     */
    public List<Double> getInputs() {
        return this.InputsList;
    }
    
    /**
     * 
     * @return list of weights each synapse
     */
    public List<Double> getWeights() {
        return this.WeightsList;
    }
    
    private void setLists() {
        this.InputsList = new LinkedList<>();
        this.WeightsList = new LinkedList<>();
    }
    
    private void setDoubles() {
        this.Bias = 0.0d;
        this.Sum = 0.0d;
        this.Beta = 1.0d;
    }
    
    private void setBooleans() {
        this.outputWasCounted = false;
        this.sumWasCalculated = false;
    }
    
    private void setValues() {
        this.setLists();
        this.setDoubles();
        this.setBooleans();
    }
    
    /**
     * 
     * @param Input list of values for each synapses 
     */
    public void setInputs(List<Double> input) {
        this.InputsList = input;
    }
    
    /**
     * 
     * @param Input  list of weight for each synapses 
     */
    public void setWeights(List<Double> input) {
        this.WeightsList = input;
    }
    
    /**
     * 
     * @param Input value of Bias synapse 
     */
    public void setBias(Double input) {
        this.Bias = input;
    }
    
    /**
     * 
     * @param Input value of Beta for activation function
     */
    public void setBeta(Double input) { 
        this.Beta = input;
    }
    
    public void changeInput(int whichOne, Double input) {
        this.InputsList.set(whichOne, input);
    }
    
    public void changeWeight(int whichOne, Double weight){
        this.WeightsList.set(whichOne, weight);
    }
    
    public void changeBias(Double bias) {
        this.Bias = bias;
    }
    
    public void changeBeta(Double beta) {
        this.Beta = beta;
    }
    
    /**
     * Will set a basic values
     */
    public Neuron() {
        this.setValues();
    }
    
    public Neuron(List<Double> weightsList) {
        this();
        
        this.setWeights(weightsList);
    }
    
    public Neuron(List<Double> weightsList, List<Double> inputList) {
        this(weightsList);
        this.setInputs(inputList);
    }
    
    public Neuron(List<Double> weightsList, List<Double> inputList, Double bias) {
        this(weightsList, inputList);
        this.setBias(bias);
    }
    
    public Neuron(Neuron Neuron) {
        this(Neuron.getWeights(), Neuron.getInputs(), Neuron.getBias());
    }
}
