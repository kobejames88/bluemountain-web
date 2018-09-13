import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Objects;

public class RedisConnectionTest {

    public static void main(String[] args) {
        //构造一个reids的客户端对象
       Jedis jedis = new Jedis("192.168.31.130",6379);
        //发送一个ping命令
        String ping = jedis.ping();
        System.out.println(ping);
    }
    @Test
    public void RedisDB(){

        String host  = "192.168.31.130";
        int port = 6379;
        Jedis jedis = null;
        try {
            jedis = new Jedis(host,port);
            jedis.auth("123456");
            jedis.select(1);
            jedis.set("name","kun");
            String name = jedis.get("name");
            System.out.println("name = " + name);
            jedis.flushDB();
            String name2 = jedis.get("name");
            System.out.println("name2 = " + name2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                try {
                    jedis.close();
                }catch (Exception e){
                    System.out.println("redis连接关闭失败");
                    e.printStackTrace();
                }
            }
        }
    }
    public void LinkList(){
        class Node<K,V> implements Map.Entry<K,V> {
            final int hash;
            final K key;
            V value;
            Node<K,V> next;

            Node(int hash, K key, V value, Node<K,V> next) {
                this.hash = hash;
                this.key = key;
                this.value = value;
                this.next = next;
            }

            public final K getKey()        { return key; }
            public final V getValue()      { return value; }
            public final String toString() { return key + "=" + value; }

            public final int hashCode() {
                return Objects.hashCode(key) ^ Objects.hashCode(value);
            }

            public final V setValue(V newValue) {
                V oldValue = value;
                value = newValue;
                return oldValue;
            }

            public final boolean equals(Object o) {
                if (o == this)
                    return true;
                if (o instanceof Map.Entry) {
                    Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                    if (Objects.equals(key, e.getKey()) &&
                            Objects.equals(value, e.getValue()))
                        return true;
                }
                return false;
            }
        }
    }




    }
