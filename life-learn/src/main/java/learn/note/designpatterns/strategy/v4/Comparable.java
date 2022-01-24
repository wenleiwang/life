package learn.note.designpatterns.strategy.v4;

/**
 * 抽象出来的策略接口
 * @param <T>
 */
public interface Comparable<T> {
    /**
     * 比较T类型的数组，第c0位置与第c1位置的大小
     * @param data T类型数组
     * @param c0 c0位置
     * @param c1 c1位置
     * @return 大小，大于为1，小于为-1，等于为0
     */
    public int compareTo(T[] data ,int c0, int c1);
}
