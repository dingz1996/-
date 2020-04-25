package Algorithm.手动实现布隆过滤器;

import java.util.BitSet;

public class MyBloomFilter implements Comparable{
    private static final int DEFAULT_SIZE = 2<<24;
    private static final int[] SEEDS = new int[]{3,13,46,71,91,134};
    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    public MyBloomFilter( ) {
        for(int i = 0;i<SEEDS.length;i++){
            func[i] = new SimpleHash(DEFAULT_SIZE,SEEDS[i]);
        }
    }
    public void add(Object o){
        for(SimpleHash s:func){
            bits.set(s.hash(o),true);
        }
    }
    public boolean judge(Object o){
        for(SimpleHash s:func){
            if(bits.get(s.hash(o))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private static class SimpleHash{
        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }
        public int hash(Object o){
            int h;
            return (o==null)?0:Math.abs(seed*(cap-1)&((h=o.hashCode())^(h>>>16)));
        }
    }

    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        int value2 = 5;
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.judge(value1));
        System.out.println(filter.judge(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.judge(value1));
        System.out.println(filter.judge(value2));

    }
}
