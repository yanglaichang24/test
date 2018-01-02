package com.ylch.test.jdk_class_test.collection;

import org.junit.Test;

import java.util.*;

/**
 *  <p>
 *      Collection 方法测试
 *  </p>
 * Created by yanglaichang1 on 2017/3/10.
 */
public class CollectionTest {

    List<String> list = new ArrayList<String>();
    Map<Object, Boolean> map = new WeakHashMap<Object, Boolean>();

    @Test
    public void reverse(){
        setDefalut();
        print();
        Collections.reverse(list);
        print();
    }

    @Test
    public void addAllTest(){
        setDefalut();
        print();
        Collections.addAll(list,"6","7");
        print();
    }

    //@Test
   /* public void  newSetFromMap(){
        map.put("1",false);
        print();
        Set<Object> weakHashSet = Collections.newSetFromMap(map);
        print();
    }*/

    @Test
    public void testStaticField(){
        List<Object> objects = Collections.emptyList();
        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        Set<Object> objects1 = Collections.emptySet();
    }

    /**
     * 使用二分搜索法搜索指定列表，以获得指定对象。在进行此调用之前，
     * 必须根据列表元素的 自然顺序对列表进行升序排序（通过 sort(List) 方法）。
     * 如果没有对列表进行排序，则结果是不确定的。
     * 如果列表包含多个等于指定对象的元素，则无法保证找到的是哪一个。
     * 此方法对“随机访问”列表运行 log(n) 次（它提供接近固定时间的位置访问）。
     * 如果指定列表没有实现 RandomAccess 接口并且是一个大型列表，
     * 则此方法将执行基于迭代器的二分搜索，
     * 执行 O(n) 次链接遍历和 O(log n) 次元素比较。
     */
    @Test
    public void binarySearch(){
        setDefalut();
        int i = Collections.binarySearch(list, "4", new Comparator<String>() {
            public int compare(String o1, String o2) {
                Integer _o1 = Integer.valueOf(o1);
                Integer _o2 = Integer.valueOf(o2);
                if (_o1.intValue() > _o2.intValue()){
                    return -1;
                } else if(_o1.intValue() == _o2.intValue()){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        System.out.println(i);
        System.out.println("  ---- " + list.get(i));
    }

    /**
     *  使用默认随机源对指定列表进行置换。所有置换发生的可能性都是大致相等的
     *  前面描述中使用了不确定的词“大致”，因为随机源只是大致上独立选择位的无偏源。
     *  如果它是一个随机选择位的最佳源，那么算法将完全一致的选择置换
     *
     *   此实现向后遍历列表，从最后一个元素一直到第二个元素，
     *   将随机选择的元素重复交换到“当前位置”。
     *   元素是从列表的一部分随机选择的，该部分列表从第一个元素一直到当前位置（包括）。
     *   此方法以线性时间运行。如果指定列表没有实现 RandomAccess 接口并且是一个大型列表，则此实现在改组列表前将指定列表转储到数组中，并将改组后的数组转储回列表中。这避免了二次行为，该行为是原地改组一个“有序访问”列表引起的。
     *
     */
    @Test
    public void shuffleTest(){
        setDefalut();
        print();

        //Collections.shuffle(list);

        Collections.shuffle(list, new Random(100));

        print();
    }

    /**
     *  在指定列表的指定位置处交换元素。
     *  （如果指定位置相同，则调用此方法不会更改列表。）
     */
    @Test
    public void swapTest(){
        setDefalut();
        print();
        Collections.swap(list,2,3);
        print();
    }

    /**
     *  使用指定元素替换指定列表中的所有元素。
     */
    @Test
    public void fillTest(){
        setDefalut();
        print();
        Collections.fill(list,"100");
        print();
    }

    @Test
    public void copyTest(){
        setDefalut();
        print();
        List<String> _list = new ArrayList<String>(list.size());
        _list.add("3");
        Collections.copy(_list, list);
        print();
        System.out.println(Arrays.toString(_list.toArray()));
    }

    /**
     *
     * 根据指定的距离轮换指定列表中的元素。调用此方法后，
     * 对于 0 和 list.size()-1（包括）之间的所有 i 值，
     * 索引 i 处的元素将是以前位于索引 (i - distance) mod list.size() 处的元素。
     * （此方法对列表的大小没有任何影响。）
     例如，假设 list 包含 [t, a, n, k, s]。在调用 Collections.rotate(list, 1)
     （或 Collections.rotate(list, -4)）之后，list 将包含 [s, t, a, n, k]。

     注意，此方法用于子列表时非常有用，可以在保留其余元素顺序的同时，
     在列表中移动一个或多个元素。
     例如，以下语句可以将索引 j 处的元素向前移动到位置 k 上（k 必须大于等于 j）：

     Collections.rotate(list.subList(j, k+1), -1);

     为了具体说明这一点，假设 list 包含 [a, b, c, d, e]。
     要将索引 1 处的元素（ b）向前移动两个位置，请执行以下调用：
     Collections.rotate(l.subList(1, 4), -1);

     得到的列表是 [a, c, d, b, e]。
     要将多个元素向前移动，则需要增加循环移动距离的绝对值。
     要将元素向后移动，请使用一个正的移动距离。

     如果指定列表是一个小型列表，
     或者它实现了 RandomAccess 接口，
     则此实现会将第一个元素交换到它应该去的位置上，
     然后重复执行交换操作，将替换的元素交换到它们应该去的位置上，
     直到替换的元素交换成第一个元素。
     如有必要，需要在第二个或后续元素上重复这个过程，直到完成轮换。
     如果指定的列表是大型列表并且没有实现 RandomAccess 接口，
     则此实现会将列表拆分成位于 -distance mod size 索引两边的两个子列表视图。
     然后在每个子列表视图上调用 reverse(List) 方法，
     并最终在整个列表上调用此方法。有关这两种算法更为完整的描述，
     请参阅 Jon Bentley 撰写的 Programming Pearls (Addison-Wesley, 1986) 一书中的第 2.3 小节。
     *
     */

    @Test
    public void rotateTest(){
        setDefalut();
        print();
        Collections.rotate(list,2);
        print();
    }

    @Test
    public void indexOfSubListTest(){


    }

    @Test
    public void unmodifiable(){
        setDefalut();
        Collections.unmodifiableCollection(list);

        //unmodifiableSortedSet
        //unmodifiableList
        //unmodifiableMap
        //unmodifiableSortedMap
    }

    @Test
    public void testJDKImmutable(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(" 【1】 " + list);
        List<String> unmodifiableList=Collections.unmodifiableList(list);
        System.out.println(" 【2】 " + unmodifiableList);
        List<String> unmodifiableList1=Collections.unmodifiableList(Arrays.asList("a","b","c"));
        System.out.println(" 【3】 " + unmodifiableList1);



        String temp=unmodifiableList.get(1);
        System.out.println(" 【4】 " + "unmodifiableList [0]："+temp);

        list.add("baby");
        System.out.println(" 【5】 " + "list add a item after list:"+list);
        System.out.println(" 【6】 " + "list add a item after unmodifiableList:"+unmodifiableList);

        unmodifiableList1.add("bb");
        System.out.println(" 【7】 " + "unmodifiableList add a item after list:"+unmodifiableList1);

        unmodifiableList.add("cc");
        System.out.println(" 【8】 " + "unmodifiableList add a item after list:"+unmodifiableList);
    }


    /**
     *  返回指定 collection 的一个动态类型安全视图。
     *  试图插入一个错误类型的元素将导致立即抛出 ClassCastException,
     *  假设在生成动态类型安全视图之前，collection 不包含任何类型不正确的元素，
     *  并且所有对该 collection 的后续访问都通过该视图进行，
     *  则可以 保证 该 collection 不包含类型不正确的元素。
     */
    @Test
    public void check(){
        setDefalut();
        //Collection<String> strings = Collections.checkedCollection(list, String.class);
        //checkedSet  返回指定 set 的一个动态类型安全视图。试图插入一个错误类型的元素将导致立即抛出 ClassCastException。

        List _list = new ArrayList();

        _list.add("lll");
        _list.add(222);
        List __list = Collections.checkedList(_list, String.class);
        __list.add(3333);
    }

    @Test
    public void frequencyTest(){
        setDefalut();
        int frequency = Collections.frequency(list, "2");
        System.out.println(frequency);
    }

    /**
     *
     *  如果两个指定 collection 中没有相同的元素，则返回 true。
     */
    @Test
    public void disjointTest(){
        setDefalut();
        boolean b = Collections.disjoint(list, list);
        System.out.println(b);
    }

    public void print(){
        if (list.size() > 0){
            System.out.println(Arrays.toString(list.toArray()));
        }
        if ( map.size() > 0){
            System.out.println(map);
        }
    }

    public void setDefalut(){
        list.add(1 + "");
        list.add(2 + "");
        list.add(3 + "");
        list.add(4 + "");
        list.add(5 + "");
    }

}
