package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Stop any running containers and remove orphans
            ProcessBuilder downBuilder = new ProcessBuilder(
                    "docker", "compose", "-f", "docker-compose.yml", "down", "--remove-orphans"
            );
            downBuilder.inheritIO();
            Process downProcess = downBuilder.start();
            downProcess.waitFor();

            // Step 2: Start containers fresh
            ProcessBuilder upBuilder = new ProcessBuilder(
                    "docker", "compose", "-f", "docker-compose.yml", "up", "-d"
            );
            upBuilder.inheritIO();
            Process upProcess = upBuilder.start();
            upProcess.waitFor();

            System.out.println("Kafka restarted via Docker Compose!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
