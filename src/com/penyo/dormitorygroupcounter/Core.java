package com.penyo.dormitorygroupcounter;

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
        this.people = people;
        if (people >= 3)
            getBasicEvent();
    }

    /**
     * 该方法用于计算群数。
     */
    private void getBasicEvent() {
        for (long i = people - 2; i > 0; i--)
            for (long j = i; j > 0; j--)
                for (long k = j; k > 0; k--)
                    basicEvent += k;
    }

    @Override
    public String toString() {
        if (basicEvent == 0)
            return "低于3个人还有甚么建群的必要吗？（悲";
        return people + "个人之间最多能建立" + basicEvent + "个群";
    }
}
