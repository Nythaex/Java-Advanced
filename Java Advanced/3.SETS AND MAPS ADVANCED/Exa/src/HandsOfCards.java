import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> deck = new LinkedHashMap<>();
        Map<String, Integer> power = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {
            String[] NameAndCards = command.split(": ");
            String[] cards = NameAndCards[1].split(", ");
            for (int i = 0; i <= cards.length - 1; i++) {
                if (!deck.containsKey(NameAndCards[0])) {
                    deck.put(NameAndCards[0], new HashSet<>());
                }
                deck.get(NameAndCards[0]).add(cards[i]);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : deck.entrySet()) {
            int powere = findPower(entry.getValue());
            System.out.println(entry.getKey() + ": " + powere);

        }


    }

    private static int findPower(Set<String> value) {
        int power = 0;
        Iterator<String> iteratore=value.iterator();
        while (iteratore.hasNext()) {
            String theCard = iteratore.next();
            int sum = 0;
            if (theCard.length() == 3) {
                sum = 10;
            } else {
                if (Character.isDigit(theCard.charAt(0))) {
                    sum = Integer.parseInt(String.valueOf(theCard.charAt(0)));
                } else {
                    if (theCard.charAt(0) == 'J') {
                        sum = 11;
                    } else if (theCard.charAt(0) == 'Q') {
                        sum = 12;
                    } else if (theCard.charAt(0) == 'K') {
                        sum = 13;
                    } else if (theCard.charAt(0) == 'A') {
                        sum = 14;
                    }
                }
            }
            if (theCard.charAt(theCard.length() - 1) == 'S') {
                sum *= 4;
            } else if (theCard.charAt(theCard.length() - 1) == 'H') {
                sum *= 3;
            } else if (theCard.charAt(theCard.length() - 1) == 'D') {
                sum *= 2;
            } else if (theCard.charAt(theCard.length() - 1) == 'C') {

            }
            power += sum;
        }
        return power;
    }
}

//(?<power>[\d]+|[JQKA])([CHDS]){1}