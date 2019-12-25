import java.time.LocalDate;

/**
 * 指定された年の間でうるう年の年を出力する
 * @author hysmo1988
 *
 */
public class Main
{
	boolean flg = false;
    public static void main(String[] args) {
        int y1=645,y2=2300;

        // 1年ずつ判定(再帰的関数)
        long startTime1 = System.currentTimeMillis();
        new Main().leapYear(y1,y2);
        long endTime1 = System.currentTimeMillis();
        System.out.println("------");

        // 4年おきに判定
        long startTime2 = System.currentTimeMillis();
        new Main().leapYear2(y1,y2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("------");

        System.out.println("処理時間1：" + (endTime1 - startTime1) + " ms");
        System.out.println("処理時間2：" + (endTime2 - startTime2) + " ms");
    }

    private void leapYear(int y1,int y2) {
        if(y1>y2) {if(!flg) System.out.println("うるう年なし");return;}
        if(LocalDate.of(y1, 2, 1).isLeapYear()) {
        	flg = true;
            System.out.println(y1+"年");
        }
        leapYear(++y1,y2);
    }

    private void leapYear2(int y1,int y2) {
        int ly = -1;
        for(int i=y1;i<=y2;i++) {
            if(LocalDate.of(i, 2, 1).isLeapYear()) {ly=i;break;}
        }
        if(ly==-1) {System.out.println("うるう年なし");return;}
        for(int i=ly;i<=y2;i+=4) {
            //西暦年号が100で割り切れて400で割り切れない年は平年
            if(i%100==0&&i%400!=0)continue;
            System.out.println(i+"年");
        }
    }
}