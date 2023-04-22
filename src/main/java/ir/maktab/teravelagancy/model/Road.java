package ir.maktab.teravelagancy.model;

import java.util.List;

public class Road extends BaseModel implements Comparable<Road> {
    private final int from;
    private final int to;
    private final List<Integer> through;
    private final int speedLimit;
    private final int length;
    private final boolean biDirectional;
    private static final int HOUR_IN_MINUTES = 60;
    private static final int DAY_IN_MINUTES = 24 * HOUR_IN_MINUTES;

    public Road(int id, String name, int from, int to, List<Integer> through, int speedLimit, int length, boolean biDirectional) {
        super(id, name);
        this.from = from;
        this.to = to;
        this.through = through;
        this.speedLimit = speedLimit;
        this.length = length;
        this.biDirectional = biDirectional;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public List<Integer> getThrough() {
        return through;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public int getLength() {
        return length;
    }

    public boolean isBiDirectional() {
        return biDirectional;
    }

    public int time() {
        return (length * 60) / speedLimit;
    }

    public String timeString() {
        int time = time();
        int days = time / DAY_IN_MINUTES;
        int hours = (time % DAY_IN_MINUTES) / HOUR_IN_MINUTES;
        int minutes = time % HOUR_IN_MINUTES;

        return String.format("%02d:%02d:%02d", days, hours, minutes);
    }

    @Override
    public int compareTo(Road road) {
        return this.time() - road.time();
    }

    public static RoadBuilder builder() {
        return new RoadBuilder();
    }

    public static class RoadBuilder {
        private int id;
        private String name;
        private int from;
        private int to;
        private List<Integer> through;
        private int speedLimit;
        private int length;
        private boolean biDirectional;

        public RoadBuilder id(int id) {
            this.id = id;
            return this;
        }

        public RoadBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RoadBuilder from(int from) {
            this.from = from;
            return this;
        }

        public RoadBuilder to(int to) {
            this.to = to;
            return this;
        }

        public RoadBuilder through(List<Integer> through) {
            this.through = through;
            return this;
        }

        public RoadBuilder speedLimit(int speedLimit) {
            this.speedLimit = speedLimit;
            return this;
        }

        public RoadBuilder length(int length) {
            this.length = length;
            return this;
        }

        public RoadBuilder biDirectional(boolean biDirectional) {
            this.biDirectional = biDirectional;
            return this;
        }

        public Road build() {
            return new Road(id, name, from, to, through, speedLimit, length, biDirectional);
        }
    }
}
