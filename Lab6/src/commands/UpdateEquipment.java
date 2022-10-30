package commands;

public class UpdateEquipment implements Interface {
    @Override
    public ResultOfCommand<String> execute()  {
        System.out.println("Update is successful!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
