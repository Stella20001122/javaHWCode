package myhashcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;
/*
 * 一致性哈希算法实现
 */
public class ConsistentHashing {
    // 哈希环，借助SortedMap接口的TreeMap实现，TreeMap 类保证 Map 将按键升序排列。
	// SortedMap接口主要提供有序的Map实现。
	// Map的主要实现有HashMap,TreeMap,HashTable,LinkedHashMap。
	// TreeMap实现了SortedMap接口，保证了有序性。默认的排序是根据key值进行升序排序，也可以重写comparator方法来根据value进行排序。

    private final SortedMap<Integer, String> hashRing = new TreeMap<>();
    // 虚拟节点数量
    private final int virtualNodes;

    public ConsistentHashing(int virtualNodes) {
        this.virtualNodes = virtualNodes;
    }

    // 添加节点，通过给每个实际节点添加多个虚拟节点，将它们映射到哈希环上。
    public void addNode(String node) {
        for (int i = 0; i < virtualNodes; i++) {
            int hash = hash(node + "#" + i);
            System.out.println(node+"的virtualNodes哈希值："+hash);
            hashRing.put(hash, node);
        }
    }

    // 删除节点，要依次移除它的虚拟节点
    public void removeNode(String node) {
        for (int i = 0; i < virtualNodes; i++) {
            int hash = hash(node + "#" + i);
            hashRing.remove(hash);
        }
    }

    // 获取数据存储的节点
    public String getNode(String key) {
        if (hashRing.isEmpty()) {
            return null;
        }
        int hash = hash(key);
        if (!hashRing.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = hashRing.tailMap(hash);
            //tailMap(K fromKey) 方法用于返回此映射中键大于或等于 fromKey 的部分的视图。 
            hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();//返回第一个大于hash的节点的hash值
        }
        return hashRing.get(hash);//根据这个节点的哈希值取出目标
    }

    // 选择一个哈希函数
    private int hash(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            int hash = ((digest[3] & 0xFF) << 24) | ((digest[2] & 0xFF) << 16) |
                       ((digest[1] & 0xFF) << 8) | (digest[0] & 0xFF);
            return hash & 0x7FFFFFFF; // 取正整数
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
//        ConsistentHashing consistentHashing = new ConsistentHashing(100);
        ConsistentHashing consistentHashing = new ConsistentHashing(3);

        // 添加节点
        consistentHashing.addNode("NodeA");
        consistentHashing.addNode("NodeB");
        consistentHashing.addNode("NodeC");

        // 获取数据存储的节点
        String key = "myKey";
        String node = consistentHashing.getNode(key);
        System.out.println("Key: " + key + " is stored in node: " + node);
        
        String key2 = "myKey2024";
        String node2 = consistentHashing.getNode(key2);
        System.out.println("Key: " + key2 + " is stored in node: " + node2);

        // 删除节点
        consistentHashing.removeNode("NodeC");
        node = consistentHashing.getNode(key2);
        System.out.println("After removing NodeC, key: " + key2 + " is stored in node: " + node);
    }
}
