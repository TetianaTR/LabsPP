package commands;

public class CalculateData implements Interface {
    @Override
    public ResultOfCommand<String> execute() {
        System.out.println("Calculating data works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
