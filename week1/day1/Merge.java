  import java.util.*;
import java.lang.*;
import java.io.*;

class Meeting {
    int start;
    int end;

    Meeting() {
        start = 0;
        end = 0;
    }

    Meeting(int s, int e) {
        start = s;
        end = e;
    }
}

public class Merge {
    public static void main(String[] args) throws java.lang.Exception {
        ArrayList<Meeting> x = new ArrayList<Meeting>();
        Meeting i1 = new Meeting(0, 1);
        Meeting i2 = new Meeting(3, 5);
        Meeting i3 = new Meeting(4, 8);
        Meeting i4 = new Meeting(10, 12);
        Meeting i5 = new Meeting(9, 10);

        x.add(i1);
        x.add(i2);
        x.add(i3);
        x.add(i4);
        x.add(i5);


        ArrayList<Meeting> r = merge(x);

        for (Meeting i : r) {
            System.out.println(i.start + " " + i.end);
        }

    }

    public static ArrayList<Meeting> merge(ArrayList<Meeting> Meetings) {

        if (Meetings.size() == 0)
            return Meetings;
        if (Meetings.size() == 1)
            return Meetings;

        Collections.sort(Meetings, new MeetingComparator());

        Meeting first = Meetings.get(0);
        int start = first.start;
        int end = first.end;

        ArrayList<Meeting> result = new ArrayList<Meeting>();

        for (int i = 1; i < Meetings.size(); i++) {
            Meeting current = Meetings.get(i);
            if (current.start <= end) {
                end = Math.max(current.end, end);
            } else {
                result.add(new Meeting(start, end));
                start = current.start;
                end = current.end;
            }

        }

        result.add(new Meeting(start, end));

        return result;

    }
}

class MeetingComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Meeting i1 = (Meeting) o1;
        Meeting i2 = (Meeting) o2;
        return i1.start - i2.start;
    }
}