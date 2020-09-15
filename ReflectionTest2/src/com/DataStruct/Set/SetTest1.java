package com.DataStruct.Set;

import java.util.HashSet;

/**
 * 在知乎上看到了一篇比较合理的解答，大致是说JDK1.8的中HashSet实现变了，又因为插入HashSet的是Integer，其hashCode()实现就返回int值本身。所以在对象hashCode这一步引入了巧合的“按大小排序”。然后HashMap.hash(Object)获取了对象的hashCode()之后会尝试进一步混淆。JDK8版java.util.HashMap内的hash算法比JDK7版的混淆程度低；在[0, 2^32-1]范围内经过HashMap.hash()之后还是得到自己。
 * 原文链接：https://www.zhihu.com/question/28414001/answer/40733996
 *
 * 2. HashSet底层是使用HashMap来实现的;当使用add方法将对象添加到Set当中，实际上是将该对象作为底层所维护Map对象的key，而value则都是同一个Object对象(该对象我们用不上).
 */
public class SetTest1 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("a");
        set.add("c");
        set.add("d");
        set.add("b");
        System.out.println(set.add("a"));

        System.out.println(set);
    }
}
