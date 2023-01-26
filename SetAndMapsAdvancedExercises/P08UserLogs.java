package SetAndMapsAdvancedExercises;

import java.util.*;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> dataMap = new TreeMap<>();

        while (!input.equals("end")) {

            String ip = input.split("\\s+")[0].split("=")[1];
            // String message = input.split("\\s+")[1].split("=")[1]; -> ne ni trqbva
            String username = input.split("\\s+")[2].split("=")[1];

            if (!dataMap.containsKey(username)) {
                dataMap.put(username, new LinkedHashMap<>());
            }

            Map<String, Integer> currentIps = dataMap.get(username);
            if (!currentIps.containsKey(ip)) {
                currentIps.put(ip, 1);
            } else {
                currentIps.put(ip, currentIps.get(ip) + 1);
            }
            input = scanner.nextLine();
        }
        for (String username : dataMap.keySet()) { // data.keySet() -> взима всички ключове в мапа - списък с ключоветеsout
            System.out.println(username + ":");
            // ip -тата на username-a
            Map<String, Integer> currentIps = dataMap.get(username);// taka imame map s ips na all usernames
            int ipsCount = currentIps.size();

            for (String ip : currentIps.keySet()) {
                if (ipsCount == 1) {
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                }
                ipsCount--;
            }
        }
    }
}

// reshenie s regex i po- razlichno otpechatvane:
//    Pattern pattern = Pattern.compile("IP=(?<ip>[^\\s]+)\\s+[^\\s]+\\s+user=(?<user>[\\w\\d]+)");
//
//    Map<String, Map<String, Integer>> attacksInfoMap = new TreeMap<>();
//    String input;
//        while (!(input = scanner.nextLine()).equals("end")) {
//                Matcher matcher = pattern.matcher(input);
//
//                if (matcher.find()) {
//                String ip = matcher.group("ip");
//                String user = matcher.group("user");
//
//                attacksInfoMap.putIfAbsent(user, new LinkedHashMap<>());
//        attacksInfoMap.get(user).putIfAbsent(ip, 0);
//        attacksInfoMap.get(user).put(ip, attacksInfoMap.get(user).get(ip) + 1);
//        }
//        }
//
//        attacksInfoMap.forEach((user, ips) -> {
//        System.out.printf("%s:\n", user);
//        StringJoiner output = new StringJoiner(", ", "", ".");
//        ips.forEach((ip, count) -> {
//        StringBuilder currentInfo = new StringBuilder();
//        currentInfo.append(ip)
//        .append(" => ")
//        .append(count);
//        output.add(currentInfo);
//        });
//        System.out.println(output);
//        });
//        }
//        }
//