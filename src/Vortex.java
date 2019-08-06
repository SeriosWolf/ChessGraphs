import java.util.ArrayList;
import java.util.List;

public class Vortex {
    public ArrayList<Integer> vortexHead = new ArrayList<Integer>();
    public ArrayList<Vortex> vortexList = new ArrayList<Vortex>();

    public static int counter = 0;
    public static List<Vortex> vList = new ArrayList<Vortex>();

    public Vortex (ArrayList<Integer> vortexHead, ArrayList<Vortex> vortexList)
    {
        this.vortexHead = vortexHead;
        this.vortexList = vortexList;
        Vortex.vList.add(this);
        Vortex.counter++;
    }

    public void addVortex(Vortex v){
        this.vortexList.add(v);
    }

}
