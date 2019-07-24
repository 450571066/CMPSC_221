/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;
import javax.swing.JOptionPane;
/**
 *
 * @author Tianqi
 */
public class java {
     public static void main(String[] args) {
        // TODO code application logic here
          // Define variable, object   
          Object[] possibleValues = { "First是", "Second石", "Third屎" };//下拉框的选项
Object selectedValue = JOptionPane.showInputDialog(null, 
"Choose one", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
possibleValues, possibleValues[0]);

System.out.println(selectedValue);
     }
 /**
     Object[] options ={ "必须是", "当然是" };  //自定义按钮上的文字
int m = JOptionPane.showOptionDialog(null, "钓鱼岛是中国的吗？", "标题",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
     
     System.out.println(m);
         */
     }
     

