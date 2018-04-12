/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author JullianCockerell
 */
public class jGraph 
{
    private ArrayList<jProject> nodes = new ArrayList<jProject>();
    private HashMap<String, jProject> map = new HashMap<String, jProject>();
    
    public jProject getOrCreateNode(String name)
    {
        if(!map.containsKey(name))
        {
            jProject node = new jProject(name);
            nodes.add(node);
            map.put(name, node);
        }
        
        return map.get(name);
    }
    
    public void addEdge(String startS, String endS)
    {
        jProject start = getOrCreateNode(startS);
        jProject end = getOrCreateNode(endS);
        start.addEdge(end);
    }
    
    public ArrayList<jProject> getNodes() {return nodes;}
}
