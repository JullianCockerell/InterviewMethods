/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;

/**
 *
 * @author JullianCockerell
 */
public class binTreeNode 
{
    public int value;
    public binTreeNode left, right;
    
    public binTreeNode(int val)
    {
        value = val;
        left = null;
        right = null;
    }
    
    public binTreeNode()
    {
        left = null;
        right = null;
    }
    
}
