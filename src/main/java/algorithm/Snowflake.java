package algorithm;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Snowflake {

    //机器ID
    private long workerId;
    private long datacenterId;
    //生成的队列
    private long sequence;
    private long twepoch = 1288834974657L;
    private long workerIdBits = 5L;
    private long datacenterIdBits = 5L;
    //最大的workerId = -1的补码 异或  -1的补码左移5位 = 31
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    //同上，最大的datacenterId =  31
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    //对列的位数
    private long sequenceBits = 12L;
    //workId偏移数
    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    //队列掩码（即最大位数）
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    public Snowflake(long workerId, long datacenterId, long sequence) {
        // sanity check for workerId
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        System.out.printf("worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }


    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        //获取当前时间
        long timestamp = timeGen();
        //如果当前时间小于上一次时间，抛异常
        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }
        //如果时间相同，序列化+1
        if (lastTimestamp == timestamp) {
            //保证了sequence结果肯定小于最大值
            sequence = (sequence + 1) & sequenceMask;
            //如果序号是0，代表最大值已经取完了，获取下次时间
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        //最近时间-指定时间<<偏移22位 | 机房ID<<偏移 17位 | workId << 偏移 12位 | 序列化
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     *  获取大于最后一次时间的时间
     * @author Stilesyu
     * @since 1.0
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    //---------------测试---------------
    public static void main(String[] args) {
        Snowflake worker = new Snowflake(1, 1, 1);
        for (int i = 0; i < 30; i++) {
            System.out.println(worker.nextId());
        }
    }

}

