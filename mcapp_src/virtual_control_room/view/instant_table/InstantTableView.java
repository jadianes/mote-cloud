/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InstantTableView.java
 *
 * Created on 18-oct-2009, 16:19:10
 */

package virtual_control_room.view.instant_table;

import java.util.Hashtable;
import samples.Sample;

/**
 *
 * @author JA Dianes
 */
public class InstantTableView extends javax.swing.JTable implements
        virtual_control_room.view.View {

    int vbleCount = -1;
    int moteID;
    static double lastTemp0;
    Hashtable<String,Integer> variables = new Hashtable();
    
    /** Creates new form InstantTableView */
    public InstantTableView(int moteID) {
        initComponents();
        initComponents2();
        this.moteID = moteID;
        this.setValueAt("Variable",0,0);
        this.setValueAt("Value",0,1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents2() {
        setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Variable", "Value"
            }
        ));
        getTableHeader().setReorderingAllowed(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    // Add row if necessary
    public void showSample(Sample s) {
        int row;
        if (variables.containsKey(s.key)) {
            row = ((Integer)variables.get(s.key)).intValue()+1;
         // System.out.println("InstantTableView.showSample(): showing existing value "+s.key+" in row "+row);
        } else {
            vbleCount++;
            variables.put(s.key, new Integer(vbleCount));
            row = vbleCount+1;
         // System.out.println("InstantTableView.showSample(): showing new value "+s.key+" in row "+row);
        }
        this.setValueAt(s.key,row,0);
        this.setValueAt(s.getValue(),row,1);
        lastTemp0 = ((Double)s.getValue()).doubleValue();
      //System.out.println("InstantTableView.showSample(): lastTempo0 set to "+lastTemp0);
    }

    public static int add(String x, String y) {
      int a = 0;
      int b = 0;
      try {
        a = Integer.parseInt(x);
        b = Integer.parseInt(y);
      }catch(Exception e) {}
      return a + b;
   }

   public static double getTemp(String i) {
       return lastTemp0;
   }

}
