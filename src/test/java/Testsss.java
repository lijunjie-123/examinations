import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wangxy on 19/12/21.
 */
public class Testsss {
    public static void main(String[] args) throws Exception {

// ��ʼʱ��

        long start = System.currentTimeMillis();

// ģ������

        List<String> list = new ArrayList<String>();

        for (int i = 1; i <= 3000; i++){

            list.add(i + "");

        }

// ÿ500�����ݿ���һ���߳�

        int threadSize = 500;

// ����������

        int dataSize = list.size();

// �߳���

        int threadNum = dataSize / threadSize + 1;

// ������,����threadNumΪ����

        boolean special = dataSize % threadSize == 0;

// ����һ���̳߳�

        ExecutorService exec = Executors.newFixedThreadPool(threadNum);

// ����һ�����񼯺�

        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();

        Callable<Integer> task = null;

        List<String> cutList = null;

// ȷ��ÿ���̵߳�����

        for (int i = 0; i < threadNum; i++) {

            if (i == threadNum - 1) {

                if (special) {

                    break;

                }

                cutList = list.subList(threadSize * i, dataSize);

            } else {

                cutList = list.subList(threadSize * i, threadSize * (i + 1));

            }

// System.out.println("��" + (i + 1) + "�飺" + cutList.toString());

            final List<String> listStr = cutList;

            task = new Callable<Integer>() {

                @Override public

                Integer call() throws Exception {

                    System.out.println(Thread.currentThread().getName() + "�̣߳�" + listStr);

                    return 1;

                }

            };

// �����ύ�����������б�ͷ��ص�Future�б����˳���Ӧ�Ĺ�ϵ

            tasks.add(task);

        }

        List<Future<Integer>> results = exec.invokeAll(tasks);

        for (Future<Integer> future : results) {

            System.out.println(future.get());

        }

// �ر��̳߳�

        exec.shutdown();

        System.out.println("�߳�����ִ�н���");

        System.err.println("ִ������������ ��" + (System.currentTimeMillis() - start) + "����");

    }

}
