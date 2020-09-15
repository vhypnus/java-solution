package org.monan.common;

public class BlockArrayListSample {

    private static BlockingArrayList list = new BlockingArrayList(10);

    static class P implements Runnable {

        public void run() {
            for (int i  = 0 ; i < 200 ;i ++) {
                while(true){
                    try{
                        list.add(i);
                        break ;
                    } catch(Exception e) {
                        try {
                            Thread.sleep(1000l);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }


            }
            System.out.println("");
            System.out.println("producer out.");

        }
    }

    static class C implements Runnable {
        public void run() {
            while(true) {
                Object o = list.poll() ;
                if (o == null ){
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(o+" ") ;
                }

            }

        }
    }

    public static void main(String[] args) {
        Thread p = new Thread(new P()) ;
        Thread c = new Thread(new C()) ;

        p.start();
        c.start();
    }

}
