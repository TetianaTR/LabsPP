package commands;

public class BuildReport implements Interface {
    @Override
    public ResultOfCommand<String> execute()  {
        System.out.println("Building report works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
