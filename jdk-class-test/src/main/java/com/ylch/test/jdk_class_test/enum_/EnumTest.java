package com.ylch.test.jdk_class_test.enum_;

/**
 * Created by yanglaichang1 on 2017/11/8.
 */
public enum  EnumTest {

    D1(new Demo() {
            public void test(String msg) {
                System.out.println("===========" + msg);
            }
    }),
    D2(new Demo() {
        public void test(String msg) {
            System.out.println("===========" + msg);
        }
    });

    private Demo demo;

     EnumTest(Demo demo){
        this.demo = demo;
    }

    public Demo getDemo() {
        return demo;
    }

   /* public void setDemo(Demo demo) {
        this.demo = demo;
    }*/

    public static void main(String[] args) {
        Demo demo = EnumTest.D1.demo;
        Demo demo2 = EnumTest.D1.demo;
        System.out.println(demo+"=="+demo2);
      /*  EnumTest[] values = EnumTest.values();
        for(EnumTest test : values){
            test.setDemo(new Demo() {
                public void test(String msg) {

                }
            });
        }*/

        Demo demo11 = EnumTest.D1.demo;
        Demo demo33 = EnumTest.D1.demo;
        System.out.println(demo11+"--"+demo33);


      /*  Demo demo22 = EnumTest.D2.demo;*/
       /* System.out.println(demo);
        System.out.println(demo.equals(demo2));
        System.out.println(demo2);
        System.out.println(demo22);*/
    }


}
