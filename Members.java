import java.util.ArrayList;
public class Members {
    private ArrayList<BasicAccount> members;
    public Members(){
        ArrayList<BasicAccount> temp = new ArrayList<BasicAccount>();
        this.members = temp;
    }
    public void addMember(BasicAccount newMember){
        this.members.add(newMember);
    }
    public ArrayList<BasicAccount> getMembers(){
        return this.members;
    }
}
