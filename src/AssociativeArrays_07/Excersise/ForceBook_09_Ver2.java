package AssociativeArrays_07.Excersise;

import java.util.*;

public class ForceBook_09_Ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> record = new HashMap<>();
        String input = sc.nextLine();
        while (!input.equals("Lumpawaroo")){
            if(input.contains(" | ")){
                String[] tokens = input.split(" \\| ");
                String side = tokens[0];
                String user = tokens[1];

                if(!record.containsKey(side)){
                    record.put(side, new ArrayList<>());
                }
                boolean flag = true;
                for(Map.Entry<String,List<String>> entry : record.entrySet()){
                    if(entry.getValue().contains(user)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    record.get(side).add(user);
                }
            }
            else if(input.contains(" -> ")) {
                String[] tokens = input.split(" -> ");
                String side = tokens[1];
                String user = tokens[0];

                if(!record.containsKey(side)){
                    record.put(side, new ArrayList<>());
                }
                for(Map.Entry<String, List<String>> entry : record.entrySet()){
                    if(entry.getValue().contains(user)){
                        entry.getValue().remove(user);
                        break;
                    }
                }
                record.get(side).add(user);
                System.out.printf("%s joins the %s side!%n",user,side);


            }

            input = sc.nextLine();
        }
        record.entrySet().stream().sorted((n1,n2) -> {
            int res = Integer.compare(n2.getValue().size(), n1.getValue().size());
            if(res == 0)
                res = n1.getKey().compareTo(n2.getKey());
            return res;
        }).forEach(e -> {
            if(e.getValue().size() > 0){
                Collections.sort(e.getValue());
                System.out.printf("Side: %s, Members: %d%n",e.getKey(),
                        e.getValue().size());
                e.getValue().forEach(n -> System.out.printf("! %s%n",n));
            }
        });
    }
}
