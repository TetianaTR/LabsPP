package commands;

public class LogOut implements Interface {
    @Override
    public ResultOfCommand<String> execute()   {
        System.out.println("Succeeded!You logged out");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
