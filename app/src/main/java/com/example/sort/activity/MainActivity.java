package com.example.sort.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Debug;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sort.ArrayDep;
import com.example.sort.R;
import com.example.sort.Sort;
import com.example.sort.bitset.FindNum;
import com.example.sort.string.StringDeal;

import java.util.BitSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    public static class MyThreadFactory implements ThreadFactory {
        private String mName = "";
        public void setThreadName(String name) {
            mName = name;
        }
        private AtomicInteger atomicInteger = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, mName + atomicInteger.getAndIncrement());
        }
    }
    MyThreadFactory threadFactory = new MyThreadFactory();

    ExecutorService executorService = Executors.newCachedThreadPool(threadFactory);

    private void change(int max) {
        max += 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.button1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test1();
            }
        });

//        int value = StringDeal.atoi("42");
//
//        Log.d("darren", "321 value: " + value);


        int [] array = new int[] {4, 5, 9, 4, 9, 8, 6, 3,4, 2, 1, 2 };
//        FindNum.findDep(array);

//        int index = ArrayDep.findDep(array);

//        Log.d("darren", "index: " + index);


        ArrayDep.sortArray(array);

//        for (int i=0; i<array.length; ++i) {
//            Log.d("darren", "i: " + i + ", value: " + array[i]);
//        }

//        Debug.startMethodTracing();

//        Trace.beginSection("MainCreate");

//        this.getPackageManager().getPackageUid(this.getPackageName(), )

        /*
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                Log.d("darren_test", "test start");
                test();
                Log.d("darren_test", "test end");
            }
        });

        try {
            long start = System.currentTimeMillis();
            Log.d("darren_test", "future get start");
            future.get();
            Log.d("darren_test", "future get end: " + (System.currentTimeMillis()-start));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

//        int array[] = {3, 9, 6, 1, 9, 3, 7, 4};
//
        int array2[] = {13, 9, 2 ,26, 111, 39, 3, 39, 3, 97, 4};
//
//        Sort.bitSetFind(array, array2);
//
//        int sort[] = Sort.baseSort(array2);

//        Sort.bucketSort(array2);
//
//        for (int i=0; i<array2.length; ++i) {
//            Log.d("darren", "sort[" + i + "]: " + array2[i]);
//        }
//
//        int max = 12;
//        change(max);
//        Log.d("darren", "file s: " + File.pathSeparator + ", max: " + max);

//        test3();

//        ActivityThread activityThread = ActivityThread.currentActivityThread();
//        Log.d("darren", "activityThread isSystem: "  + ", getProcessName: " + activityThread.getProcessName());


//        List.Node node1 = new List.Node(1);
//        List.Node node2 = new List.Node(2);
//        node1.next = node2;
////        node2.next = null;
//        List.Node node3 = new List.Node(3);
//        node2.next = node3;
////        node3.next = null;
//        List.Node node4 = new List.Node(4);
//        node3.next = node4;
////        node4.next = null;
//        List.Node node5 = new List.Node(5);
//        node4.next = node5;
////        node5.next = null;
//        List.Node node6 = new List.Node(6);
//        node5.next = node6;
////        node6.next = null;
//        List.Node node7 = new List.Node(7);
//        node6.next = node7;
//        List.Node node8 = new List.Node(8);
//        node7.next = node8;
//        node8.next = null;

//        List.Node node = node1;
//        while (null != node.next) {
//            Log.d("darren", "MainActivity value: " + node.value);
//            node = node.next;
//        }
//        Log.d("darren", "MainActivity value: " + node.value);
//
//        List.Node newHead = List.reverse(node1, 3);
//
//        List.Node nodeNew = newHead;
//        while (null != nodeNew.next) {
//            Log.d("darren", "MainActivity nodeNew value: " + nodeNew.value);
//            nodeNew = nodeNew.next;
//        }
//        Log.d("darren", "MainActivity nodeNew value: " + nodeNew.value);

//        this.getSharedPreferences()


//        testTrace();
//        test();

//        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10000);
////        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10000);
//        Producer producer = new Producer(queue);
//        Comsomer comsomer = new Comsomer(queue);
////
//        threadFactory.setThreadName("product_");
//        final Future future = executorService.submit(producer);
//        threadFactory.setThreadName("comsomer_");
//        final Future future1 = executorService.submit(comsomer);
//
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Log.e("darren", "66 size: " + queue.size());
//                    future.get();
//                    Log.e("darren", "33 size: " + queue.size());
//                    future1.cancel(true);
//                    Log.e("darren", "44 size: " + queue.size());
//                } catch (ExecutionException e) {
//                    Log.e("darren", "11 size: " + queue.size());
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    Log.e("darren", "22 size: " + queue.size());
//                    e.printStackTrace();
//                }
//
//                Log.e("darren", "55 size: " + queue.size());
//            }
//        });

//        Producer producer2 = new Producer(queue);
//        threadFactory.setThreadName("product_");
//        executorService.submit(producer2);
//
//        Comsomer comsomer2 = new Comsomer(queue);
//        threadFactory.setThreadName("comsomer_");
//        executorService.submit(comsomer2);
    }

    void find(int a[], int alen, int b[], int blen) {
        int min = alen>=blen?blen:alen;
        int start = -1, end = -1;

        if (min == alen) {
            startIndex:
            for (int i = 0; i < min; ++i) {
                for (int j = 0; j < blen; ++j) {
                    if (a[i] == b[j]) {
                        start = i;
                        break startIndex;
                    }
                }
            }
            if (-1 == start) {
                return;
            }

            endIndex: for (int i=min-1; i>=0; --i) {
                for (int j=blen-1; j>=0; --j) {
                    if (a[i] == b[j]) {
                        end = i;
                        break endIndex;
                    }
                }
            }

            if ((end == start) || (-1 == end)) {
                System.out.println(a[start]);
            } else {
                System.out.println(a[start]);

                System.out.println(a[end]);
            }
        } else {
            startIndex:
            for (int i = 0; i < min; ++i) {
                for (int j = 0; j < alen; ++j) {
                    if (b[i] == b[j]) {
                        start = i;
                        break startIndex;
                    }
                }
            }
        }
    }

    private void test1() {
//        Debug.startMethodTracing("darren_MainActivity_test1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Debug.stopMethodTracing();
    }

    private void test2() {
        Debug.startMethodTracing("darren_MainActivity_test2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Debug.stopMethodTracing();
    }

    private void test3() {
        Debug.startMethodTracing("darren_MainActivity_test3");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Debug.stopMethodTracing();
    }

    private void testTrace() {
        Trace.beginSection("MainTest");
//        Debug.startMethodTracing("darren_MainActivity_test");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Trace.endSection();

//        Debug.stopMethodTracing();
    }
}