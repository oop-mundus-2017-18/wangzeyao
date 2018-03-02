import com.sun.javafx.geom.transform.BaseTransform;

import java.util.Random;

/**
 * @Author: WANG ZEYAO
 * @Description:
 * @Date: 2018/2/23  10:37
 * @ProjectName: Flu
 * @Version: 1.0
 */
public class Location {
    int col;
    int row;
//    int [][] location = new int[1000][1000];


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    void InitialLoc(){
       Random randomcol = new Random();
       int RandLocCol = randomcol.nextInt(1001);
       this.col = RandLocCol;
       Random randomrow = new Random();
       int RandLocRow = randomrow.nextInt(1001);
       this.row = RandLocRow;
   }
   void ChangeLoc(){
        ChangeCol();
        ChangeRow();
   }
   void ChangeCol(){
       if (col ==1) {
           Random rand1 = new Random();
           int rand1_1 = rand1.nextInt(2);
           if (rand1_1 == 0)
           {
               this.col = 2;
           } else if (rand1_1 == 1)
           { }
       } else {
           Random randcol = new Random();
           int rand = randcol.nextInt(3);
           switch (rand){
               case 0:
                   this.col--;
                   break;
               case 1:
                   this.col++;
                   break;
               case 2:
                   break;
           }
       }
   }
    void ChangeRow(){
       if (row ==1) {
           Random rand1 = new Random();
           int rand1_1 = rand1.nextInt(2);
           if (rand1_1 == 0)
           {
               this.row = 2;
           } else if (rand1_1 == 1)
           { }
       } else{
           Random randrow = new Random();
           int rand = randrow.nextInt(3);
           switch (rand){
               case 0:
                   this.row--;
                   break;
               case 1:
                   this.row++;
                   break;
               case 2:
                   break;
           }
       }
   }
}
