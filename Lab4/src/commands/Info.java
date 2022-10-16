package commands;
public class Info implements Interface {
    @Override
    public ResultOfCommand<String> execute()  {
        System.out.println("Info works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
