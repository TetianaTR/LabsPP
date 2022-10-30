package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;

import java.util.ArrayList;

public class BuildReport implements Interface {
    private KnightInfo knight;
    private ArrayList<EquipList> equipLists;
    private ArrayList<WeaponList> weaponLists;
    @Override
    public ResultOfCommand<String> execute()  {
        for(int i=0;i<knight.getsize();i++) {
            System.out.println(knight.getknight(i).toString(i));
            if (i<equipLists.size() && equipLists.get(i).getsize() != 0 ) {
                System.out.println("Your knight equipment:");
                equipLists.get(i).printList();
            }
            if (i<weaponLists.size() && weaponLists.get(i).getsize() != 0) {
                System.out.println("Your knight weapon :");
                weaponLists.get(i).printList();
            }
        }
        System.out.println("Building report works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
    public BuildReport(KnightInfo knight, ArrayList<EquipList> equipLists, ArrayList<WeaponList> weaponLists){
                this.knight=knight;
                this.equipLists=equipLists;
                this.weaponLists=weaponLists;
            }
}

