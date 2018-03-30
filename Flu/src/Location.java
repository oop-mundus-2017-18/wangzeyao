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


    public Location(int col, int row) {
        this.col = col;
        this.row = row;
    }

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

    void InitialLoc() {
        Random randomcol = new Random();
        int RandLocCol = randomcol.nextInt(World.getsize()[0]);
        this.col = RandLocCol + 1;
        Random randomrow = new Random();
        int RandLocRow = randomrow.nextInt(World.getsize()[1]);
        this.row = RandLocRow + 1;
    }

    boolean IsSame(Location location) {
        int rowin = location.getRow();
        int colin = location.getCol();
        if (this.row == rowin && this.col == colin) {
            return true;
        } else {
            return false;
        }
    }

    void ChangeLoc() {
        ChangeCol();
        ChangeRow();
        if (this.col > 3 || this.row > 3) {
            InitialLoc();
        }
    }

    void ChangeCol() {
        if (col == 1) {
            Random random = new Random();
            int proba = random.nextInt(2);
            if (proba == 0) {
                this.col++;
            }
        } else if (col == World.getsize()[0]) {
            Random random = new Random();
            int proba = random.nextInt(2);
            if (proba == 0) {
                this.col--;
            }
        } else {
            Random randcol = new Random();
            int rand = randcol.nextInt(3);
            switch (rand) {
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

    void ChangeRow() {
        if (row == 1) {
            Random rand1 = new Random();
            int rand1_1 = rand1.nextInt(2);
            if (rand1_1 == 0) {
                this.row++;
            }
        } else if (row == World.getsize()[1]) {
//            if (row == rowdownsize) {
                Random rand1 = new Random();
                int rand1_1 = rand1.nextInt(2);
                if (rand1_1 == 0) {
                    this.row--;
                }
            } else {
                Random randrow = new Random();
                int rand = randrow.nextInt(3);
                switch (rand) {
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
