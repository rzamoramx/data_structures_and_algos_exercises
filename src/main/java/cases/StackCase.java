package cases;

import data.structures.Stack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class StackCase {
    public static void main(String[] args) {
        disastersReg();
    }

    public static void disastersReg() {
        List<Disaster> disasters = List.of(
                new Disaster("1957", 68, "NONE"),
                new Disaster("1973", 3000, "NONE"),
                new Disaster("1985", 40000, "NONE"),
                new Disaster("2019", 369, "NONE")
        );
        System.out.println(Arrays.toString(disasters.toArray()));

        Stack<Disaster> stack = new Stack<>();
        for (Disaster disaster : disasters) {
            while (!stack.isEmpty() && stack.top().getVictims() <= disaster.getVictims()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                disaster.setLast("NONE");
            } else {
                disaster.setLast(stack.top().getDate());
            }
            stack.push(disaster);
        }

        System.out.println(stack.toString());
        stack.empty();
    }
}

@Getter
@Setter
@AllArgsConstructor
class Disaster {
    private String date;
    private int victims;
    private String last;

    @Override
    public String toString() {
        return "Disaster{" +
                "date='" + date + '\'' +
                ", victims=" + victims +
                ", last='" + last + '\'' +
                '}';
    }
}
