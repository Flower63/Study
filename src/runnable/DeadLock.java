package runnable;

/**
 * Created by Dennis
 *
 * on 12/16/2015.
 */
public class DeadLock {
    public static class Friend {
        private String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend friend) {
            System.out.printf("%s: %s has bowed to me %n", this.name, friend.getName());
            friend.bowBack(this);
        }

        public synchronized void bowBack(Friend friend) {
            System.out.printf("%s: %s has bowed back%n", this.name, friend.getName());
        }
    }

    public static void main(String[] args) {
        Friend alphonse = new Friend("Alphonse");
        Friend jack = new Friend("Jack");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(jack);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                jack.bow(alphonse);
            }
        }).start();
    }
}
