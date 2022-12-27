package enums;

public enum Grade {
    ASSOCIATE_DEGREE(2), CONTINUES_BACHELOR_DEGREE(4), DISCONTINUES_BACHELOR_DEGREE(2), CONTINUES_MASTER(6), DISCONTINUES_MASTER(4), PROFESSIONAL_DOCTORATE(7), CONTINUES_PHD(5), DISCONTINUOUS_SPECIALIZED_DOCTORATE(5);
    public final int period;

    Grade(int period) {
        this.period = period;
    }

}
