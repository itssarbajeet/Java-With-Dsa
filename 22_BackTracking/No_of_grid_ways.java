//only right and downside movement is allowed in the grid
public class No_of_grid_ways {
    public static int Gridways(int i, int j, int row, int column){
        if(i==row-1 && j==column-1){
            return 1;
        }
        else if(i==row || j==column){
            return 0;
        }
        int way1=Gridways(i+1, j, row, column);// down step
        int way2=Gridways(i, j+1, row, column);// Right step
        return way1+way2;
    }
    public static void main(String[] args) {
        int column=4,row=4;
        System.out.println(Gridways(0, 0, row, column));
    }   
}
/*here the time complecity is expontial so we can convert 
this code to a math program and using permutaion and 
combination we can solve this problem with the formula [(m-1+n-1)!/(m-1)!(n-1)!] */