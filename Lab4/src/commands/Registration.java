package commands;

public class Registration implements Interface {

    @Override
    public ResultOfCommand<String> execute() {
        System.out.println("You are registered!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
