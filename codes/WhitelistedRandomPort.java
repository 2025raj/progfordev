//question 2b

import java.util.*;

public class WhitelistedRandomPort {
    private int k;                      // The range of possible ports (0 to k-1)
    private Set<Integer> blacklist;     // Set to store blacklisted ports
    private Random random;              // Random number generator

    // Constructor to initialize the WhitelistedRandomPort object.
    public WhitelistedRandomPort(int k, int[] blacklisted_ports) {
        this.k = k;
        this.blacklist = new HashSet<>();
        for (int port : blacklisted_ports) {
            blacklist.add(port);
        }
        this.random = new Random();
    }

    // Generates a whitelisted random port between 0 and k-1, excluding blacklisted ports.
    public int get() {
        int randomPort;

        // Generate a random port until it is not blacklisted
        do {
            randomPort = random.nextInt(k);
        } while (blacklist.contains(randomPort));

        return randomPort;
    }

    public static void main(String[] args) {
        int[] blacklisted_ports = {2, 3, 5};
        WhitelistedRandomPort wrp = new WhitelistedRandomPort(7, blacklisted_ports);

        // Get and print whitelisted random ports multiple times
        System.out.println("Random Port 1: " + wrp.get());
        System.out.println("Random Port 2: " + wrp.get());
        System.out.println("Random Port 3: " + wrp.get());
        System.out.println("Random Port 4: " + wrp.get());
        System.out.println("Random Port 5: " + wrp.get());
    }
}
