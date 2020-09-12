import java.util.Scanner;
public class shot
{
    public static void  shot (String [] arg)
    {
        Board ();
        Scanner sc = new Scanner(System.in);
        System.out.print ("Input your x axis of your shoting: ");
        x =sc.nextInt();
        System.out.print ("Input your y axis of your shoting: ");
        y =sc.nextInt();
        Board[x][y]=0; 
        ship[x][y]=0;//From ship functtion
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (ship[i][j]==1)
                {
                    Board[i][j]=ship[i][j];
                }
                else if (ship[i][j]==0)
                {
                    Board[i][j]=0;
                }
            }
        }
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                i = y;
                j = x;
                if(Board[i][j]==1)
                {
                    System.out.print ("X");//X mean hit
                }
                else
                {
                    System.out.print ("*");//* mean miss
                }
            }
        }
    }

}
