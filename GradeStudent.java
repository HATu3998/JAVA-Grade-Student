import java.util.Scanner;

public class GradeStudent {
    public static void main(String[] args){
        new Scanner(System.in);
        begin();
        double[] midTerm= midTerm();
        double[] Final= Final(midTerm);
        double[] Homework= Homework(midTerm,Final);
        report(midTerm,Final,Homework);


}
public static void begin(){
    System.out.println("This program reads exam/homework scores and reports your overall course grade");
}

 public static double[] midTerm() {
        Scanner myScanner = new Scanner(System.in);
        double we;
        int poin;
        int option;
        int poin2;
        double tb;
        double[] array= new double[5];

        System.out.println("Midterm: ");

      System.out.print("Weight (0-100): ");
        we =myScanner.nextInt();
//vòng lặp điều kiện điểm không lớn hơn 100
do {
    System.out.print("Score earned(0-100): ");
    poin = myScanner.nextInt();
}while(poin > 100 || poin < 0);
//chọn 1,2 để tăng điểm thi
      do{  System.out.println("Were scores shifted (1 = yes, 2=no): ");
          option= myScanner.nextInt();}
      while(option !=1 && option !=2);
        if (option == 1){
            System.out.print("Shift amount:  ");
            poin2= myScanner.nextInt();
            poin=poin+poin2;
            if(poin > 100){
                poin =100;
                System.out.println("Nếu Score earned + Shift amount lớn hơn 100 thì Total points là 100 ");
            System.out.println("Total points: " +(double) Math.round(poin*10)/10 +"/100"); }
            else{
                System.out.println("Total points: " + (double) Math.round(poin*10)/10+"/100");
            }
        } else if(option ==2){
            System.out.println("Total points: " +(double) Math.round(poin*10)/10+"/100");
        }
        //số điểm dựa trên trọng số
     tb=((double)poin/100)*we;
     System.out.println(" weighted score midTerm " +(double) Math.round(tb*10)/10 +"/"+ we);
     //đặt trọng số và điểm vào mảng trả về
        array[0]=tb;
        array[1]=we;
 return array ;

 }
    public static double[] Final(double[] midTerm) {
        Scanner myScanner = new Scanner(System.in);
        double we;
        int poin;
        int option;
        int  poin2;
        double tb;
        double[] array= new double[5];
        double weFinal=0;

        System.out.println(" -------------------------------------" );
        System.out.println("Final: ");
do {
    System.out.print("Weight (0-100): ");
    we = myScanner.nextInt();
    if (we+midTerm[1]>100){
        System.out.println("Tỷ trọng Midterm và Final lớn hơn 100, mời bạn nhập lại: ");

    }
}while(we+midTerm[1]>100);

        do {
            System.out.print("Score earned(0-100): ");
            poin = myScanner.nextInt();
        }while(poin > 100 || poin < 0);
        do{  System.out.println("Were scores shifted (1 = yes, 2=no): ");
            option= myScanner.nextInt();}
        while(option !=1 && option!=2);
        if (option == 1){
            System.out.print("Shift amount:  ");
            poin2= myScanner.nextInt();
            poin=poin+ poin2;
            if(poin > 100){
                poin =100;
                System.out.println("Nếu Score earned + Shift amount lớn hơn 100 thì Total points là 100 ");
                System.out.println("Total points: " + (double) Math.round(poin*10)/10+"/100"); }
            else{
                System.out.println("Total points: " +(double) Math.round(poin*10)/10+"/100" );
            }
        } else if(option ==2){
            System.out.println("Total points: " +(double) Math.round(poin*10)/10+"/100");
        }
        tb=((double)poin/100)*we;
        System.out.println(" weighted score Final " +(double) Math.round(tb*10)/10+"/"+we);
      array[0]=tb;
        array[1]=we;


        return array ;
    }
    public static double[] Homework(double[] midTerm,double[] Final) {
        Scanner myScanner = new Scanner(System.in);
      double we;

        int scan,attend;

        double points;
        double[] array= new double[5]; int sum=0;

        double  total=0;
        double  tempMyMax=0;
        System.out.println(" -------------------------------------" );
        System.out.println("Homework: ");
        we =100- (midTerm[1]+Final[1]);
        System.out.println("Weight (0-100): "+we);

        System.out.println("Number of assignments: "); int assign=myScanner.nextInt();
        double[] myPoin= new double[assign];
        double[] myMax= new double[assign];
      System.out.println("Nhập score và max , max không được nhỏ hơn score : ");
      //dùng vòng lặp để nhập số bải tập
        for (int i = 0; i < assign; i++) {
        do {
           System.out.print("Assignment " + (i + 1) + " score  :");
                myPoin[i] = myScanner.nextDouble();
                System.out.print("Assignment " + (i + 1) + " max : ");
                myMax[i] = myScanner.nextDouble();

            }
            while (myPoin[i] > myMax[i]) ;
        }
      //tính tổng số điểm trong mảng
    for(int i=0; i<myPoin.length; i++){
            total = total + myPoin[i];
            tempMyMax += myMax[i];
        }
//tính chuyên cần
        System.out.print("How many sections did you attend: ");scan = myScanner.nextInt();
        attend=scan*5;
       if(attend > 30){
           attend=30;
       }
        System.out.println("Section points: " + attend+"/30" );

        if(total > 150){
            total= 150;
            System.out.println("Total points: " +(double) Math.round(total*10)/10+"/"+tempMyMax);
        }else {
            System.out.println("Total points: " + (double) Math.round(total*10)/10+"/"+tempMyMax);
        }
        points=(double)(( total+attend)/(tempMyMax +30))*we;
        System.out.println(" weighted score Homework " + (double) Math.round(points*10)/10+"/"+we);

   array[0]= points;
        array[1]=we;
 return array ;
    }
    public static void  report(double[] midTerm,double[] Final, double[] Homework){

        double sum= midTerm[0]+Final[0] +Homework[0];
        System.out.println(" -------------------------------------" );
        System.out.println(" weighted score midTerm " + midTerm[0]);
        System.out.println(" weighted score Final " +Final[0]);
        System.out.println(" weighted score Homework " + (double) Math.round(Homework[0] * 10) / 10);
        System.out.println(" weighted score  " + (double) Math.round(sum * 10) / 10);
        if (sum >= 85){
            System.out.println("Your grade will be at least: 3.0" );
            System.out.println("Học sinh giỏi" );
        }else if(sum >= 75 && sum <85){
            System.out.println("Your grade will be at least: 2.0" ); ;
            System.out.println("Học sinh khá" );
        }else if(sum >= 60 && sum <75){
            System.out.println("Your grade will be at least: 1.0" );
            System.out.println("Học sinh tiên tiến" );
        } else {
            System.out.println("Your grade will be at least: 0.0" );
            System.out.println("Học sinh trung bình, cần cố gắng hơn" );
        }
    }

}
