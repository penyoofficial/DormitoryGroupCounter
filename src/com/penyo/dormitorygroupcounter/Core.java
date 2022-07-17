package com.penyo.dormitorygroupcounter;

import java.util.Random;

/**
 * 该类用于完成人数到群数的转换和输出。
 * 
 * @author Penyo
 */
public class Core {
    /** 人数。 */
    private int people;
    /** 群数。 */
    private long basicEvent = 0;

    /**
     * 该构造器用于接收人数以计算群数。
     * 
     * @param people 人数。
     */
    public Core(int people) {
        if (people < 0)
            people = -1;
        if (people > 233)
            people = 233;
        this.people = people;
    }

    /**
     * 该方法用于计算群数。
     */
    public long getBasicEvent() {
        if (people == -1)
            return -666;
        for (long i = people - 2; i > 0; i--)
            for (long j = i; j > 0; j--)
                for (long k = j; k > 0; k--)
                    basicEvent += k;
        return basicEvent;
    }

    @Override
    public String toString() {
        return switch (people) {
            case -1 -> "“九又四分之三宿舍”，没错了！";
            case 0 -> "你这啥宿舍啊？鬼屋？";
            case 1 -> "啊！是高贵的单人公寓！";
            case 2 -> "无比的豪华，羡慕！";
            case 3 -> "相当的舒服，赞赏。";
            case 4 -> "标准现代体验！";
            case 5 -> "住起来也许还不错。";
            case 6 -> "一般老式学校的历史包袱。";
            case 7 -> "咱就是说，没法更挤了！";
            case 8 -> "什么黑奴客轮？";
            case 233 -> "差不多得了。";
            default -> "不予置评。";
        } + "——" + switch (new Random().nextInt(10)) {
            case 0 -> "鲁迅";
            case 1 -> "郭沫若";
            case 2 -> "老舍";
            case 3 -> "莫言";
            case 4 -> "张恨水";
            case 5 -> "周作人";
            case 6 -> "沈从文";
            case 7 -> "林语堂";
            case 8 -> "曹禺";
            case 9 -> "巴金";
            default -> "某位长者"; // 这一项永远也不会出现！
        } + " ";
    }
}
